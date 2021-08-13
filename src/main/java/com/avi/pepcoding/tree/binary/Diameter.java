package com.avi.pepcoding.tree.binary;

/**
 * Created by navinash on 13/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Diameter {

    public int diameter(final Node root) {
        if (root == null) {
            return 0;
        }
        return recurse(root).diameter;
    }

    private DiameterHeight recurse(Node root) {
        if (root == null) {
            return new DiameterHeight(0, -1);
        }

        final DiameterHeight leftDH = recurse(root.getLeft());
        final DiameterHeight rightDH = recurse(root.getRight());
        final int dia = Math.max(leftDH.height + rightDH.height + 2, Math.max(leftDH.diameter, rightDH.diameter));
        final int h = Math.max(leftDH.height, rightDH.height) + 1;
        final DiameterHeight curr = new DiameterHeight(dia, h);
        return curr;
    }

    private static final class DiameterHeight {
        private final int diameter;
        private final int height;


        private DiameterHeight(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
}
