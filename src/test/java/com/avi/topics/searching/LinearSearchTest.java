package com.avi.topics.searching;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 21/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LinearSearchTest {

    @Test
    public void findFirstIndex() {
        final int[] arr = {10, 20, 80, 30, 60, 50, 30, 110, 100, 20, 130, 130, 170};
        final LinearSearch solver = new LinearSearch(arr);
        {
            final int x = 60;
            final int firstIndex = solver.findFirstIndex(x);
            Assert.assertEquals(String.valueOf(x), 4, firstIndex);
        }
        {
            final int x = 20;
            final int firstIndex = solver.findFirstIndex(x);
            Assert.assertEquals(String.valueOf(x), 1, firstIndex);
        }
        {
            final int x = 30;
            final int firstIndex = solver.findFirstIndex(x);
            Assert.assertEquals(String.valueOf(x), 3, firstIndex);
        }
        {
            final int x = 110;
            final int firstIndex = solver.findFirstIndex(x);
            Assert.assertEquals(String.valueOf(x), 7, firstIndex);
        }
        {
            final int x = 100;
            final int firstIndex = solver.findFirstIndex(x);
            Assert.assertEquals(String.valueOf(x), 8, firstIndex);
        }
        {
            final int x = 130;
            final int firstIndex = solver.findFirstIndex(x);
            Assert.assertEquals(String.valueOf(x), 10, firstIndex);
        }
    }

    @Test
    public void findLastIndex() {
        final int[] arr = {10, 20, 80, 30, 60, 50, 30, 110, 100, 20, 130, 130, 170};
        final LinearSearch solver = new LinearSearch(arr);
        {
            final int x = 60;
            final int laIndexIndex = solver.findLastIndex(x);
            Assert.assertEquals(String.valueOf(x), 4, laIndexIndex);
        }
        {
            final int x = 20;
            final int firstIndex = solver.findLastIndex(x);
            Assert.assertEquals(String.valueOf(x), 9, firstIndex);
        }
        {
            final int x = 30;
            final int firstIndex = solver.findLastIndex(x);
            Assert.assertEquals(String.valueOf(x), 6, firstIndex);
        }
        {
            final int x = 110;
            final int firstIndex = solver.findLastIndex(x);
            Assert.assertEquals(String.valueOf(x), 7, firstIndex);
        }
        {
            final int x = 100;
            final int firstIndex = solver.findLastIndex(x);
            Assert.assertEquals(String.valueOf(x), 8, firstIndex);
        }
        {
            final int x = 130;
            final int firstIndex = solver.findLastIndex(x);
            Assert.assertEquals(String.valueOf(x), 11, firstIndex);
        }
    }
}