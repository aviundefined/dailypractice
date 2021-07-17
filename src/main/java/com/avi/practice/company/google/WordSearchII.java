package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by navinash on 17/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class WordSearchII {

    private final static int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };

    private static int index(final char c) {
        return c - 'a';
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (words == null
                || words.length == 0
                || board == null
                || board.length == 0) {
            return Collections.emptyList();
        }
        final Trie trie = new Trie();
        for (final String word : words) {
            trie.addWord(word);
        }
        final Set<String> result = new HashSet<>();
        final boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (trie.root.getChild(board[i][j]) != null) {
                    backtracking(i, j, board, visited, trie.root, result);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void backtracking(int i, int j, char[][] board, boolean[][] visited, TrieNode parent, Set<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j] || parent.getChild(board[i][j]) == null) {
            return;
        }

        final TrieNode child = parent.getChild(board[i][j]);
        if (child.word != null) {
            result.add(child.word);
        }
        visited[i][j] = true;
        for (final int[] dir : dirs) {
            final int newI = i + dir[0];
            final int newJ = j + dir[1];
            if (newI < 0 || newJ < 0 || newI >= board.length || newJ >= board[newI].length || visited[newI][newJ] || child.getChild(board[newI][newJ]) == null) {
                continue;
            }
            backtracking(newI, newJ, board, visited, child, result);
        }
        visited[i][j] = false;
    }

    private static final class Trie {
        private final TrieNode root = new TrieNode();

        private void addWord(final String word) {
            if (word == null || word.length() == 0 || "".equals(word.trim())) {
                return;
            }

            TrieNode current = root;
            for (final char c : word.toLowerCase().toCharArray()) {
                final int idx = index(c);
                if (current.children[idx] == null) {
                    current.children[idx] = new TrieNode();
                }
                current = current.children[idx];
            }
            current.isEndWord = true;
            current.word = word;
        }

    }

    private static final class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private boolean isEndWord = false;
        private String word;

        private TrieNode getChild(final char c) {
            return this.children[index(c)];
        }
    }
}
