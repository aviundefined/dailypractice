package com.avi.educative.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 11/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FenwickTreeTest {

    @Test
    public void basic() {
        final int[] arr = {3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};
        final FenwickTree tree = new FenwickTree(arr);
        for (int i = 0; i < arr.length; i++) {
            final int actual = tree.sum(i);
            System.out.printf("Sum till [%d] index: %d\n", i, actual);
        }
    }
}