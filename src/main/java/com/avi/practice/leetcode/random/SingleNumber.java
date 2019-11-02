package com.avi.practice.leetcode.random;

import java.util.Arrays;

import static com.avi.paradigms.bitmanipulation.BitWiseOperations.kthBitSet;

/**
 * Created by navinash on 02/11/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class SingleNumber {

    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        final int n = nums.length;
        int allXor = 0;
        for (int i = 1; i <= n; i++) {
            allXor ^= i;
        }

        int numXor = nums[0];
        for (int i = 1; i < n; i++) {
            numXor ^= nums[i];
        }

        return (allXor ^ numXor);
    }

    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     * <p>
     * Note:
     * <p>
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * <p>
     * Example 1:
     * <p>
     * Input: [2,2,1]
     * Output: 1
     * Example 2:
     * <p>
     * Input: [4,1,2,1,2]
     * Output: 4
     */
    static int singleNumber1(final int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        // array length should be : 2 * n + 1
        final int n = nums.length;
        if (n % 2 != 1) {
            throw new IllegalArgumentException("Array length expected to be: 2 * n + 1. Found: " + n);
        }
        if (n == 1) {
            return nums[0];
        }
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            result ^= nums[i];
        }
        return result;
    }

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
    static int singleNumber2(final int[] nums) {
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
        int countNegatives = 0;
        // iterate over each number and check for each bit, if bit is set then increase the count for that bit by 1
        for (long num : nums) {
            if (num < 0) {
                countNegatives++;
                num = (-1L * num);
            }
            for (int i = 0; i < bitLength; i++) {
                if (kthBitSet(num, i + 1)) {
                    bitMap[i] = bitMap[i] + 1;
                }
            }
        }
        // in the end binary number's binary digits will be the bits where bitMap[i] is of 3 * n  + 1
        long singleNumber = 0;
        for (int i = 0; i < bitLength; i++) {
            if (bitMap[i] % 3 == 1) {
                singleNumber = singleNumber + (long) Math.pow(2, i);
            }
        }
        return (int) (countNegatives % 3 == 1 ? (-1 * singleNumber) : singleNumber);
    }
}
