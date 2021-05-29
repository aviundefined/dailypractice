package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 28/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AsteroidCollisionTest {

    private static final AsteroidCollision solver = new AsteroidCollision();

    @Test
    public void asteroidCollision1() {
        final int[] asteroids = {5, 10, -5};
        final int[] expected = {5, 10};
        final int[] actual = solver.asteroidCollision(asteroids);
        Assert.assertEquals(Arrays.toString(asteroids), Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void asteroidCollision2() {
        final int[] asteroids = {8, -8};
        final int[] expected = {};
        final int[] actual = solver.asteroidCollision(asteroids);
        Assert.assertEquals(Arrays.toString(asteroids), Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void asteroidCollision3() {
        final int[] asteroids = {10, 2, -5};
        final int[] expected = {10};
        final int[] actual = solver.asteroidCollision(asteroids);
        Assert.assertEquals(Arrays.toString(asteroids), Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void asteroidCollision4() {
        final int[] asteroids = {-2, -1, 1, 2};
        final int[] expected = {-2, -1, 1, 2};
        final int[] actual = solver.asteroidCollision(asteroids);
        Assert.assertEquals(Arrays.toString(asteroids), Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void asteroidCollisionSlow1() {
        final int[] asteroids = {5, 10, -5};
        final int[] expected = {5, 10};
        final int[] actual = solver.asteroidCollisionSlow(asteroids);
        Assert.assertEquals(Arrays.toString(asteroids), Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void asteroidCollisionSlow() {
        final int[] asteroids = {8, -8};
        final int[] expected = {};
        final int[] actual = solver.asteroidCollisionSlow(asteroids);
        Assert.assertEquals(Arrays.toString(asteroids), Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void asteroidCollisionSlow3() {
        final int[] asteroids = {10, 2, -5};
        final int[] expected = {10};
        final int[] actual = solver.asteroidCollisionSlow(asteroids);
        Assert.assertEquals(Arrays.toString(asteroids), Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void asteroidCollisionSlow4() {
        final int[] asteroids = {-2, -1, 1, 2};
        final int[] expected = {-2, -1, 1, 2};
        final int[] actual = solver.asteroidCollisionSlow(asteroids);
        Assert.assertEquals(Arrays.toString(asteroids), Arrays.toString(expected), Arrays.toString(actual));
    }
}