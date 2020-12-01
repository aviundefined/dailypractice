package com.avi.educative.tree.questions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 01/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ConstructBinarySearchTreeTest {

    @Test
    public void construct() {

        final int[] preorder = {10, 5, 1, 7, 40, 50};
        final ConstructBinarySearchTree solver = new ConstructBinarySearchTree(preorder);
        final Node<Integer> node = solver.construct();
        final BinaryTree<Integer> bst = new BinaryTree<>();
        bst.setRoot(node);
        bst.preOrder();
    }
}