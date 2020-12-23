package com.avi.practice.company.atlassian;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 22/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MajorityElementTest {

    private static final MajorityElement solver = new MajorityElement();

    @Test
    public void majorityElement1() {
        final int[] nums = {4, 2, 4};
        final int expected = 4;
        final int actual = solver.majorityElement(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }
}