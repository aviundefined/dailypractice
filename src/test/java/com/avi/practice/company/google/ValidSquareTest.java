package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 26/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ValidSquareTest {

    private static final ValidSquare solver = new ValidSquare();

    @Test
    public void validSquare1() {
        final int[] p1 = {1, 0};
        final int[] p2 = {-1, 0};
        final int[] p3 = {0, 1};
        final int[] p4 = {0, -1};
        final boolean expected = true;
        System.out.println(Arrays.toString(p1));
        System.out.println(Arrays.toString(p2));
        System.out.println(Arrays.toString(p3));
        System.out.println(Arrays.toString(p4));
        System.out.println("----------------");
        final boolean actual = solver.validSquare(p1, p2, p3, p4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void validSquare2() {
        final int[] p1 = {0, 0};
        final int[] p2 = {0, 0};
        final int[] p3 = {0, 0};
        final int[] p4 = {0, 0};
        final boolean expected = false;
        System.out.println(Arrays.toString(p1));
        System.out.println(Arrays.toString(p2));
        System.out.println(Arrays.toString(p3));
        System.out.println(Arrays.toString(p4));
        System.out.println("----------------");
        final boolean actual = solver.validSquare(p1, p2, p3, p4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void validSquare3() {
        final int[] p1 = {0, 1};
        final int[] p2 = {1, 2};
        final int[] p3 = {0, 2};
        final int[] p4 = {0, 0};
        final boolean expected = false;
        System.out.println(Arrays.toString(p1));
        System.out.println(Arrays.toString(p2));
        System.out.println(Arrays.toString(p3));
        System.out.println(Arrays.toString(p4));
        System.out.println("----------------");
        final boolean actual = solver.validSquare(p1, p2, p3, p4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void validSquare4() {
        final int[] p1 = {0, 0};
        final int[] p2 = {-1, 0};
        final int[] p3 = {1, 0};
        final int[] p4 = {0, 1};
        final boolean expected = false;
        System.out.println(Arrays.toString(p1));
        System.out.println(Arrays.toString(p2));
        System.out.println(Arrays.toString(p3));
        System.out.println(Arrays.toString(p4));
        System.out.println("----------------");
        final boolean actual = solver.validSquare(p1, p2, p3, p4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void validSquare5() {
        final int[] p1 = {1, 1};
        final int[] p2 = {5, 3};
        final int[] p3 = {3, 5};
        final int[] p4 = {7, 7};
        final boolean expected = false;
        System.out.println(Arrays.toString(p1));
        System.out.println(Arrays.toString(p2));
        System.out.println(Arrays.toString(p3));
        System.out.println(Arrays.toString(p4));
        System.out.println("----------------");
        final boolean actual = solver.validSquare(p1, p2, p3, p4);
        Assert.assertEquals(expected, actual);
    }
}