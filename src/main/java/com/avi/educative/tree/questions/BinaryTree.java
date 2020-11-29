package com.avi.educative.tree.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 26/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BinaryTree<T> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public final void inOrder() {
        final List<Node<T>> inorder = new ArrayList<>();
        _inOrder(root, inorder);
        for (final Node<T> n : inorder) {
            System.out.print(n.getData() + " ");
        }
    }

    private void _inOrder(final Node<T> node, final List<Node<T>> inorder) {
        if (node == null) {
            return;
        }
        _inOrder(node.getLeft(), inorder);
        inorder.add(node);
        _inOrder(node.getRight(), inorder);
    }
}
