package com.avi.practice.graph.pepcoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by navinash on 03/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TopologicalSort {

    public List<Integer> topologicalSort(final Graph graph) {
        if (graph == null) {
            return Collections.emptyList();
        }

        final Set<Integer> visited = new HashSet<>();
        final Stack<Integer> s = new Stack<>();
        for (final int node : graph.getAllNodes()) {
            if (!visited.contains(node)) {
                helper(graph, node, s, visited);
            }
        }

        final List<Integer> sorted = new ArrayList<>();
        while (!s.isEmpty()) {
            sorted.add(s.pop());
        }
        return sorted;
    }

    private void helper(Graph graph, int node, Stack<Integer> s, Set<Integer> visited) {
        visited.add(node);
        for (final Graph.Edge e : graph.getEdges(node)) {
            if (!visited.contains(e.getDst())) {
                helper(graph, e.getDst(), s, visited);
            }
        }
        s.push(node);
    }
}
