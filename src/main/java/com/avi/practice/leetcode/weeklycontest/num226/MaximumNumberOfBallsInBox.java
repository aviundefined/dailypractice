package com.avi.practice.leetcode.weeklycontest.num226;

import java.util.Arrays;

/**
 * You are working in a ball factory where you have n balls numbered from lowLimit up to highLimit inclusive (i.e., n == highLimit - lowLimit + 1), and an infinite number of boxes numbered from 1 to infinity.
 * <p>
 * Your job at this factory is to put each ball in the box with a number equal to the sum of digits of the ball's number. For example, the ball number 321 will be put in the box number 3 + 2 + 1 = 6 and the ball number 10 will be put in the box number 1 + 0 = 1.
 * <p>
 * Given two integers lowLimit and highLimit, return the number of balls in the box with the most balls.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: lowLimit = 1, highLimit = 10
 * Output: 2
 * Explanation:
 * Box Number:  1 2 3 4 5 6 7 8 9 10 11 ...
 * Ball Count:  2 1 1 1 1 1 1 1 1 0  0  ...
 * Box 1 has the most number of balls with 2 balls.
 * Example 2:
 * <p>
 * Input: lowLimit = 5, highLimit = 15
 * Output: 2
 * Explanation:
 * Box Number:  1 2 3 4 5 6 7 8 9 10 11 ...
 * Ball Count:  1 1 1 1 2 2 1 1 1 0  0  ...
 * Boxes 5 and 6 have the most number of balls with 2 balls in each.
 * Example 3:
 * <p>
 * Input: lowLimit = 19, highLimit = 28
 * Output: 2
 * Explanation:
 * Box Number:  1 2 3 4 5 6 7 8 9 10 11 12 ...
 * Ball Count:  0 1 1 1 1 1 1 1 1 2  0  0  ...
 * Box 10 has the most number of balls with 2 balls.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= lowLimit <= highLimit <= 105l
 */
public class MaximumNumberOfBallsInBox {

    public int countBalls(int lowLimit, int highLimit) {
        final int[] boxes = new int[100000];
        Arrays.fill(boxes, 0);
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            final int boxIndex = sumOfDigits(i);
            boxes[boxIndex]++;
            if (boxes[boxIndex] > max) {
                max = boxes[boxIndex];
            }
        }
        return max;
    }

    static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
