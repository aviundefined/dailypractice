package com.avi.pepcoding.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by navinash on 16/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ArrangeNumbersTest {

    private static final ArrangeNumbers solver = new ArrangeNumbers();

    @Test
    public void arrangements1() {
        final int n = 4;
        final String operators = "<><";
        final List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("1", "<", "3", ">", "2", "<", "4"));
        expected.add(Arrays.asList("1", "<", "4", ">", "2", "<", "3"));
        expected.add(Arrays.asList("2", "<", "4", ">", "1", "<", "3"));
        expected.add(Arrays.asList("2", "<", "3", ">", "1", "<", "4"));
        expected.add(Arrays.asList("3", "<", "4", ">", "1", "<", "2"));
        final List<List<String>> actual = solver.arrangements(n, operators);
        Assert.assertEquals(String.format("%s, %s", n, operators), new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    public void arrangements2() {
        final int n = 5;
        final String operators = "<<<<";
        final List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("1", "<", "2", "<", "3", "<", "4", "<", "5"));
        final List<List<String>> actual = solver.arrangements(n, operators);
        Assert.assertEquals(String.format("%s, %s", n, operators), new HashSet<>(expected), new HashSet<>(actual));
    }
}