package com.avi.practice.company.google.course_schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by navinash on 21/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CourseScheduleAllPossibles {


    private final Graph graph = new Graph();
    private final List<List<Integer>> allTopologicalSorts = new ArrayList<>();
    private boolean[] visited;
    private int numCourses;

    public List<List<Integer>> findOrder(int numCourses, int[][] prerequisites) {

        for (int[] preReq : prerequisites) {
            graph.addEdge(preReq[0], preReq[1]);
        }
        this.visited = new boolean[numCourses];
        this.numCourses = numCourses;

        allTopologicalSortPaths(new ArrayList<>());
        return allTopologicalSorts;
    }

    private void allTopologicalSortPaths(List<Integer> curr) {
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] || graph.inDegree(i) != 0) {
                continue;
            }

            curr.add(i);
            visited[i] = true;
            for (final int ngh : graph.getNeighbours(i)) {
                graph.decreaseInDegree(ngh);
            }
            allTopologicalSortPaths(curr);
            curr.remove(curr.size() - 1);
            visited[i] = false;
            for (final int ngh : graph.getNeighbours(i)) {
                graph.increaseInDegree(ngh);
            }
        }

        if (curr.size() == numCourses) {
            allTopologicalSorts.add(new ArrayList<>(curr));
        }
    }

    private static final class Graph {
        private final Map<Integer, Set<Integer>> adjList = new HashMap<>();
        private final Map<Integer, Integer> inDegrees = new HashMap<>();

        private void addEdge(final int src, final int dst) {
            this.adjList.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
            this.inDegrees.compute(dst, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
        }

        private Set<Integer> getNeighbours(final int node) {
            return this.adjList.getOrDefault(node, new HashSet<>());
        }

        private int inDegree(final int node) {
            return inDegrees.getOrDefault(node, 0);
        }

        private void decreaseInDegree(final int node) {
            final int inDegree = inDegrees.getOrDefault(node, 0);
            if (inDegree > 0) {
                inDegrees.put(node, inDegree - 1);
            }
        }

        private void increaseInDegree(final int node) {
            final int inDegree = inDegrees.getOrDefault(node, 0);
            inDegrees.put(node, inDegree + 1);
        }
    }
}
