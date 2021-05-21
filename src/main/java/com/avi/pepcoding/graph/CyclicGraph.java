package com.avi.pepcoding.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by navinash on 02/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CyclicGraph {

    public final boolean isCyclic(final Graph graph) {
        if (graph == null) {
            return false;
        }

        final Set<Integer> visited = new HashSet<>();
        for (final int node : graph.getAllNodes()) {
            if (visited.contains(node)) {
                continue;
            }
            final boolean cyclic = isCyclic(graph, node, visited);
            if (cyclic) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclic(Graph graph, int node, Set<Integer> visited) {
        final Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            // remove mark* work add*
            final int poll = q.poll();
            if (visited.contains(poll)) {
                return true;
            }
            visited.add(poll);
            for (final Graph.Edge edge : graph.getEdges(poll)) {
                if (!visited.contains(edge.getDst())) {
                    q.add(edge.getDst());
                }
            }
        }
        return false;
    }
}
