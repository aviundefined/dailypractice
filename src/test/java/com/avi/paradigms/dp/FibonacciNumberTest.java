package com.avi.paradigms.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 22/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FibonacciNumberTest {

    @Test
    public void fibnoacci() {
        final FibonacciNumber solver = new FibonacciNumber();
        {
            final int n = 2;
            final int expected = 1;
            final int fibonacci = solver.fibnoacci(n);
            Assert.assertEquals(String.valueOf(n), expected, fibonacci);
        }
        {
            final int n = 3;
            final int expected = 2;
            final int fibonacci = solver.fibnoacci(n);
            Assert.assertEquals(String.valueOf(n), expected, fibonacci);
        }
        {
            final int n = 9;
            final int expected = 34;
            final int fibonacci = solver.fibnoacci(n);
            Assert.assertEquals(String.valueOf(n), expected, fibonacci);
        }
    }


    @Test
    public void fibnoacciConstantSpace() {
        final FibonacciNumber solver = new FibonacciNumber();
        {
            final int n = 2;
            final int expected = 1;
            final int fibonacciConstantSpace = solver.fibobacciConstantSpace(n);
            Assert.assertEquals(String.valueOf(n), expected, fibonacciConstantSpace);
        }
        {
            final int n = 3;
            final int expected = 2;
            final int fibonacciConstantSpace = solver.fibobacciConstantSpace(n);
            Assert.assertEquals(String.valueOf(n), expected, fibonacciConstantSpace);
        }
        {
            final int n = 9;
            final int expected = 34;
            final int fibonacciConstantSpace = solver.fibobacciConstantSpace(n);
            Assert.assertEquals(String.valueOf(n), expected, fibonacciConstantSpace);
        }
    }

    @Test
    public void compareFibonacci() {
        final FibonacciNumber solver = new FibonacciNumber();
        for (int i = 0; i <= 100; i++) {
            final int fibonacci = solver.fibnoacci(i);
            final int fibonacciConstantSpace = solver.fibobacciConstantSpace(i);
            Assert.assertEquals(String.valueOf(i), fibonacci, fibonacciConstantSpace);
        }
    }
}
