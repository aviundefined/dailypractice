package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 06/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FirstMissingNumberTest {

    @Test
    public void firstMissingPositive1() {
        final FirstMissingNumber solver = new FirstMissingNumber();
        final int[] nums = {1, 2, 0};
        final int expected = 3;
        final int actual = solver.firstMissingPositive(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void firstMissingPositive2() {
        final FirstMissingNumber solver = new FirstMissingNumber();
        final int[] nums = {3, 4, -1, 1};
        final int expected = 2;
        final int actual = solver.firstMissingPositive(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void firstMissingPositive3() {
        final FirstMissingNumber solver = new FirstMissingNumber();
        final int[] nums = {7, 8, 9, 11, 12};
        final int expected = 1;
        final int actual = solver.firstMissingPositive(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void firstMissingPositive4() {
        final FirstMissingNumber solver = new FirstMissingNumber();
        final int[] nums = {0};
        final int expected = 1;
        final int actual = solver.firstMissingPositive(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }
}