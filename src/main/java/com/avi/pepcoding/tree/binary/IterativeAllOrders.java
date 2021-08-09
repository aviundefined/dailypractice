package com.avi.pepcoding.tree.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by navinash on 09/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class IterativeAllOrders {

    public void allOrders(final Node root) {
        if (root == null) {
            return;
        }
        final Stack<State> st = new Stack<>();
        st.push(new State(root, 1));
        final List<Integer> pre = new ArrayList<>();
        final List<Integer> in = new ArrayList<>();
        final List<Integer> post = new ArrayList<>();
        while (!st.empty()) {
            final State top = st.peek();
            if (top.state == 1) {
                pre.add(top.node.getValue());
                top.state++;
                if (top.node.getLeft() != null) {
                    st.push(new State(top.node.getLeft(), 1));
                }
            } else if (top.state == 2) {
                in.add(top.node.getValue());
                top.state++;
                if (top.node.getRight() != null) {
                    st.push(new State(top.node.getRight(), 1));
                }
            } else {
                post.add(top.node.getValue());
                st.pop();
            }
        }

        System.out.println("Pre-order: " + pre);
        System.out.println("In-order: " + in);
        System.out.println("Post-order: " + post);
    }

    private static final class State {
        private final Node node;
        private int state;

        private State(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
}
