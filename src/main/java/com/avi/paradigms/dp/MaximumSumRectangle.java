package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 29/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class MaximumSumRectangle {

    private final int[][] mat;
    private final int rows;
    private final int cols;

    MaximumSumRectangle(int[][] mat) {
        this.mat = mat;
        this.rows = CommonUtils.isEmpty(mat) ? 0 : mat.length;
        this.cols = CommonUtils.isEmpty(mat) ? 0 : mat[0].length;
    }

    final Result maxSum() {
        if (rows == 0 || cols == 0) {
            return null;
        }

        if (rows == 1 && cols == 1) {
            return new Result(mat[0][0], 0, 0, 0, 0);
        }
        int maxL = 0, maxR = 0, maxT = 0, maxB = 0, maxSoFar = Integer.MIN_VALUE;
        for (int L = 0; L < cols; L++) {
            final int[] runningSum = new int[rows];
            // Initialize the running sum
            for (int i = 0; i < rows; i++) {
                runningSum[i] = 0;
            }
            for (int R = 0; R < cols; R++) {
                // Update the running sum
                for (int i = 0; i < rows; i++) {
                    runningSum[i] = runningSum[i] + mat[i][R];
                }
                // Apply Kadane's algorithm on runningSum to find best top and bottom
                final MaximumSumSubArray kadane = new MaximumSumSubArray(runningSum);
                final MaximumSumSubArray.Result result = kadane.kadane();
                if (result != null && result.sum > maxSoFar) {
                    maxSoFar = result.sum;
                    maxL = L;
                    maxR = R;
                    maxT = result.start;
                    maxB = result.end;
                }
            }
        }

        return new Result(maxSoFar, maxL, maxT, maxR, maxB);
    }

    final class Result {
        final int sum;
        final int left;
        final int top;
        final int right;
        final int bottom;

        Result(int sum, int left, int top, int right, int bottom) {
            this.sum = sum;
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Max Sum: ").append(sum).append('\n');
            for (int i = top; i <= bottom; i++) {
                for (int j = left; j <= right; j++) {
                    sb.append(mat[i][j]).append(" ");
                }
                sb.append('\n');
            }
            return sb.toString();
        }
    }
}
