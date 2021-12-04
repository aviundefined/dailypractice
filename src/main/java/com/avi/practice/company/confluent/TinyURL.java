package com.avi.practice.company.confluent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by navinash on 04/12/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TinyURL {

    private static final char[] charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private static final int length = charSet.length;
    private static final int NUM = 26;
    private final Map<Long, String> shortUrlById = new HashMap<>();
    private final ReentrantLock encodeLock = new ReentrantLock();

    public String encode(final String url) {
        encodeLock.lock();
        try {
            final long id = getNewId();
            final String shortUrl = _encode(id);
            shortUrlById.put(id, url);
            return shortUrl;
        } finally {
            encodeLock.unlock();
        }
    }

    public String decode(final String shortUrl) {
        final long id = _decode(shortUrl);
        if (shortUrlById.containsKey(id)) {
            return shortUrlById.get(id);
        }
        throw new IllegalArgumentException("Invalid shortUrl: " + shortUrl);
    }

    private static String _encode(long num) {
        final StringBuilder sb = new StringBuilder();
        while (num > 0) {
            final int mod = (int) (num % length);
            sb.append(charSet[mod]);
            num = num / length;
        }
        return sb.reverse().toString();
    }


    private long _decode(final String str) {
        long num = 0L;
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            if ('a' <= c && c <= 'z') {
                num = num * length + (c - 'a');
            } else if ('A' <= c && c <= 'Z') {
                num = num * length + (c - 'A' + NUM);
            } else if ('0' <= c && c <= '9') {
                num = num * length + (c - '0' + (NUM * 2));
            }
        }
        return num;
    }

    private long getNewId() {
        long id = new Random().nextLong();
        while (id <= 0 || shortUrlById.containsKey(id)) {
            id = new Random().nextLong();
        }
        return id;
    }
}
