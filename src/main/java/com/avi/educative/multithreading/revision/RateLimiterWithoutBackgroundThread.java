package com.avi.educative.multithreading.revision;

/**
 * Created by navinash on 21/11/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RateLimiterWithoutBackgroundThread {

    private static final long LOCK_GENERATION_FREQ = 1000L;
    private final int maxTokens;
    private long possibleLocks = 0L;
    private long lastExecutionTime;

    public RateLimiterWithoutBackgroundThread(final int maxTokens) {
        this.maxTokens = maxTokens;
        lastExecutionTime = System.currentTimeMillis();
    }

    public final synchronized void getToken() throws InterruptedException {
        possibleLocks += (System.currentTimeMillis() - lastExecutionTime) / LOCK_GENERATION_FREQ;
        possibleLocks = Math.max(possibleLocks, maxTokens);
        if (possibleLocks == 0) {
            Thread.sleep(LOCK_GENERATION_FREQ);
        } else {
            possibleLocks--;
        }
        lastExecutionTime = System.currentTimeMillis();
    }
}
