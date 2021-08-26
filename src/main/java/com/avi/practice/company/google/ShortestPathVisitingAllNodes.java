package com.avi.practice.company.google;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by navinash on 25/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ShortestPathVisitingAllNodes {

    public int shortestPathLength(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        final int maxMask = (int) Math.pow(2, arr.length);
        final int[][] distance = new int[maxMask][arr.length];
        for (final int[] row : distance) {
            Arrays.fill(row, -1);
        }
        final Graph graph = new Graph();
        final Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            for (int neighbour : arr[i]) {
                graph.addEdge(i, neighbour);
            }
            final int mask = 1 << i;
            q.offer(new int[]{i, mask});
            distance[mask][i] = 0;
        }


        while (!q.isEmpty()) {
            final int[] curr = q.poll();
            final int mask = curr[1];
            final int node = curr[0];
            if (mask == maxMask - 1) {
                return distance[mask][node];
            }

            for (final int neighbour : graph.getNeighbours(node)) {
                final int newMask = (mask) | (1 << neighbour);
                if (distance[newMask][neighbour] != -1) {
                    continue;
                }
                distance[newMask][neighbour] = distance[mask][node] + 1;
                q.offer(new int[]{neighbour, newMask});
            }
        }
        return 0;
    }

    private static final class Graph {
        private final Map<Integer, Set<Integer>> adjList = new HashMap<>();

        private void addEdge(final int src, final int dst) {
            this.adjList.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
            this.adjList.computeIfAbsent(dst, k -> new HashSet<>()).add(src);
        }

        private Set<Integer> getNeighbours(final int node) {
            return this.adjList.getOrDefault(node, new HashSet<>());
        }
    }
}
