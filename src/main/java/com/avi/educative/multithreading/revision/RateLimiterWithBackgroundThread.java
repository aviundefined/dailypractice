package com.avi.educative.multithreading.revision;

/**
 * Created by navinash on 21/11/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RateLimiterWithBackgroundThread {

    private static final long LOCK_GENERATION_FREQ = 1000L;
    private final int maxTokens;
    private volatile long possibleLocks = 0L;
    private final Object lock = new Object();
    private final Thread tokenGenerator;

    public RateLimiterWithBackgroundThread(final int maxTokens) {
        this.maxTokens = maxTokens;
        this.tokenGenerator = new Thread(this::generateToken);
        this.tokenGenerator.setDaemon(true);
    }

    public final void start() {
        this.tokenGenerator.start();
    }

    public final void stop() {
        this.tokenGenerator.interrupt();
    }

    public final synchronized void getToken() throws InterruptedException {
        synchronized (lock) {
            while (possibleLocks == 0) {
                lock.wait();
            }
            possibleLocks--;
        }
    }

    private void generateToken() {
        while (true) {
            synchronized (lock) {
                if (possibleLocks < maxTokens) {
                    possibleLocks++;
                }
                lock.notify();
            }

            try {
                Thread.sleep(LOCK_GENERATION_FREQ);
            } catch (final InterruptedException ignored) {

            }
        }
    }
}
