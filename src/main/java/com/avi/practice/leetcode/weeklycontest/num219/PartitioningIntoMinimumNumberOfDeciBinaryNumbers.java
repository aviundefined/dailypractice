package com.avi.practice.leetcode.weeklycontest.num219;

/**
 * Created by navinash on 19/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 * <p>
 * Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = "32"
 * Output: 3
 * Explanation: 10 + 11 + 11 = 32
 * Example 2:
 * <p>
 * Input: n = "82734"
 * Output: 8
 * Example 3:
 * <p>
 * Input: n = "27346209830709182346"
 * Output: 9
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n.length <= 105
 * n consists of only digits.
 * n does not contain any leading zeros and represents a positive integer.
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public int minPartitions(String n) {
        final char[] chars = n.toCharArray();
        int maxVal = Integer.MIN_VALUE;
        for (final char c : chars) {
            final int numericValue = Character.getNumericValue(c);
            if (numericValue > maxVal) {
                maxVal = numericValue;
            }
        }
        return maxVal;
    }
}
