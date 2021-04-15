package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 15/04/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FindTheWinnerOfTheCircularGameTest {

    @Test
    public void findTheWinner1() {
        final FindTheWinnerOfTheCircularGame solver = new FindTheWinnerOfTheCircularGame();
        final int n = 5;
        final int k = 2;
        final int expected = 3;
        final int actual = solver.findTheWinner(n, k);
        Assert.assertEquals(String.format("friend: %d, jumps: %d", n, k), expected, actual);
    }

    @Test
    public void findTheWinner2() {
        final FindTheWinnerOfTheCircularGame solver = new FindTheWinnerOfTheCircularGame();
        final int n = 6;
        final int k = 5;
        final int expected = 1;
        final int actual = solver.findTheWinner(n, k);
        Assert.assertEquals(String.format("friend: %d, jumps: %d", n, k), expected, actual);
    }
}