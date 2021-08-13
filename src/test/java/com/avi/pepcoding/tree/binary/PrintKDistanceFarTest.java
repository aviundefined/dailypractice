package com.avi.pepcoding.tree.binary;

import org.junit.Test;

import java.util.List;

/**
 * Created by navinash on 13/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintKDistanceFarTest {

    @Test
    public void getKDistanceFar() {
        final ConstructBinaryTree constructor = new ConstructBinaryTree();
        final Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, 40,null, null, 75, 62, 60, null, null, 70, null, null, 87, null, null};
        final Node root = constructor.construct(arr);
        final PrintKDistanceFar solver = new PrintKDistanceFar();
        final List<Node> nodes = solver.getKDistanceFar(root, 25, 2);
        for (final Node node : nodes) {
            System.out.println(node.getValue());
        }
    }
}