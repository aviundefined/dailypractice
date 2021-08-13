package com.avi.pepcoding.tree.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 13/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NodeToRootPath {

    public List<Node> path(final Node root, final int node) {
        return _path(root, node);
    }

    private List<Node> _path(Node root, int node) {

        if (root == null) {
            return new ArrayList<>();
        }

        if (root.getValue() == node) {
            final List<Node> curr = new ArrayList<>();
            curr.add(root);
            return curr;
        }

        final List<Node> left = _path(root.getLeft(), node);
        if (left.size() > 0) {
           left.add(root);
           return left;
        }

        final List<Node> right = _path(root.getRight(), node);
        if (right.size() > 0) {
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    }
}
