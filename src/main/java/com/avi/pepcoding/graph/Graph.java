package com.avi.pepcoding.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by navinash on 01/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Graph {

    private final Map<Integer, List<Edge>> edges = new HashMap<>();
    private final Set<Integer> nodes = new HashSet<>();
    public Set<Integer> getAllNodes() {
        return this.nodes;
    }

    public List<Edge> getEdges(final int src) {
        return this.edges.getOrDefault(src, new ArrayList<>());
    }

    public void addEdge(final int src, final int dst) {
        addEdge(src, dst, Edge.DEFAULT_WEIGHT);
    }

    public void addEdge(final int src, final int dst, final int weight) {
        this.edges.computeIfAbsent(src, s -> new ArrayList<>()).add(new Edge(src, dst, weight));
        this.nodes.add(src);
        this.nodes.add(dst);
    }


    public static final class Edge {
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
