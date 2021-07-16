package com.avi.practice.company.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 * <p>
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 * <p>
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * <p>
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * Example 2:
 * <p>
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 * <p>
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
public class EvaluateDivision {

    private static final int G = 1;
    private static final int B = 2;
    private static final int places = 5;

    private Double value = 1.0D;

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        value = 1.0D;
        final Graph graph = new Graph();
        for (int i = 0; i < equations.size(); i++) {
            final List<String> equation = equations.get(i);
            graph.addEdge(equation.get(0), equation.get(1), values[i]);
        }
        final double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            final List<String> query = queries.get(i);
            final String start = query.get(0);
            final String end = query.get(1);
            final Map<String, Integer> colors = new HashMap<>();
            value = 1.0D;
            if (!graph.isNodeExists(start) || !graph.isNodeExists(end)) {
                result[i] = -1.0D;
            } else {
                if (dfs(start, end, "", graph, colors)) {
                    result[i] = round(value, places);
                } else {
                    result[i] = -1.0D;
                }
            }
        }
        return result;
    }

    private boolean dfs(final String start, final String end, String parent, final Graph graph, Map<String, Integer> colors) {
        if (start.equals(end)) {
            return true;
        }
        colors.put(start, G);
        final Set<Edge> edges = graph.getEdges(start);
        if (edges == null) {
            return false;
        }
        for (final Edge edge : edges) {
            if (edge.dst.equals(parent)) {
                continue;
            }
            if (colors.containsKey(edge.dst) && colors.get(edge.dst) == G) {
                return false;
            }
            if (colors.containsKey(edge.dst)) {
                continue;
            }

            final boolean childValue = dfs(edge.dst, end, start, graph, colors);
            if (childValue) {
                value *= edge.weight;
                return true;
            } else {
                return false;
            }
        }

        colors.put(start, B);
        return false;
    }

    private static final class Graph {
        private final Map<String, Set<Edge>> edges = new HashMap<>();
        private final Set<String> nodes = new HashSet<>();

        private void addEdge(final String src, final String dst, final double weight) {
            this.edges.computeIfAbsent(src, k -> new HashSet<>()).add(new Edge(src, dst, weight));
            this.edges.computeIfAbsent(dst, k -> new HashSet<>()).add(new Edge(dst, src, 1 / weight));
            this.nodes.add(src);
            this.nodes.add(dst);
        }

        private Set<Edge> getEdges(final String src) {
            return this.edges.get(src);
        }

        private boolean isNodeExists(final String node) {
            return this.nodes.contains(node);
        }
    }

    private static final class Edge {
        private final String src;
        private final String dst;
        private final double weight;

        public Edge(String src, String dst, double weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }
}
