package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 23/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GoldMineTest {

    @Test
    public void maxGold() {
        {
            final int[][] mat = {
                    {1, 3, 3},
                    {2, 1, 4},
                    {0, 6, 4}
            };
            CommonUtils.printMatrix(mat);
            final GoldMine miner = new GoldMine(mat);
            final int expected = 12;
            final int maxGold = miner.maxGold();
            Assert.assertEquals(expected, maxGold);
        }
        {
            final int[][] mat = {
                    {1, 3, 1, 5},
                    {2, 2, 4, 1},
                    {5, 0, 2, 3},
                    {0, 6, 1, 2}
            };
            CommonUtils.printMatrix(mat);
            final GoldMine miner = new GoldMine(mat);
            final int expected = 16;
            final int maxGold = miner.maxGold();
            Assert.assertEquals(expected, maxGold);
        }
        {
            final int[][] mat = {
                    {10, 33, 13, 15},
                    {22, 21, 4, 1},
                    {5, 0, 2, 3},
                    {0, 6, 14, 2}
            };
            CommonUtils.printMatrix(mat);
            final GoldMine miner = new GoldMine(mat);
            final int expected = 83;
            final int maxGold = miner.maxGold();
            Assert.assertEquals(expected, maxGold);
        }
    }
}
