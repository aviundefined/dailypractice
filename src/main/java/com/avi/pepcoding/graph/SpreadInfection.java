package com.avi.pepcoding.graph;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by navinash on 03/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SpreadInfection {

    public final int infected(final Graph graph, final int source, final int t) {
        if (graph == null || t <= 0) {
            return 0;
        }

        final Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(source, 1));
        final Map<Integer, Integer> infectedTimeByNode = new HashMap<>();
        int infected = 0;
        while (!q.isEmpty()) {
            // remove mark* word add*
            final Pair curr = q.poll();
            if (infectedTimeByNode.containsKey(curr.node)) {
                continue;
            }
            infectedTimeByNode.put(curr.node, curr.time);
            if (curr.time > t) {
                break;
            }
            infected++;
            for (final Graph.Edge e : graph.getEdges(curr.node)) {
                if (!infectedTimeByNode.containsKey(e.getDst())) {
                    q.add(new Pair(e.getDst(), curr.time + 1));
                }
            }
        }
        return infected;
    }

    private static final class Pair {
        private final int node;
        private final int time;

        private Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
}
