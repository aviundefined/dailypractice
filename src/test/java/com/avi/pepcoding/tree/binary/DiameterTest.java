package com.avi.pepcoding.tree.binary;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 13/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DiameterTest {

    @Test
    public void diameter() {
        final ConstructBinaryTree constructor = new ConstructBinaryTree();
        final Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        final Node root = constructor.construct(arr);
        System.out.println(new Diameter().diameter(root));
    }
}