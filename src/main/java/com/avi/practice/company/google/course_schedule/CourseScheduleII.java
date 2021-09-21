package com.avi.practice.company.google.course_schedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by navinash on 21/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CourseScheduleII {

    private static final int W = 0;
    private static final int G = 1;
    private static final int B = 2;

    private final Graph graph = new Graph();
    private final Map<Integer, Integer> colors = new HashMap<>();
    private final Stack<Integer> st = new Stack<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for(final int[] prereq : prerequisites) {
            graph.addEdge(prereq[0], prereq[1]);
        }


        for(int i = 0; i < numCourses; i++) {
            if(colors.containsKey(i)) {
                continue;
            }
            final boolean isPossible = dfs(i);
            if(!isPossible) {
                return new int[]{};
            }
        }
        final int[] result = new int[st.size()];
        int i = st.size() - 1;
        while(i >= 0) {
            result[i] = st.pop();
            i--;
        }
        return result;
    }


    private boolean dfs(final int node) {
        colors.put(node, G);
        for(final int ngh : graph.getNeighbours(node)) {
            if(colors.containsKey(ngh)) {
                final int color = colors.get(ngh);
                if(color == G) {
                    return false;
                }
                continue;
            }
            final boolean isCycle = dfs(ngh);
            if(!isCycle) {
                return false;
            }
        }
        colors.put(node, B);
        st.push(node);
        return true;
    }

    private static final class Graph {
        private Map<Integer, Set<Integer>> adjList = new HashMap<>();

        private void addEdge(final int src, final int dst) {
            this.adjList.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
        }

        private Set<Integer> getNeighbours(final int node) {
            return this.adjList.getOrDefault(node, new HashSet<>());
        }
    }
}
