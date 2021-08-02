package com.avi.pepcoding.stack_queues;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 02/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NextGreaterElementTest {

    @Test
    public void nextGreaterElements_from_right_to_left1() {
        final NextGreaterElement solver = new NextGreaterElement();
        final int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        final int[] result = {5, 9, 12, 12, 12, -1, 8, -1, -1};
        final int [] actual = solver.nextGreaterElements_from_right_to_left(arr);
        Assert.assertArrayEquals(Arrays.toString(arr), result, actual);
    }

    @Test
    public void nextGreaterElements_from_right_to_lef1() {
        final NextGreaterElement solver = new NextGreaterElement();
        final int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        final int[] result = {5, 9, 12, 12, 12, -1, 8, -1, -1};
        final int [] actual = solver.nextGreaterElements_from_right_to_left(arr);
        Assert.assertArrayEquals(Arrays.toString(arr), result, actual);
    }
}