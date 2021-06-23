package com.avi.pepcoding.dp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 23/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumSumSquareTest {

    private static final MaximumSumSquare solver = new MaximumSumSquare();

    @Test
    public void getMinSumSquares0() {
        final int num  = 0;
        final int expected = 0;
        final int actual = solver.getMinSumSquares(num);
        Assert.assertEquals(String.valueOf(num), expected, actual);
    }

    @Test
    public void getMinSumSquares1() {
        final int num  = 1;
        final int expected = 1;
        final int actual = solver.getMinSumSquares(num);
        Assert.assertEquals(String.valueOf(num), expected, actual);
    }

    @Test
    public void getMinSumSquares2() {
        final int num  = 2;
        final int expected = 2;
        final int actual = solver.getMinSumSquares(num);
        Assert.assertEquals(String.valueOf(num), expected, actual);
    }

    @Test
    public void getMinSumSquares3() {
        final int num  = 3;
        final int expected = 3;
        final int actual = solver.getMinSumSquares(num);
        Assert.assertEquals(String.valueOf(num), expected, actual);
    }

    @Test
    public void getMinSumSquares4() {
        final int num  = 4;
        final int expected = 1;
        final int actual = solver.getMinSumSquares(num);
        Assert.assertEquals(String.valueOf(num), expected, actual);
    }

    @Test
    public void getMinSumSquares5() {
        final int num  = 5;
        final int expected = 2;
        final int actual = solver.getMinSumSquares(num);
        Assert.assertEquals(String.valueOf(num), expected, actual);
    }

    @Test
    public void getMinSumSquares6() {
        final int num  = 6;
        final int expected = 3;
        final int actual = solver.getMinSumSquares(num);
        Assert.assertEquals(String.valueOf(num), expected, actual);
    }

    @Test
    public void getMinSumSquares7() {
        final int num  = 7;
        final int expected = 4;
        final int actual = solver.getMinSumSquares(num);
        Assert.assertEquals(String.valueOf(num), expected, actual);
    }

    @Test
    public void getMinSumSquares8() {
        final int num  = 8;
        final int expected = 2;
        final int actual = solver.getMinSumSquares(num);
        Assert.assertEquals(String.valueOf(num), expected, actual);
    }

    @Test
    public void getMinSumSquares9() {
        final int num  = 9;
        final int expected = 1;
        final int actual = solver.getMinSumSquares(num);
        Assert.assertEquals(String.valueOf(num), expected, actual);
    }

    @Test
    public void getMinSumSquares10() {
        final int num  = 10;
        final int expected = 2;
        final int actual = solver.getMinSumSquares(num);
        Assert.assertEquals(String.valueOf(num), expected, actual);
    }

    @Test
    public void getMinSumSquares11() {
        final int num  = 11;
        final int expected = 3;
        final int actual = solver.getMinSumSquares(num);
        Assert.assertEquals(String.valueOf(num), expected, actual);
    }
}