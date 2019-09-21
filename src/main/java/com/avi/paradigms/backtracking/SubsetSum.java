package com.avi.paradigms.backtracking;

import com.avi.practice.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by navinash on 20/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class SubsetSum {
    private static final int INCLUDE = 1;
    private static final int EXCLUDE = 0;
    private final int[] arr;
    private final int n;
    private int[] sol;
    private final Set<List<Integer>> subsetSums = new HashSet<>();

    SubsetSum(final int[] arr) {
        this.arr = arr;
        this.n = CommonUtils.isEmpty(arr) ? 0 : arr.length;
    }

    final Collection<List<Integer>> solve(int targetSum) {
        // base case if arr is null or empty no solution possible
        if (CommonUtils.isEmpty(arr)) {
            throw new IllegalArgumentException("Empty array");
        }
        System.out.println("Find subset in following array, which sum are equal to target: " + targetSum);
        CommonUtils.printArr(arr);
        // Sort the array and if first element is greater than targetSum then no solution possible
        Arrays.sort(arr);
        this.sol = new int[n];
        for (int i = 0; i < n; i++) {
            sol[i] = EXCLUDE;
        }
        _solve(targetSum, 0);
        return subsetSums;
    }

    private void _solve(int sum, int index) {
        if (sum == 0) {
            final List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (sol[i] == INCLUDE) {
                    subset.add(arr[i]);
                }
            }
            subsetSums.add(subset);
            return;
        }

        if (index == n) {
            return;
        }
        sol[index] = INCLUDE;
        _solve(sum - arr[index], index + 1);
        sol[index] = EXCLUDE;
        _solve(sum, index + 1);
    }
}
