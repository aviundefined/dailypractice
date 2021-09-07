package com.avi.practice.leetcode.daily;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by navinash on 06/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class OrderlyQueueTest  {

    @Test
    public void testOrderlyQueue1() {
        final OrderlyQueue solver = new OrderlyQueue();
        final String s = "cba";
        final int k = 1;
        final String expected = "acb";
        final String actual = solver.orderlyQueue(s, k);
        Assert.assertEquals(String.format("s: %s, k: %s", s, k), expected, actual);
    }

    @Test
    public void testOrderlyQueue2() {
        final OrderlyQueue solver = new OrderlyQueue();
        final String s = "baaca";
        final int k = 3;
        final String expected = "aaabc";
        final String actual = solver.orderlyQueue(s, k);
        Assert.assertEquals(String.format("s: %s, k: %s", s, k), expected, actual);
    }

    @Test
    public void testOrderlyQueue3() {
        final OrderlyQueue solver = new OrderlyQueue();
        final String s = "xyokshvwx";
        final int k = 9;
        final String expected = "aaabc";
        final String actual = solver.orderlyQueue(s, k);
        Assert.assertEquals(String.format("s: %s, k: %s", s, k), expected, actual);
    }
}