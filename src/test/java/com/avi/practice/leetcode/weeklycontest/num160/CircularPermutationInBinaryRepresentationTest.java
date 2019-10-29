package com.avi.practice.leetcode.weeklycontest.num160;

import com.avi.practice.maths.MathPractice;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by navinash on 29/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CircularPermutationInBinaryRepresentationTest {

    @Test
    public void circularPermutation() {
        final CircularPermutationInBinaryRepresentation solver = new CircularPermutationInBinaryRepresentation();
        final MathPractice mathPractice = new MathPractice();
        {
            final int n = 2;
            final int start = 3;
            final List<Integer> expected = Arrays.asList(3, 2, 0, 1);
            final List<Integer> result = solver.circularPermutation(n, start);
            final List<String> resultInBinary = result.stream()
                    .map(mathPractice::decimalToBinary)
                    .collect(Collectors.toList());
            System.out.println(resultInBinary);
            Assert.assertEquals(String.format("n: %s, start: %s", n, start), expected, result);
        }
        {
            final int n = 3;
            final int start = 2;
            final List<Integer> expected = Arrays.asList(2, 3, 1, 0, 4, 5, 7, 6);
            final List<Integer> result = solver.circularPermutation(n, start);
            final List<String> resultInBinary = result.stream()
                    .map(mathPractice::decimalToBinary)
                    .collect(Collectors.toList());
            System.out.println(resultInBinary);
            Assert.assertEquals(String.format("n: %s, start: %s", n, start), expected, result);
        }
    }
}