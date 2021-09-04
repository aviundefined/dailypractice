package com.avi.pepcoding.backtracking.lecture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 04/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class EqualKSubsetSum {

    private Integer result = 0;
    private int expectedSum = 0;

    public int numEqualKSubsetSum(final int[] nums, final int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        int sum = 0;
        for (final int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return 0;
        }
        this.expectedSum = sum / k;
        final List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            subsets.add(new ArrayList<>());
        }

        final int[] subsetSums = new int[k];
        backtrack(0, nums, k, subsets, subsetSums);
        return result;
    }

    private void backtrack(int i, int[] nums, int k, List<List<Integer>> subsets, int[] subsetSums) {
        if (i >= nums.length) {
            if (k == 0) {
                for (final int subsetSum : subsetSums) {
                    if (subsetSum != expectedSum) {
                        return;
                    }
                }
                result++;
                System.out.println(subsets);
                return;
            }
            return;
        }

        for (int j = 0; j < subsets.size(); j++) {
            final List<Integer> currentSubset = subsets.get(j);
            if (currentSubset.size() > 0 && subsetSums[j] + nums[i] <= expectedSum) {
                currentSubset.add(nums[i]);
                subsetSums[j] += nums[i];
                backtrack(i + 1, nums, k, subsets, subsetSums);
                currentSubset.remove(currentSubset.size() - 1);
                subsetSums[j] -= nums[i];
            } else if (subsetSums[j] + nums[i] <= expectedSum) {
                currentSubset.add(nums[i]);
                subsetSums[j] += nums[i];
                backtrack(i + 1, nums, k - 1, subsets, subsetSums);
                currentSubset.remove(currentSubset.size() - 1);
                subsetSums[j] -= nums[i];
                break;
            }
        }
    }
}
