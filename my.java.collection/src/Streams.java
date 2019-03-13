package src;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import junit.framework.Assert;
import src.Utilities.Employee;

// https://stackify.com/streams-guide-java-8/
// https://github.com/Baeldung/stackify/blob/master/core-java/src/test/java/com/stackify/stream/EmployeeTest.java
// removeIf, filter, allMatch, anyMatch, noneMatch, map, forEach, sorted, toArray, skip, limit, Collectors.joining(", ")
/**
 * Things to read 1. Infinite streams 2. Streams
 *
 */
public class Streams {

	public static void main(String[] args) {
		final Employee[] array = { new Employee("Jack", "A124", 23), new Employee("Sam", "A234", 12),
				new Employee("John", "A435", 45), new Employee("Jacksdf", "A124", 23), new Employee("Sai", "A124", 23),
				new Employee("JK", "A124", 23), new Employee("Samanta", "A124", 23), new Employee("Joey", "A124", 23),
				new Employee("Chandler", "A124", 23), new Employee("Monica", "A124", 23) };

		// two different ways of creating streams
		// On Arrays.asList returning a fixed-size list
		List<Employee> empList = Arrays.asList(array);
		List<Employee> empList2 = Arrays.asList(array);

		IntStream.range(0, empList.size()).filter(index -> index % 2 != 0).mapToObj(index -> empList2.get(index))
				.forEach(user -> System.out.println(user.getName()));

		empList.stream();
		Stream.of(array[0], array[1], array[2]);

		System.out.println();
		empList.stream().distinct().collect(Collectors.toList());
		// returns true if all the employess have ab in their names
		empList.stream().allMatch(e -> e.getName().contains("ab"));
		// returns true if there is atleast one employes with ab in their name
		empList.stream().anyMatch(e -> e.getName().contains("ab"));
		// returns true if there is no employee with ab in their name
		empList.stream().noneMatch(e -> e.getName().contains("ab"));

		List<Employee> rankWiseSortedList = empList.stream().sorted(new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o2.getRank().compareTo(o1.getRank());
			}
		}).collect(Collectors.toList());

		empList.stream().sorted((e1, e2) -> e1.getId().compareTo(e2.getId())).collect(Collectors.toList());
		final List<String> empIds = empList.stream().map(Employee::getId).collect(Collectors.toList());
		empIds.stream();

		final String commaSeperatedIds = empList.stream().map(Employee::getName).collect(Collectors.joining(", "))
				.toString();
		System.out.println("Comma seperated Employee Nmaes " + commaSeperatedIds);

		empList = empList.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
				.collect(Collectors.toList());
		empList.forEach(e -> System.out.println(e.getName() + " "));

		empList.forEach(e -> e.setName(e.getName() + " modified"));
		empList.forEach(e -> System.out.println(e.getName() + " "));

		List<Employee> newEmpList = empList.stream().collect(Collectors.toList());
		newEmpList.stream();

		newEmpList = newEmpList.stream().filter(e -> e.getName().contains("a")).collect(Collectors.toList());
		newEmpList.forEach(e -> System.out.println(e.getName() + " "));
		final Employee result = newEmpList.stream().filter(e -> e.getId().contains("12")).findFirst().orElse(null);
		final Long count = newEmpList.stream().filter(e -> e.getId().contains("12")).count();
		if (result == null) {
			System.out.println("No employee found with code" + "12");
		} else {
			System.out.println(count + " employees were found with the code" + "12");
		}
		final Employee[] newEmpArray = newEmpList.stream().toArray(Employee[]::new);
		System.out.println(newEmpArray);
		// skips first 2 elements
		newEmpList.stream().skip(2).limit(3);

		final Comparator<Employee> comp = Comparator.comparing(Employee::getName);

		Collections.sort(newEmpList, comp);
		newEmpList.sort(comp);
		System.out.println("size before removing: " + newEmpList.size());
		newEmpList.removeIf(emp -> "JK".equals(emp.getName()));
		System.out.println("size after removing: " + newEmpList.size());
		newEmpList.stream().map(Employee::getName).forEach(System.out::println);

		// Using parallel stream
		// when to use parallel streams ??
		List<Employee> empParallelList = Arrays.asList(array);
		List<Employee> empSeqList = Arrays.asList(array);
		long start = System.currentTimeMillis();
		List<Employee> anotherSortedItems = empParallelList.parallelStream()
				.sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		long end = System.currentTimeMillis();

		System.out.println("sorted using parallel stream");
		empList.stream().forEach(emp -> System.out.println(emp.getName()));
		System.out.println("Total the time taken process :" + (end - start) + " milisec.");

		// Using sequential stream
		start = System.currentTimeMillis();
		List<Employee> sortedItems = empSeqList.stream().sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());
		end = System.currentTimeMillis();

		System.out.println("sorted using sequential stream");
		empList.stream().forEach(emp -> System.out.println(emp.getName()));
		System.out.println("Total the time taken process :" + (end - start) + " milisec.");
		long t1, t2;
		t1 = System.currentTimeMillis();
		System.out.println("Sequential Stream Count?= " + empSeqList.stream().filter(e -> e.getRank() > 0).count());

		t2 = System.currentTimeMillis();
		System.out.println("Sequential Stream Time Taken?= " + (t2 - t1) + "\n");

		/***** Here We Are Creating A 'Parallel Stream' & Displaying The Result *****/
		t1 = System.currentTimeMillis();
		System.out
				.println("Parallel Stream Count?= " + empSeqList.parallelStream().filter(e -> e.getRank() > 0).count());

		t2 = System.currentTimeMillis();
		System.out.println("Parallel Stream Time Taken?= " + (t2 - t1));

		// https://www.baeldung.com/java-stream-ordering
		// https://stackoverflow.com/questions/20375176/should-i-always-use-a-parallel-stream-when-possible
		List<String> list = Arrays.asList("B", "A", "C", "D", "F");
		Set<String> set = new TreeSet<>(list);

		Object[] listOutput = list.stream().toArray();
		Object[] setOutput = set.stream().toArray();

		Assert.assertEquals("[B, A, C, D, F]", Arrays.toString(listOutput));
		Assert.assertEquals("[A, B, C, D, F]", Arrays.toString(setOutput));

		listOutput = list.stream().parallel().toArray();
		setOutput = set.stream().parallel().toArray();
		Assert.assertEquals("[B, A, C, D, F]", Arrays.toString(listOutput));
		Assert.assertEquals("[A, B, C, D, F]", Arrays.toString(setOutput));

		listOutput = list.stream().parallel().toArray();
		setOutput = set.stream().unordered().parallel().toArray();
		Assert.assertEquals("[B, A, C, D, F]", Arrays.toString(listOutput));
		Assert.assertEquals("[A, B, C, D, F]", Arrays.toString(setOutput));

		List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		testList.stream().forEach(System.out::print);
		System.out.println();
		testList.parallelStream().forEach(System.out::print);

	}

}
