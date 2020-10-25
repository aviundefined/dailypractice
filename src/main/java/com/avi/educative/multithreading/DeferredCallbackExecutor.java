package com.avi.educative.multithreading;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DeferredCallbackExecutor {

    private final Queue<CallBack> queue = new PriorityQueue<>((o1, o2) -> (int) (o1.executeAt - o2.executeAt));
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition newCallBackArrived = lock.newCondition();

    public void start() throws InterruptedException {
        // indefinitely check for callbacks queue
        while (true) {
            lock.lock();
            // if no callbacks then wait for new call back to come
            if (queue.isEmpty()) {
                newCallBackArrived.await();
            }
            // callbacks are in queue then now see how much time it has to sleep before if sleep time is 0 or less than 0 break and execute

            while (!queue.isEmpty()) {
                final long sleepFor = sleepDuration();
                if (sleepFor <= 0) {
                    break;
                }
                newCallBackArrived.await(sleepFor, TimeUnit.MILLISECONDS);
            }
            final CallBack callback = queue.poll();
            if (callback != null) {
                System.out.println(
                        "Executed at " + System.currentTimeMillis() / 1000 + " required at " + callback.executeAt / 1000
                                + ": message:" + callback.message);
            }
            lock.unlock();
        }
    }

    public void register(final CallBack callback) {
        lock.lock();
        queue.add(callback);
        newCallBackArrived.signal();
        lock.unlock();
    }

    private long sleepDuration() {
        return queue.isEmpty() ? 0L : queue.peek().executeAt - System.currentTimeMillis();
    }

    public static final class CallBack {
        private final long executeAt;
        private final String message;

        public CallBack(final long executeAfterMs, final String message) {
            this.executeAt = System.currentTimeMillis() + executeAfterMs;
            this.message = message;
        }
    }
}
