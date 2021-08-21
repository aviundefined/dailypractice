package com.avi.pepcoding.tree.binary;

/**
 * Created by navinash on 14/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TiltOfTheBinaryTree {

    private int tilt = 0;

    public int tilt(final Node root) {
        if (root == null) {
            return 0;
        }

        recurse(root);
        return tilt;
    }

    private int recurse(Node root) {
        if (root == null) {
            return 0;
        }

        final int leftSum = recurse(root.getLeft());
        final int rightSum = recurse(root.getRight());

        tilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.getValue();
    }
}
