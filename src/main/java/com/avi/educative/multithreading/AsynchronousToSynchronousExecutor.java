package com.avi.educative.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AsynchronousToSynchronousExecutor {

    interface Callback {
        void done();
    }

    public static class SynchronousExecutorUsingSemaphore extends Executor {

        public void asynchronousExecution(Callback callback) throws Exception {
            final Semaphore semaphore = new Semaphore(0);
            final Callback cb = () -> {
                callback.done();
                semaphore.release(1);
            };
            super.asynchronousExecution(cb);
            semaphore.acquire();
        }
    }

    public static class SynchronousExecutorUsingMonitor extends Executor {

        public void asynchronousExecution(Callback callback) throws Exception {
            final Object lock = new Object();
            final boolean[] isDone = new boolean[1];
            final Callback cb = () -> {
                callback.done();
                synchronized (lock) {
                    isDone[0] = true;
                    lock.notify();
                }
            };
            super.asynchronousExecution(cb);
            synchronized (lock) {
                while (!isDone[0]) {
                    lock.wait();
                }
            }
        }
    }

    public static class Executor {

        public void asynchronousExecution(Callback callback) throws Exception {

            Thread t = new Thread(() -> {
                // Do some useful work
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ie) {
                }
                callback.done();
            });
            t.start();
        }
    }
}
