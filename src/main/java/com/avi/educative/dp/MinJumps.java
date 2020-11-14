package com.avi.educative.dp;

/**
 * Created by navinash on 14/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinJumps {

    public int minJumpsBottomUp(final int[] jumps) {
        if (jumps == null || jumps.length == 0) {
            return 0;
        }
        if (jumps[0] == 0) {
            return Integer.MAX_VALUE;
        }
        final int[] dp = new int[jumps.length];
        dp[0] = 0;
        for (int i = 1; i < jumps.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int start = 0; start < jumps.length; start++) {
            for (int end = start + 1; end < jumps.length && end <= start + jumps[start]; end++) {
                if (dp[start] != Integer.MAX_VALUE) {
                    dp[end] = Math.min(dp[end], 1 + dp[start]);
                }
            }
        }
        return dp[jumps.length - 1];
    }

    public int minJumpsTopDown(final int[] jumps) {
        if (jumps == null || jumps.length == 0) {
            return 0;
        }
        if (jumps[0] == 0) {
            return Integer.MAX_VALUE;
        }
        final Integer[] dp = new Integer[jumps.length];
        return _minJumpsTopDown(jumps, 0, dp);
    }

    public int minJumpsRecursive(final int[] jumps) {
        if (jumps == null || jumps.length == 0) {
            return 0;
        }
        if (jumps[0] == 0) {
            return Integer.MAX_VALUE;
        }
        return _minJumpsRecursive(jumps, 0);
    }

    private int _minJumpsTopDown(int[] jumps, int index, Integer[] dp) {
        if (index == jumps.length - 1) {
            return 0;
        }
        if (jumps[index] == 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[index] == null) {
            dp[index] = Integer.MAX_VALUE;
            for (int i = index + 1; i <= index + jumps[index] && i < jumps.length; i++) {
                final int minJumps = _minJumpsTopDown(jumps, i, dp);
                if (minJumps != Integer.MAX_VALUE) {
                    dp[index] = Math.min(dp[index], 1 + minJumps);
                }
            }
        }
        return dp[index];
    }

    private int _minJumpsRecursive(int[] jumps, int index) {
        if (index == jumps.length - 1) {
            return 0;
        }
        if (jumps[index] == 0) {
            return Integer.MAX_VALUE;
        }
        int totalJumps = Integer.MAX_VALUE;
        for (int start = index + 1; start <= index + jumps[index] && start < jumps.length; start++) {
            final int minJumps = _minJumpsRecursive(jumps, start);
            if (minJumps != Integer.MAX_VALUE) {
                totalJumps = Math.min(totalJumps, 1 + minJumps);
            }
        }
        return totalJumps;
    }
}
