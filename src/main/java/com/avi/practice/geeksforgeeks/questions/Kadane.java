package com.avi.practice.geeksforgeeks.questions;

import java.util.Objects;

/**
 * Created by navinash on 24/12/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class Kadane {

    /*
        Input: -1 -2 -3 -4
        Output: -1

        Input: 1 2 3 -2 5
        Output: 9
     */
    public final Result solve(final int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        final int n = a.length;
        if (n == 1) {
            return new Result(a[0], 0, 0);
        }

        int overallMax = a[0];
        int end = 0;

        final int[] dp = new int[n];
        dp[0] = a[0];
        // dp: 1, 3. 6, 4, 9
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
            if (dp[i] >= overallMax) {
                overallMax = dp[i];
                end = i;
            }
        }

        int start = end;
        for (int i = end - 1; i >= 0; i--) {
            if (dp[i] >= 0) {
                start = i;
            } else {
                break;
            }
        }
        return new Result(overallMax, start, end);
    }


     static final class Result {
        final int sum;
        final int start;
        final int end;

        Result(int sum, int start, int end) {
            this.sum = sum;
            this.start = start;
            this.end = end;
        }

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (o == null || getClass() != o.getClass()) return false;
             Result result = (Result) o;
             return sum == result.sum &&
                     start == result.start &&
                     end == result.end;
         }

         @Override
         public int hashCode() {
             return Objects.hash(sum, start, end);
         }

         @Override
         public String toString() {
             return "Result{" +
                     "sum=" + sum +
                     ", start=" + start +
                     ", end=" + end +
                     '}';
         }
     }
}
