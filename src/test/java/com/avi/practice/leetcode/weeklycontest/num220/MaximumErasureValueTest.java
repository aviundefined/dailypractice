package com.avi.practice.leetcode.weeklycontest.num220;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 20/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumErasureValueTest {
    private static final MaximumErasureValue solver = new MaximumErasureValue();

    @Test
    public void maximumUniqueSubarray1() {
        final int[] nums = {4, 2, 4, 5, 6};
        final int expected = 17;
        final int actual = solver.maximumUniqueSubarray(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void maximumUniqueSubarray2() {
        final int[] nums = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        final int expected = 8;
        final int actual = solver.maximumUniqueSubarray(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void maximumUniqueSubarray3() {
        final int[] nums = {449,154,934,526,429,732,784,909,884,805,635,660,742,209,742,272,669,449,766,904,698,434,280,332,876,200,333,464,12,437,269,355,622,903,262,691,768,894,929,628,867,844,208,384,644,511,908,792,56,872,275,598,633,502,894,999,788,394,309,950,159,178,403,110,670,234,119,953,267,634,330,410,137,805,317,470,563,900,545,308,531,428,526,593,638,651,320,874,810,666,180,521,452,131,201,915,502,765,17,577,821,731,925,953,111,305,705,162,994,425,17,140,700,475,772,385,922,159,840,367,276,635,696,70,744,804,63,448,435,242,507,764,373,314,140,825,34,383,151,602,745};
        final int expected = 30934;
        final int actual = solver.maximumUniqueSubarray(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }
}