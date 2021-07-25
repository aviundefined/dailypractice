package com.avi.practice.game.jump;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 25/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FrogJumpTest {

    @Test
    public void dp1() {
        final FrogJump solver = new FrogJump();
        final int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        final boolean expected = true;
        final boolean actual = solver.dp(stones);
        Assert.assertEquals(Arrays.toString(stones), expected, actual);
    }

    @Test
    public void bfs1() {
        final FrogJump solver = new FrogJump();
        final int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        final boolean expected = true;
        final boolean actual = solver.bfs(stones);
        Assert.assertEquals(Arrays.toString(stones), expected, actual);
    }

    @Test
    public void dp2() {
        final FrogJump solver = new FrogJump();
        final int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
        final boolean expected = false;
        final boolean actual = solver.dp(stones);
        Assert.assertEquals(Arrays.toString(stones), expected, actual);
    }

    @Test
    public void bfs2() {
        final FrogJump solver = new FrogJump();
        final int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
        final boolean expected = false;
        final boolean actual = solver.bfs(stones);
        Assert.assertEquals(Arrays.toString(stones), expected, actual);
    }
}