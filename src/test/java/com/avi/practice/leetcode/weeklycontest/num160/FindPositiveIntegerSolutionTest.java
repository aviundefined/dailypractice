package com.avi.practice.leetcode.weeklycontest.num160;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.avi.practice.leetcode.weeklycontest.num160.FindPositiveIntegerSolution.*;
import static org.junit.Assert.*;

/**
 * Created by navinash on 29/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FindPositiveIntegerSolutionTest {

    @Test
    public void findSolutionAddition() {
        final CustomFunction additionFunction = new AdditionFunction();
        final FindPositiveIntegerSolution solver = new FindPositiveIntegerSolution();
        {
            final int z = 5;
            final List<List<Integer>> expected = new ArrayList<>();
            expected.add(Lists.newArrayList(1, 4));
            expected.add(Lists.newArrayList(2, 3));
            expected.add(Lists.newArrayList(3, 2));
            expected.add(Lists.newArrayList(4, 1));
            final List<List<Integer>> solution = solver.findSolution(additionFunction, z);
            Assert.assertEquals("Addition Function: "+z, expected, solution);
        }
    }

    @Test
    public void findSolutionMultiplication() {
        final CustomFunction multiplicationFunction = new MultiplicationFunction();
        final FindPositiveIntegerSolution solver = new FindPositiveIntegerSolution();
        {
            final int z = 5;
            final List<List<Integer>> expected = new ArrayList<>();
            expected.add(Lists.newArrayList(1, 5));
            expected.add(Lists.newArrayList(5, 1));
            final List<List<Integer>> solution = solver.findSolution(multiplicationFunction, z);
            Assert.assertEquals("Addition Function: "+z, expected, solution);
        }
    }
}