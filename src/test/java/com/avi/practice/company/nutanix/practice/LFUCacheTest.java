package com.avi.practice.company.nutanix.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 28/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LFUCacheTest {

    @Test
    public void test1() {
        //"put","put","get","put","get","get","put","get","get","get"
        //[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]
        // null,null,1,null,-1,3,null,-1,3,4
        final int capacity = 2;
        final LFUCache cache = new LFUCache(capacity);
        cache.put(1, 1);
        cache.put(2, 2);
        int expected = cache.get(1);
        Assert.assertEquals(1, expected);
        cache.put(3, 3);
        expected = cache.get(2);
        Assert.assertEquals(-1, expected);
        expected = cache.get(3);
        Assert.assertEquals(3, expected);
        cache.put(4, 4);
        expected = cache.get(1);
        Assert.assertEquals(-1, expected);
        expected = cache.get(3);
        Assert.assertEquals(3, expected);
        expected = cache.get(4);
        Assert.assertEquals(4, expected);
    }

    @Test
    public void test2() {
        // ["LFUCache","put","put","put","put","get"]
        // [[2],[3,1],[2,1],[2,2],[4,4],[2]]
        // [null,null,null,null,null,2]
        final int capacity = 2;
        final LFUCache cache = new LFUCache(capacity);
        int expected = -1;
        cache.put(3, 1);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.put(4, 4);
        expected = cache.get(2);
        Assert.assertEquals(2, expected);
    }

    @Test
    public void test3() {
        //["LFUCache","put","get"]
        //[[0],[0,0],[0]]
        final int capacity = 0;
        final LFUCache cache = new LFUCache(capacity);
        int expected = -1;
        cache.put(0, 0);
        expected = cache.get(0);
        Assert.assertEquals(-1, expected);
    }
}