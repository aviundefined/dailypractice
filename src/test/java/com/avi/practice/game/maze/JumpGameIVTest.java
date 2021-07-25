package com.avi.practice.game.maze;

import com.avi.practice.game.jump.JumpGameIV;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 25/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JumpGameIVTest {

    @Test
    public void minJumps1() {
        final JumpGameIV solver = new JumpGameIV();
        final int[] arr = {25, -28, -51, 61, -74, -51, -30, 58, 36, 68, -80, -64, 25, -30, -53, 36, -74, 61, -100, -30, -52};
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------");
        final int expected = 4;
        final int actual = solver.minJumps(arr);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minJumps2() {
        final JumpGameIV solver = new JumpGameIV();
        final int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------");
        final int expected = 3;
        final int actual = solver.minJumps(arr);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minJumps3() {
        final JumpGameIV solver = new JumpGameIV();
        final int[] arr = {7};
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------");
        final int expected = 0;
        final int actual = solver.minJumps(arr);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minJumps4() {
        final JumpGameIV solver = new JumpGameIV();
        final int[] arr = {7, 6, 9, 6, 9, 6, 9, 7};
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------");
        final int expected = 1;
        final int actual = solver.minJumps(arr);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minJumps5() {
        final JumpGameIV solver = new JumpGameIV();
        final int[] arr = {6, 1, 9};
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------");
        final int expected = 2;
        final int actual = solver.minJumps(arr);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minJumps6() {
        final JumpGameIV solver = new JumpGameIV();
        final int[] arr = {11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13};
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------");
        final int expected = 3;
        final int actual = solver.minJumps(arr);
        Assert.assertEquals(expected, actual);
    }
}