package com.avi.practice.tree.pepcoding;

import com.avi.practice.tree.model.GenericNode;
import org.junit.Test;

/**
 * Created by navinash on 15/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GenericTreeProblemsTest {
    private static final GenericTreeProblems solver = new GenericTreeProblems();

    @Test
    public void construct() {
        final int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        final GenericNode root = solver.construct(arr);
        solver.display(root);
        System.out.println("Size: " + solver.sizeIterative(root));
        System.out.println("Size: " + solver.sizeRecursive(root));
        System.out.println("Max: "+solver.max(root));
        System.out.println("Max: "+solver.height(root));

        System.out.println("--- Pre order ----");
        solver.preOrder(root);

        System.out.println("--- Post order ----");
        solver.postOrder(root);

        System.out.println("--- Level order ----");
        solver.levelOrder(root);

        System.out.println("--- Level Order With Levels ----");
        solver.levelOrderWithLevels(root);

        System.out.println("--- Level Order ZigZag ----");
        solver.levelOrderZigZag(root);

        System.out.println("--- Level Order With Two Queue ----");
        solver.levelOrderWithLevelsTwoQueue(root);

        System.out.println("--- Level Order ZigZag With Two Stack ----");
        solver.levelOrderZigZagTwoStack(root);
    }
}