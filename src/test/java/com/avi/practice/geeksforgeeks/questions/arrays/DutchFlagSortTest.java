package com.avi.practice.geeksforgeeks.questions.arrays;

import com.avi.practice.utils.CommonUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 24/12/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DutchFlagSortTest {

    private final DutchFlagSort sorter = new DutchFlagSort();

    @Test
    public void sort_0_1() {
        final int[] a = {0, 1, 1, 0, 1, 0, 1};
        final int[] sorted = cloneAndSort(a);
        Arrays.sort(sorted);
        CommonUtils.printArr(a);
        sorter.sort_0_1(a);
        CommonUtils.printArr(a);
        assertArrayEquals(sorted, a);
        System.out.println("------------------------------");
        final int rand = rand();
        for (int i = 0; i <= rand; i++) {
            final int[] arr = get_0_1_Array();
            final int[] sortedArr = cloneAndSort(arr);
            CommonUtils.printArr(arr);
            sorter.sort_0_1(arr);
            CommonUtils.printArr(arr);
            assertArrayEquals(sortedArr, arr);
            System.out.println("------------------------------");
        }
    }

    @Test
    public void sort_0_1_2() {
        final int[] a = {0, 1, 1, 2, 0, 1, 1, 0, 1, 2, 1, 0, 1, 0, 1, 2, 1};
        final int[] sorted = cloneAndSort(a);
        Arrays.sort(sorted);
        CommonUtils.printArr(a);
        sorter.sort_0_1_2(a);
        CommonUtils.printArr(a);
        assertArrayEquals(sorted, a);
        System.out.println("------------------------------");
        final int rand = rand();
        for (int i = 0; i <= rand; i++) {
            final int[] arr = get_0_1_2_Array();
            final int[] sortedArr = cloneAndSort(arr);
            CommonUtils.printArr(arr);
            sorter.sort_0_1_2(arr);
            CommonUtils.printArr(arr);
            assertArrayEquals(sortedArr, arr);
            System.out.println("------------------------------");
        }
    }

    private int[] cloneAndSort(int[] arr) {
        final int[] sortedArr = new int[arr.length];
        for (int j = 0; j < arr.length; j++) {
            sortedArr[j] = arr[j];
        }
        Arrays.sort(sortedArr);
        return sortedArr;
    }

    private int[] get_0_1_2_Array() {
        final int n = rand(25);
        final int[] arr = new int[n];
        for (int j = 0; j < n; j++) {
            arr[j] = rand() % 3;
        }
        return arr;
    }

    private int[] get_0_1_Array() {
        final int n = rand(20);
        final int[] arr = new int[n];
        for (int j = 0; j < n; j++) {
            arr[j] = rand() % 2;
        }
        return arr;
    }

    private int rand() {
        return rand(100);
    }

    private int rand(final int n) {
        return (int) (Math.random() * 100 + 1);
    }

}