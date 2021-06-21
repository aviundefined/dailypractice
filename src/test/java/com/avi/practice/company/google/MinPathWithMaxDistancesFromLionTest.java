package com.avi.practice.company.google;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 21/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinPathWithMaxDistancesFromLionTest {

    private static final MinPathWithMaxDistancesFromLion solver = new MinPathWithMaxDistancesFromLion();
    @Test
    public void path() {
        final int[][] arr = {
                {1, 2, 0, 1},
                {3, 1, 5, 1},
                {1, 2, 1, 1},
                {0, 1, 1, 1}
        };
        System.out.println("------ Cost ----");
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("----------------");
        final int actual = solver.path(arr);
        System.out.println(actual);
    }
}