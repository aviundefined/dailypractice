package com.avi.pepcoding.tree.binary;

/**
 * Created by navinash on 14/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ISBinarySearchTree {

    public boolean isBST(final Node root) {
        if (root == null) {
            return true;
        }
        return recurse(root).isBst;
    }

    private Tuple recurse(Node root) {
        if (root == null) {
            return new Tuple(true, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        final Tuple left = recurse(root.getLeft());
        final Tuple right = recurse(root.getRight());

        final boolean isBst = root.getValue() >= left.max
                && root.getValue() <= right.min
                && left.isBst
                && right.isBst;

        final int min = Math.min(left.min, right.min);
        final int max = Math.max(left.max, right.max);

        return new Tuple(isBst, min, max);
    }

    private static final class Tuple {
        private final boolean isBst;
        private final int min;
        private final int max;


        private Tuple(boolean isBst, int min, int max) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
        }
    }
}
