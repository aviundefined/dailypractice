package com.avi.practice.leetcode.problems.hard;

import org.junit.Assert;
import org.junit.Test;

/**
 * You are given nums, an array of positive integers of size 2 * n. You must perform n operations on this array.
 * <p>
 * In the ith operation (1-indexed), you will:
 * <p>
 * Choose two elements, x and y.
 * Receive a score of i * gcd(x, y).
 * Remove x and y from nums.
 * Return the maximum score you can receive after performing n operations.
 * <p>
 * The function gcd(x, y) is the greatest common divisor of x and y.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2]
 * Output: 1
 * Explanation: The optimal choice of operations is:
 * (1 * gcd(1, 2)) = 1
 * Example 2:
 * <p>
 * Input: nums = [3,4,6,8]
 * Output: 11
 * Explanation: The optimal choice of operations is:
 * (1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,4,5,6]
 * Output: 14
 * Explanation: The optimal choice of operations is:
 * (1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 7
 * nums.length == 2 * n
 * 1 <= nums[i] <= 106
 */
public class MaximizeScoreAfterNOperationsTest {

    private static final MaximizeScoreAfterNOperations solver = new MaximizeScoreAfterNOperations();

    @Test
    public void gcd1() {
        final int a = 98;
        final int b = 56;
        final int expected = 14;
        final int actual = solver.gcd(a, b);
        Assert.assertEquals(String.format("%s, %s", a, b), expected, actual);
    }

    @Test
    public void gcd2() {
        final int a = 3;
        final int b = 4;
        final int expected = 1;
        final int actual = solver.gcd(a, b);
        Assert.assertEquals(String.format("%s, %s", a, b), expected, actual);
    }
}