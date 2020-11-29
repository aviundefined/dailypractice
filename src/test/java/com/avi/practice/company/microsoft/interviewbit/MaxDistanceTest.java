package com.avi.practice.company.microsoft.interviewbit;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxDistanceTest {
private static final MaxDistance solver = new MaxDistance();
    @Test
    public void maximumGap() {
        final List<Integer> A = Arrays.asList(3, 5, 4, 2);
        final int expected = 2;
        final int actual = solver.maximumGap(A);
        Assert.assertEquals(A.toString(), expected, actual);
    }
}