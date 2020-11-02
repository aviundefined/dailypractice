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

        {
            final int[][] matrix = {{-23, 20, -49, -30, -39, -28, -5, -14}, {-19, 4, -33, 2, -47, 28, 43, -6}, {-47, 36, -49, 6, 17, -8, -21, -30}, {-27, 44, 27, 10, 21, -8, 3, 14}, {-19, 12, -25, 34, -27, -48, -37, 14}, {-47, 40, 23, 46, -39, 48, -41, 18}, {-27, -4, 7, -10, 9, 36, 43, 2}, {37, 44, 43, -38, 29, -44, 19, 38}};
            final int[][] expected = {{7, 13, 1, 5, 4, 6, 9, 8}, {8, 11, 2, 10, 1, 12, 14, 9}, {2, 14, 1, 11, 13, 7, 5, 3}, {3, 19, 16, 12, 14, 7, 10, 13}, {8, 12, 6, 14, 5, 1, 4, 13}, {2, 16, 15, 17, 4, 18, 3, 14}, {3, 7, 11, 6, 12, 13, 14, 10}, {16, 19, 18, 3, 15, 2, 11, 17}};
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