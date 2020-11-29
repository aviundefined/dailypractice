package com.avi.educative.tree.questions;

import com.avi.educative.tree.Node;

/**
 * Created by navinash on 26/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MirrorCheck {

    public boolean isMirror(final Node root) {
        if (root == null) {
            return true;
        }

        return _isMirror(root, root);
    }

    private boolean _isMirror(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.getData() == node2.getData()
                && _isMirror(node1.getLeftChild(), node2.getRightChild())
                && _isMirror(node1.getRightChild(), node2.getLeftChild());
    }
}
