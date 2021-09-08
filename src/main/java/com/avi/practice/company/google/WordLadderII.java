package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.Collections;
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

    private static final String marker = "";

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        boolean isStartWordInDict = false;
        boolean isEndWordDict = false;

        final Set<String> dict = new HashSet<>(wordList);
        final Graph graph = buildGraph2(wordList);
        for (final String word : wordList) {
            if (!isStartWordInDict && beginWord.equals(word)) {
                isStartWordInDict = true;
            }
            if (!isEndWordDict && endWord.equals(word)) {
                isEndWordDict = true;
            }
        }

        if (!isEndWordDict) {
            return Collections.emptyList();
        }
        if (!isStartWordInDict) {
            updateGraph2(wordList, beginWord, graph);
        }
        final Set<String> visited = new HashSet<>();

        int minDistance = 1;
        final Queue<String> q = new LinkedList<>();

        q.offer(beginWord);

        q.offer(marker);
        while (!q.isEmpty()) {
            // remove mark* work add*
            final String curr = q.poll();
            if (curr.equals(marker)) {
                if (!q.isEmpty()) {
                    q.offer(marker);
                    minDistance++;
                }
                continue;
            }
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            if (curr.equals(endWord)) {
                break;
            }
            for (final String nextWord : graph.getNeighbours(curr)) {
                if (visited.contains(nextWord)) {
                    continue;
                }
                q.offer(nextWord);
            }
        }

        final List<List<String>> result = new ArrayList<>();
        visited.clear();
        dfs(graph, beginWord, endWord, new ArrayList<>(), minDistance, visited, result);
        return result;
    }

    private void updateGraph(Set<String> dict, Graph graph) {
        for (final String word : dict) {
            final StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                final char curr = word.charAt(i);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (curr == c) {
                        continue;
                    }
                    sb.setCharAt(i, c);
                    final String newWord = sb.toString();
                    if (dict.contains(newWord)) {
                        graph.addEdge(word, newWord);
                    }
                }
            }
        }
    }

    private void updateGraph2(List<String> wordList, final String beginWord, Graph graph) {
        for (final String word : wordList) {
            if (isOneCharDiff(beginWord, word)) {
                graph.addEdge(beginWord, word);
            }
        }
    }

    private Graph buildGraph(Set<String> dict) {
        final Graph graph = new Graph();
        for (final String word : dict) {
            final StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                final char curr = word.charAt(i);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (curr == c) {
                        continue;
                    }
                    sb.setCharAt(i, c);
                    final String newWord = sb.toString();
                    if (dict.contains(newWord)) {
                        graph.addEdge(word, newWord);
                    }
                }
            }
        }
        return graph;
    }

    private Graph buildGraph2(List<String> wordList) {
        final Graph graph = new Graph();
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (isOneCharDiff(wordList.get(i), wordList.get(j))) {
                    graph.addEdge(wordList.get(i), wordList.get(j));
                }
            }
        }
        return graph;
    }

    private void dfs(
            final Graph graph,
            String beginWord,
            String endWord,
            ArrayList<String> curr,
            int minDistance,
            Set<String> visited,
            List<List<String>> result) {
        if (visited.contains(beginWord)) {
            return;
        }
        if (curr.size() > minDistance) {
            return;
        }
        if (beginWord.equals(endWord)) {
            if (curr.size() == minDistance - 1) {
                curr.add(beginWord);
                result.add(new ArrayList<>(curr));
                curr.remove(curr.size() - 1);
            }
            return;
        }
        visited.add(beginWord);
        curr.add(beginWord);
        for (final String nextWord : graph.getNeighbours(beginWord)) {
            if (visited.contains(nextWord)) {
                continue;
            }
            dfs(graph, nextWord, endWord, curr, minDistance, visited, result);
        }
        visited.remove(beginWord);
        curr.remove(curr.size() - 1);
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
