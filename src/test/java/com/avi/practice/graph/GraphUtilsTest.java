package com.avi.practice.graph;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 27/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GraphUtilsTest {

    private static Graph generateTestGraphDirectedCyclic() {
        final Graph graph = new GraphDirected(4);
        graph.addEdge(new Graph.Vertex("0"), new Graph.Vertex("1"));
        graph.addEdge(new Graph.Vertex("1"), new Graph.Vertex("2"));
        graph.addEdge(new Graph.Vertex("1"), new Graph.Vertex("3"));
        graph.addEdge(new Graph.Vertex("3"), new Graph.Vertex("0"));
        return graph;
    }

    private static Graph generateTestGraphDirectedAcyclic() {
        final Graph graph = new GraphDirected(3);
        graph.addEdge(new Graph.Vertex("0"), new Graph.Vertex("1"));
        graph.addEdge(new Graph.Vertex("1"), new Graph.Vertex("2"));
        return graph;
    }

    @Test
    public void detectCycle() {
        {
            final Graph graph = generateTestGraphDirectedCyclic();
            System.out.println(GraphUtils.detectCycle(graph));
        }

        {
            final Graph graph = generateTestGraphDirectedAcyclic();
            System.out.println(GraphUtils.detectCycle(graph));
        }
    }

}