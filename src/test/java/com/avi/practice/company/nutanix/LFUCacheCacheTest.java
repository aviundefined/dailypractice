package com.avi.practice.company.nutanix;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 28/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LFUCacheCacheTest {

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
    }

}