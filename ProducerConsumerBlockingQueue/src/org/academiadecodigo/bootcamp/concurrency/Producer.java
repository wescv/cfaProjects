package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementNum;

    /**
     * @param queue the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " CAN PRODUCE " + elementNum + " ITEMS!");
        queue.separator();
        while (elementNum > 0) {
            elementNum--;
            System.out.println(Thread.currentThread().getName() + "HAS PRODUCED ONE ITEM!");
            System.out.println(Thread.currentThread().getName() + " CAN STILL PRODUCE " + elementNum + " ITEMS!");
            queue.separator();
            queue.offer(1);

        }
    }
}

