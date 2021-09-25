package com.avi.practice.company.google;

import com.avi.practice.company.google.RangeSumQuery2D.NumMatrix;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 25/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RangeSumQuery2DTest {

    @Test
    public void testUseCase1() {
        final int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        final NumMatrix solver = new NumMatrix(matrix);
        System.out.println(solver.sumRegion(2, 1, 4, 3));

        solver.update(3, 2, 2);

        System.out.println(solver.sumRegion(2, 1, 4, 3));
    }
}