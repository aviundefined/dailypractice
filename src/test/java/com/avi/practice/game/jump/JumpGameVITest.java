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
public class JumpGameVITest {

    @Test
    public void maxResult1() {
        final JumpGameVI solver = new JumpGameVI();
        final int[] nums = {1, -1, -2, 4, -7, 3};
        final int k = 2;
        final int expected = 7;
        System.out.printf("nums: %s, k: %s\n", Arrays.toString(nums), k);
        System.out.println("---------------");
        final int actual = solver.maxResult(nums, k);
        Assert.assertEquals(expected, actual);
    }
}