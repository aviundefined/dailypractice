package com.avi.practice.company.google;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by navinash on 08/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TimeMap {


    private final Map<String, TreeMap<Integer, String>> cache = new HashMap<>();

    /** Initialize your data structure here. */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        final TreeMap<Integer, String> keyCache = this.cache.computeIfAbsent(key, k -> new TreeMap<>());
        keyCache.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        final TreeMap<Integer, String> keyCache  = this.cache.get(key);
        if(keyCache == null) {
            return "";
        }
        final Integer floorKey =  keyCache.floorKey(timestamp);
        if(floorKey == null) {
            return "";
        }
        return keyCache.getOrDefault(floorKey, "");
    }
}
