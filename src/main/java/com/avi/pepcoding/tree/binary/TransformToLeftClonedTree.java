package com.avi.pepcoding.tree.binary;

/**
 * Created by navinash on 13/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TransformToLeftClonedTree {

    public Node transformToLeftClonedTree(final Node root) {
        if (root == null) {
            return null;
        }
        return _transformToLeftClonedTree(root);
    }
    public Node normalize(final Node root) {
        if(root == null) {
            return null;
        }

        return _normalize(root);
    }

    private Node _normalize(Node root) {
        if(root == null) {
            return null;
        }

        final Node leftNormalize = _normalize(root.getLeft().getLeft());
        final Node rightNormalize = _normalize(root.getRight());
        root.setLeft(leftNormalize);
        root.setRight(rightNormalize);
        return root;
    }

    private Node _transformToLeftClonedTree(Node root) {
        if (root == null) {
            return null;
        }
        final Node leftTransformedRoot = _transformToLeftClonedTree(root.getLeft());
        final Node rightTransformedRoot = _transformToLeftClonedTree(root.getRight());
        final Node newNode = new Node(root.getValue());
        newNode.setLeft(leftTransformedRoot);
        root.setLeft(newNode);
        root.setRight(rightTransformedRoot);
        return root;
    }

}
