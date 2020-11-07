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
                final Node left = current.getLeft();
                if (left == null) {
                    current.setLeft(new Node(value));
                    return true;
                }
                current = left;
            } else {
                final Node right = current.getRight();
                if (right == null) {
                    current.setRight(new Node(value));
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
                current = current.getLeft();
            } else {
                current = current.getRight();
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
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        if (current == null) {
            return false;
        }
        // leaft
        if (current.getLeft() == null && current.getRight() == null) {
            // leaf and root
            if (current.getData() == root.getData()) {
                root = null;
            } else if (current.getData() < parent.getData()) {
                parent.setLeft(null);
            } else if (current.getData() > parent.getData()) {
                parent.setRight(null);
            }
        } else if (current.getLeft() == null) { // single child - only right
            if (current.getData() == root.getData()) {
                root = current.getRight();
            } else if (current.getData() < parent.getData()) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        } else if (current.getRight() == null) { // single child - only left
            if (current.getData() == root.getData()) {
                root = current.getLeft();
            } else if (current.getData() < parent.getData()) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else {
            final Node min = findMinimum(current.getRight());
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
            if (current.getLeft() != null) {
                min = current.getLeft();
            }
            current = node.getLeft();
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
        printTree(current.getLeft());
        printTree(current.getRight());
    }
}
