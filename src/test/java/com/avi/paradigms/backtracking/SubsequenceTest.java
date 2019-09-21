package com.avi.paradigms.backtracking;


import com.avi.paradigms.backtracking.Subsequence;
import com.avi.practice.utils.CommonUtils;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

/**
 * Created by navinash on 21/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SubsequenceTest {

    @Test
    public void all() {
        final int[] arr = {2, 3, 4, 5, 1};
        System.out.print("Print all subsequences of arr: ");
        CommonUtils.printArr(arr);
        final Subsequence solver = new Subsequence(arr);
        final Collection<List<Integer>> all = solver.all();
        for (final List<Integer> sub : all) {
            System.out.println(sub);
        }
        System.out.println();
    }

    @Test
    public void ofLengthK() {
        final int length = 3;
        final int[] arr = {2, length, 4, 5, 1};
        final Subsequence solver = new Subsequence(arr);
        System.out.print("Array ");
        CommonUtils.printArr(arr);
        System.out.println("Print subsequences of arr of length: " + length);
        final Collection<List<Integer>> offK = solver.ofLengthK(length);
        for (final List<Integer> sub : offK) {
            System.out.println(sub);
        }
    }


    @Test
    public void all1() {
        final int[] arr = {2, 3, 4, 5, 5, 1, 1, 2};
        System.out.print("Print all subsequences of arr: ");
        CommonUtils.printArr(arr);
        final Subsequence solver = new Subsequence(arr);
        final Collection<List<Integer>> all = solver.all();
        for (final List<Integer> sub : all) {
            System.out.println(sub);
        }
        System.out.println();
    }
}