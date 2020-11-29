package com.avi.educative.tree.questions;

/**
 * Created by navinash on 26/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class Node<T> {
    private final T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
