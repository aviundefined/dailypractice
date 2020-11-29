package com.avi.educative.tree.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by navinash on 26/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BinaryTree<T> {

    protected Node<T> root;

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
        System.out.println();
    }

    public final void inOrderIterative() {
        if (root == null) {
            return;
        }

        Node<T> current = root;
        final Stack<Node<T>> s = new Stack<>();
        while (current != null || !s.isEmpty()) {
            while (current != null) {
                s.push(current);
                current = current.getLeft();
            }
            // At this point current is null
            current = s.pop();
            System.out.print(current.getData() + " ");
            current = current.getRight();
        }
        System.out.println();
    }

    public final void preOrder() {
        final List<Node<T>> preOrder = new ArrayList<>();
        _preOrder(root, preOrder);
        for (final Node<T> n : preOrder) {
            System.out.print(n.getData() + " ");
        }
        System.out.println();
    }

    public final void postOrder() {
        final List<Node<T>> postOrder = new ArrayList<>();
        _postOrder(root, postOrder);
        for (final Node<T> n : postOrder) {
            System.out.print(n.getData() + " ");
        }
        System.out.println();
    }

    private void _postOrder(Node<T> root, List<Node<T>> postOrder) {
        if (root == null) {
            return;
        }
        _postOrder(root.getLeft(), postOrder);
        _postOrder(root.getRight(), postOrder);
        postOrder.add(root);
    }

    private void _preOrder(final Node<T> root, final List<Node<T>> preOrder) {
        if (root == null) {
            return;
        }
        preOrder.add(root);
        _preOrder(root.getLeft(), preOrder);
        _preOrder(root.getRight(), preOrder);
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
