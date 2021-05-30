package com.avi.practice.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by navinash on 30/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ConnectingCitiesWithMinimumCost {

    public int minimumCost(int n, int[][] connections) {
        if (n <= 1 || connections == null) {
            return 0;
        }
        final Graph graph = new Graph();
        for (final int[] connection : connections) {
            graph.addEdge(connection[0], connection[1], connection[2]);
        }
        final Set<Integer> visited = new HashSet<>();
        int cost = 0;
        final Edge startEdge = selectMinWeightEdge(graph, visited);
        final PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(startEdge.src, -1, 0));
        while (!q.isEmpty()) {
            // remove mark* work add*
            final Pair curr = q.poll();
            if (visited.contains(curr.node)) {
                continue;
            }
            visited.add(curr.node);
            cost += curr.weight;
            for (final Edge edge : graph.getEdges(curr.node)) {
                if (visited.contains(edge.dst)) {
                    continue;
                }
                q.add(new Pair(edge.dst, curr.node, edge.weight));
            }
        }
        return visited.size() == n ? cost : -1;
    }

    private Edge selectMinWeightEdge(Graph graph, final Set<Integer> visited) {
        int minWeight = Integer.MAX_VALUE;
        Edge min = null;
        for (final List<Edge> edges : graph.edges.values()) {
            for (final Edge e : edges) {
                if (visited.contains(e.src) || visited.contains(e.dst)) {
                    continue;
                }
                if (e.weight < minWeight) {
                    minWeight = e.weight;
                    min = e;
                }
            }
        }
        return min;
    }


    private static final class Graph {
        private final Map<Integer, List<Edge>> edges = new HashMap<>();

        private void addEdge(final int node1, final int node2, final int weight) {
            this.edges.computeIfAbsent(node1, k -> new ArrayList<>()).add(new Edge(node1, node2, weight));
            this.edges.computeIfAbsent(node2, k -> new ArrayList<>()).add(new Edge(node2, node1, weight));
        }

        private List<Edge> getEdges(final int node) {
            return this.edges.getOrDefault(node, new ArrayList<>());
        }
    }

    private static final class Edge implements Comparable<Edge> {
        private final int src;
        private final int dst;
        private final int weight;

        private Edge(final int src, final int dst, final int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }

        @Override
        public int compareTo(final Edge edge) {
            return this.weight - edge.weight;
        }
    }

    private final static class Pair implements Comparable<Pair> {
        private final int node;
        private final int via;
        private final int weight;

        public Pair(int node, int via, int weight) {
            this.node = node;
            this.via = via;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }
}
