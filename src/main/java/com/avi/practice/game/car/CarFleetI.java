package com.avi.practice.game.car;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are n cars going to the same destination along a one-lane road. The destination is target miles away.
 * <p>
 * You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
 * <p>
 * A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
 * <p>
 * The distance between these two cars is ignored (i.e., they are assumed to have the same position).
 * <p>
 * A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.
 * <p>
 * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
 * <p>
 * Return the number of car fleets that will arrive at the destination.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 * Explanation:
 * The cars starting at 10 and 8 become a fleet, meeting each other at 12.
 * The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
 * The cars starting at 5 and 3 become a fleet, meeting each other at 6.
 * Note that no other cars meet these fleets before the destination, so the answer is 3.
 * Example 2:
 * <p>
 * Input: target = 10, position = [3], speed = [3]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == position.length == speed.length
 * 1 <= n <= 105
 * 0 < target <= 106
 * 0 <= position[i] < target
 * All the values of position are unique.
 * 0 < speed[i] <= 106
 */
public class CarFleetI {

    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || speed == null || position.length != speed.length || target == 0) {
            return 0;
        }
        final Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], (target - position[i]) * 1.00D / (speed[i]));
        }
        Arrays.sort(cars, Comparator.comparingInt(car -> car.position));
        int result = 1;
        for (int i = cars.length - 1; i >= 1; i--) {
            // if back car will reach to destination first then they will collide and speed will be of lower that means
            // slower time to reach destination
            if (cars[i - 1].timeToReachTarget <= cars[i].timeToReachTarget) {
                cars[i - 1].timeToReachTarget = cars[i].timeToReachTarget;
            } else {
                result++;
            }
        }
        return result;
    }

    private static final class Car {
        private final int position;
        private double timeToReachTarget;

        public Car(int position, double timeToReachTarget) {
            this.position = position;
            this.timeToReachTarget = timeToReachTarget;
        }
    }
}
