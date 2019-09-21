package com.avi.topics.searching;

import com.avi.practice.utils.CommonUtils;
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
            final int actual = SearchQuestions.rotationPoint(arr);
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
            final int actual = SearchQuestions.rotationPoint(arr);
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
            final int actual = SearchQuestions.rotationPoint(arr);
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
            final int actual = SearchQuestions.rotationPoint(arr);
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
}
