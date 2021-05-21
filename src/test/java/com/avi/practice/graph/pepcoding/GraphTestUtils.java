package com.avi.practice.graph.pepcoding;

import com.avi.pepcoding.graph.Graph;

import java.util.Arrays;

/**
 * Created by navinash on 01/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GraphTestUtils {

    public static Graph getTestUndirectedGraph1() {
        /*   1 ------ 3 ----- 5
         *   |        |      |  \
         *   |        |      |   \
         *   |        |      |    \
         *   2 ------ 4      6---- 7
         */
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

        /*   1        3       5
         *   |        |      |  \
         *   |        |      |   \
         *   |        |      |    \
         *   2        4      6---- 7
         */
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

    public static Graph getTestUndirectedGraph3() {

        /*   1 ------ 3 ----- 5
         *   |        |       |
         *   |        |       |
         *   |        |       |
         *   2 ------ 4       6---- 7
         */
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

        graph.addEdge(6, 5);
        graph.addEdge(6, 7);

        graph.addEdge(7, 6);
        return graph;
    }

    public static Graph getTestUndirectedGraph4() {
        /*   1        3 ----- 5
         *   |        |       |
         *   |        |       |
         *   |        |       |
         *   2 ------ 4      6---- 7
         */
        final Graph graph = new Graph();
        graph.addEdge(1, 2);

        graph.addEdge(2, 1);
        graph.addEdge(2, 4);


        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        graph.addEdge(4, 2);
        graph.addEdge(4, 3);

        graph.addEdge(5, 3);
        graph.addEdge(5, 6);

        graph.addEdge(6, 5);
        graph.addEdge(6, 7);

        graph.addEdge(7, 6);
        return graph;
    }


    public static Graph getTestDirectedGraph1() {
        /*
         *
         *   1 -----> 3 ----> 5
         *   |        |      |  \
         *   |        |      |   \
         *   v        v      v    v
         *   2 -----> 4      6---->7
         */
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
        /*
         *
         *   1        3       5
         *   |        |      |  \
         *   |        |      |   \
         *   v        v      v    v
         *   2        4      6---->7
         */
        final Graph graph = new Graph();
        graph.addEdge(1, 2);

        graph.addEdge(3, 4);

        graph.addEdge(5, 6);
        graph.addEdge(5, 7);

        graph.addEdge(6, 7);

        return graph;
    }


    public static Graph getTestDirectedGraph3() {
        /*
         *
         *   1 -----> 3 <---- 5
         *   |        |      |  \
         *   |        |      |   \
         *   v        v      v    v
         *   2 -----> 4      6---->7
         */
        final Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        graph.addEdge(2, 4);


        graph.addEdge(3, 4);


        graph.addEdge(5, 3);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);

        graph.addEdge(6, 7);

        return graph;
    }

    public static Graph getTestDirectedGraph4() {
        /*
         *
         *   0 -----> 3 ------> 4
         *   |        ^       |  \
         *   |        |       |   \
         *   v        |       v    v
         *   1 -----> 2       5---->6
         */
        final Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);

        graph.addEdge(1, 2);


        graph.addEdge(2, 3);


        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        graph.addEdge(5, 6);

        return graph;
    }
    public static Graph getTestUndirectedWeightedGraph1() {

        /*      40       2
         *   1 ------ 3 ----- 5
         *   |        |      |  \
         * 10|     10 |     3|   \ 8
         *   |        |      | 3  \
         *   2 ------ 4      6---- 7
         *       10
         */
        final Graph graph = new Graph();
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 40);

        graph.addEdge(2, 1, 10);
        graph.addEdge(2, 4, 10);


        graph.addEdge(3, 1, 40);
        graph.addEdge(3, 4, 10);
        graph.addEdge(3, 5, 2);

        graph.addEdge(4, 2, 10);
        graph.addEdge(4, 3, 10);

        graph.addEdge(5, 3, 2);
        graph.addEdge(5, 6, 3);
        graph.addEdge(5, 7, 8);

        graph.addEdge(6, 5, 3);
        graph.addEdge(6, 7, 3);

        graph.addEdge(7, 5, 8);
        graph.addEdge(7, 6, 3);
        return graph;
    }

    public static Graph getTestUndirectedWeightedGraph2() {

        /*
         *        5
         *   1 ------- 2
         *   |        /|
         *   |       / |
         *   |      /  |
         * 4 |   2 /   | 3
         *   |    /    |
         *   |   /     |
         *   |  /      |
         *   | /       |
         *   3 ------- 4
         *       6
         */
        final Graph graph = new Graph();
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 4);

        graph.addEdge(2, 1, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 3);

        graph.addEdge(3, 1, 4);
        graph.addEdge(3, 2, 2);
        graph.addEdge(3, 4, 6);

        graph.addEdge(4, 2, 3);
        graph.addEdge(4, 3, 6);


        return graph;
    }

    public static Graph getTestUndirectedWeightedGraph3() {

        final Graph graph = new Graph();
        graph.addEdge(1, 2, 28);
        graph.addEdge(1, 6, 10);

        graph.addEdge(2, 1, 28);
        graph.addEdge(2, 7, 14);
        graph.addEdge(2, 3, 16);

        graph.addEdge(3, 2, 16);
        graph.addEdge(3, 4, 12);

        graph.addEdge(4, 3, 12);
        graph.addEdge(4, 7, 18);
        graph.addEdge(4, 5, 22);

        graph.addEdge(5, 4, 22);
        graph.addEdge(5, 7, 24);
        graph.addEdge(5, 6, 25);

        graph.addEdge(6, 5, 25);
        graph.addEdge(6, 1, 10);

        graph.addEdge(7, 2, 14);
        graph.addEdge(7, 4, 18);
        graph.addEdge(7, 5, 24);

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
