package com.avi.practice.leetcode.weeklycontest.num158;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class QueenThatCanAttackKingTest {

    @Test
    public void queensAttacktheKing() {
        final QueenThatCanAttackKing solver = new QueenThatCanAttackKing();
        {
            final int[][] queens =
                    {
                            {0, 1},
                            {1, 0},
                            {4, 0},
                            {0, 4},
                            {3, 3},
                            {2, 4}
                    };
            final int[] king = {0, 0};
            final List<List<Integer>> output = new ArrayList<>();
            output.add(Arrays.asList(0, 1));
            output.add(Arrays.asList(1, 0));
            output.add(Arrays.asList(3, 3));
            final List<List<Integer>> actual = solver.queensAttacktheKing(queens, king);
            Assert.assertEquals(output, actual);
        }
        {
            final int[][] queens =
                    {
                            {0, 1},
                            {1, 0},
                            {4, 0},
                            {0, 4},
                            {3, 3},
                            {2, 4}
                    };
            final int[] king = {0, 0};
            final List<List<Integer>> output = new ArrayList<>();
            output.add(Arrays.asList(0, 1));
            output.add(Arrays.asList(1, 0));
            output.add(Arrays.asList(3, 3));
            final List<List<Integer>> actual = solver.queensAttacktheKing(queens, king);
            Assert.assertEquals(output, actual);
        }
    }
}