package com.avi.practice.company.microsoft.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by navinash on 27/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SerializeDeserializeNAryTree {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "-1";
        }

        return recurse(root);
    }

    private String recurse(final Node root) {

        String s = String.valueOf(root.val);
        if(root.children != null && root.children.size() > 0) {
            for(final Node child : root.children) {
                if(child != null) {
                    s = s + "," + recurse(child);
                }
            }
        }
        return s + "," + "-1";

    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.equals("-1")) {
            return null;
        }
        final String[] nodes = data.split(",");
        final Stack<Node> st = new Stack<>();
        final Node root = new Node(Integer.parseInt(nodes[0]), new ArrayList<>());
        st.push(root);

        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i].equals("")) {
                continue;
            }
            if (nodes[i].equals("-1")) {
                st.pop();
            } else {
                final Node node = new Node(Integer.parseInt(nodes[i]), new ArrayList<>());
                if (!st.isEmpty()) {
                    st.peek().children.add(node);
                }
                st.push(node);
            }
        }
        return root;
    }

    static final class Node {
        private final int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
        }

        Node(int val, final List<Node> children) {
            this.val = val;
            this.children = children;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            if (val != node.val) {
                return false;
            }
            if ((this.children == null || this.children.size() == 0) && (node.children == null || node.children.size() == 0)) {
                return true;
            }

            if ((this.children == null || this.children.size() == 0) || (node.children == null || node.children.size() == 0)) {
                return false;
            }
            if (this.children.size() != node.children.size()) {
                return false;
            }
            for (int i = 0; i < this.children.size(); i++) {
                final Node child1 = this.children.get(i);
                final Node child2 = node.children.get(i);
                if (!child1.equals(child2)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, children);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", children=" + children +
                    '}';
        }
    }
}
