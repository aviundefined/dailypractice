package com.avi.practice.company.google.iterators;

import java.util.Stack;

/**
 * Created by navinash on 01/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BSTIterator {

    private final Stack<Pair> st = new Stack<>();
    private TreeNode inOrder = null;

    public BSTIterator(TreeNode root) {
        st.push(new Pair(root));
        assignNext();
    }

    public int next() {
        if (!hasNext()) {
            return -1;
        }
        final int val = inOrder.val;
        assignNext();
        return val;
    }

    public boolean hasNext() {
        return inOrder != null;
    }

    private void assignNext() {
        inOrder = null;
        while (!st.isEmpty() && inOrder == null) {
            final Pair top = st.peek();
            if (top.state == 0) {
                if (top.node.left != null) {
                    st.push(new Pair(top.node.left));
                }
                top.state++;
            } else if (top.state == 1) {
                if (top.node.right != null) {
                    st.push(new Pair(top.node.right));
                }
                inOrder = top.node;
                top.state++;
            } else {
                st.pop();
            }
        }
    }

    private static final class Pair {
        private final TreeNode node;
        private int state = 0;

        private Pair(final TreeNode node) {
            this.node = node;
        }

        public String toString() {
            return "(" + node + ", state: " + state + ")";
        }
    }

    static final class TreeNode {
        private final int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
