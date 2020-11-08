package com.avi.educative.tree;

/**
 * Created by navinash on 07/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BinarySearchTree {

    private Node root;

    public boolean insert(final int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }

        Node current = root;
        while (current != null) {
            // Value is less then current node so should be inserted in left
            if (value < current.getData()) {
                final Node left = current.getLeftChild();
                if (left == null) {
                    current.setLeftChild(new Node(value));
                    return true;
                }
                current = left;
            } else {
                final Node right = current.getRightChild();
                if (right == null) {
                    current.setRightChild(new Node(value));
                    return true;
                }
                current = right;
            }
        }
        return false;
    }

    public Node search(final int value) {
        if (root == null) {
            return null;
        }
        Node current = root;
        while (current != null) {
            if (current.getData() == value) {
                return current;
            }
            if (value < current.getData()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return null;
    }

    public boolean delete(final int value) {
        if (root == null) {
            return false;
        }

        Node current = root;
        Node parent = null;
        while (current != null) {
            if (current.getData() == value) {
                break;
            }
            parent = current;
            if (value < current.getData()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        if (current == null) {
            return false;
        }
        // leaft
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            // leaf and root
            if (current.getData() == root.getData()) {
                root = null;
            } else if (current.getData() < parent.getData()) {
                parent.setLeftChild(null);
            } else if (current.getData() > parent.getData()) {
                parent.setRightChild(null);
            }
        } else if (current.getLeftChild() == null) { // single child - only right
            if (current.getData() == root.getData()) {
                root = current.getRightChild();
            } else if (current.getData() < parent.getData()) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else if (current.getRightChild() == null) { // single child - only left
            if (current.getData() == root.getData()) {
                root = current.getLeftChild();
            } else if (current.getData() < parent.getData()) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else {
            final Node min = findMinimum(current.getRightChild());
            final int newValue = min.getData();
            delete(newValue);
            current.setData(newValue);
        }
        return true;
    }

    private Node findMinimum(final Node node) {
        if (node == null) {
            return null;
        }
        Node min = node;
        Node current = node;
        while (current != null) {
            if (current.getLeftChild() != null) {
                min = current.getLeftChild();
            }
            current = node.getLeftChild();
        }
        return min;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //Just for Testing purpose
    public void printTree(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());
    }
}
