package com.avi.educative.tree.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by navinash on 01/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GenerateAllPossibleBinaryTree {

    public List<BinaryTree<Integer>> getAllTrees(final int[] inorder) {
        if (inorder == null || inorder.length == 0) {
            return Collections.emptyList();
        }
        if (inorder.length == 1) {
            return Collections.singletonList(binaryTree(new Node<>(inorder[0])));
        }

        final List<Node<Integer>> roots = _getTrees(inorder, 0, inorder.length - 1);
        return roots.stream().map(this::binaryTree).collect(Collectors.toList());
    }

    private List<Node<Integer>> _getTrees(int[] inorder, int start, int end) {
        final List<Node<Integer>> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            final List<Node<Integer>> leftNodes = _getTrees(inorder, start, i - 1);
            final List<Node<Integer>> rightNodes = _getTrees(inorder, i + 1, end);

            // Now for all combination of left and right nodes mark ith node as root
            for (Node<Integer> leftNode : leftNodes) {
                for (Node<Integer> rightNode : rightNodes) {
                    final Node<Integer> root = new Node<>(inorder[i]);
                    root.setLeft(leftNode);
                    root.setRight(rightNode);
                    trees.add(root);
                }
            }
        }
        return trees;
    }

    private BinaryTree<Integer> binaryTree(final Node<Integer> root) {
        final BinaryTree<Integer> bt = new BinaryTree<>();
        bt.setRoot(root);
        return bt;
    }
}
