package com.avi.practice.graph.pepcoding;

import com.avi.pepcoding.graph.BFS;
import com.avi.pepcoding.graph.Graph;
import com.avi.pepcoding.graph.Kruskal;
import com.avi.pepcoding.graph.Kruskal.Result;
import org.junit.Test;

/**
 * Created by navinash on 04/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class KruskalTest {

    private static final Kruskal solver = new Kruskal();
    private static final BFS bfs = new BFS();

    @Test
    public void minimumSpanningTree1() {

        /*      40       2
         *   1 ------ 3 ----- 5
         *   |        |      |  \
         * 10|     10 |     3|   \ 8
         *   |        |      | 3  \
         *   2 ------ 4      6---- 7
         *       10
         */
        final Graph graph = GraphTestUtils.getTestUndirectedWeightedGraph1();
        final Result result = solver.minimumSpanningTree(graph);

        System.out.println("Weight: " + result.getWeight());
        bfs.bfs(result.getMst(), graph.getAllNodes().iterator().next());
    }

    @Test
    public void minimumSpanningTree2() {

        /*
         *        5
         *   1 ------- 2
         *   |        /|
         *   |       / |
         *   |      /  |
         * 4 |   2 /   | 3
         *   |    /    |
         *   |   /     |
         *   |  /      |
         *   | /       |
         *   3 ------- 4
         *       6
         */
        final Graph graph = GraphTestUtils.getTestUndirectedWeightedGraph2();
        final Result result = solver.minimumSpanningTree(graph);

        System.out.println("Weight: " + result.getWeight());
        bfs.bfs(result.getMst(), graph.getAllNodes().iterator().next());
    }

    @Test
    public void minimumSpanningTree3() {
        final Graph graph = GraphTestUtils.getTestUndirectedWeightedGraph3();
        final Result result = solver.minimumSpanningTree(graph);

        System.out.println("Weight: " + result.getWeight());
        bfs.bfs(result.getMst(), graph.getAllNodes().iterator().next());
    }
}