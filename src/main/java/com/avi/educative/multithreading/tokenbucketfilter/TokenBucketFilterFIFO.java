package com.avi.educative.multithreading.tokenbucketfilter;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TokenBucketFilterFIFO {

    private static final long LOCK_GENERATION_FREQ = 1000L;
    private final int MAX_TOKENS;
    private volatile long lastRequestTime = System.currentTimeMillis();
    private volatile long possibleLocks = 0;
    private ReentrantLock lock = new ReentrantLock(true);

    public TokenBucketFilterFIFO(final int maxTokens) {
        this.MAX_TOKENS = maxTokens;
    }

    public final synchronized void getToken() throws InterruptedException {
        lock.lock();
        possibleLocks += (System.currentTimeMillis() - lastRequestTime) / LOCK_GENERATION_FREQ;

        if (possibleLocks > MAX_TOKENS) {
            possibleLocks = MAX_TOKENS;
        }
        if (possibleLocks == 0) {
            Thread.sleep(LOCK_GENERATION_FREQ);
        } else {
            possibleLocks--;
        }
        lastRequestTime = System.currentTimeMillis();
        System.out.println("Thread " + Thread.currentThread().getName() + " got token at " + lastRequestTime);
        lock.unlock();
    }
}
