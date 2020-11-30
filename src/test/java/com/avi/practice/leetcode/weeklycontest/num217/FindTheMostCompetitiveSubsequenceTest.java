package com.avi.practice.leetcode.weeklycontest.num217;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 30/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FindTheMostCompetitiveSubsequenceTest {
private static FindTheMostCompetitiveSubsequence solver = new FindTheMostCompetitiveSubsequence();
    @Test
    public void mostCompetitive1() {
        final int[] nums = {3,5,2,6};
        final int k = 2;
        final int[] expected = {2, 6};
        System.out.printf("nums: %s, length: %d\n", Arrays.toString(nums), k);
        final int[] actual = solver.mostCompetitive(nums, k);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void mostCompetitive2() {
        final int[] nums = {2,4,3,3,5,4,9,6};
        final int k = 4;
        final int[] expected = {2,3,3,4};
        System.out.printf("nums: %s, length: %d\n", Arrays.toString(nums), k);
        final int[] actual = solver.mostCompetitive(nums, k);
        Assert.assertArrayEquals(expected, actual);
    }
}