package src.Threads;


/**
 * https://www.journaldev.com/1079/multithreading-in-java http://tutorials.jenkov.com/java-concurrency/index.html
 *
 */
public class MyThreadExecutionClass {

    public static void main(String[] args) {
        final MyThreadExecutionClass obj = new MyThreadExecutionClass();
        // obj.deadLockWithSingleLine();
        try {
            obj.multipleJoinExample();
        } catch (final Exception ex) {
            System.out.println("Caught Exception");

        }

        // obj.deamonThreadExample();
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.activeCount());
        Thread.currentThread().checkAccess();
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY); // 10
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY); // 1

        // fetching the priority and state of thread1
        System.out
                .println(
                        "Priority of " + Thread.currentThread().getName() + " thread = "
                                + Thread.currentThread().getPriority());
        obj.synchronizationExample();

    }

    public void deadLockWithSingleLine() {
        System.out.println("Thread started");
        try {
            Thread.currentThread().join();
        } catch (final Exception e) {
            System.out.println("Caught Exception");

        }
        System.out.println("Thread Stopped");
    }

    public void multipleJoinExample() throws InterruptedException {
        final MyThread t1 = new MyThread();
        final MyThread t2 = new MyThread();
        final MyThread t3 = new MyThread();

        // all these methods are not working if MyThread implements runnable and not
        // extends Thread class, read why ?
        t1.start();
        t1.join();

        t2.start();
        t2.join();
        t3.run(); // it is not the new thread that is executed but the thread that created the new thread
        t3.join();
        System.out.println("All threads completed execution");
    }

    public void deamonThreadExample() {
        final Thread t1 = new Thread(new MyThreadWithRunnable(), "t1");
        final Thread t2 = new Thread(new MyThreadWithRunnable(), "t2");

        t1.setDaemon(true);
        t1.start();
        try {
            t1.join();
        } catch (final Exception ex) {

        }
        t2.start();
        try {
            t2.join();
        } catch (final Exception ex) {

        }
    }

    public void synchronizationExample() {
        final MyThreadWithRunnable obj1 = new MyThreadWithRunnable();
        final Thread t1 = new Thread(obj1, "t1");
        final Thread t2 = new Thread(obj1, "t2");
        t1.start();
        t2.start();
    }

    /**
     * cannot set a thread as daemon after starting JVM wait for user threads and not for Deamon threads
     */
    public void deamonThreadExceptionExample() {
        final Thread t1 = new Thread(new MyThreadWithRunnable(), "threadName");
        t1.start();
        t1.setDaemon(true); // throws IllegalThreadStateException exception

    }

    public void testMethod() {
        // yet to read about ThreadLocal, ThreadGroup, ConextClassLoader
    }

    public class MyThread extends Thread {

        @Override
        public void run() {
            if (Thread.currentThread().isDaemon()) {
                System.out.println(Thread.currentThread().getName() + ": Deamon Thread started");

            } else {
                System.out.println(Thread.currentThread().getName() + ": Thread started");

            }
            try {
                Thread.sleep(1000);
            } catch (final Exception e) {
                System.out.println("Caught Exception");

            }
            if (Thread.currentThread().isDaemon()) {
                System.out.println(Thread.currentThread().getName() + ": Deamon Thread Stopped");
            } else {
                System.out.println(Thread.currentThread().getName() + ": Thread Stopped");

            }

        }
    }

    public class MyThreadWithRunnable implements Runnable {

        int num1 = 0;

        public void addOne(int inc) {
            System.out.println("Adding from " + Thread.currentThread().getName());
            num1 = num1 + inc;
        }

        @Override
        public void run() {
            if (Thread.currentThread().isDaemon()) {
                System.out.println(Thread.currentThread().getName() + ": Deamon Thread started");

            } else {
                System.out.println(Thread.currentThread().getName() + ": Thread started");

            }
            try {
                synchronized (this) {
                    for (int i = 0; i < 10; i++) {
                        this.addOne(1);
                        Thread.sleep(100);
                    }
                }
            } catch (final Exception e) {
                System.out.println("Caught Exception");

            }
            if (Thread.currentThread().isDaemon()) {
                System.out.println(Thread.currentThread().getName() + ": Deamon Thread Stopped");
            } else {
                System.out.println(Thread.currentThread().getName() + ": Thread Stopped");

            }

        }
    }

}
