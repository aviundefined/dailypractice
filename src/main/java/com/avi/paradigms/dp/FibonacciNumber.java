package com.avi.paradigms.dp;

/**
 * Created by navinash on 22/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class FibonacciNumber {

    final int fibonacci(final int n) {
        if (n <= 1) {
            return n;
        }
        final int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    final int fibonacciConstantSpace(final int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int fn_1 = 1, fn_2 = 0;
        int fn = -1;
        for (int i = 2; i <= n; i++) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1; // assigning f(n - 1) to f(n - 2)
            fn_1 = fn; // assign f(n) to f(n - 1)
        }
        return fn;
    }
}
