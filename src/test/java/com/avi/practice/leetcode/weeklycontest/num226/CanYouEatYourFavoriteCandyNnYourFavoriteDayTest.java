package com.avi.practice.leetcode.weeklycontest.num226;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 06/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CanYouEatYourFavoriteCandyNnYourFavoriteDayTest {

    private final CanYouEatYourFavoriteCandyNnYourFavoriteDay solver = new CanYouEatYourFavoriteCandyNnYourFavoriteDay();

    @Test
    public void canEat() {
        final int[] candiesCount = {7, 4, 5, 3, 8};
        final int[][] queries = {{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}};
        final boolean[] expected = {true, false, true};
        final boolean[] actual = solver.canEat(candiesCount, queries);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(String.valueOf(i), expected[i], actual[i]);
        }
    }
}