package com.avi.practice.graph;

import com.avi.practice.graph.Graph.Vertex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by navinash on 27/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GraphUtils {
    public static boolean detectCycle(final Graph graph) {
        final Map<Vertex, Boolean> visited = new HashMap<>();
        final Map<Vertex, Boolean> currentStack = new HashMap<>();
        for (final Vertex v : graph.getAdjList().keySet()) {
            if (_detectCycle(v, visited, currentStack, graph)) {
                return true;
            }
        }
        return false;
    }

    private static boolean _detectCycle(
            final Vertex v,
            final Map<Vertex, Boolean> visited,
            final Map<Vertex, Boolean> stack,
            final Graph graph) {
        if (stack.containsKey(v) && stack.get(v)) {
            return true;
        }
        if (visited.containsKey(v) && visited.get(v)) {
            return false;
        }

        visited.put(v, true);
        stack.put(v, true);

        final List<Vertex> vertices = graph.getAdjList().get(v);
        if (vertices != null && vertices.size() != 0) {
            for (final Vertex neighbour : vertices) {
                if (_detectCycle(neighbour, visited, stack, graph)) {
                    return true;
                }
            }
        }
        stack.put(v, false);
        return false;
    }
}
