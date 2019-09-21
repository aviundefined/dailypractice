package com.avi.topics.searching;

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
}
