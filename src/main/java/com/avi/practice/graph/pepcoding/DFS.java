package com.avi.practice.graph.pepcoding;

import com.avi.practice.graph.pepcoding.Graph.Edge;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by navinash on 04/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DFS {

    public void dfs(final Graph graph, final int src) {
        if (graph == null) {
            return;
        }

        final Set<Integer> visited = new HashSet<>();
        final Stack<Integer> s = new Stack<>();
        s.push(src);
        while (!s.isEmpty()) {
            // remove mark* work add*
            final int curr = s.pop();
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            System.out.println(curr);
            for (final Edge e : graph.getEdges(curr)) {
                if (!visited.contains(e.getDst())) {
                    s.push(e.getDst());
                }
            }
        }
    }
}
