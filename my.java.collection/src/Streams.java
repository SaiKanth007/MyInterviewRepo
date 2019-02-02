package src;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import src.Utilities.Employee;

// https://stackify.com/streams-guide-java-8/
// https://github.com/Baeldung/stackify/blob/master/core-java/src/test/java/com/stackify/stream/EmployeeTest.java
/**
 * Things to read 1. Infinite streams 2. Parallel Streams
 *
 */
public class Streams {

    public static void main(String[] args) {
        final Employee[] array =
                        {new Employee("Jack", "A124"), new Employee("Sam", "A234"), new Employee("John", "A435")};

        // two different ways of creating streams
        List<Employee> empList = Arrays.asList(array);
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

        final List<String> empIds = empList.stream().map(Employee::getId).collect(Collectors.toList());
        empIds.stream();

        final String commaSeperatedIds =
                        empList.stream().map(Employee::getName).collect(Collectors.joining(", ")).toString();
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
        newEmpList.removeIf(emp -> "testing".equals(emp.getName()));
        newEmpList.stream().map(Employee::getName).forEach(System.out::println);
    }

}
