package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 16/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class EvaluateDivisionTest {

    @Test
    public void calcEquation1() {
        final EvaluateDivision solver = new EvaluateDivision();
        final List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        final double[] values = {2.0, 3.0};
        final List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        final double[] expected = {6.00000, 0.50000, -1.00000, 1.00000, -1.00000};
        final double[] actual = solver.calcEquation(equations, values, queries);
        System.out.println("Expected:" + Arrays.toString(expected));
        System.out.println("Actual:" + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void calcEquation2() {
        final EvaluateDivision solver = new EvaluateDivision();
        final List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        equations.add(Arrays.asList("bc", "cd"));
        final double[] values = {1.5, 2.5, 5.0};
        final List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("c", "b"));
        queries.add(Arrays.asList("bc", "cd"));
        queries.add(Arrays.asList("cd", "bc"));
        final double[] expected = {3.75000, 0.40000, 5.00000, 0.20000};
        final double[] actual = solver.calcEquation(equations, values, queries);
        System.out.println("Expected:" + Arrays.toString(expected));
        System.out.println("Actual:" + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void calcEquation3() {
        final EvaluateDivision solver = new EvaluateDivision();
        final List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        final double[] values = {0.5};
        final List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "b"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("x", "y"));
        final double[] expected = {0.50000, 2.00000, -1.00000, -1.00000};
        final double[] actual = solver.calcEquation(equations, values, queries);
        System.out.println("Expected:" + Arrays.toString(expected));
        System.out.println("Actual:" + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual, 0);
    }


    @Test
    public void calcEquation4() {
        final EvaluateDivision solver = new EvaluateDivision();
        final List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("x1", "x2"));
        equations.add(Arrays.asList("x2", "x3"));
        equations.add(Arrays.asList("x3", "x4"));
        equations.add(Arrays.asList("x4", "x5"));
        final double[] values = {3.0, 4.0, 5.0, 6.0};
        final List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("x1", "x5"));
        queries.add(Arrays.asList("x5", "x2"));
        queries.add(Arrays.asList("x2", "x4"));
        queries.add(Arrays.asList("x2", "x2"));
        queries.add(Arrays.asList("x2", "x9"));
        queries.add(Arrays.asList("x9", "x9"));
        final double[] expected = {360.00000, 0.00833, 20.00000, 1.00000, -1.00000, -1.00000};
        final double[] actual = solver.calcEquation(equations, values, queries);
        System.out.println("Expected:" + Arrays.toString(expected));
        System.out.println("Actual:" + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual, 0);
    }
}