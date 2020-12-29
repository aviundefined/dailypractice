package com.avi.practice.company.microsoft.leetcode.medium;

import java.util.Arrays;

/**
 * Created by navinash on 27/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        final Integer[] ints = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[i] = nums[i];
        }
        return largestNumber(ints);
    }

    private String largestNumber(Integer[] nums) {
        Arrays.sort(nums, (o1, o2) -> {
            final String a = o1 + "" + o2;
            final String b = o2 + "" + o1;
            return b.compareTo(a);
        });

        String result = "";
        for (final int num : nums) {
            result += num;
        }
        return removeTrailingZeros(result);
    }

    private String removeTrailingZeros(final String s) {
        System.out.println(Double.compare(0, 0.00D));
        final String result = s.replaceAll("^0+", "");
        if (result == null || result.length() == 0 || "".equals(result)) {
            return "0";
        }
        return result;
    }
}
