package com.avi.practice.game.stone;

/**
 * Created by navinash on 24/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class StoneGameV {

    private int[] prefix;
    private int[][] dp;

    public int stoneGameV(int[] stoneValue) {
        if (stoneValue == null || stoneValue.length == 0) {
            return 0;
        }

        if (stoneValue.length == 1) {
            return 0;
        }

        if (stoneValue.length == 2) {
            return Math.min(stoneValue[0], stoneValue[1]);
        }
        prefix = new int[stoneValue.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < stoneValue.length; i++) {
            prefix[i + 1] = stoneValue[i] + prefix[i];
        }
        dp = new int[stoneValue.length][stoneValue.length];
        return recurse(stoneValue, 0, stoneValue.length - 1);
    }

    private int recurse(final int[] stones, final int left, final int right) {
        if (left >= right) {
            return 0;
        }

        if (left + 1 == right) {
            return Math.min(stones[left], stones[right]);
        }
        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        int max = Integer.MIN_VALUE;
        for (int i = left; i < right; i++) {
            // from i to left
            final int leftSum = getScore(left, i);
            final int rightSum = getScore(i + 1, right);
            if (leftSum > rightSum) {
                // left will be discarded by bob so go right
                final int curr = rightSum + recurse(stones, i + 1, right);
                max = Math.max(max, curr);
            } else if (leftSum < rightSum) {
                // right will be discarded by bob so go left
                final int curr = leftSum + recurse(stones, left, i);
                max = Math.max(max, curr);
            } else {
                final int curr = Math.max(
                        leftSum + recurse(stones, left, i),
                        rightSum + recurse(stones, i + 1, right));
                max = Math.max(max, curr);
            }
        }
        dp[left][right] = max;
        return max;
    }

    private int getScore(final int left, final int right) {
        return prefix[right + 1] - prefix[left];
    }
}
