package com.avi.educative.dp;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 14/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinJumpsTest {
    private static final MinJumps aj = new MinJumps();

    @Test
    public void minJumpsBottomUp() {
        {
            final int[] jumps = {2, 1, 1, 1, 4};
            final int expected = 3;
            CommonUtils.printArr(jumps);
            final int actual = aj.minJumpsBottomUp(jumps);
            Assert.assertEquals(expected, actual);
            System.out.println("--------------------------");
        }
        {
            final int[] jumps = {1, 1, 3, 6, 9, 3, 0, 1, 3};
            final int expected = 4;
            CommonUtils.printArr(jumps);
            final int actual = aj.minJumpsBottomUp(jumps);
            Assert.assertEquals(expected, actual);
            System.out.println("--------------------------");
        }
    }

    @Test
    public void minJumpsTopDown() {
        {
            final int[] jumps = {2, 1, 1, 1, 4};
            final int expected = 3;
            CommonUtils.printArr(jumps);
            final int actual = aj.minJumpsTopDown(jumps);
            Assert.assertEquals(expected, actual);
            System.out.println("--------------------------");
        }
        {
            final int[] jumps = {1, 1, 3, 6, 9, 3, 0, 1, 3};
            final int expected = 4;
            CommonUtils.printArr(jumps);
            final int actual = aj.minJumpsTopDown(jumps);
            Assert.assertEquals(expected, actual);
            System.out.println("--------------------------");
        }
    }

    @Test
    public void minJumpsRecursive() {
        {
            final int[] jumps = {2, 1, 1, 1, 4};
            final int expected = 3;
            CommonUtils.printArr(jumps);
            final int actual = aj.minJumpsRecursive(jumps);
            Assert.assertEquals(expected, actual);
            System.out.println("--------------------------");
        }
        {
            final int[] jumps = {1, 1, 3, 6, 9, 3, 0, 1, 3};
            final int expected = 4;
            CommonUtils.printArr(jumps);
            final int actual = aj.minJumpsRecursive(jumps);
            Assert.assertEquals(expected, actual);
            System.out.println("--------------------------");
        }
    }
}