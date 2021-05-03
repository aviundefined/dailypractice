package com.avi.practice.graph.pepcoding;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by navinash on 03/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TopologicalSortTest {

    private static final TopologicalSort solver = new TopologicalSort();

    @Test
    public void topologicalSort1() {
        /*
         *
         *   1 -----> 3 ----> 5
         *   |        |      |  \
         *   |        |      |   \
         *   v        v      v    v
         *   2 -----> 4      6---->7
         */
        final Graph graph = GraphTestUtils.getTestDirectedGraph1();
        final List<Integer> topologicalSort = solver.topologicalSort(graph);
        System.out.println(topologicalSort);
        System.out.println("----------------");
    }

    @Test
    public void topologicalSort2() {
        /*
         *
         *   1        3       5
         *   |        |      |  \
         *   |        |      |   \
         *   v        v      v    v
         *   2        4      6---->7
         */
        final Graph graph = GraphTestUtils.getTestDirectedGraph2();
        final List<Integer> topologicalSort = solver.topologicalSort(graph);
        System.out.println(topologicalSort);
        System.out.println("----------------");
    }

    @Test
    public void topologicalSort3() {
        /*
         *
         *   1 -----> 3 <---- 5
         *   |        |      |  \
         *   |        |      |   \
         *   v        v      v    v
         *   2 -----> 4      6---->7
         */
        final Graph graph = GraphTestUtils.getTestDirectedGraph3();
        final List<Integer> topologicalSort = solver.topologicalSort(graph);
        System.out.println(topologicalSort);
        System.out.println("----------------");
    }

    @Test
    public void topologicalSort4() {
        /*
         *
         *   0 -----> 3 ------> 4
         *   |        ^       |  \
         *   |        |       |   \
         *   v        |       v    v
         *   1 -----> 2       5---->6
         */
        final Graph graph = GraphTestUtils.getTestDirectedGraph4();
        final List<Integer> topologicalSort = solver.topologicalSort(graph);
        System.out.println(topologicalSort);
        System.out.println("----------------");
    }
}