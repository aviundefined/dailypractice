package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 25/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class KokoEatingBananasTest {

    private static final KokoEatingBananas solver = new KokoEatingBananas();

    @Test
    public void minEatingSpeed1() {
        final int[] piles = {3, 6, 7, 11};
        final int H = 8;
        System.out.printf("piles: %s, hours: %d", Arrays.toString(piles), H);
        final int expected = 4;
        final int actual = solver.minEatingSpeed(piles, H);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minEatingSpeed2() {
        final int[] piles = {30, 11, 23, 4, 20};
        final int H = 5;
        System.out.printf("piles: %s, hours: %d", Arrays.toString(piles), H);
        final int expected = 30;
        final int actual = solver.minEatingSpeed(piles, H);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minEatingSpeed3() {
        final int[] piles = {30, 11, 23, 4, 20};
        final int H = 6;
        System.out.printf("piles: %s, hours: %d", Arrays.toString(piles), H);
        final int expected = 23;
        final int actual = solver.minEatingSpeed(piles, H);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minEatingSpeed4() {
        final int[] piles = {312884470};
        final int H = 312884469;
        System.out.printf("piles: %s, hours: %d", Arrays.toString(piles), H);
        final int expected = 2;
        final int actual = solver.minEatingSpeed(piles, H);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minEatingSpeed5() {
        final int[] piles = {873375536,395271806,617254718,970525912,634754347,824202576,694181619,20191396,886462834,442389139,572655464,438946009,791566709,776244944,694340852,419438893,784015530,588954527,282060288,269101141,499386849,846936808,92389214,385055341,56742915,803341674,837907634,728867715,20958651,167651719,345626668,701905050,932332403,572486583,603363649,967330688,484233747,859566856,446838995,375409782,220949961,72860128,998899684,615754807,383344277,36322529,154308670,335291837,927055440,28020467,558059248,999492426,991026255,30205761,884639109,61689648,742973721,395173120,38459914,705636911,30019578,968014413,126489328,738983100,793184186,871576545,768870427,955396670,328003949,786890382,450361695,994581348,158169007,309034664,388541713,142633427,390169457,161995664,906356894,379954831,448138536};
        final int H = 943223529;
        System.out.printf("piles: %s, hours: %d", Arrays.toString(piles), H);
        final int expected = 46;
        final int actual = solver.minEatingSpeed(piles, H);
        Assert.assertEquals(expected, actual);
    }
}