package com.avi.practice.company.google;

import java.util.Arrays;

/**
 * Created by navinash on 22/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInKMoves {

    public int minDifference(int[] nums) {
        return minDifference(nums, 3);
    }

    private int minDifference(int[] nums, int moves) {
        if(nums.length < moves + 2) {
            return 0;
        }

        Arrays.sort(nums);
        final int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int k = 0; k <= moves; k++) {
            min = Math.min(nums[n - 1 - k] - nums[moves - k], min);
        }
        return min;
    }

}
