package com.avi.pepcoding.graph;

import com.avi.pepcoding.graph.Graph.Edge;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by navinash on 03/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Prims {

    public Result minimumSpanningTree(final Graph graph) {
        if (graph == null) {
            return null;
        }
        int weight = 0;
        final Graph mst = new Graph();
        // first choose the edge which has the minimum weight and use any node as starting node
        final Edge startEdge = selectMinWeightEdge(graph);
        final PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(startEdge.getSrc(), -1, 0));
        final Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            // remove mark* work add*
            final Pair curr = q.poll();
            if (visited.contains(curr.node)) {
                continue;
            }
            visited.add(curr.node);
            if (curr.via != -1) {
                mst.addEdge(curr.via, curr.node, curr.weight);
                mst.addEdge(curr.node, curr.via, curr.weight);
                weight += curr.weight;
            }
            for (final Edge e : graph.getEdges(curr.node)) {
                if (!visited.contains(e.getDst())) {
                    q.add(new Pair(e.getDst(), curr.node, e.getWeight()));
                }
            }
        }
        return new Result(mst, weight);
    }

    public static final class Result {
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

    private Edge selectMinWeightEdge(Graph graph) {
        int minWeight = Integer.MAX_VALUE;
        Edge min = null;
        for (final int node : graph.getAllNodes()) {
            for (final Edge e : graph.getEdges(node)) {
                if (e.getWeight() < minWeight) {
                    minWeight = e.getWeight();
                    min = e;
                }
            }
        }
        return min;
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
