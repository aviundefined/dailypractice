package com.avi.practice.graph.pepcoding;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 02/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CyclicGraphTest {
    private final static CyclicGraph solver = new CyclicGraph();

    @Test
    public void isCyclic1() {
        final Graph graph = GraphTestUtils.getTestDirectedGraph1();
        final boolean expected = true;
        final boolean cyclic = solver.isCyclic(graph);
        Assert.assertEquals(expected, cyclic);
    }

    @Test
    public void isCyclic2() {
        final Graph graph = GraphTestUtils.getTestDirectedGraph2();
        final boolean expected = false;
        final boolean cyclic = solver.isCyclic(graph);
        Assert.assertEquals(expected, cyclic);
    }

    @Test
    public void isCyclic3() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph1();
        final boolean expected = true;
        final boolean cyclic = solver.isCyclic(graph);
        Assert.assertEquals(expected, cyclic);
    }

    @Test
    public void isCyclic4() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph2();
        final boolean expected = true;
        final boolean cyclic = solver.isCyclic(graph);
        Assert.assertEquals(expected, cyclic);
    }
}