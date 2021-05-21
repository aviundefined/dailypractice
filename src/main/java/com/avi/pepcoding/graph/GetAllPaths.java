package com.avi.pepcoding.graph;

import com.avi.pepcoding.graph.Graph.Edge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by navinash on 01/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GetAllPaths {

    public List<List<Integer>> allPaths(final Graph graph, final int src, final int dst) {

        final List<List<Integer>> paths = new ArrayList<>();

        final Set<Integer> visited = new HashSet<>();
        final List<Integer> pathSoFar = new ArrayList<>();
        pathSoFar.add(src);
        helper(graph, src, dst, pathSoFar, visited, paths);
        return paths;
    }

    private void helper(Graph graph, int src, int dst, List<Integer> pathSoFar, Set<Integer> visited, List<List<Integer>> paths) {
        if (src == dst) {
            paths.add(new ArrayList<>(pathSoFar));
            return;
        }
        visited.add(src);
        final List<Edge> edges = graph.getEdges(src);
        for (final Edge edge : edges) {
            if (!visited.contains(edge.getDst())) {
                pathSoFar.add(edge.getDst());
                helper(graph, edge.getDst(), dst, pathSoFar, visited, paths);
                pathSoFar.remove(pathSoFar.size() - 1);
            }
        }
        visited.remove(src);
    }
}
