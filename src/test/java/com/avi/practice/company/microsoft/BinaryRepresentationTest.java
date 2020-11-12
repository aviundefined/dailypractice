package com.avi.practice.company.microsoft;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BinaryRepresentationTest {

    private final BinaryRepresentation solver = new BinaryRepresentation();

    @Test
    public void binary() {
        {
            final int number = 23;
            final String expected = "10111";
            final String actual = solver.binary(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 21;
            final String expected = "10101";
            final String actual = solver.binary(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 25;
            final String expected = "11001";
            final String actual = solver.binary(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
    }

    @Test
    public void binary2ndApproach() {
        {
            final int number = 23;
            final String expected = "10111";
            final String actual = solver.binary2ndApproach(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 21;
            final String expected = "10101";
            final String actual = solver.binary2ndApproach(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 25;
            final String expected = "11001";
            final String actual = solver.binary2ndApproach(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
    }
}