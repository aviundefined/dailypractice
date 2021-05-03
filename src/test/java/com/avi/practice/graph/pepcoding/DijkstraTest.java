package com.avi.practice.graph.pepcoding;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 03/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DijkstraTest {
    private static final Dijkstra solver = new Dijkstra();
    @Test
    public void shortestPath1() {

        /*      40       2
         *   1 ------ 3 ----- 5
         *   |        |      |  \
         * 10|     10 |     3|   \ 8
         *   |        |      | 3  \
         *   2 ------ 4      6---- 7
         *       10
         */
        final Graph graph = GraphTestUtils.getTestUndirectedWeightedGraph1();
        solver.shortestPath(graph, 1);
    }
}