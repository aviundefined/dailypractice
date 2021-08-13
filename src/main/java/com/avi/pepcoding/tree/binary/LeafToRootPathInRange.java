package com.avi.pepcoding.tree.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 13/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LeafToRootPathInRange {

    public List<List<Integer>> rootToNode(final Node root, final int low, final int high) {
        if (root == null) {
            return Collections.emptyList();
        }

        final List<List<Integer>> result = new ArrayList<>();

        recurse(root, new ArrayList<>(), 0, low, high, result);
        return result;
    }

    private void recurse(Node root, List<Integer> current, int sum, int low, int high, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            // leaf
            final int total = sum + root.getValue();
            if (total >= low && total <= high) {
                final List<Integer> currResult = new ArrayList<>(current);
                currResult.add(root.getValue());
                result.add(currResult);
            }
            return;
        }

        current.add(root.getValue());
        recurse(root.getLeft(), current, sum + root.getValue(), low, high, result);
        current.remove(current.size() - 1);

        current.add(root.getValue());
        recurse(root.getRight(), current, sum + root.getValue(), low, high, result);
        current.remove(current.size() - 1);

    }
}
