package com.avi.practice.company.google;

import com.avi.practice.company.google.CountOfSmallerNumbersAfterSelf.FenwickTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 20/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */

public class CountOfSmallerNumbersAfterSelfTest {

    @Test
    public void countSmaller1() {
        final CountOfSmallerNumbersAfterSelf solver = new CountOfSmallerNumbersAfterSelf();
        final int[] nums = {5, 2, 6, 1};
        final List<Integer> expected = Arrays.asList(2, 1, 1, 0);
        final List<Integer> actual = solver.countSmaller(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void countSmaller2() {
        final CountOfSmallerNumbersAfterSelf solver = new CountOfSmallerNumbersAfterSelf();
        final int[] nums = {-1};
        final List<Integer> expected = Collections.singletonList(0);
        final List<Integer> actual = solver.countSmaller(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void countSmaller3() {
        final CountOfSmallerNumbersAfterSelf solver = new CountOfSmallerNumbersAfterSelf();
        final int[] nums = {-1, -1};
        final List<Integer> expected = Arrays.asList(0, 0);
        final List<Integer> actual = solver.countSmaller(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void countSmaller4() {
        final CountOfSmallerNumbersAfterSelf solver = new CountOfSmallerNumbersAfterSelf();
        final int[] nums = {-1, -2};
        final List<Integer> expected = Arrays.asList(1, 0);
        final List<Integer> actual = solver.countSmaller(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void testFenwickTree1() {
        final int[] arr = {3, 1, 5, -2, -1, 4, 6, -5, 3, 8, -6, -7, 2, 9, 6, -4};
        final FenwickTree fenwickTree = new FenwickTree(arr);
        fenwickTree.print();
    }
}