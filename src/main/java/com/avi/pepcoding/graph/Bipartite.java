package com.avi.pepcoding.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by navinash on 02/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Bipartite {

    public final boolean isBipartite(final Graph graph) {
        if (graph == null) {
            return true;
        }

        final Set<Integer> nodes = graph.getAllNodes();
        final Map<Integer, Integer> levels = new HashMap<>();

        for (final int node : nodes) {
            if (!levels.containsKey(node)) {
                final boolean isComponentBipartite = isComponentBipartite(graph, node, levels);
                if (!isComponentBipartite) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isComponentBipartite(Graph graph, int node, Map<Integer, Integer> levels) {
        final Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, 0));
        while (!q.isEmpty()) {
            // remove mark* work add*
            final Pair poll = q.poll();
            if (levels.containsKey(poll.node)) {
                if (levels.get(poll.node) != poll.level) {
                    return false;
                }
                continue;
            }

            levels.put(poll.node, poll.level);
            for (final Graph.Edge edge : graph.getEdges(poll.node)) {
                final int nxtNode = edge.getDst();
                if (!levels.containsKey(nxtNode)) {
                    q.add(new Pair(nxtNode, poll.level + 1));
                }
            }
        }
        return true;
    }

    private static final class Pair {
        private final int node;
        private final int level;

        public Pair(int node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
