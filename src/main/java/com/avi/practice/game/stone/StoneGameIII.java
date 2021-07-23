package com.avi.practice.game.stone;

/**
 * Created by navinash on 23/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class StoneGameIII {

    private int[] prefix;
    private Integer[] dp;

    public String stoneGameIII(int[] stoneValue) {
        prefix = new int[stoneValue.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < stoneValue.length; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        dp = new Integer[stoneValue.length];
        final int diff = recurse(stoneValue, 0, 3);
        if (diff == 0) {
            return "Tie";
        }

        if (diff > 0) {
            return "Alice";
        }

        return "Bob";
    }

    private int recurse(
            final int[] stones,
            final int index,
            final int k) {
        if (index >= stones.length) {
            return 0;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        int max = Integer.MIN_VALUE;
        for (int i = index; i < stones.length && i < index + k; i++) {
            final int curr = getScore(i, index) - recurse(stones, i + 1, k);
            max = Math.max(curr, max);
        }
        dp[index] = max;
        return dp[index];
    }

    private int getScore(final int right, final int left) {
        return prefix[right + 1] - prefix[left];
    }
}
