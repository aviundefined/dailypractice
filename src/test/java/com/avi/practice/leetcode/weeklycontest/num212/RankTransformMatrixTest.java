package com.avi.practice.leetcode.weeklycontest.num212;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 02/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RankTransformMatrixTest {

    @Test
    public void matrixRankTransform() {

        final RankTransformMatrix solver = new RankTransformMatrix();
        {
            final int[][] matrix = {{1, 2}, {3, 4}};
            final int[][] expected = {{1, 2}, {2, 3}};
            final int[][] actual = solver.matrixRankTransform(matrix);
            for (int i = 0; i < expected.length; i++) {
                for (int j = 0; j < expected[0].length; j++) {
                    Assert.assertEquals(String.format("(%d, %d)", i, j), expected[i][j], actual[i][j]);
                }
            }
        }

        {
            final int[][] matrix = {{7, 7}, {7, 7}};
            final int[][] expected = {{1, 1}, {1, 1}};
            final int[][] actual = solver.matrixRankTransform(matrix);
            for (int i = 0; i < expected.length; i++) {
                for (int j = 0; j < expected[0].length; j++) {
                    Assert.assertEquals(String.format("(%d, %d)", i, j), expected[i][j], actual[i][j]);
                }
            }
        }

        {
            final int[][] matrix = {
                    {-37, -50, -3, 44},
                    {-37, 46, 13, -32},
                    {47, -42, -3, -40},
                    {-17, -22, -39, 24}
            };
            final int[][] expected = {{2, 1, 4, 6}, {2, 6, 5, 4}, {5, 2, 4, 3}, {4, 3, 1, 5}};
            final int[][] actual = solver.matrixRankTransform(matrix);
            CommonUtils.printMatrix(matrix);
            CommonUtils.printMatrix(expected);
            CommonUtils.printMatrix(actual);
            for (int i = 0; i < expected.length; i++) {
                for (int j = 0; j < expected[0].length; j++) {
                    Assert.assertEquals(String.format("(%d, %d)", i, j), expected[i][j], actual[i][j]);
                }
            }
        }
    }
}