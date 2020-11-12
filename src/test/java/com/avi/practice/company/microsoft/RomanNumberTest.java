package com.avi.practice.company.microsoft;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RomanNumberTest {

    private final RomanNumber solver = new RomanNumber();
    @Test
    public void romanNumber() {
        {
            final int number = 9;
            final String expected = "IX";
            final String actual = solver.romanNumber(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 40;
            final String expected = "XL";
            final String actual = solver.romanNumber(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 1904;
            final String expected = "MCMIV";
            final String actual = solver.romanNumber(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
    }
}