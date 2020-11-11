package com.avi.practice.leetcode.weeklycontest.num214;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 11/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CreateSortedArrayThroughInstructionsTest {

    private final CreateSortedArrayThroughInstructions solver = new CreateSortedArrayThroughInstructions();

    @Test
    public void createSortedArray() {
        {
            final int[] instructions = {1, 5, 6, 2};
            final int expected = 1;
            CommonUtils.printArr(instructions);
            final int actual = solver.createSortedArray(instructions);
            Assert.assertEquals(expected, actual);
            System.out.println("------------------");
        }
        {
            final int[] instructions = {1, 2, 3, 6, 5, 4};
            final int expected = 3;
            CommonUtils.printArr(instructions);
            final int actual = solver.createSortedArray(instructions);
            Assert.assertEquals(expected, actual);
            System.out.println("------------------");
        }
        {
            final int[] instructions = {1, 3, 3, 3, 2, 4, 2, 1, 2};
            final int expected = 4;
            CommonUtils.printArr(instructions);
            final int actual = solver.createSortedArray(instructions);
            Assert.assertEquals(expected, actual);
            System.out.println("------------------");
        }

    }
}