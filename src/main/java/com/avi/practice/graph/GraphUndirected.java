package com.avi.practice.graph;

import java.util.LinkedList;

/**
 * Created by navinash on 27/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GraphUndirected extends Graph {

    public GraphUndirected(int numVertices) {
        super(numVertices);
    }

    public void addEdge(final Vertex src, final Vertex dst) {
        this.adjList.computeIfAbsent(src, k -> new LinkedList<>()).add(dst);
        this.adjList.computeIfAbsent(dst, k -> new LinkedList<>()).add(src);
    }
}
