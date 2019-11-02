package com.avi.practice.leetcode.random;

import com.avi.practice.maths.MathPractice;

import java.util.Arrays;

import static com.avi.paradigms.bitmanipulation.BitWiseOperations.kthBitSet;

/**
 * Created by navinash on 02/11/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class SingleNumber {

    /**
     * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
     * <p>
     * Note:
     * <p>
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * <p>
     * Example 1:
     * <p>
     * Input: [2,2,3,2]
     * Output: 3
     * Example 2:
     * <p>
     * Input: [0,1,0,1,0,1,99]
     * Output: 99
     */
    static int singleNumber(final int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        // array length should be : 3 * n + 1
        final int n = nums.length;
        if (n % 3 != 1) {
            throw new IllegalArgumentException("Array length expected to be: 3 * n + 1. Found: " + n);
        }
        if (n == 1) {
            return nums[0];
        }

        final int bitLength = 32;
        final int[] bitMap = new int[bitLength];
        Arrays.fill(bitMap, 0);
        final MathPractice math = new MathPractice();
        int countNegatives = 0;
        // iterate over each number and check for each bit, if bit is set then increase the count for that bit by 1
        for (int num : nums) {
            if (num < 0) {
                countNegatives++;
                num = -1 * num;
            }
            for (int i = 0; i < bitLength; i++) {
                if (kthBitSet(num, i + 1)) {
                    bitMap[i] = bitMap[i] + 1;
                }
            }
        }
        // in the end binary number's binary digits will be the bits where bitMap[i] is of 3 * n  + 1
        int singleNumber = 0;
        for (int i = 0; i < bitLength; i++) {
            if (bitMap[i] % 3 == 1) {
                singleNumber = singleNumber + (int) Math.pow(2, i);
            }
        }
        return countNegatives % 3 == 1 ? -1 * singleNumber : singleNumber;
    }
}
