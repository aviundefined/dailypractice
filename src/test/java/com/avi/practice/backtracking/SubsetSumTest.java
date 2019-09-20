package com.avi.practice.backtracking;


import org.junit.Test;

import java.util.Collection;
import java.util.List;

/**
 * Created by navinash on 20/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SubsetSumTest {


    @Test
    public void solve1() {
        int[] a = {1, 2, 3, 4};
        int target = 5;
        final SubsetSum solver = new SubsetSum(a);
        final Collection<List<Integer>> subsetSums = solver.solve(target);
        System.out.println("Solutions: " + subsetSums);
    }

    @Test
    public void solve2() {
        int[] a = {15, 22, 14, 26, 32, 9, 16, 8};
        int target = 53;
        final SubsetSum solver = new SubsetSum(a);
        final Collection<List<Integer>> subsetSums = solver.solve(target);
        System.out.println("Solutions: " + subsetSums);
    }

    @Test
    public void solve3() {
        int[] a = {3, 2, 7, 1};
        final SubsetSum solver = new SubsetSum(a);
        final int target = 6;
        final Collection<List<Integer>> subsetSums = solver.solve(target);
        System.out.println("Solutions: " + subsetSums);
    }

    @Test
    public void solve4() {
        int[] a = {3, 2, 6, 1};
        final SubsetSum solver = new SubsetSum(a);
        final int target = 6;
        final Collection<List<Integer>> subsetSums = solver.solve(target);
        System.out.println("Solutions: " + subsetSums);
    }

    @Test
    public void solve5() {
        int[] a = {3, 2, 7, 1, -1, 2};
        final SubsetSum solver = new SubsetSum(a);
        final int target = 6;
        final Collection<List<Integer>> subsetSums = solver.solve(target);
        System.out.println("Solutions: " + subsetSums);
    }


}