package com.avi.topics.searching;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 21/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BinarySearchTest {

    @Test
    public void find() {
        final int[] arr = {2, 3, 4, 10, 40};
        final BinarySearch solver = new BinarySearch(arr);
        final int n = arr.length;
        System.out.print("Find index in arr: ");
        CommonUtils.printArr(arr);
        {
            final int x = 4;
            final int index = solver.findRecursive(x);
            Assert.assertEquals(String.valueOf(x), 2, index);
        }
        {
            final int x = arr[0];
            final int index = solver.findRecursive(x);
            Assert.assertEquals(String.valueOf(x), 0, index);
        }
        {
            final int x = arr[n - 1];
            final int index = solver.findRecursive(x);
            Assert.assertEquals(String.valueOf(x), n - 1, index);
        }
        {
            final int x = arr[3];
            final int index = solver.findRecursive(x);
            Assert.assertEquals(String.valueOf(x), 3, index);
        }
        {
            final int x = 50;
            final int index = solver.findRecursive(x);
            Assert.assertEquals(String.valueOf(x), -1, index);
        }
        {
            final int x = 1;
            final int index = solver.findRecursive(x);
            Assert.assertEquals(String.valueOf(x), -1, index);
        }
    }

    @Test
    public void findFirstLastWithoutDuplicates() {
        final int[] arr = {2, 3, 4, 10, 40};
        final BinarySearch solver = new BinarySearch(arr);
        final int n = arr.length;
        System.out.print("Find first index in arr: ");
        CommonUtils.printArr(arr);
        {
            final int x = 4;
            final int find = solver.findRecursive(x);
            final int findFirst = solver.findFirstRecursive(x);
            final int findLast = solver.findLastRecursive(x);
            final int findIterative = solver.findIterative(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
            Assert.assertEquals(String.valueOf(x), find, findIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIterative);
            Assert.assertEquals(String.valueOf(x), find, findLastIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), find, findLastIndexApproach2);
        }
        {
            final int x = arr[0];
            final int find = solver.findRecursive(x);
            final int findFirst = solver.findFirstRecursive(x);
            final int findLast = solver.findLastRecursive(x);
            final int findIterative = solver.findIterative(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
            Assert.assertEquals(String.valueOf(x), find, findIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIterative);
            Assert.assertEquals(String.valueOf(x), find, findLastIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), find, findLastIndexApproach2);
        }
        {
            final int x = arr[n - 1];
            final int find = solver.findRecursive(x);
            final int findFirst = solver.findFirstRecursive(x);
            final int findLast = solver.findLastRecursive(x);
            final int findIterative = solver.findIterative(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
            Assert.assertEquals(String.valueOf(x), find, findIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIterative);
            Assert.assertEquals(String.valueOf(x), find, findLastIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), find, findLastIndexApproach2);
        }
        {
            final int x = arr[3];
            final int find = solver.findRecursive(x);
            final int findFirst = solver.findFirstRecursive(x);
            final int findLast = solver.findLastRecursive(x);
            final int findIterative = solver.findIterative(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
            Assert.assertEquals(String.valueOf(x), find, findIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIterative);
            Assert.assertEquals(String.valueOf(x), find, findLastIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), find, findLastIndexApproach2);
        }
        {
            final int x = 50;
            final int find = solver.findRecursive(x);
            final int findFirst = solver.findFirstRecursive(x);
            final int findLast = solver.findLastRecursive(x);
            final int findIterative = solver.findIterative(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
            Assert.assertEquals(String.valueOf(x), find, findIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIterative);
            Assert.assertEquals(String.valueOf(x), find, findLastIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), find, findLastIndexApproach2);
        }
        {
            final int x = 1;
            final int find = solver.findRecursive(x);
            final int findFirst = solver.findFirstRecursive(x);
            final int findLast = solver.findLastRecursive(x);
            final int findIterative = solver.findIterative(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
            Assert.assertEquals(String.valueOf(x), find, findIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIterative);
            Assert.assertEquals(String.valueOf(x), find, findLastIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), find, findLastIndexApproach2);
        }
    }

    @Test
    public void findFirstWithDuplicates() {
        final int[] arr = {1, 1, 2, 3, 3, 4, 10, 10, 10, 40, 50, 50, 60, 60, 70, 70, 70};
        final BinarySearch solver = new BinarySearch(arr);
        System.out.print("Find first index in arr: ");
        CommonUtils.printArr(arr);
        {
            final int x = 1;
            final int index = solver.findFirstRecursive(x);
            Assert.assertEquals(String.valueOf(x), 0, index);
        }
        {
            final int x = 2;
            final int index = solver.findFirstRecursive(x);
            Assert.assertEquals(String.valueOf(x), 2, index);
        }
        {
            final int x = 3;
            final int index = solver.findFirstRecursive(x);
            Assert.assertEquals(String.valueOf(x), 3, index);
        }
        {
            final int x = 4;
            final int index = solver.findFirstRecursive(x);
            Assert.assertEquals(String.valueOf(x), 5, index);
        }
        {
            final int x = 10;
            final int index = solver.findFirstRecursive(x);
            Assert.assertEquals(String.valueOf(x), 6, index);
        }
        {
            final int x = 40;
            final int index = solver.findFirstRecursive(x);
            Assert.assertEquals(String.valueOf(x), 9, index);
        }
        {
            final int x = 50;
            final int index = solver.findFirstRecursive(x);
            Assert.assertEquals(String.valueOf(x), 10, index);
        }
        {
            final int x = 60;
            final int index = solver.findFirstRecursive(x);
            Assert.assertEquals(String.valueOf(x), 12, index);
        }
        {
            final int x = 70;
            final int index = solver.findFirstRecursive(x);
            Assert.assertEquals(String.valueOf(x), 14, index);
        }
    }

    @Test
    public void findLastWithDuplicates() {
        final int[] arr = {1, 1, 2, 3, 3, 4, 10, 10, 10, 40, 50, 50, 60, 60, 70, 70, 70};
        final BinarySearch solver = new BinarySearch(arr);
        System.out.print("Find first index in arr: ");
        CommonUtils.printArr(arr);
        {
            final int x = 1;
            final int index = solver.findLastRecursive(x);
            Assert.assertEquals(String.valueOf(x), 1, index);
        }
        {
            final int x = 2;
            final int index = solver.findLastRecursive(x);
            Assert.assertEquals(String.valueOf(x), 2, index);
        }
        {
            final int x = 3;
            final int index = solver.findLastRecursive(x);
            Assert.assertEquals(String.valueOf(x), 4, index);
        }
        {
            final int x = 4;
            final int index = solver.findLastRecursive(x);
            Assert.assertEquals(String.valueOf(x), 5, index);
        }
        {
            final int x = 10;
            final int index = solver.findLastRecursive(x);
            Assert.assertEquals(String.valueOf(x), 8, index);
        }
        {
            final int x = 40;
            final int index = solver.findLastRecursive(x);
            Assert.assertEquals(String.valueOf(x), 9, index);
        }
        {
            final int x = 50;
            final int index = solver.findLastRecursive(x);
            Assert.assertEquals(String.valueOf(x), 11, index);
        }
        {
            final int x = 60;
            final int index = solver.findLastRecursive(x);
            Assert.assertEquals(String.valueOf(x), 13, index);
        }
        {
            final int x = 70;
            final int index = solver.findLastRecursive(x);
            Assert.assertEquals(String.valueOf(x), 16, index);
        }
    }

    @Test
    public void compareFindRecursiveAndIterative() {
        final int[] arr = {2, 3, 4, 10, 40};
        final BinarySearch solver = new BinarySearch(arr);
        final int n = arr.length;
        System.out.print("Find index in arr: ");
        CommonUtils.printArr(arr);
        {
            final int x = 4;
            final int findRecursive = solver.findRecursive(x);
            final int findIterative = solver.findIterative(x);
            Assert.assertEquals(String.valueOf(x), findRecursive, findIterative);
        }
        {
            final int x = arr[0];
            final int findRecursive = solver.findRecursive(x);
            final int findIterative = solver.findIterative(x);
            Assert.assertEquals(String.valueOf(x), findRecursive, findIterative);
        }
        {
            final int x = arr[n - 1];
            final int findRecursive = solver.findRecursive(x);
            final int findIterative = solver.findIterative(x);
            Assert.assertEquals(String.valueOf(x), findRecursive, findIterative);
        }
        {
            final int x = arr[3];
            final int findRecursive = solver.findRecursive(x);
            final int findIterative = solver.findIterative(x);
            Assert.assertEquals(String.valueOf(x), findRecursive, findIterative);
        }
        {
            final int x = 50;
            final int findRecursive = solver.findRecursive(x);
            final int findIterative = solver.findIterative(x);
            Assert.assertEquals(String.valueOf(x), findRecursive, findIterative);
        }
        {
            final int x = 1;
            final int findRecursive = solver.findRecursive(x);
            final int findIterative = solver.findIterative(x);
            Assert.assertEquals(String.valueOf(x), findRecursive, findIterative);
        }
    }

    @Test
    public void compareFindFirst() {
        final int[] arr = {1, 1, 2, 3, 3, 4, 10, 10, 10, 40, 50, 50, 60, 60, 70, 70, 70};
        final BinarySearch solver = new BinarySearch(arr);
        System.out.print("Find first index in arr: ");
        CommonUtils.printArr(arr);
        {
            final int x = 1;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 0, index);
        }
        {
            final int x = 2;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 2, index);
        }
        {
            final int x = 3;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 3, index);
        }
        {
            final int x = 4;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 5, index);
        }
        {
            final int x = 10;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 6, index);
        }
        {
            final int x = 40;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 9, index);
        }
        {
            final int x = 50;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 10, index);
        }
        {
            final int x = 60;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 12, index);
        }
        {
            final int x = 70;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findFirstIndexApproach2 = solver.findFirstIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, findFirstIndexApproach2);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 14, index);
        }
    }


    @Test
    public void compareFindLast() {
        final int[] arr = {1, 1, 2, 3, 3, 4, 10, 10, 10, 40, 50, 50, 60, 60, 70, 70, 70};
        final BinarySearch solver = new BinarySearch(arr);
        System.out.print("Find first index in arr: ");
        CommonUtils.printArr(arr);
        {
            final int x = 1;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), index, findLastIndexApproach2);
            System.out.println("Done with: " + x);
            Assert.assertEquals(String.valueOf(x), 1, index);
        }
        {
            final int x = 2;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), index, findLastIndexApproach2);
            System.out.println("Done with: " + x);
            Assert.assertEquals(String.valueOf(x), 2, index);
        }
        {
            final int x = 3;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), index, findLastIndexApproach2);
            System.out.println("Done with: " + x);
            Assert.assertEquals(String.valueOf(x), 4, index);
        }
        {
            final int x = 4;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), index, findLastIndexApproach2);
            System.out.println("Done with: " + x);
            Assert.assertEquals(String.valueOf(x), 5, index);
        }
        {
            final int x = 10;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), index, findLastIndexApproach2);
            System.out.println("Done with: " + x);
            Assert.assertEquals(String.valueOf(x), 8, index);
        }
        {
            final int x = 40;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), index, findLastIndexApproach2);
            System.out.println("Done with: " + x);
            Assert.assertEquals(String.valueOf(x), 9, index);
        }
        {
            final int x = 50;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), index, findLastIndexApproach2);
            System.out.println("Done with: " + x);
            Assert.assertEquals(String.valueOf(x), 11, index);
        }
        {
            final int x = 60;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), index, findLastIndexApproach2);
            System.out.println("Done with: " + x);
            Assert.assertEquals(String.valueOf(x), 13, index);
        }
        {
            final int x = 70;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            final int findLastIndexApproach2 = solver.findLastIndexApproach2(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), index, findLastIndexApproach2);
            System.out.println("Done with: " + x);
            Assert.assertEquals(String.valueOf(x), 16, index);
        }
    }

    @Test
    public void floorWithoutDuplicates() {
        final int[] arr = {2, 3, 4, 10, 40};
        final BinarySearch solver = new BinarySearch(arr);
        System.out.print("Find floor in arr: ");
        CommonUtils.printArr(arr);
        {
            final int x = 1;
            final int expected = Integer.MAX_VALUE;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 2;
            final int expected = 2;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 3;
            final int expected = 3;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 4;
            final int expected = 4;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 5;
            final int expected = 4;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 6;
            final int expected = 4;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 7;
            final int expected = 4;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 8;
            final int expected = 4;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 9;
            final int expected = 4;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 10;
            final int expected = 10;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 11;
            final int expected = 10;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 16;
            final int expected = 10;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 21;
            final int expected = 10;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 38;
            final int expected = 10;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 40;
            final int expected = 40;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
        {
            final int x = 45;
            final int expected = 40;
            final int floor = solver.floor(x);
            Assert.assertEquals(String.valueOf(x), expected, floor);
        }
    }

    @Test
    public void ceilingWithoutDuplicates() {
        final int[] arr = {2, 3, 4, 10, 40};
        final BinarySearch solver = new BinarySearch(arr);
        System.out.print("Find floor in arr: ");
        CommonUtils.printArr(arr);
        {
            final int x = 1;
            final int expected = 2;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 2;
            final int expected = 2;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 3;
            final int expected = 3;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 4;
            final int expected = 4;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 5;
            final int expected = 10;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 6;
            final int expected = 10;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 7;
            final int expected = 10;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 8;
            final int expected = 10;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 9;
            final int expected = 10;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 10;
            final int expected = 10;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 11;
            final int expected = 40;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 16;
            final int expected = 40;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 21;
            final int expected = 40;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 38;
            final int expected = 40;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 40;
            final int expected = 40;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
        {
            final int x = 45;
            final int expected = Integer.MIN_VALUE;
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expected, ceiling);
        }
    }

    @Test
    public void floorWithDuplicates() {
        final int[] arr = {1, 1, 2, 3, 3, 4, 10, 10, 10, 40, 50, 50, 60, 60, 70, 70, 70};
        final BinarySearch solver = new BinarySearch(arr);
        System.out.print("Find floor in arr: ");
        CommonUtils.printArr(arr);
        {
            final int x = 0;
            final int expectedFloor = Integer.MAX_VALUE;
            final int expectedCeiling = 1;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 1;
            final int expectedFloor = 1;
            final int expectedCeiling = 1;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 2;
            final int expectedFloor = 2;
            final int expectedCeiling = 2;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 3;
            final int expectedFloor = 3;
            final int expectedCeiling = 3;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 4;
            final int expectedFloor = 4;
            final int expectedCeiling = 4;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 5;
            final int expectedFloor = 4;
            final int expectedCeiling = 10;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 8;
            final int expectedFloor = 4;
            final int expectedCeiling = 10;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 10;
            final int expectedFloor = 10;
            final int expectedCeiling = 10;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 20;
            final int expectedFloor = 10;
            final int expectedCeiling = 40;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 33;
            final int expectedFloor = 10;
            final int expectedCeiling = 40;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 40;
            final int expectedFloor = 40;
            final int expectedCeiling = 40;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 44;
            final int expectedFloor = 40;
            final int expectedCeiling = 50;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 45;
            final int expectedFloor = 40;
            final int expectedCeiling = 50;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 49;
            final int expectedFloor = 40;
            final int expectedCeiling = 50;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 55;
            final int expectedFloor = 50;
            final int expectedCeiling = 60;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 60;
            final int expectedFloor = 60;
            final int expectedCeiling = 60;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 67;
            final int expectedFloor = 60;
            final int expectedCeiling = 70;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 70;
            final int expectedFloor = 70;
            final int expectedCeiling = 70;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
        {
            final int x = 78;
            final int expectedFloor = 70;
            final int expectedCeiling = Integer.MIN_VALUE;
            final int floor = solver.floor(x);
            final int ceiling = solver.ceiling(x);
            Assert.assertEquals(String.valueOf(x), expectedFloor, floor);
            Assert.assertEquals(String.valueOf(x), expectedCeiling, ceiling);
        }
    }

    @Test
    public void occurrences() {
        final int[] arr = {1, 1, 2, 3, 3, 4, 10, 10, 10, 40, 50, 50, 60, 60, 70, 70, 70};
        final BinarySearch solver = new BinarySearch(arr);
        System.out.print("Find occurrences in arr: ");
        {
            final int x = 0;
            final int expected = 0;
            final int actual = solver.occurrences(x);
            Assert.assertEquals(String.valueOf(x), expected, actual);
        }
        {
            final int x = 1;
            final int expected = 2;
            final int actual = solver.occurrences(x);
            Assert.assertEquals(String.valueOf(x), expected, actual);
        }
        {
            final int x = 2;
            final int expected = 1;
            final int actual = solver.occurrences(x);
            Assert.assertEquals(String.valueOf(x), expected, actual);
        }
        {
            final int x = 3;
            final int expected = 2;
            final int actual = solver.occurrences(x);
            Assert.assertEquals(String.valueOf(x), expected, actual);
        }
        {
            final int x = 4;
            final int expected = 1;
            final int actual = solver.occurrences(x);
            Assert.assertEquals(String.valueOf(x), expected, actual);
        }
        {
            final int x = 5;
            final int expected = 0;
            final int actual = solver.occurrences(x);
            Assert.assertEquals(String.valueOf(x), expected, actual);
        }
        {
            final int x = 10;
            final int expected = 3;
            final int actual = solver.occurrences(x);
            Assert.assertEquals(String.valueOf(x), expected, actual);
        }
        {
            final int x = 20;
            final int expected = 0;
            final int actual = solver.occurrences(x);
            Assert.assertEquals(String.valueOf(x), expected, actual);
        }
        {
            final int x = 35;
            final int expected = 0;
            final int actual = solver.occurrences(x);
            Assert.assertEquals(String.valueOf(x), expected, actual);
        }
        {
            final int x = 50;
            final int expected = 2;
            final int actual = solver.occurrences(x);
            Assert.assertEquals(String.valueOf(x), expected, actual);
        }
        {
            final int x = 60;
            final int expected = 2;
            final int actual = solver.occurrences(x);
            Assert.assertEquals(String.valueOf(x), expected, actual);
        }
        {
            final int x = 70;
            final int expected = 3;
            final int actual = solver.occurrences(x);
            Assert.assertEquals(String.valueOf(x), expected, actual);
        }
        {
            final int x = 74;
            final int expected = 0;
            final int actual = solver.occurrences(x);
            Assert.assertEquals(String.valueOf(x), expected, actual);
        }
    }


    @Test
    public void findFistLastBoundaryCases() {
        {
            final int iterations = randInt();
            for (int i = 0; i <= iterations; i++) {
                final int value = randInt();
                final int size = randInt();
                final int[] arr = new int[size];
                Arrays.fill(arr, value);
                final BinarySearch solver = new BinarySearch(arr);
                System.out.print("Find First and Last Index in arr: ");
                CommonUtils.printArr(arr);
                final int firstIterative = solver.findFirstIterative(value);
                final int lastIterative = solver.findLastIterative(value);
                Assert.assertEquals(0, firstIterative);
                Assert.assertEquals(size - 1, lastIterative);
            }
        }

        {
            final int iterations = randInt();
            for (int i = 0; i <= iterations; i++) {
                final int value1 = randInt();
                final int value2 = value1 + randInt();
                final int size = randInt();
                final int[] arr = new int[size];
                int mid = size / 2;
                for (int j = 0; j < mid; j++) {
                    arr[j] = value1;
                }
                for (int j = mid; j < size; j++) {
                    arr[j] = value2;
                }
                final BinarySearch solver = new BinarySearch(arr);
                System.out.print("Find First and Last Index in arr: ");
                CommonUtils.printArr(arr);
                final int firstIterativeValue1 = solver.findFirstIterative(value1);
                final int lastIterativeValue1 = solver.findLastIterative(value1);
                final int firstIterativeValue2 = solver.findFirstIterative(value2);
                final int lastIterativeValue2 = solver.findLastIterative(value2);
                Assert.assertEquals(String.format("First index of : %s", value1), 0, firstIterativeValue1);
                Assert.assertEquals(String.format("Last index of : %s", value1), mid - 1, lastIterativeValue1);
                Assert.assertEquals(String.format("First index of : %s", value2), mid, firstIterativeValue2);
                Assert.assertEquals(String.format("Last index of : %s", value2), size - 1, lastIterativeValue2);
            }
        }

    }

    private static int randInt() {
        return randInt(1000);
    }

    private static int randInt(final int n) {
        return (int) (Math.random() * n) + 5;
    }
}
