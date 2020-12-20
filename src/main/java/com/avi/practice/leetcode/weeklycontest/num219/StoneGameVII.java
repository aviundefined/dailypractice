package com.avi.practice.leetcode.weeklycontest.num219;

import java.util.Arrays;

/**
 * Created by navinash on 19/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * <p>
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone or the rightmost stone from the row and receive points equal to the sum of the remaining stones' values in the row. The winner is the one with the higher score when there are no stones left to remove.
 * <p>
 * Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the score's difference. Alice's goal is to maximize the difference in the score.
 * <p>
 * Given an array of integers stones where stones[i] represents the value of the ith stone from the left, return the difference in Alice and Bob's score if they both play optimally.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: stones = [5,3,1,4,2]
 * Output: 6
 * Explanation:
 * - Alice removes 2 and gets 5 + 3 + 1 + 4 = 13 points. Alice = 13, Bob = 0, stones = [5,3,1,4].
 * - Bob removes 5 and gets 3 + 1 + 4 = 8 points. Alice = 13, Bob = 8, stones = [3,1,4].
 * - Alice removes 3 and gets 1 + 4 = 5 points. Alice = 18, Bob = 8, stones = [1,4].
 * - Bob removes 1 and gets 4 points. Alice = 18, Bob = 12, stones = [4].
 * - Alice removes 4 and gets 0 points. Alice = 18, Bob = 12, stones = [].
 * The score difference is 18 - 12 = 6.
 * Example 2:
 * <p>
 * Input: stones = [7,90,5,1,100,10,10,2]
 * Output: 122
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == stones.length
 * 2 <= n <= 1000
 * 1 <= stones[i] <= 1000
 */
public class StoneGameVII {

    public int stoneGameVII(final int[] stones) {

        // F(i,j, sum)  = max(
        //                  sum - stones[i] + F(i + 1, j  , sum - stones[i])
        //                  sum - stones[j] + F(i, j - 1, sum - stones[j]),
        //              );

        final int n = stones.length;
        final int[][] dp = new int[n][n];
        int sum = 0;
        for (final int stone : stones) {
            sum += stone;
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, n - 1, sum, dp, stones);
    }

    private int f(int i, int j, int sum, int[][] dp, int[] stones) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        final int val = Math.max(sum - stones[i] - f(i + 1, j, sum - stones[i], dp, stones), sum - stones[j] - f(i, j - 1, sum - stones[j], dp, stones));
        dp[i][j] = val;
        return val;
    }
}
