package com.avi.pepcoding.tree.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 14/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintSingleChildParent {

    public List<Node> getPrintSingleChildParent(final Node root) {
        if (root == null) {
            return null;
        }

        final List<Node> nodes = new ArrayList<>();
        recurse(root, null, nodes);
        return nodes;
    }

    private void recurse(Node root, Node parent, List<Node> nodes) {
        if (root == null) {
            return;
        }

        if (parent != null && parent.getLeft() == root && parent.getRight() == null) {
            nodes.add(root);
        }
        if (parent != null && parent.getRight() == root && parent.getLeft() == null) {
            nodes.add(root);
        }
        recurse(root.getLeft(), root, nodes);
        recurse(root.getRight(), root, nodes);
    }
}
