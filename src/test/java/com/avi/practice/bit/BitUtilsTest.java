package com.avi.practice.bit;

import com.avi.practice.company.microsoft.BinaryRepresentation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 11/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BitUtilsTest {

    @Test
    public void toggleKthBit() {
        {
            final int number = 5;
            final int k = 1;
            final int expected = 4;
            final int actual = BitUtils.toggleKthBit(number, k);
            Assert.assertEquals(String.format("Toggle [%d] bit of [%d]", k, number), expected, actual);
        }
        {
            final int number = 2;
            final int k = 3;
            final int expected = 6;
            final int actual = BitUtils.toggleKthBit(number, k);
            Assert.assertEquals(String.format("Toggle [%d] bit of [%d]", k, number), expected, actual);
        }
        {
            final int number = 5;
            final int k = 1;
            final int expected = 4;
            final int actual = BitUtils.toggleKthBit(number, k);
            Assert.assertEquals(String.format("Toggle [%d] bit of [%d]", k, number), expected, actual);
        }
        {
            final int number = 75;
            final int k = 4;
            final int expected = 67;
            final int actual = BitUtils.toggleKthBit(number, k);
            Assert.assertEquals(String.format("Toggle [%d] bit of [%d]", k, number), expected, actual);
        }
    }

    @Test
    public void numBits() {
        {
            final int number = 5;
            final int expected = 3;
            final int actual = BitUtils.numBits(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 2;
            final int expected = 2;
            final int actual = BitUtils.numBits(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 75;
            final int expected = 7;
            final int actual = BitUtils.numBits(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
    }


    @Test
    public void invertBits() {
        {
            final int number = 11;
            final int expected = 4;
            final int actual = BitUtils.invertBits(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 10;
            final int expected = 5;
            final int actual = BitUtils.invertBits(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 5;
            final int expected = 2;
            final int actual = BitUtils.invertBits(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 2;
            final int expected = 1;
            final int actual = BitUtils.invertBits(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
    }

    @Test
    public void twosComplement() {
        {
            final int number = 11;
            final int expected = -11;
            final int actual = BitUtils.twosComplement(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 10;
            final int expected = -10;
            final int actual = BitUtils.twosComplement(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 5;
            final int expected = -5;
            final int actual = BitUtils.twosComplement(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 2;
            final int expected = -2;
            final int actual = BitUtils.twosComplement(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
    }

    @Test
    public void unsetRightMostSetBit() {
        {
            final int number = 11;
            final int expected = 10;
            final int actual = BitUtils.unsetRightMostSetBit(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 10;
            final int expected = 8;
            final int actual = BitUtils.unsetRightMostSetBit(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 8;
            final int expected = 0;
            final int actual = BitUtils.unsetRightMostSetBit(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 5;
            final int expected = 4;
            final int actual = BitUtils.unsetRightMostSetBit(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
        {
            final int number = 2;
            final int expected = 0;
            final int actual = BitUtils.unsetRightMostSetBit(number);
            Assert.assertEquals(String.valueOf(number), expected, actual);
        }
    }

    @Test
    public void extractKthBit() {
        final BinaryRepresentation solver = new BinaryRepresentation();
        final int number = 25;
        System.out.println(solver.binary(number));
        {
            final int k = 1;
            final int expected = 1;
            final int actual = BitUtils.extractKthBit(number, k);
            Assert.assertEquals(String.valueOf(k), expected, actual);
        }
        {
            final int k = 2;
            final int expected = 0;
            final int actual = BitUtils.extractKthBit(number, k);
            Assert.assertEquals(String.valueOf(k), expected, actual);
        }
        {
            final int k = 3;
            final int expected = 0;
            final int actual = BitUtils.extractKthBit(number, k);
            Assert.assertEquals(String.valueOf(k), expected, actual);
        }
        {
            final int k = 4;
            final int expected = 1;
            final int actual = BitUtils.extractKthBit(number, k);
            Assert.assertEquals(String.valueOf(k), expected, actual);
        }
        {
            final int k = 5;
            final int expected = 1;
            final int actual = BitUtils.extractKthBit(number, k);
            Assert.assertEquals(String.valueOf(k), expected, actual);
        }

    }
}