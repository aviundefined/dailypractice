package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 22/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInKMovesTest {

    private static final MinimumDifferenceBetweenLargestAndSmallestValueInKMoves solver = new MinimumDifferenceBetweenLargestAndSmallestValueInKMoves();

    @Test
    public void minDifference1() {
        final int[] nums = {5, 3, 2, 4};
        final int expected = 0;
        final int actual = solver.minDifference(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void minDifference2() {
        final int[] nums = {1, 5, 0, 10, 14};
        final int expected = 1;
        final int actual = solver.minDifference(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }
}