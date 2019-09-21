package com.avi.topics.searching;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

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
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
            Assert.assertEquals(String.valueOf(x), find, findIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIterative);
            Assert.assertEquals(String.valueOf(x), find, findLastIterative);
        }
        {
            final int x = arr[0];
            final int find = solver.findRecursive(x);
            final int findFirst = solver.findFirstRecursive(x);
            final int findLast = solver.findLastRecursive(x);
            final int findIterative = solver.findIterative(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findLastIterative = solver.findLastIterative(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
            Assert.assertEquals(String.valueOf(x), find, findIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIterative);
            Assert.assertEquals(String.valueOf(x), find, findLastIterative);
        }
        {
            final int x = arr[n - 1];
            final int find = solver.findRecursive(x);
            final int findFirst = solver.findFirstRecursive(x);
            final int findLast = solver.findLastRecursive(x);
            final int findIterative = solver.findIterative(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findLastIterative = solver.findLastIterative(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
            Assert.assertEquals(String.valueOf(x), find, findIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIterative);
            Assert.assertEquals(String.valueOf(x), find, findLastIterative);
        }
        {
            final int x = arr[3];
            final int find = solver.findRecursive(x);
            final int findFirst = solver.findFirstRecursive(x);
            final int findLast = solver.findLastRecursive(x);
            final int findIterative = solver.findIterative(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findLastIterative = solver.findLastIterative(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
            Assert.assertEquals(String.valueOf(x), find, findIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIterative);
            Assert.assertEquals(String.valueOf(x), find, findLastIterative);
        }
        {
            final int x = 50;
            final int find = solver.findRecursive(x);
            final int findFirst = solver.findFirstRecursive(x);
            final int findLast = solver.findLastRecursive(x);
            final int findIterative = solver.findIterative(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findLastIterative = solver.findLastIterative(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
            Assert.assertEquals(String.valueOf(x), find, findIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIterative);
            Assert.assertEquals(String.valueOf(x), find, findLastIterative);
        }
        {
            final int x = 1;
            final int find = solver.findRecursive(x);
            final int findFirst = solver.findFirstRecursive(x);
            final int findLast = solver.findLastRecursive(x);
            final int findIterative = solver.findIterative(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            final int findLastIterative = solver.findLastIterative(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
            Assert.assertEquals(String.valueOf(x), find, findIterative);
            Assert.assertEquals(String.valueOf(x), find, findFirstIterative);
            Assert.assertEquals(String.valueOf(x), find, findLastIterative);
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
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 0, index);
        }
        {
            final int x = 2;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 2, index);
        }
        {
            final int x = 3;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 3, index);
        }
        {
            final int x = 4;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 5, index);
        }
        {
            final int x = 10;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 6, index);
        }
        {
            final int x = 40;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 9, index);
        }
        {
            final int x = 50;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 10, index);
        }
        {
            final int x = 60;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
            Assert.assertEquals(String.valueOf(x), findFirstIterative, index);
            Assert.assertEquals(String.valueOf(x), 12, index);
        }
        {
            final int x = 70;
            final int index = solver.findFirstRecursive(x);
            final int findFirstIterative = solver.findFirstIterative(x);
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
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), 1, index);
        }
        {
            final int x = 2;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), 2, index);
        }
        {
            final int x = 3;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), 4, index);
        }
        {
            final int x = 4;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), 5, index);
        }
        {
            final int x = 10;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), 8, index);
        }
        {
            final int x = 40;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), 9, index);
        }
        {
            final int x = 50;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), 11, index);
        }
        {
            final int x = 60;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), 13, index);
        }
        {
            final int x = 70;
            final int index = solver.findLastRecursive(x);
            final int findLastIterative = solver.findLastIterative(x);
            Assert.assertEquals(String.valueOf(x), index, findLastIterative);
            Assert.assertEquals(String.valueOf(x), 16, index);
        }
    }
}
