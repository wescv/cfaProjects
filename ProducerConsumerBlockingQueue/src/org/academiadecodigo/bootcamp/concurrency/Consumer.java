package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (elementNum > 0) {
                if (queue.getSize() == 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " NO ITEMS AVAILABLE. WAITING FOR PRODUCTION!");
                        queue.separator();
                        queue.wait(); // Wait for producers to notify

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                elementNum--;
                queue.poll();
                System.out.println(Thread.currentThread().getName() + " CAN STILL CONSUME " + elementNum + " ITEMS!");
                queue.separator();
            }

        }
    }
}


