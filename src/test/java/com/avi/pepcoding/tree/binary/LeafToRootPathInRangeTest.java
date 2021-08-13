package com.avi.pepcoding.tree.binary;

import org.junit.Test;

import java.util.List;

/**
 * Created by navinash on 13/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LeafToRootPathInRangeTest {

    @Test
    public void rootToNode() {

        final ConstructBinaryTree constructor = new ConstructBinaryTree();
        final Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, 40,null, null, 75, 62, 60, null, null, 70, null, null, 87, null, null};
        final Node root = constructor.construct(arr);
        final LeafToRootPathInRange solver = new LeafToRootPathInRange();
        final List<List<Integer>> paths = solver.rootToNode(root, 150, 250);
        for (final List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}