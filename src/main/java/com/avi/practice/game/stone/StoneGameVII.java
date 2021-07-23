package com.avi.practice.game.stone;

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

    private int[] prefix;
    private Integer[][] dp;

    public int stoneGameVII(int[] stones) {
        prefix = new int[stones.length + 1];
        prefix[0] = 0;
        for(int i = 0; i < stones.length; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }
        dp = new Integer[stones.length][stones.length];
        return bruteForce(stones);
    }

    private int score(final int left, final int right) {
        return prefix[right + 1] - prefix[left];
    }

    private int bruteForce(final int[] stones) {
        return recurse(stones, 0, stones.length - 1);
    }

    private int recurse(final int[] stones, final int left, final int right) {
        if(left > right) {
            return 0;
        }
        if(dp[left][right] != null) {
            return dp[left][right];
        }

        final int leftScore = score(left + 1, right) - recurse(stones, left + 1, right);
        final int rightScore = score(left, right - 1) - recurse(stones, left, right - 1);
        dp[left][right] =  Math.max(leftScore, rightScore);
        return dp[left][right];
    }
}
