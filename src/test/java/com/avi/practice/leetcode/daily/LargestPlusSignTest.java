package com.avi.practice.leetcode.daily;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by navinash on 10/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LargestPlusSignTest extends TestCase {

    public void testOrderOfLargestPlusSign1() {
        final LargestPlusSign solver = new LargestPlusSign();
        final int n = 5;
        final int[][] mines = {
                {4,2}
        };
        final int expected = 2;
        final int actual = solver.orderOfLargestPlusSign(n, mines);
        Assert.assertEquals(expected, actual);

        final TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(2, 0);
        final List<Integer> collect = map.values()
                .stream()
                .filter(v -> v != 0)
                .sorted((a, b) -> b - a).collect(Collectors.toList());
    }
}