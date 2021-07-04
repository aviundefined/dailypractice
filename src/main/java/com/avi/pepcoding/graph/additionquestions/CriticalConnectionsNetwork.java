package com.avi.pepcoding.graph.additionquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by navinash on 04/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CriticalConnectionsNetwork {

    Integer counter = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if (n == 0) {
            return Collections.emptyList();
        }
        final Graph graph = new Graph();
        for (final List<Integer> connection : connections) {
            graph.addEdge(connection.get(0), connection.get(1));
        }

        final Set<List<Integer>> result = new HashSet<>();
        final Map<Integer, Integer> nodeIds = new HashMap<>();
        for (int i = 0; i < n; i++) {
            dfs(i, -1, graph, nodeIds, result);
        }
        return new ArrayList<>(result);
    }

    private int dfs(int node, int from, Graph graph, Map<Integer, Integer> nodeIds, Set<List<Integer>> result) {
        if (nodeIds.containsKey(node)) {
            return nodeIds.get(node);
        }
        nodeIds.put(node, counter);
        counter++;
        final int currentValue = nodeIds.get(node);
        int min = Integer.MAX_VALUE;
        for (final int neighbour : graph.getNeighbours(node)) {
            if (from == neighbour) {
                continue;
            }
            final int neighbourValue = dfs(neighbour, node, graph, nodeIds, result);
            min = Math.min(neighbourValue, min);
        }
        if (currentValue > min) {
            nodeIds.put(node, min);
        }
        if (from != -1 && currentValue < min) {
            result.add(Arrays.asList(from, node));
        }
        return Math.min(currentValue, min);
    }

    public List<List<Integer>> criticalConnectionsBruteForce(int n, List<List<Integer>> connections) {
        if (n == 0) {
            return Collections.emptyList();
        }
        final Graph graph = new Graph();
        for (final List<Integer> connection : connections) {
            graph.addEdge(connection.get(0), connection.get(1));
        }

        final Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            final Set<Integer> neighbours = graph.getNeighbours(i);
            final Set<Integer> visited = new HashSet<>();
            for (final int neighbour : neighbours) {
                graph.removeEdge(i, neighbour);
                dfsBruteForce(i, graph, visited);
                graph.addEdge(i, neighbour);
                if (visited.size() < n) {
                    if (i > neighbour) {
                        result.add(Arrays.asList(neighbour, i));
                    } else {
                        result.add(Arrays.asList(i, neighbour));
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void dfsBruteForce(int node, Graph graph, Set<Integer> visited) {
        visited.add(node);
        for (final int neighbour : graph.getNeighbours(node)) {
            if (visited.contains(neighbour)) {
                continue;
            }
            dfsBruteForce(neighbour, graph, visited);
        }
    }


    private static final class Graph {
        private final Map<Integer, Set<Integer>> adjList = new HashMap<>();

        private void addEdge(final int src, final int dst) {
            this.adjList.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
            this.adjList.computeIfAbsent(dst, k -> new HashSet<>()).add(src);
        }

        private void removeEdge(final int src, final int dst) {
            this.adjList.getOrDefault(src, new HashSet<>()).remove(dst);
            this.adjList.getOrDefault(dst, new HashSet<>()).remove(src);
        }

        private Set<Integer> getNeighbours(final int src) {
            return new HashSet<>(this.adjList.getOrDefault(src, new HashSet<>()));
        }
    }

}
