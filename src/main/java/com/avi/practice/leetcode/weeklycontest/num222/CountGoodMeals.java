package com.avi.practice.leetcode.weeklycontest.num222;

import java.util.Arrays;

/**
 * Created by navinash on 06/01/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal to a power of two.
 * <p>
 * You can pick any two different foods to make a good meal.
 * <p>
 * Given an array of integers deliciousness where deliciousness[i] is the deliciousness of the i​​​​​​th​​​​​​​​ item of food, return the number of different good meals you can make from this list modulo 109 + 7.
 * <p>
 * Note that items with different indices are considered different even if they have the same deliciousness value.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: deliciousness = [1,3,5,7,9]
 * Output: 4
 * Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
 * Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.
 * Example 2:
 * <p>
 * Input: deliciousness = [1,1,1,3,3,3,7]
 * Output: 15
 * Explanation: The good meals are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7) with 3 ways.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 220
 */
public class CountGoodMeals {

    public int countPairs(int[] deliciousness) {
        Arrays.sort(deliciousness);
        final int n = deliciousness.length;
        int count = 0;
        for (int j = 0; j < n; j++) {
            final int curr = deliciousness[j];
            for (int bit = 0; bit <= 20; bit++) {
                final int remaining = (1 << bit) - curr;
                if (remaining < 0) {
                    continue;
                }
                if(remaining > deliciousness[n - 1]) {
                    break;
                }
                final int idx = binarySearch(deliciousness, remaining, j + 1, n - 1);
                if (idx != -1) {
                    System.out.println(curr + "," + remaining);
                    count++;
                    final int smallIdx = binarySearch(deliciousness, remaining, j + 1, idx - 1);
                }
            }
        }

        return count;
    }

    private int binarySearch(int[] arr, int x, int left, int right) {
        if(left > right) {
            return -1;
        }
        while (left <= right) {
            final int mid = (right + left) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
