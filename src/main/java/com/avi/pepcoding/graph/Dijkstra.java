package com.avi.pepcoding.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by navinash on 03/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Dijkstra {

    public void shortestPath(final Graph graph, final int source) {
        if (graph == null) {
            return;
        }

        final PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.weightSoFar));
        q.add(new Pair(source, source + ",", 0));
        final Set<Integer> visited = new HashSet<>();

        while (!q.isEmpty()) {
            // remove mark* work add*
            final Pair curr = q.poll();
            if (visited.contains(curr.node)) {
                continue;
            }
            visited.add(curr.node);
            System.out.printf("%s via %s with weight %s\n", curr.node, curr.pathSoFar, curr.weightSoFar);
            for (final Graph.Edge e : graph.getEdges(curr.node)) {
                if (!visited.contains(e.getDst())) {
                    q.add(new Pair(e.getDst(), curr.pathSoFar + e.getDst() + ",", curr.weightSoFar + e.getWeight()));
                }
            }
        }
    }

    private static final class Pair {
        private final int node;
        private final String pathSoFar;
        private final int weightSoFar;

        private Pair(int node, String pathSoFar, int weightSoFar) {
            this.node = node;
            this.pathSoFar = pathSoFar;
            this.weightSoFar = weightSoFar;
        }
    }
}
