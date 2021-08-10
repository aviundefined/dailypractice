package com.avi.practice.company.google;

import java.util.Arrays;
import java.util.Stack;

/**
 * There are n cars traveling at different speeds in the same direction along a one-lane road. You are given an array cars of length n, where cars[i] = [positioni, speedi] represents:
 * <p>
 * positioni is the distance between the ith car and the beginning of the road in meters. It is guaranteed that positioni < positioni+1.
 * speedi is the initial speed of the ith car in meters per second.
 * For simplicity, cars can be considered as points moving along the number line. Two cars collide when they occupy the same position. Once a car collides with another car, they unite and form a single car fleet. The cars in the formed fleet will have the same position and the same speed, which is the initial speed of the slowest car in the fleet.
 * <p>
 * Return an array answer, where answer[i] is the time, in seconds, at which the ith car collides with the next car, or -1 if the car does not collide with the next car. Answers within 10-5 of the actual answers are accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cars = [[1,2],[2,1],[4,3],[7,2]]
 * Output: [1.00000,-1.00000,3.00000,-1.00000]
 * Explanation: After exactly one second, the first car will collide with the second car, and form a car fleet with speed 1 m/s. After exactly 3 seconds, the third car will collide with the fourth car, and form a car fleet with speed 2 m/s.
 * Example 2:
 * <p>
 * Input: cars = [[3,4],[5,4],[6,3],[9,1]]
 * Output: [2.00000,1.00000,1.50000,-1.00000]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= cars.length <= 105
 * 1 <= positioni, speedi <= 106
 * positioni < positioni+1
 */
public class CarFleetII {

    public double[] getCollisionTimes(int[][] cars) {
        if (cars == null || cars.length == 0) {
            return new double[]{};
        }

        final int n = cars.length;
        final double[] result = new double[n];
        Arrays.fill(result, -1.00D);
        final Stack<Integer> s = new Stack<>();
        s.push(n - 1);
        result[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            while (!s.isEmpty() && cars[s.peek()][1] >= cars[i][1]) {
                // right car is faster so can't collide
                s.pop();
            }

            while (!s.isEmpty()) {
                // calculate collison time with next car
                final double collisonTime = (1.00D * (cars[s.peek()][0] - cars[i][0]) / (cars[i][1] - cars[s.peek()][1]));

                if (result[s.peek()] == -1.00D || collisonTime <= result[s.peek()]) {
                    result[i] = collisonTime;
                    break;
                }
                s.pop();
            }
            s.push(i);
        }
        return result;
    }
}
