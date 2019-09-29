package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 28/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class MaximumSumSubArray {

    private final int[] a;

    MaximumSumSubArray(int[] a) {
        this.a = a;
    }

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    final Result maxSumSubArray() {
        if (CommonUtils.isEmpty(a)) {
            return null;
        }
        final int n = a.length;
        if (n == 1) {
            return new Result(a[0], 0, 0);
        }

        final int[] maxSum = new int[n];
        maxSum[0] = a[0];
        int overAllMax = a[0];
        int overAllMaxEndIdx = 0;
        for (int i = 1; i < n; i++) {
            maxSum[i] = Math.max(a[i], a[i] + maxSum[i - 1]);
            if (maxSum[i] > overAllMax) {
                overAllMax = maxSum[i];
                overAllMaxEndIdx = i;
            }
        }

        int start = overAllMaxEndIdx;
        for (int i = overAllMaxEndIdx; i >= 0; i--) {
            if (maxSum[i] >= 0) {
                start = i;
            } else {
                break;
            }
        }
        return new Result(overAllMax, start, overAllMaxEndIdx);
    }


    /**
     * Time:  O(n)
     * Space: O(1)
     */
    final Result kadane() {
        if (CommonUtils.isEmpty(a)) {
            return null;
        }
        final int n = a.length;
        if (n == 1) {
            return new Result(a[0], 0, 0);
        }
        //result[0] == maxSum, result[1] == start, result[2] == end;
        int[] result = new int[]{Integer.MIN_VALUE, 0, -1};
        int currentSum = 0;
        int localStart = 0;

        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            if (currentSum < 0) {
                currentSum = 0;
                localStart = i + 1;
            } else if (currentSum > result[0]) {
                result[0] = currentSum;
                result[1] = localStart;
                result[2] = i;
            }
        }

        //all numbers in a are negative
        if (result[2] == -1) {
            result[0] = a[0];
            for (int i = 0; i < a.length; i++) {
                if (a[i] > result[0]) {
                    result[0] = a[i];
                    result[1] = i;
                    result[2] = i;
                }
            }
        }
        return new Result(result[0], result[1], result[2]);
    }

    final class Result {
        final int sum;
        final int start;
        final int end;

        Result(int sum, int start, int end) {
            this.sum = sum;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Maximum sum: ").append(sum).append(" -> [");
            for (int i = start; i <= end; i++) {
                sb.append(a[i]);
                if (i != end) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
