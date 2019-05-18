package src.Threads;

import java.util.LinkedList;
import java.util.Queue;


/**
 */
public class ProducerConsumerWithoutBlockingQueue {

    public static void main(String[] args) throws InterruptedException {

        final Queue queue = new LinkedList<String>();

        final Thread producer = new Thread(new ProducerTwo(queue));
        final Thread consumer = new Thread(new ConsumerTwo(queue));
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        System.out.println("Both producer and consumer have completed their tasks");
        System.out.println("The size of the queue remaining is:" + queue.size());

    }

}


class ProducerTwo implements Runnable {

    Queue queue = new LinkedList<String>();

    /**
     * @param queue2
     */
    public ProducerTwo(Queue queue) {
        // TODO Auto-generated constructor stub
        this.queue = queue;
    }

    /**
     *
     */
    public ProducerTwo() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the queue
     */
    public Queue getQueue() {
        return queue;
    }

    /**
     * @param queue the queue to set
     */
    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        for (int i = 0; i < 4; i++) {
            System.out.println("Putting Data inside the queue");
            System.out.println("current size of the queue is" + this.queue.size());
            this.queue.add(i * 21);
            try {
                synchronized (queue) {
                    queue.notify();
                }
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}


class ConsumerTwo implements Runnable {

    Queue queue = new LinkedList<String>();

    /**
     * @param queue2
     */
    public ConsumerTwo(Queue queue) {
        // TODO Auto-generated constructor stub
        this.queue = queue;
    }

    /**
     *
     */
    public ConsumerTwo() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 4; i++) {
            System.out.println("Reading from the queue");
            System.out.println("From Consumer: current size of the queue is" + this.queue.size());

            try {
                if (this.queue.size() <= 0) {
                    synchronized (queue) {
                        System.out.println("Queue is empty, waiting for producer to put the data");
                        queue.wait();
                        System.out.println("Consumer got notifiied");
                    }
                }

            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("Reading data" + queue.poll());
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
