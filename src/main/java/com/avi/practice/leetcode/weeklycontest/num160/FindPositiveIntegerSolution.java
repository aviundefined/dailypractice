package com.avi.practice.leetcode.weeklycontest.num160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 29/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class FindPositiveIntegerSolution {

    public List<List<Integer>> findSolution(final CustomFunction customfunction, final int z) {

        final int MAX_INPUT = 1000;
        final int MAX_OUTPUT = 100;
        int maxX = 1;
        int maxY = 1;
        // As function is increasing find maxX by fixing y = 1
        for (int x = 1; x <= MAX_INPUT; x++) {
            if (customfunction.f(x, 1) > z) {
                break;
            }
            maxX = x;
        }
        // As function is increasing find maxY by fixing x = 1
        for (int y = 1; y <= MAX_INPUT; y++) {
            if (customfunction.f(1, y) > z) {
                break;
            }
            maxY = y;
        }
        final List<List<Integer>> results = new ArrayList<>();
        for (int x = 1; x <= maxX; x++) {
            for (int y = 1; y <= maxY; y++) {
                final int currSol = customfunction.f(x, y);
                if (currSol > z) {
                    break;
                }
                if (currSol < z) {
                    continue;
                }
                final List<Integer> sol = new ArrayList<>();
                sol.add(x);
                sol.add(y);
                results.add(sol);
                break;
            }
        }
        return results;
    }

    public final List<List<Integer>> findSolutionOptimized(final CustomFunction customfunction, final int z) {
        final int MAX_INPUT = 1000;
        int maxX = 1;
        int maxY = 1;
        // As function is increasing find maxX by fixing y = 1
        for (int x = 1; x <= MAX_INPUT; x++) {
            if (customfunction.f(x, 1) > z) {
                break;
            }
            maxX = x;
        }
        // As function is increasing find maxY by fixing x = 1
        for (int y = 1; y <= MAX_INPUT; y++) {
            if (customfunction.f(1, y) > z) {
                break;
            }
            maxY = y;
        }
        final List<List<Integer>> results = new ArrayList<>();
        int x = 1, y = maxY;
        while (x <= maxX && y >= 1) {
            int v = customfunction.f(x, y);
            if (v > z) {
                y--; // current is greater than expected decrease the y
            } else if (v < z) {
                x++; // current is lower than expected increase the x
            } else {
                results.add(Arrays.asList(x, y)); // found add
                x++;
                y--;
            }
        }
        return results;
    }

    // This is the custom function interface.
    // You should not implement it, or speculate about its implementation
    interface CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        int f(int x, int y);
    }

    static final class AdditionFunction implements CustomFunction {

        @Override
        public int f(int x, int y) {
            return x + y;
        }
    }

    static final class MultiplicationFunction implements CustomFunction {

        @Override
        public int f(int x, int y) {
            return x * y;
        }
    }

    static final class CustomEquation implements CustomFunction {
        @Override
        public int f(int x, int y) {
            return (2 * x) + (3 * y);
        }
    }

}
