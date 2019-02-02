import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * //*********************************************** // Copyright UNITEDHEALTH GROUP CORPORATION 2019. // This software
 * and documentation contain confidential and // proprietary information owned by UnitedHealth Group Corporation. //
 * Unauthorized use and distribution are prohibited. //***********************************************
 */

/**
 */
public class ProducerConsumerProblem {

    public static void main(String[] args) throws InterruptedException {

        final BlockingQueue queue = new ArrayBlockingQueue<String>(10);

        final Thread producer = new Thread(new Producer(queue));
        final Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        System.out.println("Both producer and consumer have completed their tasks");
        System.out.println("The size of the queue remaining is:" + queue.size());

    }

}


class Producer implements Runnable {

    BlockingQueue queue = new ArrayBlockingQueue<String>(10);

    /**
     * @param queue2
     */
    public Producer(BlockingQueue queue) {
        // TODO Auto-generated constructor stub
        this.queue = queue;
    }

    /**
     *
     */
    public Producer() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the queue
     */
    public BlockingQueue getQueue() {
        return queue;
    }

    /**
     * @param queue the queue to set
     */
    public void setQueue(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        for (int i = 0; i < 4; i++) {
            System.out.println("Putting Data inside the queue");
            System.out.println("current size of the queue is" + this.queue.size());
            this.queue.add(this.queue.size() + 1);
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}


class Consumer implements Runnable {

    BlockingQueue queue = new ArrayBlockingQueue<String>(10);

    /**
     * @param queue2
     */
    public Consumer(BlockingQueue queue) {
        // TODO Auto-generated constructor stub
        this.queue = queue;
    }

    /**
     *
     */
    public Consumer() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 4; i++) {
            System.out.println("Reading from the queue");
            System.out.println("From Consumer: current size of the queue is" + this.queue.size());
            System.out.println(queue.poll());
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
