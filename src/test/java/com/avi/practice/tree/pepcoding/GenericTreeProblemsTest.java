package com.avi.practice.tree.pepcoding;

import com.avi.practice.tree.model.GenericNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 15/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GenericTreeProblemsTest {
    private static final GenericTreeProblems solver = new GenericTreeProblems();

    @Test
    public void construct() {
        final GenericNode root = getTree();
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

        System.out.println("--- Mirror ---");
        solver.mirror(root);
        solver.display(root);


        System.out.println("--- Mirror ---");
        solver.mirror(root);
        solver.display(root);

        {
            final GenericNode tree = getTree();
            System.out.println(" --- Remove Tree ---");
            solver.removeLeaves(tree);
            solver.display(tree);
        }

        {
            final GenericNode tree = getTree();
            System.out.println(" --- Tree ---");
            solver.display(tree);
            System.out.println(" --- Linearize Tree ---");
            solver.linearize(tree);
            solver.display(tree);
        }
    }

    @Test
    public void test() {
        final List<Integer> list  = new ArrayList<>();
        final boolean add = list.add(1);
    }

    private GenericNode getTree() {
        final int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        return solver.construct(arr);
    }
}