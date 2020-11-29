package com.avi.educative.tree.questions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 30/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ConstructTreeTest {

    @Test
    public void constructFromInorderAndPreorder() {
        final Integer[] inorder = {4, 2, 5, 1, 3, 6};
        final Integer[] preorder = {1, 2, 4, 5, 3, 6};
        final ConstructTree<Integer> solver = new ConstructTree<>(inorder, preorder);
        final Node<Integer> root = solver.constructFromInorderAndPreorder();
        final BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(root);
        System.out.println("Post Order");
        tree.postOrder();
    }
}