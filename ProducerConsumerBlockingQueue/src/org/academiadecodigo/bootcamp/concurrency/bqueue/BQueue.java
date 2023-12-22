package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Blocking Queue
 *
 * @param <T> the type of elements stored by this queue
 */
public final class BQueue<T> {
    private Queue<T> queue;
    private int limit;

    /**
     * Constructs a new queue with a maximum size
     *
     * @param limit the queue size
     */
    public BQueue(int limit) {
        queue = new LinkedList<>();
        this.limit = limit;
    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     *
     * @param data the data to add to the queue
     */
    public synchronized void offer(T data) {
        if (data == null) {
            return;
        }
        while (queue.size() == limit) {
            try {
                System.out.println(Thread.currentThread().getName() + " WAITING: QUEUE IS FULL. PRODUCTION STOPPED.");
                separator();
                wait();


            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            
        }

        queue.offer(data);
        notifyAll();
        System.out.println(Thread.currentThread().getName() + ": QUEUE HAS SPACE... CONTINUING PRODUCTION!");
        getSize();
        separator();


    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     *
     * @return the data from the head of the queue
     */
    public synchronized T poll() {
        while (true) {
            if (queue.size() == 0) {
                notifyAll();
            }
            while (queue.size() > 0) {
                System.out.println(Thread.currentThread().getName() + " REMOVED ONE ITEM FROM QUEUE: ");
                separator();

                return queue.remove();

            }

        }

    }

    /**
     * Gets the number of elements in the queue
     *
     * @return the number of elements
     */
    public int getSize() {
        System.out.println("CURRENTLY ON QUEUE: " + queue.size());
        return queue.size();
    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     *
     * @return the maximum number of elements
     */
    public int getLimit() {
        return limit;
    }

    public void separator() {
        System.out.println("--------------------------");
    }
}
