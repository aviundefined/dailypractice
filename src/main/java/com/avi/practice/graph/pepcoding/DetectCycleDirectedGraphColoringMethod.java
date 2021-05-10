package com.avi.practice.graph.pepcoding;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 11/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DetectCycleDirectedGraphColoringMethod {

    public boolean isCycle(final Graph graph) {
        if (graph == null) {
            return false;
        }

        final Map<Integer, Color> nodesByColor = new HashMap<>();
        for (final int n : graph.getAllNodes()) {
            if (!nodesByColor.containsKey(n)) {
                if (isCycle(graph, n, nodesByColor)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCycle(Graph graph, int currentNode, Map<Integer, Color> nodesByColor) {
        nodesByColor.put(currentNode, Color.GREY);
        for (final Graph.Edge edge : graph.getEdges(currentNode)) {
            if (nodesByColor.containsKey(edge.getDst()) && nodesByColor.get(edge.getDst()) == Color.GREY) {
                return true;
            }
            if (!nodesByColor.containsKey(edge.getDst())) {
                if (isCycle(graph, edge.getDst(), nodesByColor)) {
                    return true;
                }
            }
        }
        nodesByColor.put(currentNode, Color.BLACK);
        return false;
    }

    private enum Color {
        WHITE,
        GREY,
        BLACK
    }
}
