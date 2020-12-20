package com.avi.practice.company.microsoft.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 20/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> numList = arrToList(nums);
        backtrack(0, nums.length - 1, numList, result);
        return result;
    }

    private void backtrack(int left, int right, List<Integer> nums, List<List<Integer>> result) {
        if (left == right) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for (int i = left; i <= right; i++) {
            Collections.swap(nums, left, i);
            backtrack(left + 1, right, nums, result);
            Collections.swap(nums, left, i);
        }
    }

    private List<Integer> arrToList(final int[] nums) {
        final List<Integer> curr = new ArrayList<>();
        for (final int num : nums) {
            curr.add(num);
        }
        return curr;
    }
}
