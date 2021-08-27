package com.avi.practice.maths;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by navinash on 27/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RotateImageTest extends TestCase {

    public void testRotateImage1() {
        final RotateImage solver = new RotateImage();
        final int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        final int[][] rotated = solver.rotate(matrix);
        for (final int[] row : rotated) {
            System.out.println(Arrays.toString(row));
        }
    }
}