package com.avi.practice.leetcode.weeklycontest.num220;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 20/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ReformatNumberTest {

    private static final ReformatNumber solver = new ReformatNumber();

    @Test
    public void reformatNumber1() {
        final String number = "1-23-45 6";
        final String expected = "123-456";
        final String actual = solver.reformatNumber(number);
        Assert.assertEquals(number, expected, actual);
    }

    @Test
    public void reformatNumber2() {
        final String number = "123 4-567";
        final String expected = "123-45-67";
        final String actual = solver.reformatNumber(number);
        Assert.assertEquals(number, expected, actual);
    }

    @Test
    public void reformatNumber3() {
        final String number = "123 4-5678";
        final String expected = "123-456-78";
        final String actual = solver.reformatNumber(number);
        Assert.assertEquals(number, expected, actual);
    }

    @Test
    public void reformatNumber4() {
        final String number = "12";
        final String expected = "12";
        final String actual = solver.reformatNumber(number);
        Assert.assertEquals(number, expected, actual);
    }

    @Test
    public void reformatNumber5() {
        final String number = "--17-5 229 35-39475 ";
        final String expected = "175-229-353-94-75";
        final String actual = solver.reformatNumber(number);
        Assert.assertEquals(number, expected, actual);
    }

}
