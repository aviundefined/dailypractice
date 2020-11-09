package com.avi.practice.leetcode.weeklycontest.num215;

import java.util.Arrays;

/**
 * Created by navinash on 09/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * <p>
 * You have an inventory of different colored balls, and there is a customer that wants orders balls of any color.
 * <p>
 * The customer weirdly values the colored balls. Each colored ball's value is the number of balls of that color you currently have in your inventory. For example, if you own 6 yellow balls, the customer would pay 6 for the first yellow ball. After the transaction, there are only 5 yellow balls left, so the next yellow ball is then valued at 5 (i.e., the value of the balls decreases as you sell more to the customer).
 * <p>
 * You are given an integer array, inventory, where inventory[i] represents the number of balls of the ith color that you initially own. You are also given an integer orders, which represents the total number of balls that the customer wants. You can sell the balls in any order.
 * <p>
 * Return the maximum total value that you can attain after selling orders colored balls. As the answer may be too large, return it modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: inventory = [2,5], orders = 4
 * Output: 14
 * Explanation: Sell the 1st color 1 time (2) and the 2nd color 3 times (5 + 4 + 3).
 * The maximum total value is 2 + 5 + 4 + 3 = 14.
 * Example 2:
 * <p>
 * Input: inventory = [3,5], orders = 6
 * Output: 19
 * Explanation: Sell the 1st color 2 times (3 + 2) and the 2nd color 4 times (5 + 4 + 3 + 2).
 * The maximum total value is 3 + 2 + 5 + 4 + 3 + 2 = 19.
 * Example 3:
 * <p>
 * Input: inventory = [2,8,4,10,6], orders = 20
 * Output: 110
 * Example 4:
 * <p>
 * Input: inventory = [1000000000], orders = 1000000000
 * Output: 21
 * Explanation: Sell the 1st color 1000000000 times for a total value of 500000000500000000. 500000000500000000 modulo 109 + 7 = 21.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= inventory.length <= 105
 * 1 <= inventory[i] <= 10^9
 * 1 <= orders <= min(sum(inventory[i]), 10^9)
 */
public class SellDiminishingValuedColoredBalls {

    public int maxProfit(int[] inventory, int orders) {
        if (inventory == null || inventory.length == 0 || orders <= 0) {
            return 0;
        }
        Arrays.sort(inventory);
        int profit = 0;
        int right = inventory.length - 1;
        int left = right - 1;
        while (orders > 0 && left >= 0) {
            final int delta = Math.min(inventory[right] - inventory[left], orders);
            profit += profit(inventory, left + 1, right, delta);
            orders = orders - delta;
            left--;
        }
        if (orders <= 0) {
            return profit;
        }
        left = 0;
        boolean isItemLeft = true;
        while (orders > 0 && isItemLeft) {
            if (orders >= inventory.length) {
                profit += profit(inventory, left, right, 1);
                orders = orders - inventory.length;
                if (inventory[left] == 0) {
                    isItemLeft = false;
                }
            } else {
                left = inventory.length - orders;
                profit += profit(inventory, left, right, 1);
                orders = 0;
            }
        }
        return profit % (10 ^ 9 + 7);
    }

    private int profit(final int[] inventory, final int start, final int end, final int delta) {
        int profit = 0;
        int multiplier = end - start + 1;
        final int currVal = inventory[end];
        for (int i = 0; i < delta; i++) {
            if (currVal - i >= 0) {
                profit = profit + (currVal - i);
            }
        }
        for (int i = start; i <= end; i++) {
            if (inventory[i] > 0) {
                inventory[i] = inventory[i] - delta;
            }
        }
        profit = profit * multiplier;
        return profit;
    }
}
