package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 22/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TicTacToeTest {

    @Test
    public void useCase1() {
        /*
         *  ["TicTacToe", "move", "move", "move", "move", "move", "move", "move"]
         *  [[3], [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], [2, 0, 1], [1, 0, 2], [2, 1, 1]]
         *  Output
         *  [null, 0, 0, 0, 0, 0, 0, 1]
         */
        final TicTacToe ticTacToe = new TicTacToe(3);
        Assert.assertEquals(0, ticTacToe.move(0, 0, 1));
        Assert.assertEquals(0, ticTacToe.move(0, 2, 2));
        Assert.assertEquals(0, ticTacToe.move(2, 2, 1));
        Assert.assertEquals(0, ticTacToe.move(1, 1, 2));
        Assert.assertEquals(0, ticTacToe.move(2, 0, 1));
        Assert.assertEquals(0, ticTacToe.move(1, 0, 2));
        Assert.assertEquals(1, ticTacToe.move(2, 1, 1));
    }
}