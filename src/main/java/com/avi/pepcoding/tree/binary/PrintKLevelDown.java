package com.avi.pepcoding.tree.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 13/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintKLevelDown {

    public List<Node> getKLevelDown(final Node root, final int k) {
        if (root == null || k < 0) {
            return Collections.emptyList();
        }

        return recurse(root, k);
    }

    private List<Node> recurse(Node root, int k) {
        if (root == null || k < 0) {
            return Collections.emptyList();
        }
        if (k == 0) {
            final List<Node> nodes = new ArrayList<>();
            nodes.add(root);
            return nodes;
        }
        final List<Node> nodes = new ArrayList<>();
        final List<Node> left = recurse(root.getLeft(), k - 1);
        if (left.size() > 0) {
            nodes.addAll(left);
        }
        final List<Node> right = recurse(root.getRight(), k - 1);
        if (right.size() > 0) {
            nodes.addAll(right);
        }
        return nodes;

    }
}
