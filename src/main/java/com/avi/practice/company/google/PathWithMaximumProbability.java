package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by navinash on 29/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PathWithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        final Graph graph = new Graph();
        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1], succProb[i]);
        }

        final PriorityQueue<PathWithCost> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.cost, a.cost);
        });


        pq.offer(new PathWithCost(start, 1.00D));
        final Set<Integer> visited = new HashSet<>();
        while (!pq.isEmpty()) {
            final PathWithCost curr = pq.poll();
            if (visited.contains(curr.node)) {
                continue;
            }
            visited.add(curr.node);
            if (curr.node == end) {
                return curr.cost;
            }
            for (final Edge edge : graph.getEdges(curr.node)) {
                final int next = edge.dst;
                if (visited.contains(next)) {
                    continue;
                }
                pq.offer(new PathWithCost(next, curr.cost * edge.weight));
            }
        }
        return 0.00D;
    }

    private static final class PathWithCost {
        private final int node;
        private final double cost;

        private PathWithCost(final int node, final double cost) {
            this.node = node;
            this.cost = cost;
        }

        public String toString() {
            return "(" + node + "," + cost + ")";
        }
    }

    private final static class Edge {
        private final int src;
        private final int dst;
        private final double weight;

        private Edge(final int src, final int dst, final double weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }

        public String toString() {
            return "(" + src + "," + dst + "," + weight + ")";
        }
    }

    private static final class Graph {
        private Map<Integer, List<Edge>> edges = new HashMap<>();

        private void addEdge(final int src, final int dst, final double weight) {
            this.edges.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(src, dst, weight));
            this.edges.computeIfAbsent(dst, k -> new ArrayList<>()).add(new Edge(dst, src, weight));
        }

        private List<Edge> getEdges(final int node) {
            return this.edges.getOrDefault(node, new ArrayList<>());
        }
    }
}
