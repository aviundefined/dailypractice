package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


/**
 * We have n cities and m bi-directional roads where roads[i] = [ai, bi] connects city ai with city bi. Each city has a name consisting of exactly 3 upper-case English letters given in the string array names. Starting at any city x, you can reach any city y where y != x (i.e. the cities and the roads are forming an undirected connected graph).
 * <p>
 * You will be given a string array targetPath. You should find a path in the graph of the same length and with the minimum edit distance to targetPath.
 * <p>
 * You need to return the order of the nodes in the path with the minimum edit distance, The path should be of the same length of targetPath and should be valid (i.e. there should be a direct road between ans[i] and ans[i + 1]). If there are multiple answers return any one of them.
 * <p>
 * The edit distance is defined as follows:
 * <p>
 * <p>
 * <p>
 * Follow-up: If each node can be visited only once in the path, What should you change in your solution?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 5, roads = [[0,2],[0,3],[1,2],[1,3],[1,4],[2,4]], names = ["ATL","PEK","LAX","DXB","HND"], targetPath = ["ATL","DXB","HND","LAX"]
 * Output: [0,2,4,2]
 * Explanation: [0,2,4,2], [0,3,0,2] and [0,3,1,2] are accepted answers.
 * [0,2,4,2] is equivalent to ["ATL","LAX","HND","LAX"] which has edit distance = 1 with targetPath.
 * [0,3,0,2] is equivalent to ["ATL","DXB","ATL","LAX"] which has edit distance = 1 with targetPath.
 * [0,3,1,2] is equivalent to ["ATL","DXB","PEK","LAX"] which has edit distance = 1 with targetPath.
 * Example 2:
 * <p>
 * <p>
 * Input: n = 4, roads = [[1,0],[2,0],[3,0],[2,1],[3,1],[3,2]], names = ["ATL","PEK","LAX","DXB"], targetPath = ["ABC","DEF","GHI","JKL","MNO","PQR","STU","VWX"]
 * Output: [0,1,0,1,0,1,0,1]
 * Explanation: Any path in this graph has edit distance = 8 with targetPath.
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: n = 6, roads = [[0,1],[1,2],[2,3],[3,4],[4,5]], names = ["ATL","PEK","LAX","ATL","DXB","HND"], targetPath = ["ATL","DXB","HND","DXB","ATL","LAX","PEK"]
 * Output: [3,4,5,4,3,2,1]
 * Explanation: [3,4,5,4,3,2,1] is the only path with edit distance = 0 with targetPath.
 * It's equivalent to ["ATL","DXB","HND","DXB","ATL","LAX","PEK"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 100
 * m == roads.length
 * n - 1 <= m <= (n * (n - 1) / 2)
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * The graph is guaranteed to be connected and each pair of nodes may have at most one direct road.
 * names.length == n
 * names[i].length == 3
 * names[i] consists of upper-case English letters.
 * There can be two cities with the same name.
 * 1 <= targetPath.length <= 100
 * targetPath[i].length == 3
 * targetPath[i] consists of upper-case English letters.
 */
public class TheMostSimilarPathInAGraph {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        if (n == 0 || roads == null || roads.length == 0 || names == null || targetPath.length == 0) {
            return Collections.emptyList();
        }


        final Graph graph = new Graph();
        for (int i = 0; i < n; i++) {
            graph.addNode(i);
        }
        for (final int[] road : roads) {
            graph.addEdge(road[0], road[1]);
        }

        // previous node to reach ith city at j index
        final int pathLength = targetPath.length;
        final int[][] path = new int[n][pathLength];
        // how many edits are required to reach ith city and jth index in target path
        final int[][] numEdits = new int[n][pathLength];
        final PriorityQueue<City> q = new PriorityQueue<>((a, b) -> {
            if (numEdits[a.city][a.pathIndex] == numEdits[b.city][b.pathIndex]) {
                return b.pathIndex - a.pathIndex;
            }
            return numEdits[a.city][a.pathIndex] - numEdits[b.city][b.pathIndex];
        });
        for (int i = 0; i < n; i++) {
            Arrays.fill(numEdits[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            // consider each city as starting city and update number of edits to 0 if name matches else 1
            numEdits[i][0] = targetPath[0].equals(names[i]) ? 0 : 1;
            q.offer(new City(i, 0));
        }

        while (!q.isEmpty()) {
            // remove mark* work add*
            final City curr = q.poll();
            if (curr.pathIndex == pathLength - 1) {
                break;
            }
            // get neighbours and try things for next pathIndex
            for (final int nextCity : graph.getNeighbours(curr.city)) {
                final int nextPathIndex = curr.pathIndex + 1;
                final String cityName = targetPath[nextPathIndex];
                final int edits = numEdits[curr.city][curr.pathIndex] + (cityName.equals(names[nextCity]) ? 0 : 1);
                if (edits < numEdits[nextCity][nextPathIndex]) {
                    numEdits[nextCity][nextPathIndex] = edits;
                    path[nextCity][nextPathIndex] = curr.city;
                    q.offer(new City(nextCity, nextPathIndex));
                }
            }
        }
        //     print(path, "path");
        //      print(numEdits, "number of edits");

        // iterate over num edits matrix last column and check for minimum edit distance value and that will be
        // our last city to process now using that get the previous city using path matrix
        int minEditDistance = Integer.MAX_VALUE;
        int lastCity = -1;
        for (int i = 0; i < n; i++) {
            if (numEdits[i][pathLength - 1] < minEditDistance) {
                minEditDistance = numEdits[i][pathLength - 1];
                lastCity = i;
            }
        }
        final List<Integer> result = new ArrayList<>();
        for (int i = pathLength - 1; i >= 0; i--) {
            result.add(lastCity);
            lastCity = path[lastCity][i];
        }
        Collections.reverse(result);
        return result;
    }

    private void print(final int[][] matrix, final String tag) {
        System.out.printf("--------- %s -----------\n", tag);
        for (final int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }


    private static final class City {
        private final int city;
        private final int pathIndex;

        private City(int city, int pathIndex) {
            this.city = city;
            this.pathIndex = pathIndex;
        }
    }


    private static final class Graph {
        private final Map<Integer, Set<Integer>> edges = new HashMap<>();
        private final Set<Integer> nodes = new HashSet<>();

        private void addEdge(final int src, final int dst) {
            this.edges.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
            this.edges.computeIfAbsent(dst, k -> new HashSet<>()).add(src);
            this.nodes.add(src);
            this.nodes.add(dst);
        }

        private void addNode(final int node) {
            this.edges.putIfAbsent(node, new HashSet<>());
            this.nodes.add(node);
        }

        private Set<Integer> getNeighbours(final int src) {
            return this.edges.getOrDefault(src, new HashSet<>());
        }
    }
}
