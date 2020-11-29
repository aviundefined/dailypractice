package com.avi.practice.company.microsoft.interviewbit;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AddOneToNumberTest {
private static final AddOneToNumber solver = new AddOneToNumber();
    @Test
    public void plusOne1() {
        final ArrayList<Integer> A =  new ArrayList<>(Arrays.asList(1, 2, 3));
        final ArrayList<Integer> expected =  new ArrayList<>(Arrays.asList(1, 2, 4));
        final ArrayList<Integer> actual = solver.plusOne(A);
        Assert.assertEquals(A.toString(), expected, actual);
    }

    @Test
    public void plusOne2() {
        final ArrayList<Integer> A =  new ArrayList<>(Arrays.asList(0, 3, 7, 6, 4, 0, 5, 5, 5));
        final ArrayList<Integer> expected =  new ArrayList<>(Arrays.asList(3, 7, 6, 4, 0, 5, 5, 6));
        final ArrayList<Integer> actual = solver.plusOne(A);
        Assert.assertEquals(A.toString(), expected, actual);
    }
}