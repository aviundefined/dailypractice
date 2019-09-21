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
            final int index = solver.find(x);
            Assert.assertEquals(String.valueOf(x), 2, index);
        }
        {
            final int x = arr[0];
            final int index = solver.find(x);
            Assert.assertEquals(String.valueOf(x), 0, index);
        }
        {
            final int x = arr[n - 1];
            final int index = solver.find(x);
            Assert.assertEquals(String.valueOf(x), n - 1, index);
        }
        {
            final int x = arr[3];
            final int index = solver.find(x);
            Assert.assertEquals(String.valueOf(x), 3, index);
        }
        {
            final int x = 50;
            final int index = solver.find(x);
            Assert.assertEquals(String.valueOf(x), -1, index);
        }
        {
            final int x = 1;
            final int index = solver.find(x);
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
            final int find = solver.find(x);
            final int findFirst = solver.findFirst(x);
            final int findLast = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
        }
        {
            final int x = arr[0];
            final int find = solver.find(x);
            final int findFirst = solver.findFirst(x);
            final int findLast = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
        }
        {
            final int x = arr[n - 1];
            final int find = solver.find(x);
            final int findFirst = solver.findFirst(x);
            final int findLast = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
        }
        {
            final int x = arr[3];
            final int find = solver.find(x);
            final int findFirst = solver.findFirst(x);
            final int findLast = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
        }
        {
            final int x = 50;
            final int find = solver.find(x);
            final int findFirst = solver.findFirst(x);
            final int findLast = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
        }
        {
            final int x = 1;
            final int find = solver.find(x);
            final int findFirst = solver.findFirst(x);
            final int findLast = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), find, findFirst);
            Assert.assertEquals(String.valueOf(x), findLast, findFirst);
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
            final int index = solver.findFirst(x);
            Assert.assertEquals(String.valueOf(x), 0, index);
        }
        {
            final int x = 2;
            final int findFirst = solver.findFirst(x);
            Assert.assertEquals(String.valueOf(x), 2, findFirst);
        }
        {
            final int x = 3;
            final int index = solver.findFirst(x);
            Assert.assertEquals(String.valueOf(x), 3, index);
        }
        {
            final int x = 4;
            final int index = solver.findFirst(x);
            Assert.assertEquals(String.valueOf(x), 5, index);
        }
        {
            final int x = 10;
            final int index = solver.findFirst(x);
            Assert.assertEquals(String.valueOf(x), 6, index);
        }
        {
            final int x = 40;
            final int index = solver.findFirst(x);
            Assert.assertEquals(String.valueOf(x), 9, index);
        }
        {
            final int x = 50;
            final int index = solver.findFirst(x);
            Assert.assertEquals(String.valueOf(x), 10, index);
        }
        {
            final int x = 60;
            final int index = solver.findFirst(x);
            Assert.assertEquals(String.valueOf(x), 12, index);
        }
        {
            final int x = 70;
            final int index = solver.findFirst(x);
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
            final int index = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), 1, index);
        }
        {
            final int x = 2;
            final int findFirst = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), 2, findFirst);
        }
        {
            final int x = 3;
            final int index = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), 4, index);
        }
        {
            final int x = 4;
            final int index = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), 5, index);
        }
        {
            final int x = 10;
            final int index = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), 8, index);
        }
        {
            final int x = 40;
            final int index = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), 9, index);
        }
        {
            final int x = 50;
            final int index = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), 11, index);
        }
        {
            final int x = 60;
            final int index = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), 13, index);
        }
        {
            final int x = 70;
            final int index = solver.findLast(x);
            Assert.assertEquals(String.valueOf(x), 16, index);
        }
    }
}
