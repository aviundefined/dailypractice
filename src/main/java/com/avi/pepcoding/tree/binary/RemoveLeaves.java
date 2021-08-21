package com.avi.pepcoding.tree.binary;

/**
 * Created by navinash on 14/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RemoveLeaves {

    public Node remove(final Node root) {
        if (root == null) {
            return root;
        }

        return recurse(root);
    }

    private Node recurse(Node root) {
        if (root == null) {
            return null;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return null;
        }

        root.setLeft(recurse(root.getLeft()));
        root.setRight(recurse(root.getRight()));
        return root;
    }
}
