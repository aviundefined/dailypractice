package com.avi.pepcoding.tree.binary;

/**
 * Created by navinash on 07/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Node {

    private final int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void preorder() {
        final Node node = this;
        _preorder(node);
    }


    public void inorder() {
        final Node node = this;
        _inorder(node);
    }

    private void _preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        _preorder(node.left);
        _preorder(node.right);
    }

    private void _inorder(Node node) {
        if (node == null) {
            return;
        }
        _inorder(node.left);
        System.out.println(node.value);
        _inorder(node.right);
    }
}
