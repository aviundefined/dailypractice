package com.avi.pepcoding.graph;

import com.avi.pepcoding.graph.Graph.Edge;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by navinash on 08/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DSU {

    public Result minimumSpanningTree(final Graph graph) {
        if (graph == null) {
            return null;
        }

        final PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.getWeight() == e2.getWeight()) {
                return e1.getDst() - e2.getDst();
            }
            return e1.getWeight() - e2.getWeight();
        });
        for (final int node : graph.getAllNodes()) {
            for (final Edge edge : graph.getEdges(node)) {
                pq.offer(edge);
            }
        }

        final int[] parent = new int[graph.getAllNodes().size()];
        Arrays.fill(parent, -1);
        final Graph mst = new Graph();
        int weight = 0;
        while (!pq.isEmpty()) {
            final Edge edge = pq.poll();
            final boolean include = union(parent, edge.getSrc(), edge.getDst());
            if (include) {
                mst.addEdge(edge.getSrc(), edge.getDst(), edge.getWeight());
                mst.addEdge(edge.getDst(), edge.getSrc(), edge.getWeight());
                weight += edge.getWeight();
            }
        }
        return new Result(mst, weight);
    }


    private int find(final int[] parent, final int node) {
        if (parent[node - 1] < 0) {
            return node;
        }
        return find(parent, parent[node - 1]);
    }

    private boolean union(final int[] parent, final int node1, final int node2) {
        final int parent1 = find(parent, node1);
        final int parent2 = find(parent, node2);
        if (parent1 == parent2) {
            return false;
        }
        final int parent1NodeCount = Math.abs(parent[parent1 - 1]);
        final int parent2NodeCount = Math.abs(parent[parent2 - 1]);
        if (parent1NodeCount >= parent2NodeCount) {
            parent[parent2 - 1] = parent1;
        } else {
            parent[parent1 - 1] = parent2;
        }
        return true;
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
}
