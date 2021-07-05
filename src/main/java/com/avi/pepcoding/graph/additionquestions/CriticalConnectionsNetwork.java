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
        // Create a graph from connections
        final Graph graph = new Graph();
        for (final List<Integer> connection : connections) {
            graph.addEdge(connection.get(0), connection.get(1));
        }

        final Set<List<Integer>> result = new HashSet<>(); // result to store data
        final int[] discovery = new int[n]; // array to store discovery time
        final int[] low = new int[n]; // array to store low time
        Arrays.fill(discovery, -1); // fill both with -1
        Arrays.fill(low, -1);
        dfs(0, -1, graph, discovery, low, result); // start dfs
        return new ArrayList<>(result);
    }

    private int dfs(int current, int parent, Graph graph, int[] discovery, int[] low, Set<List<Integer>> result) {
        // initial put the counter value for both discovery and low time and increase the counter
        discovery[current] = counter;
        low[current] = counter;
        counter++;
        for (final int neighbour : graph.getNeighbours(current)) {
            if (neighbour == parent) {
                continue; // skip parent edge
            }
            if (discovery[neighbour] != -1) { // back edge found
                // back edge found and back edge can't critical edge
                low[current] = Math.min(low[current], discovery[neighbour]);
                continue;
            }
            // get the low value for neighbour and update current value is it's greater than the neighbours low value
            final int neighbourLowValue = dfs(neighbour, current, graph, discovery, low, result);
            low[current] = Math.min(neighbourLowValue, low[current]);
            // if neighbour's low value > discover time of current then it's a critical edge
            if (neighbourLowValue > discovery[current]) {
                result.add(Arrays.asList(current, neighbour));
            }
        }
        // return low value of the current node
        return low[current];
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
