package com.avi.practice.game.jump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 * <p>
 * In one step you can jump from index i to index:
 * <p>
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 * Return the minimum number of steps to reach the last index of the array.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 * Example 2:
 * <p>
 * Input: arr = [7]
 * Output: 0
 * Explanation: Start index is the last index. You don't need to jump.
 * Example 3:
 * <p>
 * Input: arr = [7,6,9,6,9,6,9,7]
 * Output: 1
 * Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 * Example 4:
 * <p>
 * Input: arr = [6,1,9]
 * Output: 2
 * Example 5:
 * <p>
 * Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 5 * 104
 * -108 <= arr[i] <= 108
 */
public class JumpGameIV {

    private static final int marker = -1;

    public int minJumps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        final int n = arr.length;
        final Graph graph = new Graph();
        for (int i = 0; i < n; i++) {
            graph.addEdge(arr[i], i);
        }

        final Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        q.offer(-1);
        int jumps = 0;
        final boolean[] visited = new boolean[n];

        while (!q.isEmpty()) {
            // remove mark* work add*
            final int curr = q.poll();
            if (curr == marker) {
                if (!q.isEmpty()) {
                    q.offer(marker);
                    jumps++;
                }
            } else {
                if (visited[curr]) {
                    continue;
                }
                visited[curr] = true;
                if (curr == n - 1) {
                    return jumps;
                }
                for (final int next : graph.getNeighbours(arr[curr])) {
                    if (visited[next]) {
                        continue;
                    }
                    q.offer(next);
                }
                if (curr + 1 < n && !visited[curr + 1]) {
                    q.offer(curr + 1);
                }
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    q.offer(curr - 1);
                }
                graph.clear(arr[curr]);
            }
        }
        return -1;
    }


    private static final class Graph {
        private final Map<Integer, Set<Integer>> adjList = new HashMap<>();

        private void addEdge(final int src, final int dst) {
            this.adjList.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
        }

        private Set<Integer> getNeighbours(final int node) {
            return this.adjList.getOrDefault(node, new HashSet<>());
        }

        private void clear(final int node) {
            this.adjList.get(node).clear();
        }
    }
}
