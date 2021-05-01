package com.avi.practice.graph.pepcoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by navinash on 01/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ConnectedComponents {

    public List<List<Integer>> connectedComponents(final Graph graph) {
        if (graph == null) {
            return Collections.emptyList();
        }

        final List<List<Integer>> connectedComponents = new ArrayList<>();
        final Set<Integer> visited = new HashSet<>();
        for (final int node : graph.getAllNodes()) {
            if (!visited.contains(node)) {
                final List<Integer> component = new ArrayList<>();
                helper(graph, node, visited, component);
                connectedComponents.add(component);
            }
        }
        return connectedComponents;
    }

    private void helper(
            final Graph graph,
            final int node,
            final Set<Integer> visited,
            final List<Integer> component) {
        visited.add(node);
        component.add(node);
        for (final Graph.Edge edge : graph.getEdges(node)) {
            final int nextNode = edge.getDst();
            if (!visited.contains(nextNode)) {
                helper(graph, nextNode, visited, component);
            }
        }
    }
}
