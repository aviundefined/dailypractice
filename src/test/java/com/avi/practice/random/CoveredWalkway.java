package com.avi.practice.random;

/**
 * Your university wants to build a new walkway, and they want at least part of it to be covered. There are certain points which must be covered. It doesn’t matter if other points along the walkway are covered or not.
 * <p>
 * The building contractor has an interesting pricing scheme. To cover the walkway from a point at 𝑥 to a point at 𝑦, they will charge 𝑐+(𝑥−𝑦)2, where 𝑐 is a constant. Note that it is possible for 𝑥=𝑦. If so, then the contractor would simply charge 𝑐.
 * <p>
 * Given the points along the walkway and the constant 𝑐, what is the minimum cost to cover the walkway?
 * <p>
 * Input
 * Input consists of a single test case. The test case will begin with a line with two integers, 𝑛 (1≤𝑛≤1000000) and 𝑐 (1≤𝑐≤109), where 𝑛 is the number of points which must be covered, and 𝑐 is the contractor’s constant. Each of the following 𝑛 lines will contain a single integer, representing a point along the walkway that must be covered. The points will be in order, from smallest to largest. All of the points will be in the range from 1 to 109, inclusive.
 * <p>
 * Output
 * Output a single integer, representing the minimum cost to cover all of the specified points. All possible inputs yield answers which will fit in a signed 64-bit integer.
 * <p>
 * Sample Input 1	Sample Output 1
 * 10 5000
 * 1
 * 23
 * 45
 * 67
 * 101
 * 124
 * 560
 * 789
 * 990
 * 1019
 * 30726
 */
public class CoveredWalkway {

    public long minCost(final int[] arr, final int c) {
        final int n = arr.length;
        final long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = c;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j >= 1; j--) {
                // add j & i
                final long curr = c + ((arr[i - 1] - arr[j - 1]) * (arr[i - 1] - arr[j - 1])) + dp[j - 1];
                dp[i] = Math.min(curr, dp[i]);
            }
        }
        return dp[n];
    }
}
