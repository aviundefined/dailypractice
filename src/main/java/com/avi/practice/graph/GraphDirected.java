package com.avi.practice.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by navinash on 27/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GraphDirected extends Graph {

    public GraphDirected(int numVertices) {
        super(numVertices);
    }

    public void addEdge(final Vertex src, final Vertex dst) {
        this.adjList.computeIfAbsent(src, k -> new LinkedList<>()).add(dst);
    }

    public int numEdges() {
        int numEdges = 0;
        for (final List<Vertex> vertices : adjList.values()) {
            numEdges =+ vertices.size();
        }
        return numEdges;
    }

    @Override
    public Graph newInstance(int size) {
        return new GraphDirected(size);
    }
}
