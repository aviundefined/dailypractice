package com.avi.pepcoding.graph.union_find;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 17/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BricksFallingWhenHitTest {

    @Test
    public void hitBricks1() {
        final BricksFallingWhenHit solver  = new BricksFallingWhenHit();
        final int[][] grid = {{1,0,0,0},{1,1,1,0}};
        final int[][] hits = {{1,0}};
        final int[] expected = {2};
        final int[] actual = solver.hitBricks(grid, hits);
        System.out.println("expected: "+ Arrays.toString(expected));
        System.out.println("actual: "+ Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }
}