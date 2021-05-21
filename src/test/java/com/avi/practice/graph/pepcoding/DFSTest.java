package com.avi.practice.graph.pepcoding;

import com.avi.pepcoding.graph.DFS;
import com.avi.pepcoding.graph.Graph;
import org.junit.Test;

/**
 * Created by navinash on 04/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DFSTest {

    private static final DFS solver = new DFS();
    @Test
    public void dfs1() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph1();
        for(final int node : graph.getAllNodes()) {
            System.out.println("DFS from node: "+node);
            solver.dfs(graph, node);
            System.out.println("-----------");
        }
    }

    @Test
    public void dfs2() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph2();
        for(final int node : graph.getAllNodes()) {
            System.out.println("DFS from node: "+node);
            solver.dfs(graph, node);
            System.out.println("-----------");
        }
    }
}