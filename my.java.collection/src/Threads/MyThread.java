package src.Threads;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * //*********************************************** // Copyright UNITEDHEALTH GROUP CORPORATION 2018. // This software
 * and documentation contain confidential and // proprietary information owned by UnitedHealth Group Corporation. //
 * Unauthorized use and distribution are prohibited. //***********************************************
 */

/**
 */

/**
 * isAlive, yield, wait, sleep, join, notify (any one of the waiting threads on the given object), notifyAll (all the
 * waiting threads of the given object) https://www.geeksforgeeks.org/difference-notify-notifyall-java/
 *
 *
 * If any thread is in sleeping or waiting state then using interrupt() method, we can interrupt the execution of that
 * thread by showing InterruptedException. A thread which is in the sleeping or waiting state can be interrupted with
 * the help of interrupt() method of Thread class. if the thread is neither sleeping not waiting, calling interrupt()
 * method only sets the interrupted flag to true, which can be used by java programmer later.
 */
public class MyThread {

    public static void main(String[] args) throws InterruptedException {

        final ExecutorService service = Executors.newCachedThreadPool();

        service.execute(new Runnable() {

            @Override
            public void run() {
                for (int index = 2; index < 10000 / 2; index++) {
                    System.out.println("13" + " ");
                    if (1000000 % 2 == 0) {
                    }
                }

            }

        });
        final Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int index = 2; index < 100 / 2; index++) {
                    System.out.println("12" + " ");
                    if (1000000 % 2 == 0) {
                    }
                }
            }
        };
        System.out.println("Thread didn;t start");
        t1.start();
        System.out.println("Thread didn;t start running");
        t1.join();
        System.out.println("Thread finished printing");

    }

    public static boolean checkIFPrime(Integer input) {
        return false;
    }

    /**
     * http://www.java67.com/2012/08/5-thread-interview-questions-answers-in.html
     * https://javarevisited.blogspot.com/2018/07/java-multi-threading-interview-questions-answers-from-investment-banks.html
     *
     * BUSY SPINNING: The busy waiting is a wait strategy, where one thread wait for a condition to become true, but
     * instead of calling wait or sleep method and releasing CPU, it just spins. This is particularly useful if the
     * condition is going to be true quite quickly i.e. in a millisecond or microsecond.
     *
     * The advantage of not releasing CPU is that all cached data and instruction remain unaffected, which may be lost,
     * had this thread is suspended on one core and brought back to another thread
     *
     * Read more: http://www.java67.com/2012/08/5-thread-interview-questions-answers-in.html#ixzz5cbYn3EYi
     *
     *
     *
     * All about volatile variable
     * https://javarevisited.blogspot.com/2011/06/volatile-keyword-java-example-tutorial.html
     *
     *
     */

}
