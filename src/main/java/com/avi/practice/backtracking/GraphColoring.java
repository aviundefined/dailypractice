package com.avi.practice.backtracking;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 20/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class GraphColoring {
    private final int[][] graph;
    private final int numVertexes;

    GraphColoring(final int[][] graph) {
        this.graph = graph;
        this.numVertexes = graph.length;
    }

    boolean solve(final int numOfColors) {
        System.out.println("Num colors: " + numOfColors);
        CommonUtils.printMatrix(graph);
        if (numOfColors == 0) {
            return false;
        }
        final int[] color = new int[numVertexes];
        if (_solve(0, color, numOfColors)) {
            System.out.println("Solution found");
            CommonUtils.printArr(color);
            return true;
        }
        System.out.println("Solution doesn't exist");
        return false;
    }

    private boolean _solve(final int currVertex, final int[] color, int numOfColors) {
        if (currVertex == numVertexes) {
            return true;
        }

        for (int c = 1; c <= numOfColors; c++) {
            if (_isSafe(currVertex, c, color)) {
                color[currVertex] = c;
                if (_solve(currVertex + 1, color, numOfColors)) {
                    return true;
                }
                color[currVertex] = 0;
            }
        }
        return false;
    }

    private boolean _isSafe(final int currVertex, final int c, final int[] color) {
        // if ith vertex is connected with current vertex and is painted with same color then reject it
        for (int i = 0; i < numVertexes; i++) {
            if (graph[currVertex][i] == 1 // ith vertex is connected with current vertex
                    && color[i] == c // is painted with same color
            ) {
                return false; // reject it
            }
        }
        return true; // else accept it
    }
}
