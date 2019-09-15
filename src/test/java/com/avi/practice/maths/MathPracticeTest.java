package com.avi.practice.maths;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 15/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MathPracticeTest {

    private MathPractice tool;

    @Before
    public void setup() {
        tool = new MathPractice();
    }

    @After
    public void tearDown() {
        tool = null;
    }

    @Test
    public void allFactors() {
        {
            final int a = 1;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            Assert.assertEquals(expected, tool.allFactors(a));
        }
        {
            final int a = 2;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(2);
            Assert.assertEquals(expected, tool.allFactors(a));
        }
        {
            final int a = 3;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(3);
            Assert.assertEquals(expected, tool.allFactors(a));
        }
        {
            final int a = 6;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(2);
            expected.add(3);
            expected.add(6);
            Assert.assertEquals(expected, tool.allFactors(a));
        }

        {
            final int a = 85463;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(7);
            expected.add(29);
            expected.add(203);
            expected.add(421);
            expected.add(2947);
            expected.add(12209);
            expected.add(85463);
            Assert.assertEquals(expected, tool.allFactors(a));
        }
    }

    @Test
    public void allFactorsOptimized() {
        {
            final int a = 1;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            Assert.assertEquals(expected, tool.allFactorsOptimized(a));
        }
        {
            final int a = 2;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(2);
            Assert.assertEquals(expected, tool.allFactorsOptimized(a));
        }
        {
            final int a = 3;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(3);
            Assert.assertEquals(expected, tool.allFactorsOptimized(a));
        }
        {
            final int a = 6;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(2);
            expected.add(3);
            expected.add(6);
            Assert.assertEquals(expected, tool.allFactorsOptimized(a));
        }

        {
            final int a = 85463;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(7);
            expected.add(29);
            expected.add(203);
            expected.add(421);
            expected.add(2947);
            expected.add(12209);
            expected.add(85463);
            Assert.assertEquals(expected, tool.allFactorsOptimized(a));
        }
    }
}