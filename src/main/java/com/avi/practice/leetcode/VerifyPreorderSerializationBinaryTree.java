package com.avi.practice.leetcode;

import java.util.Stack;

/**
 * Created by navinash on 26/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class VerifyPreorderSerializationBinaryTree {

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }

        if (preorder.equals("#")) {
            return true;
        }

        final Stack<State> st = new Stack<>();
        final String[] nodes = preorder.split(",");
        if(nodes.length > 1 && nodes[0].equals("#")) {
            return false;
        }
        st.push(new State(nodes[0], 1));
        int i = 1;
        while (!st.isEmpty()) {
            final State top = st.peek();
            if (top.state == 1) {
                // preorder
                top.state++;
                if (i >= nodes.length) {
                    return false;
                }
                if (!nodes[i].equals("#")) {
                    st.push(new State(nodes[i], 1));
                }
                i++;
            } else if (top.state == 2) {
                // inorder
                top.state++;
                if (i >= nodes.length) {
                    return false;
                }
                if (!nodes[i].equals("#")) {
                    st.push(new State(nodes[i], 1));
                }
                i++;
            } else {
                // post order
                st.pop();
            }
        }


        return i == nodes.length;
    }

    private static final class State {
        private final String val;
        private int state;

        private State(String val, int state) {
            this.val = val;
            this.state = state;
        }
    }
}
