package com.avi.practice.graph.pepcoding;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 02/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BipartiteTest {
    private static final Bipartite solver = new Bipartite();

    @Test
    public void isBipartite1() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph1();
        final boolean expected = false;
        final boolean isBipartite = solver.isBipartite(graph);
        Assert.assertEquals(expected, isBipartite);
    }

    @Test
    public void isBipartite2() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph2();
        final boolean expected = false;
        final boolean isBipartite = solver.isBipartite(graph);
        Assert.assertEquals(expected, isBipartite);
    }


    @Test
    public void isBipartite3() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph3();
        final boolean expected = true;
        final boolean isBipartite = solver.isBipartite(graph);
        Assert.assertEquals(expected, isBipartite);
    }

    @Test
    public void isBipartite4() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph4();
        final boolean expected = true;
        final boolean isBipartite = solver.isBipartite(graph);
        Assert.assertEquals(expected, isBipartite);
    }
}