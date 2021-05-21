package com.avi.practice.graph.pepcoding;

import com.avi.pepcoding.graph.KnightsTour;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 01/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class KnightsTourTest {
    private static final KnightsTour solver = new KnightsTour();

    @Test
    public void knightsTour1() {
        final int n = 5;
        final int row = 4;
        final int col = 3;
        final int[][] chess = chess(n);
        solver.knightsTour(chess, row, col);
    }

    @Test
    public void knightsTour2() {
        final int n = 5;
        final int row = 0;
        final int col = 3;
        final int[][] chess = chess(n);
        solver.knightsTour(chess, row, col);
    }

    @Test
    public void knightsTour3() {
        final int n = 5;
        final int row = 2;
        final int col = 3;
        final int[][] chess = chess(n);
        solver.knightsTour(chess, row, col);
    }

    @Test
    public void knightTourAll() {
        final int n = 5;

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                System.out.printf("Checking for cell: (%s, %s)\n", row, col);
                final int[][] chess = chess(n);
                solver.knightsTour(chess, row, col);
                System.out.println("---------- End ----------");
            }
        }
    }
    private static int[][] chess(final int n) {
        final int[][] chess = new int[n][n];
        for(final int[] row: chess) {
            Arrays.fill(row, 0);
        }
        return chess;
    }
}