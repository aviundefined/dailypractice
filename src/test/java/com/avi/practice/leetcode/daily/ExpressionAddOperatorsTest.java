package com.avi.practice.leetcode.daily;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by navinash on 19/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ExpressionAddOperatorsTest {

    @Test
    public void addOperators1() {
        final ExpressionAddOperators solver = new ExpressionAddOperators();
        final String num = "123";
        final int target = 6;
        final List<String> expected = Arrays.asList("1+2+3", "1*2*3");
        final List<String> actual = solver.addOperators(num, target);
        Assert.assertEquals(String.format("num: %s, target: %s", num, target), new HashSet<>(expected), new HashSet<>(actual));
    }
}