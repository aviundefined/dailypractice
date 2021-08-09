package com.avi.pepcoding.tree.binary;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 09/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class IterativeAllOrdersTest {

    @Test
    public void allOrders() {
        final ConstructBinaryTree solver = new ConstructBinaryTree();
        final Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70 , null, null, 87, null, null};
        final Node root = solver.construct(arr);
        final IterativeAllOrders allOrders = new IterativeAllOrders();
        allOrders.allOrders(root);
    }
}