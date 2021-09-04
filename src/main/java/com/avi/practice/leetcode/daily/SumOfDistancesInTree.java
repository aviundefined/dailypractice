package com.avi.practice.leetcode.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by navinash on 04/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SumOfDistancesInTree {

    public int[] sumOfDistancesInTree_BruteForce(int n, int[][] edges) {
        if (n == 0 | edges == null || edges.length == 0) {
            return new int[]{};
        }
        return bruteForce(n, edges);
    }

    private int[] bruteForce(int n, int[][] edges) {
        final Graph graph = new Graph();
        for (final int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        final int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            final Set<Integer> visited = new HashSet<>();
            int distance = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    final Pair pair = distance(i, j, graph, visited);
                    if (pair.isFound) {
                        distance += pair.distance;
                    }
                }
            }
            result[i] = distance;
        }
        return result;
    }

    private Pair distance(int source, int destination, Graph graph, Set<Integer> visited) {
        if (source == destination) {
            return new Pair(true, 0);
        }
        if (visited.contains(source)) {
            return new Pair(false, -1);
        }
        visited.add(source);
        for (final int neighbour : graph.getNeighbours(source)) {
            if (visited.contains(neighbour)) {
                continue;

            }
            final Pair pair = distance(neighbour, destination, graph, visited);
            if (pair.isFound) {
                visited.remove(source);
                return new Pair(true, 1 + pair.distance);
            }

        }
        visited.remove(source);
        return new Pair(false, -1);
    }

    private static final class Pair {
        private final boolean isFound;
        private final int distance;

        private Pair(boolean isFound, int distance) {
            this.isFound = isFound;
            this.distance = distance;
        }
    }

    private static final class Graph {
        private final Map<Integer, Set<Integer>> adjList = new HashMap<>();

        private void addEdge(final int src, final int dst) {
            this.adjList.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
            this.adjList.computeIfAbsent(dst, k -> new HashSet<>()).add(src);
        }

        private Set<Integer> getNeighbours(final int node) {
            return this.adjList.getOrDefault(node, new HashSet<>());
        }
    }
}
