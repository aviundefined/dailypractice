package com.avi.practice.leetcode.weeklycontest.num159;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class StringBalancerTest {

    @Test
    public void minReplace() {
        {
            final String s = "QWER";
            final StringBalancer balancer = new StringBalancer();
            final int expected = 0;
            final int actual = balancer.minReplacements(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "QWWR";
            final StringBalancer balancer = new StringBalancer();
            final int expected = 1;
            final int actual = balancer.minReplacements(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "QQQQ";
            final StringBalancer balancer = new StringBalancer();
            final int expected = 3;
            final int actual = balancer.minReplacements(s);
            Assert.assertEquals(s, expected, actual);
        }

        {
            final String s = "WQWRQQQW";
            final StringBalancer balancer = new StringBalancer();
            final int expected = 3;
            final int actual = balancer.minReplacements(s);
            Assert.assertEquals(s, expected, actual);
            // s = 0 , e = 5;
            // s = 1, e = 5;
        }
    }

}