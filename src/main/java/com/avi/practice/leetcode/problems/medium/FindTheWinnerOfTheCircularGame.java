package com.avi.practice.leetcode.problems.medium;

import java.util.Arrays;

/**
 * Created by navinash on 15/04/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FindTheWinnerOfTheCircularGame {

    private static final int VALID = 1;
    private static final int OUT = -1;

    public int findTheWinner(int n, int k) {
        final int[] friends = new int[n];
        Arrays.fill(friends, VALID);
        int start = 0;
        int out = 0;
        // game terminates when (n-1) friends are out i.e. out == n - 1
        while (out < (n - 1)) {
            // find the validate start
            while (friends[start] != VALID) {
                start = next(start, n);
            }
            // find the valid start -> now start counting from that
            int count = 0;
            while (count < k) {
                if (friends[start] == VALID) {
                    count++;
                    if (count == k) {
                        break;
                    }
                    start = next(start, n);

                    continue;
                }
                // find the validate start
                while (friends[start] != VALID) {
                    start = next(start, n);
                }
            }
            friends[start] = OUT;
            start = next(start, n);
            out++;
        }


        for (int i = 0; i < friends.length; i++) {
            if (friends[i] == VALID) {
                return i + 1;
            }
        }
        return -1;
    }

    private int next(final int start, final int max) {
        if (start == (max - 1)) {
            return 0;
        }
        return start + 1;
    }
}
