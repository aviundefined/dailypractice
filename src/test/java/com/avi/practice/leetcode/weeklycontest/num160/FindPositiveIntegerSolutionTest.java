package com.avi.practice.leetcode.weeklycontest.num160;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.avi.practice.leetcode.weeklycontest.num160.FindPositiveIntegerSolution.AdditionFunction;
import static com.avi.practice.leetcode.weeklycontest.num160.FindPositiveIntegerSolution.CustomEquation;
import static com.avi.practice.leetcode.weeklycontest.num160.FindPositiveIntegerSolution.CustomFunction;
import static com.avi.practice.leetcode.weeklycontest.num160.FindPositiveIntegerSolution.MultiplicationFunction;

/**
 * Created by navinash on 29/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FindPositiveIntegerSolutionTest {

    @Test
    public void findSolutionAddition() {
        final CustomFunction customFunction = new AdditionFunction();
        final FindPositiveIntegerSolution solver = new FindPositiveIntegerSolution();
        {
            final int z = 5;
            final List<List<Integer>> expected = new ArrayList<>();
            expected.add(Lists.newArrayList(1, 4));
            expected.add(Lists.newArrayList(2, 3));
            expected.add(Lists.newArrayList(3, 2));
            expected.add(Lists.newArrayList(4, 1));
            final List<List<Integer>> solution = solver.findSolution(customFunction, z);
            final List<List<Integer>> solutionOptimized = solver.findSolutionOptimized(customFunction, z);
            Assert.assertEquals("Addition Function: " + z, expected, solution);
            Assert.assertEquals("Addition Function: " + z, expected, solutionOptimized);
        }
    }

    @Test
    public void findSolutionMultiplication() {
        final CustomFunction customFunction = new MultiplicationFunction();
        final FindPositiveIntegerSolution solver = new FindPositiveIntegerSolution();
        {
            final int z = 5;
            final List<List<Integer>> expected = new ArrayList<>();
            expected.add(Lists.newArrayList(1, 5));
            expected.add(Lists.newArrayList(5, 1));
            final List<List<Integer>> solution = solver.findSolution(customFunction, z);
            final List<List<Integer>> solutionOptimized = solver.findSolutionOptimized(customFunction, z);
            Assert.assertEquals("Addition Function: " + z, expected, solution);
            Assert.assertEquals("Addition Function: " + z, expected, solutionOptimized);
        }
    }

    @Test
    public void findSolutionCustomEquation() {
        final CustomFunction customFunction = new CustomEquation();
        final FindPositiveIntegerSolution solver = new FindPositiveIntegerSolution();
        {
            final int z = 50;
            final List<List<Integer>> expected = new ArrayList<>();
            expected.add(Arrays.asList(1, 16));
            expected.add(Arrays.asList(4, 14));
            expected.add(Arrays.asList(7, 12));
            expected.add(Arrays.asList(10, 10));
            expected.add(Arrays.asList(13, 8));
            expected.add(Arrays.asList(16, 6));
            expected.add(Arrays.asList(19, 4));
            expected.add(Arrays.asList(22, 2));
            final List<List<Integer>> solution = solver.findSolution(customFunction, z);
            final List<List<Integer>> solutionOptimized = solver.findSolutionOptimized(customFunction, z);
            Assert.assertEquals("Addition Function: " + z, expected, solution);
            Assert.assertEquals("Addition Function: " + z, expected, solutionOptimized);
        }
    }
}