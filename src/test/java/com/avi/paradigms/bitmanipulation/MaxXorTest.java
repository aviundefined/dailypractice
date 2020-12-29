package com.avi.paradigms.bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 29/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxXorTest {

    private static final MaxXor solver = new MaxXor();
    @Test
    public void maxXor() {
        final int[] nums = { 25, 10, 2, 8, 5, 3 };
        final int expected = 28;
        final int actual = solver.maxXor(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }
}