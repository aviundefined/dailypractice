package com.avi.educative.tree.segment_tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 01/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CountNumberOfHeadsTest {

    @Test
    public void test() {
        //                0   1  2  3   4  5  6  7  8
        final int[] arr = {0, 1, 1, 0, 0, 1, 1, 0, 0};
        final CountNumberOfHeads solver= new CountNumberOfHeads(arr);
    }
}