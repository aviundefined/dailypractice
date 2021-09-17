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
public class LongestConsecutiveSequenceTest {

    @Test
    public void longestConsecutive1() {
        final LongestConsecutiveSequence solver = new LongestConsecutiveSequence();
        final int[] nums = {100, 4, 200, 1, 3, 2};
        final int expected = 4;
        final int actual = solver.longestConsecutive(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }
}