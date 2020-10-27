package com.avi.practice.graph;

import com.avi.practice.graph.Graph.Vertex;
import org.junit.Test;

/**
 * Created by navinash on 27/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GraphTest {

    private static Graph generateTestGraphUndirected1() {
        final Graph graph = new GraphUndirected(5);
        graph.addEdge(new Vertex("0"), new Vertex("1"));
        graph.addEdge(new Vertex("0"), new Vertex("2"));
        graph.addEdge(new Vertex("1"), new Vertex("3"));
        graph.addEdge(new Vertex("1"), new Vertex("4"));
        return graph;
    }

    private static Graph generateTestGraphUndirected2() {
        final Graph graph = new GraphUndirected(5);
        graph.addEdge(new Vertex("0"), new Vertex("1"));
        graph.addEdge(new Vertex("0"), new Vertex("4"));
        graph.addEdge(new Vertex("1"), new Vertex("2"));
        graph.addEdge(new Vertex("4"), new Vertex("3"));
        return graph;
    }

    private static Graph generateTestGraphDirected1() {
        final Graph graph = new GraphDirected(5);
        graph.addEdge(new Vertex("0"), new Vertex("1"));
        graph.addEdge(new Vertex("0"), new Vertex("2"));
        graph.addEdge(new Vertex("1"), new Vertex("3"));
        graph.addEdge(new Vertex("1"), new Vertex("4"));
        return graph;
    }

    private static Graph generateTestGraphDirected2() {
        final Graph graph = new GraphDirected(5);
        graph.addEdge(new Vertex("0"), new Vertex("1"));
        graph.addEdge(new Vertex("0"), new Vertex("4"));
        graph.addEdge(new Vertex("1"), new Vertex("2"));
        graph.addEdge(new Vertex("4"), new Vertex("3"));
        return graph;
    }

    @Test
    public void bfs() {
        {
            final Graph graph = generateTestGraphUndirected1();
            graph.bfs();
            System.out.println("-------------");
        }
        {
            final Graph graph = generateTestGraphUndirected2();
            graph.bfs();
            System.out.println("-------------");
        }
        {
            final Graph graph = generateTestGraphDirected1();
            graph.bfs();
            System.out.println("-------------");
        }
        {
            final Graph graph = generateTestGraphDirected2();
            graph.bfs();
            System.out.println("-------------");
        }
    }

    @Test
    public void dfs() {
        {
            final Graph graph = generateTestGraphUndirected1();
            graph.dfs();
            System.out.println("-------------");
        }
        {
            final Graph graph = generateTestGraphUndirected2();
            graph.dfs();
            System.out.println("-------------");
        }
        {
            final Graph graph = generateTestGraphDirected1();
            graph.dfs();
            System.out.println("-------------");
        }
        {
            final Graph graph = generateTestGraphDirected2();
            graph.dfs();
            System.out.println("-------------");
        }
    }
}