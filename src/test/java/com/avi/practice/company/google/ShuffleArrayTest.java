package com.avi.practice.company.google;

import com.avi.practice.company.google.ShuffleArray.Solution;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 01/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ShuffleArrayTest {

    @Test
    public void test() {
        final int[] nums = {1, 2, 3};
        final Solution solver = new Solution(nums);
        System.out.println(Arrays.toString(solver.shuffle()));
        System.out.println(Arrays.toString(solver.reset()));
        System.out.println(Arrays.toString(solver.shuffle()));

    }
}