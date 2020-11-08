package com.avi.educative.tree;

/**
 * Created by navinash on 07/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Node {

    private int data;
    private Node leftChild;
    private Node rightChild;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node left) {
        this.leftChild = left;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node right) {
        this.rightChild = right;
    }
}
