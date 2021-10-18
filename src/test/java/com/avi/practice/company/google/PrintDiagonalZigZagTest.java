package com.avi.practice.company.google;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 18/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintDiagonalZigZagTest {

    @Test
    public void print1() {
        final PrintDiagonalZigZag solver = new PrintDiagonalZigZag();
        final int[][] arr = {
                {4, 9, 10, 12},
                {3, 5, 8, 11},
                {1, 2, 6, 7}
        };
        solver.print(arr);
        System.out.println("------------------");
    }

    @Test
    public void print2() {
        final PrintDiagonalZigZag solver = new PrintDiagonalZigZag();
        final int[][] arr = {
                {10, 11, 17, 18, 20},
                {4, 9, 12, 16, 19},
                {3, 5, 8, 13, 15},
                {1, 2, 6, 7, 14}

        };
        solver.print(arr);
        System.out.println("------------------");
    }
}