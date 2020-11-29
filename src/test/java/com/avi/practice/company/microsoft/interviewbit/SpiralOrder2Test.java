package com.avi.practice.company.microsoft.interviewbit;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SpiralOrder2Test {

    private static final SpiralOrder2 solver = new SpiralOrder2();

    @Test
    public void generateMatrix1() {
        final int n = 1;
        final int[][] expected = {
                {1}
        };
        final ArrayList<ArrayList<Integer>> actual = solver.generateMatrix(n);
        Assert.assertEquals(String.valueOf(n), solver._convert(expected), actual);
    }

    @Test
    public void generateMatrix2() {
        final int n = 2;
        final int[][] expected = {
                {1, 2},
                {4, 3}
        };
        final ArrayList<ArrayList<Integer>> actual = solver.generateMatrix(n);
        Assert.assertEquals(String.valueOf(n), solver._convert(expected), actual);
    }

    @Test
    public void generateMatrix3() {
        final int n = 3;
        final int[][] expected = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5},
        };
        final ArrayList<ArrayList<Integer>> actual = solver.generateMatrix(n);
        Assert.assertEquals(String.valueOf(n), solver._convert(expected), actual);
    }

    @Test
    public void generateMatrix4() {
        final int n = 4;
        final int[][] expected = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7},
        };
        final ArrayList<ArrayList<Integer>> actual = solver.generateMatrix(n);
        Assert.assertEquals(String.valueOf(n), solver._convert(expected), actual);
    }

}