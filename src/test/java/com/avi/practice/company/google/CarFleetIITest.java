package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 24/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CarFleetIITest {
    private static final CarFleetII solver = new CarFleetII();

    @Test
    public void getCollisionTimes1() {
        final int[][] cars = {
                {1, 2},
                {2, 1},
                {4, 3},
                {7, 2}};
        final double[] expected = {1.00000D, -1.00000D, 3.00000D, -1.00000D};
        final double[] actual = solver.getCollisionTimes(cars);
        System.out.print("Cars: ");
        for (final int[] car : cars) {
            System.out.print(Arrays.toString(car) + ",");
        }
        System.out.println();
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
        Assert.assertEquals("size", expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], actual[i], 0);
        }
        System.out.println("-------------------------");
    }

    @Test
    public void getCollisionTimes2() {
        final int[][] cars = {
                {3, 4},
                {5, 4},
                {6, 3},
                {9, 1}
        };
        final double[] expected = {2.00000D,1.00000D,1.50000D,-1.00000D};
        final double[] actual = solver.getCollisionTimes(cars);
        System.out.print("Cars: ");
        for (final int[] car : cars) {
            System.out.print(Arrays.toString(car) + ",");
        }
        System.out.println();
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
        Assert.assertEquals("size", expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], actual[i], 5);
        }
        System.out.println("-------------------------");
    }
}