package com.avi.practice.company.google;

import java.util.Arrays;

/**
 * Created by navinash on 20/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {

        final int n = position.length;
        final Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i], (1.00D * (target - position[i])) / speed[i]);
        }
        Arrays.sort(cars, (o1, o2) -> Double.compare(o1.position, o2.position));
        int numFleets = 1;
        for (int i = n - 1; i > 0; i--) {
            // i - 1 car will merge into i car if time take by i - 1 will be less than equal to i, else new fleet
            if (cars[i - 1].timeToTargetSeconds <= cars[i].timeToTargetSeconds) {
                cars[i - 1].timeToTargetSeconds = cars[i].timeToTargetSeconds;
            } else {
               numFleets++;
            }
        }
        return numFleets;
    }

    private static final class Car {
        private final int position;
        private final int speed;
        private double timeToTargetSeconds;

        private Car(int position, int speed, double timeToTargetSeconds) {
            this.position = position;
            this.speed = speed;
            this.timeToTargetSeconds = timeToTargetSeconds;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "position=" + position +
                    ", speed=" + speed +
                    ", timeToTargetSeconds=" + timeToTargetSeconds +
                    '}';
        }
    }
}
