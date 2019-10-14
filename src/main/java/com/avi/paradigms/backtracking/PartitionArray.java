package com.avi.paradigms.backtracking;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 15/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class PartitionArray {

    private final int[] a;
    private final int n;
    private final long totalSum;

    public PartitionArray(final int[] a) {
        this.a = a;
        this.n = CommonUtils.isEmpty(a) ? 0 : a.length;
        totalSum = sum();
    }

    final boolean canPartition(final int k) {
        if (k == 0 || totalSum % k != 0) {
            return false;
        }
        final boolean[] used = new boolean[n];
        return _canPartition(0, k, 0L, totalSum / k, used);
    }

    private boolean _canPartition(
            final int start,
            final int numPartition,
            final long currentPartitionSum,
            final long targetSum,
            final boolean[] used) {
        if (numPartition == 1) {
            return true;
        }
        if (currentPartitionSum == targetSum) {
            return _canPartition(0, numPartition - 1, 0, targetSum, used);
        }
        for (int i = start; i < n; i++) {
            if (!used[i] && currentPartitionSum + a[i] <= targetSum) {
                used[i] = true;
                if (_canPartition(i + 1, numPartition, currentPartitionSum + a[i], targetSum, used)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    private long sum() {
        long sum = 0L;
        for (final int e : a) {
            sum = sum + e;
        }
        return sum;
    }
}
