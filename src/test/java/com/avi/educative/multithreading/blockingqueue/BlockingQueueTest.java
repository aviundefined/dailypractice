package com.avi.educative.multithreading.blockingqueue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 24/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BlockingQueueTest {

    @Test
    public void usingReentrantLock() throws Exception {
        final IBlockingQueue<Integer> queue = new BlockingQueueReentrantLock<>(5);
        final Thread producer1 = new Thread(producerRunnable(queue));
        final Thread producer2 = new Thread(producerRunnable(queue));
        final Thread consumer1 = new Thread(consumerRunnable(queue));
        final Thread consumer2 = new Thread(consumerRunnable(queue));
        final Thread consumer3 = new Thread(consumerRunnable(queue));
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

        producer1.join();
        producer2.join();
        consumer1.join();
        consumer3.join();
        consumer3.join();
    }

    @Test
    public void usingSynchronized() throws Exception {
        final IBlockingQueue<Integer> queue = new BlockingQueueUsingObjectLock<>(5);
        final Thread producer1 = new Thread(producerRunnable(queue));
        final Thread producer2 = new Thread(producerRunnable(queue));
        final Thread consumer1 = new Thread(consumerRunnable(queue));
        final Thread consumer2 = new Thread(consumerRunnable(queue));
        final Thread consumer3 = new Thread(consumerRunnable(queue));
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

        producer1.join();
        producer2.join();
        consumer1.join();
        consumer3.join();
        consumer3.join();
    }

    @Test
    public void usingObjectLock() throws Exception {
        final IBlockingQueue<Integer> queue = new BlockingQueueUsingSynchronized<>(5);
        final Thread producer1 = new Thread(producerRunnable(queue));
        final Thread producer2 = new Thread(producerRunnable(queue));
        final Thread consumer1 = new Thread(consumerRunnable(queue));
        final Thread consumer2 = new Thread(consumerRunnable(queue));
        final Thread consumer3 = new Thread(consumerRunnable(queue));
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

        producer1.join();
        producer2.join();
        consumer1.join();
        consumer3.join();
        consumer3.join();
    }


    private Runnable producerRunnable(IBlockingQueue<Integer> queue) {
        return new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        final int data = randomInt();
                        System.out.println("Producer: " + Thread.currentThread().getName() + ":" + data);
                        queue.enqueue(data);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private Runnable consumerRunnable(IBlockingQueue<Integer> queue) {
        return new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Consumer: " + Thread.currentThread().getName() + ": " + queue.dequeue());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private int randomInt() {
        return (int) (Math.random() * 1000);
    }

}