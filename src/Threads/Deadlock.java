/**
 *
 */
// https://www.geeksforgeeks.org/deadlock-starvation-java/
public class Deadlock {
    /**
     * @param args the command line arguments
     */
    // cant be considered as deadlock, since the definition says atleast two different thread
    public static void main(String[] args) throws InterruptedException {
        System.out.println("before deadlock");
        Thread.currentThread().join();
        System.out.println("after deadlock stated");
    }
}


class Deadlock2 implements Runnable {

    public static Thread mainThread;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            mainThread.join();
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // working
    public static void main(String[] args) {
        System.out.println("Deadlock2 execution started");
        Deadlock2.mainThread = Thread.currentThread();
        final Thread thread = new Thread(new Deadlock2());
        thread.start();
        try {
            thread.join(10000);
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Thread Execution Complete");

    }

}
