package com.avi.practice.company.fb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by navinash on 03/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AlienDictionary {

    private static final int GREY = 1;
    private static final int BLACK = 2;

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        final GraphDirected graph = new GraphDirected();
        final Set<Character> allChars = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) {
            final String currWord = words[i];
            final String nextWord = words[i + 1];
            updateGraph(currWord, nextWord, graph, allChars);
        }

        // one edge case - if graph is empty then that means all word are same and in order the just return the last word
        if (graph.getAllNodes().size() == 0) {
            return words[words.length - 1];
        }
        return topologicalSort(graph, allChars);
    }

    private String topologicalSort(GraphDirected graph, Set<Character> allChars) {
        final Stack<Character> s = new Stack<>();
        final Map<Character, Integer> nodeColors = new HashMap<>();
        for (final Character node : allChars) {
            if (nodeColors.containsKey(node)) {
                continue;
            }
            if (dfs(node, graph, s, nodeColors)) {
                return "";
            }
        }
        final StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    private boolean dfs(final Character node, GraphDirected graph, Stack<Character> s, Map<Character, Integer> nodeColors) {
        nodeColors.put(node, GREY);
        for (final Character nxt : graph.getNeighbours(node)) {
            if (nodeColors.containsKey(nxt) && nodeColors.get(nxt) == GREY) {
                return true;
            }
            if (!nodeColors.containsKey(nxt)) {
                if (dfs(nxt, graph, s, nodeColors)) {
                    return true;
                }
            }
        }
        s.push(node);
        nodeColors.put(node, BLACK);
        return false;
    }

    private void updateGraph(String currWord, String nextWord, GraphDirected graph, Set<Character> allChars) {
        int i;
        for (i = 0; i < currWord.length() && i < nextWord.length(); i++) {
            final char c1 = currWord.charAt(i);
            final char c2 = nextWord.charAt(i);
            allChars.add(c2);
            allChars.add(c1);
            if (c1 == c2) {
                continue;
            }
            graph.addEdge(c1, c2);
            break;
        }
        for(int j = i; j < currWord.length(); j++) {
            allChars.add(currWord.charAt(j));
        }

        for(int j = i; j < nextWord.length(); j++) {
            allChars.add(nextWord.charAt(j));
        }
    }

    private static final class GraphDirected {
        private final Map<Character, Set<Character>> adjList = new HashMap<>();
        private final Set<Character> nodes = new HashSet<>();

        private void addEdge(final Character src, final Character next) {
            this.adjList.computeIfAbsent(src, k -> new HashSet<>()).add(next);
            this.nodes.add(src);
            this.nodes.add(next);
        }

        private Set<Character> getNeighbours(final Character src) {
            return this.adjList.getOrDefault(src, new HashSet<>());
        }

        private Set<Character> getAllNodes() {
            return this.nodes;
        }
    }
}
