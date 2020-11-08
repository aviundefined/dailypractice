package com.avi.educative.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 08/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CheckAncestors {

    public static String findAncestors(Node root, int k) {
        final List<Integer> ancestors = new ArrayList<>();
        _findAncestors(root, k, ancestors);
        StringBuilder s = new StringBuilder();
        for (final int ancestor : ancestors) {
            s.append(ancestor).append(",");
        }
        return s.toString();
    }

    private static void _findAncestors(Node root, int k, List<Integer> ancestors) {
        if (root == null || root.getData() == k) {
            return;
        }
        ancestors.add(root.getData());
        if (k < root.getData()) {
            _findAncestors(root.getLeftChild(), k, ancestors);
        } else {
            _findAncestors(root.getRightChild(), k, ancestors);
        }
    }
}
