package com.avi.practice.leetcode.monthly.august2021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.
 * <p>
 * For each house i, we can either build a well inside it directly with cost wells[i - 1] (note the -1 due to 0-indexing), or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes, where each pipes[j] = [house1j, house2j, costj] represents the cost to connect house1j and house2j together using a pipe. Connections are bidirectional.
 * <p>
 * Return the minimum total cost to supply water to all houses.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
 * Output: 3
 * Explanation:
 * The image shows the costs of connecting houses using pipes.
 * The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with cost 2 so the total cost is 3.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 104
 * wells.length == n
 * 0 <= wells[i] <= 105
 * 1 <= pipes.length <= 104
 * pipes[j].length == 3
 * 1 <= house1j, house2j <= n
 * 0 <= costj <= 105
 * house1j != house2j
 */
public class OptimizeWaterDistributionVillage {
    private static final int FAKE_NODE = 0;

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        final Graph graph = new Graph();


        for (final int[] pipe : pipes) {
            //[house1, house2, pipe_cost]
            graph.addEdge(pipe[0], pipe[1], pipe[2]);
            graph.addEdge(pipe[1], pipe[0], pipe[2]);
        }


        for (int i = 0; i < wells.length; i++) {
            //[house1, house2, pipe_cost]
            graph.addEdge(FAKE_NODE, i + 1, wells[i]);
        }
        final Set<Integer> visited = new HashSet<>();

        int cost = 0;

        final PriorityQueue<Tuple> q = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        q.offer(new Tuple(0, -1, 0));

        while (!q.isEmpty()) {
            // remove mark* work add*
            final Tuple curr = q.poll();
            if (visited.contains(curr.node)) {
                continue;
            }
            visited.add(curr.node);
            if (curr.via != -1) {
                cost += curr.cost;
            }
            final List<Edge> edges = graph.getEdges(curr.node);
            for (final Edge edge : edges) {
                if (!visited.contains(edge.dst)) {
                    q.offer(new Tuple(edge.dst, curr.node, edge.weight));
                }
            }
        }
        return cost;
    }

    private static final class Graph {
        private final Map<Integer, List<Edge>> adjList = new HashMap<>();

        private void addEdge(final int src, final int dst, final int weight) {
            this.adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(src, dst, weight));
        }

        private List<Edge> getEdges(final int node) {
            return this.adjList.getOrDefault(node, new ArrayList<>());
        }
    }

    private static final class Edge {
        private final int src;
        private final int dst;
        private final int weight;

        private Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }

    private static final class Tuple {
        private final int node;
        private final int via;
        private final int cost;

        public Tuple(int node, int via, int cost) {
            this.node = node;
            this.via = via;
            this.cost = cost;
        }
    }
}
