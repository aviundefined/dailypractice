package com.avi.practice.leetcode.biweekly.num39;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by navinash on 21/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * <p>
 * You are given an array of n integers, nums, where there are at most 50 unique values in the array. You are also given an array of m customer order quantities, quantity, where quantity[i] is the amount of integers the ith customer ordered. Determine if it is possible to distribute nums such that:
 * <p>
 * The ith customer gets exactly quantity[i] integers,
 * The integers the ith customer gets are all equal, and
 * Every customer is satisfied.
 * Return true if it is possible to distribute nums according to the above conditions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4], quantity = [2]
 * Output: false
 * Explanation: The 0th customer cannot be given two different integers.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,3], quantity = [2]
 * Output: true
 * Explanation: The 0th customer is given [3,3]. The integers [1,2] are not used.
 * Example 3:
 * <p>
 * Input: nums = [1,1,2,2], quantity = [2,2]
 * Output: true
 * Explanation: The 0th customer is given [1,1], and the 1st customer is given [2,2].
 * Example 4:
 * <p>
 * Input: nums = [1,1,2,3], quantity = [2,2]
 * Output: false
 * Explanation: Although the 0th customer could be given [1,1], the 1st customer cannot be satisfied.
 * Example 5:
 * <p>
 * Input: nums = [1,1,1,1,1], quantity = [2,3]
 * Output: true
 * Explanation: The 0th customer is given [1,1], and the 1st customer is given [1,1,1].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= 1000
 * m == quantity.length
 * 1 <= m <= 10
 * 1 <= quantity[i] <= 105
 * There are at most 50 unique values in nums.
 */
public class DistributeRepeatingIntegers {

    public boolean canDistribute(int[] nums, int[] quantity) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        if (quantity == null || quantity.length == 0) {
            return true;
        }

        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (final int a : nums) {
            frequencyMap.compute(a, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
        }
        final List<Integer> frequencies = frequencyMap.
                values().
                stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Arrays.sort(quantity);

        int curr = 0;
        final int n = frequencies.size();
        boolean isPossible = true;
        final int numQuantity = quantity.length;
        for (int i = numQuantity - 1; i >= 0; i--) {
            if (curr >= n) {
                isPossible = false;
                break;
            }
            final int numOrder = quantity[i];
            final int maxCurrentOrder = frequencies.get(curr);
            if (numOrder <= maxCurrentOrder) {
                final int leftOverOrder = maxCurrentOrder - numOrder;
                if (leftOverOrder == 0) {
                    curr++;
                } else {
                    frequencies.set(curr, leftOverOrder);
                    frequencies.sort(Collections.reverseOrder());
                }
            } else {
                isPossible = false;
                break;
            }
        }
        return isPossible;
    }
}
