package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by navinash on 24/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class WordLadderII {

    private static final Pair marker = new Pair("", -1);

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        boolean isStartWordInDict = false;
        final Graph graph = new Graph();
        for (int i = 0; i < wordList.size(); i++) {
            if (beginWord.equals(wordList.get(i))) {
                isStartWordInDict = true;
            }
            for (int j = 0; j < wordList.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (isOneCharDiff(wordList.get(i), wordList.get(j))) {
                    graph.addEdge(wordList.get(i), wordList.get(j));
                }
            }
        }
        if (!isStartWordInDict) {
            for (final String word : wordList) {
                if (isOneCharDiff(beginWord, word)) {
                    graph.addEdge(beginWord, word);
                }
            }
        }
        final Set<String> visited = new HashSet<>();
        final List<List<String>> result = new ArrayList<>();
        int distance = isStartWordInDict ? 0 : 1;
        final Queue<Pair> q = new LinkedList<>();
        final Pair start = new Pair(beginWord, distance);
        final List<String> startPath = new ArrayList<>();
        startPath.add(beginWord);
        start.addPath(distance, startPath);
        q.offer(start);
        q.offer(marker);
        int minDistance = -1;
        while (!q.isEmpty()) {
            // remove mark* work add*
            final Pair curr = q.poll();
            if (marker.node.equals(curr.node)) {
                if (!q.isEmpty()) {
                    q.offer(marker);
                    distance++;
                }
            } else {
                if (endWord.equals(curr.node)) {
                    if (minDistance == -1) {
                        minDistance = curr.distance;
                        final List<List<String>> paths = curr.paths.get(curr.distance);
                        for(final List<String> path : paths) {
                            result.add(new ArrayList<>(path));
                        }
                    } else if (minDistance == curr.distance) {
                        final List<List<String>> paths = curr.paths.get(curr.distance);
                        for(final List<String> path : paths) {
                            result.add(new ArrayList<>(path));
                        }
                    }
                    continue;
                }
                if (visited.contains(curr.node)) {
                    continue;
                }
                visited.add(curr.node);
                for (final String next : graph.getNeighbours(curr.node)) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    final Pair nextWord = new Pair(next, distance);

                }
            }
        }
        return result;
    }


    private boolean isOneCharDiff(final String word1, final String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int delta = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                delta++;
            }
            if (delta > 1) {
                return false;
            }
        }
        return delta == 1;
    }

    private final static class Pair {
        private final String node;
        private final Map<Integer, List<List<String>>> paths = new HashMap<>();
        private final int distance;

        private Pair(final String node, final int distance) {
            this.node = node;
            this.distance = distance;
        }

        private void addPath(final int level, final List<String> path) {
            this.paths.computeIfAbsent(level, k -> new ArrayList<>()).add(path);
        }
    }

    private static final class Graph {
        private final Map<String, Set<String>> adjList = new HashMap<>();

        private void addEdge(final String src, final String dst) {
            this.adjList.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
            this.adjList.computeIfAbsent(dst, k -> new HashSet<>()).add(src);
        }

        private Set<String> getNeighbours(final String src) {
            return adjList.getOrDefault(src, new HashSet<>());
        }
    }
}
