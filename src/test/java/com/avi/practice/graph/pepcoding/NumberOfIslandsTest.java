package com.avi.practice.graph.pepcoding;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 01/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NumberOfIslandsTest {

    private static final NumberOfIslands solver = new NumberOfIslands();

    @Test
    public void numberOfIslands1() {
        final int[][] matrix = GraphTestUtils.matrix1();
        final int expected = 2;
        final int numberOfIslands = solver.numberOfIslands(matrix);
        for(int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
        Assert.assertEquals(expected, numberOfIslands);
        System.out.println("----------------");
    }

    @Test
    public void numberOfIslands2() {
        final int[][] matrix = GraphTestUtils.matrix2();
        final int expected = 3;
        final int numberOfIslands = solver.numberOfIslands(matrix);
        for(int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
        Assert.assertEquals(expected, numberOfIslands);
        System.out.println("----------------");
    }

    @Test
    public void numberOfIslands3() {
        final int[][] matrix = GraphTestUtils.matrix3();
        final int expected = 2;
        final int numberOfIslands = solver.numberOfIslands(matrix);
        for(int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
        Assert.assertEquals(expected, numberOfIslands);
        System.out.println("----------------");
    }

    @Test
    public void numberOfIslands4() {
        final int[][] matrix = GraphTestUtils.matrix4();
        final int expected = 1;
        final int numberOfIslands = solver.numberOfIslands(matrix);
        for(int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
        Assert.assertEquals(expected, numberOfIslands);
        System.out.println("----------------");
    }
}