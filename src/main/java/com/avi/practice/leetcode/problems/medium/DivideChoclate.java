package com.avi.practice.leetcode.problems.medium;

/**
 * Created by navinash on 26/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
 * <p>
 * You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces using K cuts, each piece consists of some consecutive chunks.
 * <p>
 * Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
 * <p>
 * Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
 * <p>
 * Example 1:
 * Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
 * Output: 6
 * Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
 * <p>
 * Example 2:
 * Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
 * Output: 1
 * Explanation: There is only one way to cut the bar into 9 pieces.
 * <p>
 * Example 3:
 * Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
 * Output: 5
 * Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
 * <p>
 * Constraints:
 * 0 <= K < sweetness.length <= 10^4
 * 1 <= sweetness[i] <= 10^5
 */
public class DivideChoclate {

    public int divide(int[] sweetness, int k) {
        int max = 0;
        for (final int a : sweetness) {

            max += a;
        }
        int min = 1;
        int curr = min;
        while (min < max) {
            final int mid = (max + min + 1) / 2;
            if (isPossible(sweetness, k + 1, mid)) {
                if (mid > curr) {
                    curr = mid;
                }
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return curr;
    }

    final boolean isPossible(final int[] sweetness, final int k, final int minSweetness) {
        int cuts = 0;
        int sum = 0;
        for (int currSweetness : sweetness) {
            sum += currSweetness;
            if (sum >= minSweetness) {
                cuts++;
                sum = 0;
            }
        }
        return cuts >= k;
    }
}
