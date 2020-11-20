package com.avi.practice.leetcode.biweekly;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 20/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DefuseTheBombTest {
    private static final DefuseTheBomb solver = new DefuseTheBomb();

    @Test
    public void decrypt() {

        {
            final int[] code = {5, 7, 1, 4};
            final int k = 3;
            final int[] expected = {12, 10, 16, 13};
            System.out.println(Arrays.toString(code) + ": " + (k));
            final int[] actual = solver.decrypt(code, k);
            Assert.assertArrayEquals(expected, actual);
            System.out.println("---------------------------");
        }
        {
            final int[] code = {1,2,3,4};
            final int k = 0;
            final int[] expected = {0, 0, 0, 0};
            System.out.println(Arrays.toString(code) + ": " + (k));
            final int[] actual = solver.decrypt(code, k);
            Assert.assertArrayEquals(expected, actual);
            System.out.println("---------------------------");
        }
        {
            final int[] code = {2,4,9,3};
            final int k = -2;
            final int[] expected = {12,5,6,13};
            System.out.println(Arrays.toString(code) + ": " + (k));
            final int[] actual = solver.decrypt(code, k);
            Assert.assertArrayEquals(expected, actual);
            System.out.println("---------------------------");
        }
        {
            final int[] code = {2,4,9,3};
            final int k = -2;
            final int[] expected = {12,5,6,13};
            System.out.println(Arrays.toString(code) + ": " + (k));
            final int[] actual = solver.decrypt(code, k);
            Assert.assertArrayEquals(expected, actual);
            System.out.println("---------------------------");
        }

    }
}