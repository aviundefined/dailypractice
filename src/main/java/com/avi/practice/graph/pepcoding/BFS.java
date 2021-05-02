package com.avi.practice.graph.pepcoding;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by navinash on 01/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BFS {

    public void bfs(final Graph gpaph, final int src) {
        final Queue<Integer> queue = new LinkedList<>();
        final Set<Integer> visited = new HashSet<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            // remove mark* work add*
            final Integer poll = queue.poll();
            if (visited.contains(poll)) {
                continue;
            }
            visited.add(poll);
            System.out.println(poll);
            for (final Graph.Edge edge : gpaph.getEdges(poll)) {
                if (visited.contains(edge.getDst())) {
                    continue;
                }
                queue.add(edge.getDst());
            }
        }
    }
}
