package com.avi.educative.tree.questions;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by navinash on 01/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GenerateAllPossibleBinaryTreeTest {
    private static final GenerateAllPossibleBinaryTree solver = new GenerateAllPossibleBinaryTree();

    @Test
    public void getAllTrees() {
        final int[] inorder = {4, 5, 7};
        final List<BinaryTree<Integer>> allTrees = solver.getAllTrees(inorder);
        System.out.println(Arrays.toString(inorder));
        for (final BinaryTree<Integer> tree : allTrees) {
            tree.preOrder();
        }
    }
}