package com.avi.practice.leetcode.weeklycontest.num160;

import com.avi.practice.maths.MathPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 29/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class CircularPermutationInBinaryRepresentation {

    public List<Integer> circularPermutation(int n, int start) {
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add((start) ^ greyCode(i));
        }
        return result;
    }

    private int greyCode(final int n) {
        return n ^ (n >> 1);
    }

    public static void main(String[] args) {
        CircularPermutationInBinaryRepresentation solver = new CircularPermutationInBinaryRepresentation();
        final MathPractice practice = new MathPractice();
        for (int i = 0; i <= 15; i++) {
            final int greyCode = solver.greyCode(i);
            System.out.println(String.format("Grey code at index %s is %s [%s]", i, greyCode, practice.decimalToBinary(greyCode)));
        }

    }
}
