package com.avi.pepcoding.tree.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 13/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintKDistanceFar {

    public List<Node> getKDistanceFar(final Node root, final int node, final int k) {
        if (root == null || k < 0) {
            return Collections.emptyList();
        }

        final List<Node> path = nodeToRootPath(root, node);
        if (path.size() <= 0) {
            return Collections.emptyList();
        }

        final List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            final List<Node> curr = printKLevelDown(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
            if (curr.size() > 0) {
                nodes.addAll(curr);
            }
        }
        return nodes;
    }

    private List<Node> printKLevelDown(final Node root, final int k, final Node blocker) {
        if (root == null || k < 0 ||  root == blocker) {
            return Collections.emptyList();
        }
        if (k == 0) {
            final List<Node> nodes = new ArrayList<>();
            nodes.add(root);
            return nodes;
        }
        final List<Node> nodes = new ArrayList<>();
        final List<Node> left = printKLevelDown(root.getLeft(), k - 1, blocker);
        if (left.size() > 0) {
            nodes.addAll(left);
        }
        final List<Node> right = printKLevelDown(root.getRight(), k - 1, blocker);
        if (right.size() > 0) {
            nodes.addAll(right);
        }
        return nodes;
    }

    private List<Node> nodeToRootPath(final Node root, final int node) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.getValue() == node) {
            final List<Node> curr = new ArrayList<>();
            curr.add(root);
            return curr;
        }

        final List<Node> left = nodeToRootPath(root.getLeft(), node);
        if (left.size() > 0) {
            left.add(root);
            return left;
        }

        final List<Node> right = nodeToRootPath(root.getRight(), node);
        if (right.size() > 0) {
            right.add(root);
            return right;
        }

        return new ArrayList<>();
    }
}
