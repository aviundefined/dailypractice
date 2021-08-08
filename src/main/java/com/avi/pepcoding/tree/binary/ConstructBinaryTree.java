package com.avi.pepcoding.tree.binary;

import java.util.Stack;

/**
 * Created by navinash on 07/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ConstructBinaryTree {

    public Node construct(final Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        final Stack<Pair> s = new Stack<>();
        final Node root = new Node(arr[0]);
        s.push(new Pair(root, 1));
        int idx = 1;
        while (!s.isEmpty()) {
            final Pair top = s.peek();
            if (top.state == 1) {
                if (arr[idx] != null) {
                    final Node left = new Node(arr[idx]);
                    top.node.setLeft(left);
                    s.push(new Pair(left, 1));
                }
                top.state++;
                idx++;
            } else if (top.state == 2) {
                if (arr[idx] != null) {
                    final Node right = new Node(arr[idx]);
                    top.node.setRight(right);
                    s.push(new Pair(right, 1));
                }
                top.state++;
                idx++;
            } else {
                s.pop();
            }
        }
        return root;
    }

    private static final class Pair {
        private final Node node;
        private int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
}
