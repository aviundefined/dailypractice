package com.avi.practice.company.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * You are given an undirected graph. You are given an integer n which is the number of nodes in the graph and an array edges, where each edges[i] = [ui, vi] indicates that there is an undirected edge between ui and vi.
 * <p>
 * A connected trio is a set of three nodes where there is an edge between every pair of them.
 * <p>
 * The degree of a connected trio is the number of edges where one endpoint is in the trio, and the other is not.
 * <p>
 * Return the minimum degree of a connected trio in the graph, or -1 if the graph has no connected trios.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
 * Output: 3
 * Explanation: There is exactly one trio, which is [1,2,3]. The edges that form its degree are bolded in the figure above.
 * Example 2:
 * <p>
 * <p>
 * Input: n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]
 * Output: 0
 * Explanation: There are exactly three trios:
 * 1) [1,4,3] with degree 0.
 * 2) [2,5,6] with degree 2.
 * 3) [5,6,7] with degree 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 400
 * edges[i].length == 2
 * 1 <= edges.length <= n * (n-1) / 2
 * 1 <= ui, vi <= n
 * ui != vi
 * There are no repeated edges.
 */
public class MinimumDegreeConnectedTrioGraph {

    public int minTrioDegree(int n, int[][] edges) {
        final boolean[][] isEdge = new boolean[n + 1][n + 1];
        final Map<Integer, Integer> degrees = new HashMap<>();
        for (final int[] edge : edges) {
            degrees.compute(edge[0], (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
            degrees.compute(edge[1], (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
            isEdge[edge[0]][edge[1]] = true;
            isEdge[edge[1]][edge[0]] = true;
        }
        int min = Integer.MAX_VALUE;
        for (final int[] edge : edges) {
            for (int i = 1; i <= n; i++) {
                if (isEdge[i][edge[0]] && isEdge[i][edge[1]]) {
                    final int trioDegree = degrees.getOrDefault(i, 0) + degrees.getOrDefault(edge[0], 0) + degrees.getOrDefault(edge[1], 0) - 6;
                    if (trioDegree < min) {
                        min = trioDegree;
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    public int minTrioDegree_TLE(int n, int[][] edges) {
        final Graph graph = new Graph();
        for (final int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        int min = Integer.MAX_VALUE;
        final Map<Tuple, Integer> dp = new HashMap<>();
        for (int u = 1; u <= n; u++) {
            for (int v = 1; v <= n; v++) {
                if (v == u) {
                    continue;
                }
                for (int w = 1; w <= n; w++) {
                    if (w == v || w == u) {
                        continue;
                    }
                    final Tuple tuple = new Tuple(u, v, w);
                    if (dp.containsKey(tuple)) {
                        continue;
                    }
                    if (isTrio(u, v, w, graph)) {
                        final int degree = graph.degree(u) + graph.degree(v) + graph.degree(w) - 6;
                        dp.put(new Tuple(u, v, w), degree);
                        if (degree < min) {
                            min = degree;
                        }
                    } else {
                        dp.put(new Tuple(u, v, w), -1);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private boolean isTrio(int u, int v, int w, Graph graph) {
        // u -> v
        // v -> w
        // w -> u
        if (!graph.getNeighbours(u).contains(v)) {
            return false;
        }

        if (!graph.getNeighbours(v).contains(w)) {
            return false;
        }

        if (!graph.getNeighbours(w).contains(u)) {
            return false;
        }
        return true;
    }


    private static final class Graph {
        private final Map<Integer, Set<Integer>> edges = new HashMap<>();

        private void addEdge(final int src, final int dst) {
            this.edges.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
            this.edges.computeIfAbsent(dst, k -> new HashSet<>()).add(src);
        }

        private Set<Integer> getNeighbours(final int src) {
            return this.edges.getOrDefault(src, new HashSet<>());
        }

        private int degree(final int node) {
            return this.edges.containsKey(node) ? this.edges.get(node).size() : 0;
        }
    }

    private static final class Tuple {
        private final int u;
        private final int v;
        private final int w;

        public Tuple(int u, int v, int w) {
            final int[] arr = new int[3];
            arr[0] = u;
            arr[1] = v;
            arr[2] = w;
            Arrays.sort(arr);
            this.u = arr[0];
            this.v = arr[1];
            this.w = arr[2];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return u == tuple.u &&
                    v == tuple.v &&
                    w == tuple.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v, w);
        }
    }
}
