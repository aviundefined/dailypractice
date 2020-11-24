package com.avi.practice.leetcode.weeklycontest.num216;

/**
 * Created by navinash on 24/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * You are given an integer array nums. You can choose exactly one index (0-indexed) and remove the element. Notice that the index of the elements may change after the removal.
 * <p>
 * For example, if nums = [6,1,7,4,1]:
 * <p>
 * Choosing to remove index 1 results in nums = [6,7,4,1].
 * Choosing to remove index 2 results in nums = [6,1,4,1].
 * Choosing to remove index 4 results in nums = [6,1,7,4].
 * An array is fair if the sum of the odd-indexed values equals the sum of the even-indexed values.
 * <p>
 * Return the number of indices that you could choose such that after the removal, nums is fair.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,1,6,4]
 * Output: 1
 * Explanation:
 * Remove index 0: [1,6,4] -> Even sum: 1 + 4 = 5. Odd sum: 6. Not fair.
 * Remove index 1: [2,6,4] -> Even sum: 2 + 4 = 6. Odd sum: 6. Fair.
 * Remove index 2: [2,1,4] -> Even sum: 2 + 4 = 6. Odd sum: 1. Not fair.
 * Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8. Odd sum: 1. Not fair.
 * There is 1 index that you can remove to make nums fair.
 * Example 2:
 * <p>
 * Input: nums = [1,1,1]
 * Output: 3
 * Explanation: You can remove any index and the remaining array is fair.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 0
 * Explanation: You cannot make a fair array after removing any index.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class WaysToMakeArrayFair {

    public int waysToMakeFair(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 1;
        }

        if (nums.length == 2) {
            return nums[0] == nums[1] ? 1 : 0;
        }

        final int n = nums.length;
        int rightEvenSum = 0;
        int rightOddSum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                rightEvenSum += nums[i];
            } else {
                rightOddSum += nums[i];
            }
        }

        int count = 0;
        int leftEvenSum = 0;
        int leftOddSum = 0;
        for (int i = 0; i < n; i++) {
            final boolean isEven = i % 2 == 0;
            if (isEven) {
                rightEvenSum -= nums[i];
            } else {
                rightOddSum -= nums[i];
            }

            if (rightEvenSum + leftOddSum == rightOddSum + leftEvenSum) {
                count++;
            }
            if (isEven) {
                leftEvenSum += nums[i];
            } else {
                leftOddSum += nums[i];
            }
        }
        return count;
    }
}
