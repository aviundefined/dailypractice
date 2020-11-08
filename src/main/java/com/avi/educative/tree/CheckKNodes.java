package com.avi.educative.tree;

/**
 * Created by navinash on 08/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CheckKNodes {

    public static String findKNodes(Node root, int k) {
        final StringBuilder sb = new StringBuilder();
        _findKNodes(root, k, 0, sb);
        return sb.toString();
    }

    private static void _findKNodes(Node root, int k, int level, StringBuilder sb) {
        if (root == null) {
            return;
        }

        if (k == level) {
            sb.append(root.getData()).append(",");
        }

        _findKNodes(root.getLeftChild(), k, level + 1, sb);
        _findKNodes(root.getRightChild(), k, level + 1, sb);
    }
}
