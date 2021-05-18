package com.avi.practice.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by navinash on 18/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CourseSchedule {

    private static final int W = 0;
    private static final int G = 1;
    private static final int B = 2;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create graph
        final Graph graph = new Graph();
        for (final int[] preReq : prerequisites) {
            // [1,0] means 1 -> 0
            graph.addEdge(preReq[0], preReq[1]);
        }

        final Stack<Integer> order = new Stack<>();
        final Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited.getOrDefault(i, W) != W) {
                continue;
            }

            final boolean dfs = dfs(graph, i, visited, order);
            if (!dfs) {
                return new int[0];
            }

        }

        final int[] result = new int[numCourses];
        int i = numCourses - 1;
        while (!order.isEmpty()) {
            result[i] = order.pop();
            i--;
        }
        return result;
    }

    private boolean dfs(
            final Graph graph,
            final int i,
            final Map<Integer, Integer> visited,
            final Stack<Integer> order) {

        visited.put(i, G);
        for (final Graph.Edge edge : graph.getEdges(i)) {
            final int dst = edge.getDst();
            final int color = visited.getOrDefault(dst, W);
            if (color == W) {
                final boolean dfs = dfs(graph, dst, visited, order);
                if (!dfs) {
                    return false;
                }
            } else if (color == G) {
                return false;
            }
        }
        order.push(i);
        visited.put(i, B);
        return true;
    }

    private static class Graph {

        private final Map<Integer, List<Edge>> edges = new HashMap<>();
        private final Set<Integer> nodes = new HashSet<>();

        private Set<Integer> getAllNodes() {
            return this.nodes;
        }

        private List<Edge> getEdges(final int src) {
            return this.edges.getOrDefault(src, new ArrayList<>());
        }

        private void addEdge(final int src, final int dst) {
            addEdge(src, dst, Edge.DEFAULT_WEIGHT);
        }

        private void addEdge(final int src, final int dst, final int weight) {
            this.edges.computeIfAbsent(src, s -> new ArrayList<>()).add(new Edge(src, dst, weight));
            this.nodes.add(src);
            this.nodes.add(dst);
        }


        private static final class Edge {
            private static final int DEFAULT_WEIGHT = 1;
            private final int src;
            private final int dst;
            private final int weight;

            public Edge(int src, int dst) {
                this(src, dst, DEFAULT_WEIGHT);
            }

            public Edge(int src, int dst, int weight) {
                this.src = src;
                this.dst = dst;
                this.weight = weight;
            }

            public int getSrc() {
                return src;
            }

            public int getDst() {
                return dst;
            }

            public int getWeight() {
                return weight;
            }
        }
    }
}
