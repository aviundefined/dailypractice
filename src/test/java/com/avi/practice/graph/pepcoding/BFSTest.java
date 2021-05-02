package com.avi.practice.graph.pepcoding;

import org.junit.Test;

/**
 * Created by navinash on 01/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BFSTest {

    private static final BFS solver = new BFS();
    @Test
    public void bfs1() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph1();
        for(final int node : graph.getAllNodes()) {
            System.out.println("BFS from node: "+node);
            solver.bfs(graph, node);
            System.out.println("-----------");
        }
    }

    @Test
    public void bfs2() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph2();
        for(final int node : graph.getAllNodes()) {
            System.out.println("BFS from node: "+node);
            solver.bfs(graph, node);
            System.out.println("-----------");
        }
    }
}