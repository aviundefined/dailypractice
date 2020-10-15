package com.avi.educative.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 15/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RearrangeArrayTest {

    private final RearrangeArray tool = new RearrangeArray();

    @Test
    public void maxMinAlternativeSortedArray() {
        {
            final int[] arr = {1, 2, 3, 4, 5};
            final int[] expected = {5, 1, 4, 2, 3};
            tool.maxMinAlternativeSortedArray(arr);
            Assert.assertArrayEquals(expected, arr);
        }
        {
            final int[] arr = {1, 2, 3, 4, 5, 6};
            final int[] expected = {6, 1, 5, 2, 4, 3};
            tool.maxMinAlternativeSortedArray(arr);
            Assert.assertArrayEquals(expected, arr);
        }
        {
            final int[] arr = {1, 2, 3, 4, 5, 6, 7};
            final int[] expected = {7, 1, 6, 2, 5, 3, 4};
            tool.maxMinAlternativeSortedArray(arr);
            Assert.assertArrayEquals(expected, arr);
        }
    }
}