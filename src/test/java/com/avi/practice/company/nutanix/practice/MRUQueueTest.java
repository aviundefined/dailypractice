package com.avi.practice.company.nutanix.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 28/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MRUQueueTest {

    @Test
    public void test() {
        /*
         * ["MRUQueue", "fetch", "fetch", "fetch", "fetch"]
         * [[8], [3], [5], [2], [8]]
         * [null, 3, 6, 2, 2]
         */
        final int capacity = 8;
        int expected = -1;
        int actual = -1;
        int k = -1;
        final MRUQueue queue = new MRUQueue(capacity);

        k = 3;
        expected = 3;
        actual = queue.fetch(k);
        Assert.assertEquals(String.valueOf(k), expected, actual);

        k = 5;
        expected = 6;
        actual = queue.fetch(k);
        Assert.assertEquals(String.valueOf(k), expected, actual);

        k = 2;
        expected = 2;
        actual = queue.fetch(k);
        Assert.assertEquals(String.valueOf(k), expected, actual);

        k = 9;
        expected = 2;
        actual = queue.fetch(k);
        Assert.assertEquals(String.valueOf(k), expected, actual);
    }
}