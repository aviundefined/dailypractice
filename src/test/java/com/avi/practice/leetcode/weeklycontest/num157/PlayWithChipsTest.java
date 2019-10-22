package com.avi.practice.leetcode.weeklycontest.num157;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PlayWithChipsTest {

    @Test
    public void minCostToMoveChips() {
        final PlayWithChips solver = new PlayWithChips();
        {
            final int[] chips = {1, 2, 3};
            final int expected = 1;
            CommonUtils.printArr(chips);
            final int minMoves = solver.minCostToMoveChips(chips);
            Assert.assertEquals(expected, minMoves);
        }
        {
            final int[] chips = {2, 2, 2, 3, 3};
            final int expected = 2;
            CommonUtils.printArr(chips);
            final int minMoves = solver.minCostToMoveChips(chips);
            Assert.assertEquals(expected, minMoves);
        }
    }
}