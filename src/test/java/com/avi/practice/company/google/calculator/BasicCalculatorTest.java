package com.avi.practice.company.google.calculator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 10/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BasicCalculatorTest {

    @Test
    public void calculate1() {
        final BasicCalculator calculator = new BasicCalculator();
        final String s = "1 + 1";
        final int expected = 2;
        final int actual = calculator.calculate(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void calculate2() {
        final BasicCalculator calculator = new BasicCalculator();
        final String s = " 2-1 + 2 ";
        final int expected = 3;
        final int actual = calculator.calculate(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void calculate3() {
        final BasicCalculator calculator = new BasicCalculator();
        final String s = "(1+(4+5+2)-3)+(6+8)";
        final int expected = 23;
        final int actual = calculator.calculate(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void calculate4() {
        final BasicCalculator calculator = new BasicCalculator();
        final String s = "-2+ 1";
        final int expected = -1;
        final int actual = calculator.calculate(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void calculate5() {
        final BasicCalculator calculator = new BasicCalculator();
        final String s = "-2-1 + 2 ";
        final int expected = -1;
        final int actual = calculator.calculate(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void calculate6() {
        final BasicCalculator calculator = new BasicCalculator();
        final String s = "(-2-1) + 2 ";
        final int expected = -1;
        final int actual = calculator.calculate(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void calculate7() {
        final BasicCalculator calculator = new BasicCalculator();
        final String s = "- (3 + (4 + 5))";
        final int expected = -12;
        final int actual = calculator.calculate(s);
        Assert.assertEquals(s, expected, actual);
    }

}