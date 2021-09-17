package com.avi.pepcoding.graph.union_find;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by navinash on 17/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        final Map<Integer, Integer> counterByValue = new HashMap<>();
        int counter = 0;
        for (final int num : nums) {
            if (!counterByValue.containsKey(num)) {
                counterByValue.put(num, counter);
                counter++;
            }
        }
        final Set<Integer> visited = new HashSet<>();
        final DSU dsu = new DSU(counter);
        for (final int num : nums) {
            final int node1 = counterByValue.get(num);
            if (visited.contains(node1)) {
                continue;
            }
            visited.add(node1);
            // check for it's edges
            if (counterByValue.containsKey(num - 1)) {
                final int prevNode = counterByValue.get(num - 1);
                dsu.union(node1, prevNode);
            }
            if (counterByValue.containsKey(num + 1)) {
                final int nextNode = counterByValue.get(num + 1);
                dsu.union(node1, nextNode);
            }
        }
        return dsu.getMaxCount();
    }

    private static final class DSU {
        private final int[] parent;
        private final int[] rank;
        private final int[] counts;

        private DSU(final int size) {
            this.parent = new int[size];
            this.rank = new int[size];
            this.counts = new int[size];
            for (int i = 0; i < size; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
                this.counts[i] = 1;
            }
        }

        private int find(final int node) {
            if (parent[node] == node) {
                return node;
            }
            final int tmp = find(parent[node]);
            parent[node] = tmp;
            return tmp;
        }

        private boolean union(final int node1, final int node2) {
            final int parent1 = find(node1);
            final int parent2 = find(node2);
            if (parent1 == parent2) {
                return false;
            }

            if (this.rank[parent1] > this.rank[parent2]) {
                this.parent[parent2] = parent1;
                this.counts[parent1] += this.counts[parent2];
            } else if (this.rank[parent1] < this.rank[parent2]) {
                this.parent[parent1] = parent2;
                this.counts[parent2] += this.counts[parent1];
            } else {
                this.parent[parent2] = parent1;
                this.counts[parent1] += this.counts[parent2];
                this.rank[parent1]++;
            }
            return true;
        }

        private int getMaxCount() {
            int max = 1;
            for (final int count : this.counts) {
                max = Math.max(count, max);
            }
            return max;
        }
    }
}
