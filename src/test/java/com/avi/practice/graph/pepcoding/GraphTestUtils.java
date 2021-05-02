package com.avi.practice.graph.pepcoding;

import java.util.Arrays;

/**
 * Created by navinash on 01/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GraphTestUtils {

    public static Graph getTestUndirectedGraph1() {
        final Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        graph.addEdge(2, 1);
        graph.addEdge(2, 4);


        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        graph.addEdge(4, 2);
        graph.addEdge(4, 3);

        graph.addEdge(5, 3);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);

        graph.addEdge(6, 5);
        graph.addEdge(6, 7);

        graph.addEdge(7, 5);
        graph.addEdge(7, 6);
        return graph;
    }

    public static Graph getTestUndirectedGraph2() {
        final Graph graph = new Graph();
        graph.addEdge(1, 2);

        graph.addEdge(2, 1);

        graph.addEdge(3, 4);

        graph.addEdge(4, 3);

        graph.addEdge(5, 6);
        graph.addEdge(5, 7);

        graph.addEdge(6, 5);
        graph.addEdge(6, 7);

        graph.addEdge(7, 5);
        graph.addEdge(7, 6);
        return graph;
    }

    public static Graph getTestDirectedGraph1() {
        final Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        graph.addEdge(2, 4);


        graph.addEdge(3, 4);
        graph.addEdge(3, 5);


        graph.addEdge(5, 6);
        graph.addEdge(5, 7);

        graph.addEdge(6, 7);

        return graph;
    }

    public static Graph getTestDirectedGraph2() {
        final Graph graph = new Graph();
        graph.addEdge(1, 2);

        graph.addEdge(3, 4);

        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        return graph;
    }

    public static int[][] matrix1() {
        final int m = 5;
        final int n = 5;

        /*
         * 0 0 0 0 0
         * 0 0 0 1 1
         * 1 1 1 1 1
         * 1 1 0 0 1
         * 1 1 1 1 1
         */

        final int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(a[i], 1);
        }
        a[0][0] = 0;
        a[0][1] = 0;
        a[0][2] = 0;
        a[0][3] = 0;
        a[0][4] = 0;

        a[1][0] = 0;
        a[1][1] = 0;
        a[1][2] = 0;

        a[3][2] = 0;
        a[3][3] = 0;
        return a;
    }

    public static int[][] matrix2() {
        final int m = 5;
        final int n = 5;

        /*
         * 1 1 1 1 0
         * 1 0 0 1 1
         * 1 0 1 1 1
         * 1 1 0 0 1
         * 1 1 1 1 1
         */

        final int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(a[i], 1);
        }
        a[0][4] = 0;

        a[1][1] = 0;
        a[1][2] = 0;
        a[2][1] = 0;

        a[3][2] = 0;
        a[3][3] = 0;
        return a;
    }

    public static int[][] matrix3() {
        final int m = 5;
        final int n = 5;

        /*
         * 1 1 1 1 0
         * 1 0 0 1 1
         * 1 0 1 1 1
         * 1 0 0 0 1
         * 1 1 1 1 1
         */

        final int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(a[i], 1);
        }
        a[0][4] = 0;

        a[1][1] = 0;
        a[1][2] = 0;
        a[2][1] = 0;
        a[3][1] = 0;
        a[3][2] = 0;
        a[3][3] = 0;
        return a;
    }

    public static int[][] matrix4() {
        final int m = 5;
        final int n = 5;

        /*
         * 1 1 1 0 0
         * 1 0 0 0 1
         * 1 0 1 1 1
         * 1 0 0 0 1
         * 1 1 1 1 1
         */

        final int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(a[i], 1);
        }
        a[0][3] = 0;
        a[0][4] = 0;
        a[1][1] = 0;
        a[1][2] = 0;
        a[1][3] = 0;
        a[2][1] = 0;
        a[3][1] = 0;
        a[3][2] = 0;
        a[3][3] = 0;
        return a;
    }
}
