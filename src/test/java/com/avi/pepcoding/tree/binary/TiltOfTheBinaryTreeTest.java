package com.avi.pepcoding.tree.binary;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 14/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TiltOfTheBinaryTreeTest {

    @Test
    public void tilt() {

        final ConstructBinaryTree constructor = new ConstructBinaryTree();
        final Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        final Node root = constructor.construct(arr);
        final TiltOfTheBinaryTree solver = new TiltOfTheBinaryTree();
        System.out.println(solver.tilt(root));
    }
}