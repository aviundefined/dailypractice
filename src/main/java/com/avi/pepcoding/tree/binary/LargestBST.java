package com.avi.pepcoding.tree.binary;

/**
 * Created by navinash on 14/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LargestBST {


    public int largestBST(final Node root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }

        return recurse(root).size;

    }

    private Tuple recurse(Node root) {
        if (root == null) {
            return new Tuple(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, null);
        }

        final Tuple left = recurse(root.getLeft());
        final Tuple right = recurse(root.getRight());

        final boolean isBst = left.isBST && right.isBST && (root.getValue() >= left.max && root.getValue() <= right.min);
        final int min = Math.min(root.getValue(), Math.min(left.min, right.min));
        final int max = Math.max(root.getValue(), Math.max(left.max, right.max));
        final Tuple tuple;
        if (isBst) {
            tuple = new Tuple(isBst, min, max, left.size + right.size + 1, root);
        } else if (left.size > right.size) {
            tuple = new Tuple(isBst, min, max, left.size, left.root);
        } else {
            tuple = new Tuple(isBst, min, max, right.size, right.root);
        }
        return tuple;
    }

    private static final class Tuple {
        private final boolean isBST;
        private final int min;
        private final int max;
        private final int size;
        private final Node root;


        private Tuple(boolean isBST, int min, int max, int size, final Node root) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.size = size;
            this.root = root;
        }
    }
}
