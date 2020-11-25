package com.avi.practice.leetcode.problems.medium;

/**
 * Created by navinash on 25/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        for (final int a : piles) {
            if (a > max) {
                max = a;
            }
        }

        final int n = piles.length;
        int min = 1;
        int allowed = max;
        while (min < max) {
            final int mid = min + (max - min) / 2;
            final boolean valid = isValid(piles, mid, H, n);
            if (valid) {
                if (mid < allowed) {
                    allowed = mid;
                }
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return allowed;
    }

    private boolean isValid(int[] piles, int maxAllowed, int H, int n) {
        int i = 0;
        while (H > 0 && i < n) {
            final int required = piles[i] % maxAllowed == 0 ? piles[i] / maxAllowed : (piles[i] / maxAllowed) + 1;
            if (H < required) {
                return false;
            }
            H = H - required;
            if (H <= 0 && i < n - 1) {
                return false;
            }
            i++;
        }
        return true;
    }
}
