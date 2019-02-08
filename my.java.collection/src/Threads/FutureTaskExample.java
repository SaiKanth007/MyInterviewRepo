package src.Threads;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

//https://blog.codecentric.de/en/2011/10/executing-tasks-in-parallel-using-java-future/
public class FutureTaskExample {

	public static final int MAX_NUMBER = 2000000000;

	/**
	 * Maximum amount of numbers to check
	 */

	/**
	 * Returns the amount of numbers that can be divided by the divisor without
	 * remainder.
	 * 
	 * @param first
	 *            First number to check
	 * @param last
	 *            Last number to check
	 * @param divisor
	 *            Divisor
	 * @return Amount of numbers that can be divided by the divisor without
	 *         remainder
	 */
	public static int amountOfDivisibleBy(int first, int last, int divisor) {

		int amount = 0;
		for (int i = first; i <= last; i++) {
			if (i % divisor == 0) {
				amount++;
			}
		}
		return amount;
	}

	/**
	 * Returns the amount of numbers that can be divided by the divisor without
	 * remainder (using parallel execution).
	 * 
	 * @param first
	 *            First number to check
	 * @param last
	 *            Last number to check
	 * @param divisor
	 *            Divisor
	 * @return Amount of numbers that can be divided by the divisor without
	 *         remainder
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static int amountOfDivisibleByFuture(final int first, final int last, final int divisor)
			throws InterruptedException, ExecutionException {

		int amount = 0;

		// Prepare to execute and store the Futures
		int threadNum = 2;
		ExecutorService executor = Executors.newFixedThreadPool(threadNum);
		List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();

		// Start thread for the first half of the numbers
		FutureTask<Integer> futureTask_1 = new FutureTask<Integer>(new Callable<Integer>() {
			@Override
			public Integer call() {
				return FutureTaskExample.amountOfDivisibleBy(first, last / 2, divisor);
			}
		});
		taskList.add(futureTask_1);
		executor.execute(futureTask_1);

		// Start thread for the second half of the numbers
		FutureTask<Integer> futureTask_2 = new FutureTask<Integer>(new Callable<Integer>() {
			@Override
			public Integer call() {
				return FutureTaskExample.amountOfDivisibleBy(last / 2 + 1, last, divisor);
			}
		});
		taskList.add(futureTask_2);
		executor.execute(futureTask_2);

		// Wait until all results are available and combine them at the same time
		for (int j = 0; j < threadNum; j++) {
			FutureTask<Integer> futureTask = taskList.get(j);
			amount += futureTask.get();
		}
		executor.shutdown();

		return amount;
	}

	/**
	 * Executing the example.
	 * 
	 * @param args
	 *            Command line arguments
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// Sequential execution
		long timeStart = Calendar.getInstance().getTimeInMillis();
		int result = FutureTaskExample.amountOfDivisibleBy(0, MAX_NUMBER, 3);
		long timeEnd = Calendar.getInstance().getTimeInMillis();
		long timeNeeded = timeEnd - timeStart;
		System.out.println("Result         : " + result + " calculated in " + timeNeeded + " ms");

		// Parallel execution
		long timeStartFuture = Calendar.getInstance().getTimeInMillis();
		int resultFuture = FutureTaskExample.amountOfDivisibleByFuture(0, MAX_NUMBER, 3);
		long timeEndFuture = Calendar.getInstance().getTimeInMillis();
		long timeNeededFuture = timeEndFuture - timeStartFuture;
		System.out.println("Result (Future): " + resultFuture + " calculated in " + timeNeededFuture + " ms");
	}

}
