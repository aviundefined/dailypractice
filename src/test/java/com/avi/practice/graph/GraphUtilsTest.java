package com.avi.practice.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 27/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GraphUtilsTest {

    private static Graph generateTestGraphDirectedCyclic1() {
        final Graph graph = new GraphDirected(4);
        graph.addEdge(new Graph.Vertex("0"), new Graph.Vertex("1"));
        graph.addEdge(new Graph.Vertex("1"), new Graph.Vertex("2"));
        graph.addEdge(new Graph.Vertex("1"), new Graph.Vertex("3"));
        graph.addEdge(new Graph.Vertex("3"), new Graph.Vertex("0"));
        return graph;
    }

    private static Graph generateTestGraphDirectedCyclic2() {
        final Graph graph = new GraphDirected(4);
        graph.addEdge(new Graph.Vertex("0"), new Graph.Vertex("1"));
        graph.addEdge(new Graph.Vertex("1"), new Graph.Vertex("2"));
        graph.addEdge(new Graph.Vertex("1"), new Graph.Vertex("3"));
        graph.addEdge(new Graph.Vertex("3"), new Graph.Vertex("0"));
        return graph;
    }

    private static Graph generateTestGraphDirectedAcyclic1() {
        final Graph graph = new GraphDirected(3);
        graph.addEdge(new Graph.Vertex("0"), new Graph.Vertex("1"));
        graph.addEdge(new Graph.Vertex("1"), new Graph.Vertex("2"));
        return graph;
    }

    private static Graph generateTestGraphDirectedAcyclic2() {
        final Graph graph = new GraphDirected(4);
        graph.addEdge(new Graph.Vertex("0"), new Graph.Vertex("1"));
        graph.addEdge(new Graph.Vertex("1"), new Graph.Vertex("2"));
        graph.addEdge(new Graph.Vertex("3"), new Graph.Vertex("0"));
        graph.addEdge(new Graph.Vertex("3"), new Graph.Vertex("1"));
        return graph;
    }

    @Test
    public void detectCycle() {
        {
            final Graph graph = generateTestGraphDirectedCyclic1();
            System.out.println(GraphUtils.detectCycle(graph));
        }
        {
            final Graph graph = generateTestGraphDirectedCyclic2();
            System.out.println(GraphUtils.detectCycle(graph));
        }


        {
            final Graph graph = generateTestGraphDirectedAcyclic2();
            System.out.println(GraphUtils.detectCycle(graph));
        }

        {
            final Graph graph = generateTestGraphDirectedAcyclic1();
            System.out.println(GraphUtils.detectCycle(graph));
        }
    }

    @Test
    public void findMotherVertx() {
        {
            final Graph graph = generateTestGraphDirectedAcyclic1();
            final Graph.Vertex motherVertx = GraphUtils.findMotherVertx(graph);
            Assert.assertNotNull(motherVertx);
            Assert.assertEquals("0", motherVertx.getId());
        }

        {
            final Graph graph = generateTestGraphDirectedAcyclic2();
            final Graph.Vertex motherVertx = GraphUtils.findMotherVertx(graph);
            Assert.assertNotNull(motherVertx);
            Assert.assertEquals("3", motherVertx.getId());
        }

    }

}