package com.avi.pepcoding.tree.binary;

/**
 * Created by navinash on 14/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class IsBalancedTree {

    public boolean isBalanced(final Node root) {
        if (root == null) {
            return true;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return true;
        }

        return recurse(root).isBalanced;
    }

    private Pair recurse(final Node root) {
        if (root == null) {
            return new Pair(true, 0);
        }
        final Pair left = recurse(root.getLeft());
        final Pair right = recurse(root.getRight());
        final boolean isBalanced = Math.abs(left.height - right.height) <= 1
                && left.isBalanced
                && right.isBalanced;
        final int height = 1 + Math.max(left.height, right.height);

        return new Pair(isBalanced, height);
    }

    private static final class Pair {
        private final boolean isBalanced;
        private final int height;

        private Pair(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
