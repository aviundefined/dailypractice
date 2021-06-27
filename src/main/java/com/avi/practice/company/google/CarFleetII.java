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
            return new double[0];
        }

        final int n = cars.length;
        if (n == 1) {
            final double[] result = new double[1];
            result[0] = -1;
            return result;
        }
        final double[] dp = new double[n];
        Arrays.fill(dp, -1.00000D);
        final Stack<Car> s = new Stack<>();
        s.push(new Car(cars[0][0], cars[0][1]));
        for (int i = 1; i < n; i++) {
            double currentCurrOldPosition = cars[i][0];
            final int speed = cars[i][1];
            if (s.peek().speed > speed) {
                // collision
                if (i == 1 || dp[i - 2] == -1.00000D) {
                    final Car prevCar = s.pop();
                    final double timeToCollide = (currentCurrOldPosition - prevCar.position) * 1.0000D / (prevCar.speed - speed);
                    final double currCarNewPosition = (timeToCollide * speed) + currentCurrOldPosition;
                    s.push(new Car(currCarNewPosition, speed));
                    dp[i - 1] = timeToCollide;
                } else {
                    final Car prevCar = s.pop();
                    currentCurrOldPosition = currentCurrOldPosition + (dp[i - 2] * speed);
                    final double timeToCollide = (currentCurrOldPosition - prevCar.position) * 1.0000D / (prevCar.speed - speed);
                    final double currCarNewPosition = (timeToCollide * speed) + currentCurrOldPosition;
                    s.push(new Car(currCarNewPosition, speed));
                    dp[i - 1] = timeToCollide;
                }

            }else {
                s.pop();
                s.push(new Car(currentCurrOldPosition, speed));
            }
        }
        return dp;
    }

    private static final class Car {
        private double position;
        private double speed;

        public Car(double position, double speed) {
            this.position = position;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return "(" + +position + "," + speed + ")";
        }
    }
}
