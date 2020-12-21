package com.avi.practice.leetcode.weeklycontest.num220;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 20/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
 * <p>
 * Return the maximum score you can get by erasing exactly one subarray.
 * <p>
 * An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,2,4,5,6]
 * Output: 17
 * Explanation: The optimal subarray here is [2,4,5,6].
 * Example 2:
 * <p>
 * Input: nums = [5,2,1,2,5,2,1,2,5]
 * Output: 8
 * Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class MaximumErasureValue {

    public int maximumUniqueSubarray(int[] nums) {
        final int n = nums.length;
        final Map<Integer, Integer> indexes = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        while (l <= r && r < n) {
            if (indexes.containsKey(nums[r])) {
                final Integer prevIndexOfRight = indexes.get(nums[r]);
                for (int i = l; i <= prevIndexOfRight; i++) {
                    curSum -= nums[i];
                    indexes.remove(nums[i]);
                }
                l = prevIndexOfRight + 1;
            }
            indexes.put(nums[r], r);
            curSum += nums[r];
            r++;
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }


}
