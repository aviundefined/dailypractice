package com.avi.pepcoding.stack_queues;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 14/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SmallestNumberFollowingPatternTest {

    @Test
    public void smallestNumberFollowingPattern1() {
        final SmallestNumberFollowingPattern solver = new SmallestNumberFollowingPattern();
        final String pattern = "ddiddidd";
        final int expected = 321654987;
        final int actual = solver.smallestNumberFollowingPattern(pattern);
        Assert.assertEquals(pattern, expected, actual);
    }
}