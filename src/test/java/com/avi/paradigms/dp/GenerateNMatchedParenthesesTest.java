package com.avi.paradigms.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by navinash on 05/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GenerateNMatchedParenthesesTest {

    @Test
    public void solve() {
        final GenerateNMatchedParentheses solver = new GenerateNMatchedParentheses();
        {
            final int n = 0;
            final int expected = 1;
            final List<String> result = solver.solve(n);
            System.out.println(result);
            Assert.assertEquals(String.valueOf(n), expected, result.size());
        }
        {
            final int n = 1;
            final int expected = 1;
            final List<String> result = solver.solve(n);
            System.out.println(result);
            Assert.assertEquals(String.valueOf(n), expected, result.size());
        }
        {
            final int n = 2;
            final int expected = 2;
            final List<String> result = solver.solve(n);
            System.out.println(result);
            Assert.assertEquals(String.valueOf(n), expected, result.size());
        }
        {
            final int n = 3;
            final int expected = 5;
            final List<String> result = solver.solve(n);
            System.out.println(result);
            Assert.assertEquals(String.valueOf(n), expected, result.size());
        }
        {
            final int n = 4;
            final int expected = 14;
            final List<String> result = solver.solve(n);
            System.out.println(result);
            Assert.assertEquals(String.valueOf(n), expected, result.size());
        }
    }
}
