package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 27/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class KokoEatingBananasTest {

    private static final KokoEatingBananas solver = new KokoEatingBananas();

    @Test
    public void minEatingSpeed1() {
        final int[] piles = {3, 6, 7, 11};
        final int h = 8;
        final int expected = 4;
        final int actual = solver.minEatingSpeed(piles, h);
        Assert.assertEquals(String.format("piles: %s, h: %s", Arrays.toString(piles), h), expected, actual);
    }
}