package com.avi.topics.searching;

import com.avi.practice.utils.CommonUtils;
import com.avi.topics.searching.SearchQuestions.ClosetToZeroSumResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 21/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SearchQuestionsTest {

    @Test
    public void findListInList() {
        {
            final List<Integer> parent = Arrays.asList(5, 10, 20);
            final List<Integer> target = Arrays.asList(10, 20);
            final int expected = 1;
            final int startIndex = SearchQuestions.findListInList(parent, target);
            Assert.assertEquals(expected, startIndex);
        }
        {
            final List<Integer> parent = Arrays.asList(1, 2, 1, 2, 3, 4, 5);
            final List<Integer> target = Arrays.asList(1, 2, 3, 4);
            final int expected = 2;
            final int startIndex = SearchQuestions.findListInList(parent, target);
            Assert.assertEquals(expected, startIndex);
        }
        {
            final List<Integer> parent = Arrays.asList(1, 2, 2, 1, 2, 3);
            final List<Integer> target = Arrays.asList(1, 2, 3, 4);
            final int expected = -1;
            final int startIndex = SearchQuestions.findListInList(parent, target);
            Assert.assertEquals(expected, startIndex);
        }
    }

    @Test
    public void rotationPoint() {
        {
            final int[] arr = {5, 6, 7, 8, 10, 11, 1, 2, 4};
            CommonUtils.printArr(arr);
            final int expected = 6;
            final int actual = SearchQuestions.findMinimumElementInRotatedSortedArray(arr);
            Assert.assertEquals(expected, actual);
            if (actual == -1) {
                System.out.println("Rotation point not found");
            } else {
                System.out.println("Rotation point: " + arr[actual]);
            }
        }

        {
            final int[] arr = {6, 7, 8, 10, 11, 1, 2, 4, 5};
            CommonUtils.printArr(arr);
            final int expected = 5;
            final int actual = SearchQuestions.findMinimumElementInRotatedSortedArray(arr);
            Assert.assertEquals(expected, actual);
            if (actual == -1) {
                System.out.println("Rotation point not found");
            } else {
                System.out.println("Rotation point: " + arr[actual]);
            }
        }

        {
            final int[] arr = {18, 6, 7, 8, 10, 11, 12, 13, 14, 15, 16, 17};
            CommonUtils.printArr(arr);
            final int expected = 1;
            final int actual = SearchQuestions.findMinimumElementInRotatedSortedArray(arr);
            Assert.assertEquals(expected, actual);
            if (actual == -1) {
                System.out.println("Rotation point not found");
            } else {
                System.out.println("Rotation point: " + arr[actual]);
            }
        }

        {
            final int[] arr = {6, 7, 8, 10, 11, 12, 13, 14, 15, 16, 17, 1};
            CommonUtils.printArr(arr);
            final int expected = 11;
            final int actual = SearchQuestions.findMinimumElementInRotatedSortedArray(arr);
            Assert.assertEquals(expected, actual);
            if (actual == -1) {
                System.out.println("Rotation point not found");
            } else {
                System.out.println("Rotation point: " + arr[actual]);
            }
        }
    }

    @Test
    public void rotatedSearch() {
        final int[] arr = {5, 6, 7, 8, 10, 11, 1, 2, 4};
        CommonUtils.printArr(arr);
        for (int i = 0; i < arr.length; i++) {
            final int actual = SearchQuestions.rotatedSearch(arr, arr[i]);
            Assert.assertEquals(String.valueOf(arr[i]), i, actual);
        }
        {
            final int key = 0;
            final int expected = -1;
            final int actual = SearchQuestions.rotatedSearch(arr, key);
            Assert.assertEquals(String.valueOf(key), expected, actual);
        }
        {
            final int key = 3;
            final int expected = -1;
            final int actual = SearchQuestions.rotatedSearch(arr, key);
            Assert.assertEquals(String.valueOf(key), expected, actual);
        }
        {
            final int key = 9;
            final int expected = -1;
            final int actual = SearchQuestions.rotatedSearch(arr, key);
            Assert.assertEquals(String.valueOf(key), expected, actual);
        }
        {
            final int key = 13;
            final int expected = -1;
            final int actual = SearchQuestions.rotatedSearch(arr, key);
            Assert.assertEquals(String.valueOf(key), expected, actual);
        }
    }

    @Test
    public void findMissingNumber() {
        {
            final int[] arr = {1, 2, 3, 5, 6, 7};
            CommonUtils.printArr(arr);
            final int expected = 4;
            final int sumApproach = SearchQuestions.findMissingNumberSumApproach(arr);
            final int xorApproach = SearchQuestions.findMissingNumberXORApproach(arr);
            Assert.assertEquals(expected, sumApproach);
            Assert.assertEquals(expected, xorApproach);
        }

        {
            final int[] arr = {2, 1, 3, 4, 6, 7};
            CommonUtils.printArr(arr);
            final int expected = 5;
            final int sumApproach = SearchQuestions.findMissingNumberSumApproach(arr);
            final int xorApproach = SearchQuestions.findMissingNumberXORApproach(arr);
            Assert.assertEquals(expected, sumApproach);
            Assert.assertEquals(expected, xorApproach);
        }
    }

    @Test
    public void findPivot() {
        {
            final int[] a = {3, 4, 5, 1, 2};
            CommonUtils.printArr(a);
            final int expected = 2;
            final int pivot = SearchQuestions.findPivot(a);
            if (expected != pivot) {
                if (pivot == -1) {
                    System.out.println(String.format("Expected pivot: {%s} but pivot not found", a[expected]));
                } else {
                    System.out.println(String.format("Expected pivot: {%s}, Found Pivot: {%s}", a[expected], a[pivot]));
                }
            }
            Assert.assertEquals(String.valueOf(a[expected]), expected, pivot);
        }
        {
            final int[] a = {5, 6, 7, 8, 10, 11, 1, 2, 4};
            CommonUtils.printArr(a);
            final int expected = 5;
            final int pivot = SearchQuestions.findPivot(a);
            if (expected != pivot) {
                if (pivot == -1) {
                    System.out.println(String.format("Expected pivot: {%s} but pivot not found", a[expected]));
                } else {
                    System.out.println(String.format("Expected pivot: {%s}, Found Pivot: {%s}", a[expected], a[pivot]));
                }
            }
            Assert.assertEquals(String.valueOf(a[expected]), expected, pivot);
        }

        {
            final int[] a = {4, 5, 6, 7, 8, 9, 1, 2, 3};
            CommonUtils.printArr(a);
            final int expected = 5;
            final int pivot = SearchQuestions.findPivot(a);
            if (expected != pivot) {
                if (pivot == -1) {
                    System.out.println(String.format("Expected pivot: {%s} but pivot not found", a[expected]));
                } else {
                    System.out.println(String.format("Expected pivot: {%s}, Found Pivot: {%s}", a[expected], a[pivot]));
                }
            }
            Assert.assertEquals(String.valueOf(a[expected]), expected, pivot);
        }
    }

    @Test
    public void medianSortedArraysEqualSize() {
        {
            final int[] arr1 = {1, 2, 3, 6};
            final int[] arr2 = {4, 6, 8, 10};
            CommonUtils.printArr(arr1);
            CommonUtils.printArr(arr2);
            final double expected = 5;
            final double medianActual = SearchQuestions.medianSortedArraysEqualSize(arr1, arr2);
            System.out.println(expected + " --> " + medianActual);
            Assert.assertEquals(expected, medianActual, 0.0);
        }

        {
            final int[] arr1 = {1, 12, 15, 26, 38};
            final int[] arr2 = {2, 13, 17, 30, 45};
            CommonUtils.printArr(arr1);
            CommonUtils.printArr(arr2);
            final double expected = 16;
            final double medianActual = SearchQuestions.medianSortedArraysEqualSize(arr1, arr2);
            System.out.println(expected + " --> " + medianActual);
            Assert.assertEquals(expected, medianActual, 0.0);
        }

        {
            final int[] arr1 = {1, 12, 15, 16, 38};
            final int[] arr2 = {2, 13, 17, 30, 45};
            CommonUtils.printArr(arr1);
            CommonUtils.printArr(arr2);
            final double expected = 15.5;
            final double medianActual = SearchQuestions.medianSortedArraysEqualSize(arr1, arr2);
            System.out.println(expected + " --> " + medianActual);
            Assert.assertEquals(expected, medianActual, 0.0);
        }

        {
            final int[] arr1 = {1, 12, 15, 26, 38, 50};
            final int[] arr2 = {2, 13, 17, 30, 45, 48};
            CommonUtils.printArr(arr1);
            CommonUtils.printArr(arr2);
            final double expected = 21.5;
            final double medianActual = SearchQuestions.medianSortedArraysEqualSize(arr1, arr2);
            System.out.println(expected + " --> " + medianActual);
            Assert.assertEquals(expected, medianActual, 0.0);
        }

        {
            final int[] arr1 = {1, 12, 15, 26, 38, 50, 53};
            final int[] arr2 = {2, 13, 17, 26, 45, 48, 55};
            CommonUtils.printArr(arr1);
            CommonUtils.printArr(arr2);
            final double expected = 26;
            final double medianActual = SearchQuestions.medianSortedArraysEqualSize(arr1, arr2);
            System.out.println(expected + " --> " + medianActual);
            Assert.assertEquals(expected, medianActual, 0.0);
        }
    }

    @Test
    public void findClosetToZeroSum() {
        {
            final int[] arr = {1, 60, -10, 70, -80, 85};
            CommonUtils.printArr(arr);
            final int expected = 5;
            final ClosetToZeroSumResult result = SearchQuestions.findClosetToZeroSum(arr);
            Assert.assertNotNull(result);
            Assert.assertEquals(result.toString(), expected, result.sum());
            System.out.println(result);
        }
    }

    private static int randInt() {
        return randInt(1000);
    }

    private static int randInt(final int n) {
        return (int) (Math.random() * n);
    }
}
