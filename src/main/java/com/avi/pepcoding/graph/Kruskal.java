package com.avi.pepcoding.graph;

import com.avi.pepcoding.graph.Graph.Edge;

import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by navinash on 04/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 *
 *
 * TODO Avinash: It's not correct as cycle deduction code is not right
 */
public class Kruskal {

    public final Result minimumSpanningTree(final Graph graph) {
        if (graph == null) {
            return new Result(null, 0);
        }

        final Graph mst = new Graph();
        int weight = 0;
        final PriorityQueue<Pair> q = new PriorityQueue<>();
        final Set<Pair> edges = new HashSet<>();
        final Set<Integer> allNodes = graph.getAllNodes();
        for (final int node : allNodes) {
            for (final Edge e : graph.getEdges(node)) {
                final Pair pair = new Pair(e.getSrc(), e.getDst(), e.getWeight());
                if (!edges.contains(pair)) {
                    q.add(pair);
                    edges.add(pair);
                }
            }
        }
        final Set<Integer> visited = new HashSet<>();
        int numEdges = 0;
        while (!q.isEmpty()) {
            final Pair curr = q.poll();
            if (visited.contains(curr.first) && visited.contains(curr.second)) {
                continue;
            }
            numEdges++;
            visited.add(curr.first);
            visited.add(curr.second);
            mst.addEdge(curr.first, curr.second, curr.weight);
            mst.addEdge(curr.second, curr.first, curr.weight);
            weight += curr.weight;
        }
        return new Result(mst, weight);
    }

    static final class Result {
        private final Graph mst;
        private final int weight;

        private Result(Graph mst, int weight) {
            this.mst = mst;
            this.weight = weight;
        }

        public Graph getMst() {
            return mst;
        }

        public int getWeight() {
            return weight;
        }
    }

    private static final class Pair implements Comparable<Pair> {
        private final int first;
        private final int second;
        private final int weight;

        public Pair(int first, int second, final int weight) {
            this.first = Math.min(first, second);
            this.second = Math.max(first, second);
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first &&
                    second == pair.second &&
                    weight == pair.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second, weight);
        }
    }
}
