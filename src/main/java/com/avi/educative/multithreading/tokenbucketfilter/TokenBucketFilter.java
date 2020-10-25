package com.avi.educative.multithreading.tokenbucketfilter;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TokenBucketFilter {

    private static final long LOCK_GENERATION_FREQ = 1000L;
    private final int MAX_TOKENS;
    private volatile long lastRequestTime = System.currentTimeMillis();
    private volatile long possibleTokens = 0;

    public TokenBucketFilter(final int maxTokes) {
        this.MAX_TOKENS = maxTokes;
    }

    public synchronized void getToken() throws InterruptedException {
        possibleTokens += (System.currentTimeMillis() - lastRequestTime) / LOCK_GENERATION_FREQ;
        if (possibleTokens > MAX_TOKENS) {
            possibleTokens = MAX_TOKENS;
        }
        if (possibleTokens == 0) {
            Thread.sleep(LOCK_GENERATION_FREQ);
        } else {
            possibleTokens--;
        }
        lastRequestTime = System.currentTimeMillis();
        System.out.println("Thread " + Thread.currentThread().getName() + " got token at " + lastRequestTime);
    }
}
