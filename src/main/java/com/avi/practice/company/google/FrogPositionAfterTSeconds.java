package com.avi.practice.company.google;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by navinash on 19/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FrogPositionAfterTSeconds {


    public double frogPosition(int n, int[][] edges, int t, int target) {
        final Graph graph = new Graph();
        for (final int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }
        double[] result = new double[n + 1];
        Arrays.fill(result, 0.0D);
        // at time 0 frog is at position 1 with Probability 1.0D
        // now in next step it can go all neighbours with with equal Probability
        final Queue<Tuple> q = new ArrayDeque<>();
        q.offer(new Tuple(1, 0, 1.0D));
        while (!q.isEmpty()) {
            final Tuple curr = q.poll();
            // update the Probability is time is under limit
            if (curr.time <= t) {
                result[curr.node] = curr.p;
            }
            // if time is over for that node then we can't jump any more
            if (curr.time + 1 > t) {
                continue;
            }
            final int outDegree = graph.getOutDegree(curr.node);
            // there is no neighbours to jump
            if (outDegree <= 0) {
                continue;
            }
            // jumped from this node so make this Probability 0.0D
            result[curr.node] = 0.0D;
            // calculate new Probability
            final double p = (1.0D / outDegree) * curr.p;
            final Set<Integer> neighbours = new HashSet<>(graph.getNeighbours(curr.node));
            for (final int neighbour : neighbours) {
                // remove the visited edge so that next time Probability calculations will be accurate
                graph.removeEdge(curr.node, neighbour);
                q.offer(new Tuple(neighbour, curr.time + 1, p));

            }
        }
        return result[target];
    }

    private static final class Tuple {
        private final int node;
        private final int time;
        private final double p;

        private Tuple(int node, int time, double p) {
            this.node = node;
            this.time = time;
            this.p = p;
        }

        public String toString() {
            return "(" + node + "," + time + "," + p + ")";
        }
    }

    private static final class Graph {
        private final Map<Integer, Set<Integer>> adjList = new HashMap<>();
        private final Map<Integer, Integer> outDegrees = new HashMap<>();

        private void addEdge(final int src, final int dst) {
            this.adjList.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
            this.adjList.computeIfAbsent(dst, k -> new HashSet<>()).add(src);

            incOutDegrees(src);
            incOutDegrees(dst);
        }

        private void removeEdge(final int src, final int dst) {
            this.adjList.computeIfAbsent(src, k -> new HashSet<>()).remove(dst);
            this.adjList.computeIfAbsent(dst, k -> new HashSet<>()).remove(src);
            decOutDegrees(src);
            decOutDegrees(dst);
        }

        private Set<Integer> getNeighbours(final int node) {
            return this.adjList.getOrDefault(node, new HashSet<>());
        }

        private int getOutDegree(final int node) {
            return this.outDegrees.getOrDefault(node, 0);
        }

        private void decOutDegrees(final int node) {
            this.outDegrees.put(node, outDegrees.getOrDefault(node, 0) - 1);
        }

        private void incOutDegrees(final int node) {
            this.outDegrees.compute(node, (k, v) -> {
                return v == null ? 1 : v + 1;
            });
        }
    }
}
