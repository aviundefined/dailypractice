package com.avi.practice.game.stone;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 23/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class StoneGameIIITest {

    @Test
    public void stoneGameIII_1() {
        final StoneGameIII solver = new StoneGameIII();
        final int[] stoneValue = {1, 2, 3, 7};
        System.out.println(Arrays.toString(stoneValue));
        final String expected = "Bob";
        final String actual = solver.stoneGameIII(stoneValue);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stoneGameIII_2() {
        final StoneGameIII solver = new StoneGameIII();
        final int[] stoneValue = {1, 2, 3, -9};
        System.out.println(Arrays.toString(stoneValue));
        final String expected = "Alice";
        final String actual = solver.stoneGameIII(stoneValue);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stoneGameIII_3() {
        final StoneGameIII solver = new StoneGameIII();
        final int[] stoneValue = {1, 2, 3, 6};
        System.out.println(Arrays.toString(stoneValue));
        final String expected = "Tie";
        final String actual = solver.stoneGameIII(stoneValue);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stoneGameIII_4() {
        final StoneGameIII solver = new StoneGameIII();
        final int[] stoneValue = {1, 2, 3, -1, -2, -3, 7};
        System.out.println(Arrays.toString(stoneValue));
        final String expected = "Alice";
        final String actual = solver.stoneGameIII(stoneValue);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stoneGameIII_5() {
        final StoneGameIII solver = new StoneGameIII();
        final int[] stoneValue = {-1, -2, -3};
        System.out.println(Arrays.toString(stoneValue));
        final String expected = "Tie";
        final String actual = solver.stoneGameIII(stoneValue);
        Assert.assertEquals(expected, actual);
    }


}