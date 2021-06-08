package com.avi.practice.leetcode.problems.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * Example 2:
 * <p>
 * <p>
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 */
public class WordSearch2 {
    private static final int[][] directions = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };

    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || board == null || words.length == 0 || board.length == 0) {
            return Collections.emptyList();
        }
        /*
         *  o   a   a   n
         *  e   t   a   e
         *  i   h   k   r
         *  i   f   l   v
         *
         */
        final Trie trie = new Trie();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                updateTrie(board, trie, i, j);
            }
        }
        final List<String> result = new ArrayList<>();
        for (final String word : words) {
            if (trie.search(word)) {
                result.add(word);
            }
        }
        return result;
    }

    private void updateTrie(char[][] board, Trie trie, int i, int j) {
        final Set<Cell> visited = new HashSet<>();
        final Queue<Cell> q = new ArrayDeque<>();
        final Map<Cell, String> map = new HashMap<>();
        q.offer(new Cell(i, j, null));
        while (!q.isEmpty()) {
            // remove mark* work add*
            final Cell curr = q.poll();
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            final String word = curr.via == null ? String.valueOf(board[i][j]) : map.get(curr.via) + String.valueOf(board[i][j]);
            trie.insert(word);
            map.put(curr, word);
            for (final int[] direction : directions) {
                final int row = curr.row + direction[0];
                final int col = curr.col + direction[1];
                if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
                    continue;
                }
                final Cell cell = new Cell(row, col, curr);
                if (visited.contains(cell)) {
                    continue;
                }
                q.add(cell);
            }
        }
    }

    private static final class Cell {
        private final Cell via;
        private final int row;
        private final int col;

        private Cell(int row, int cell, Cell via) {
            this.row = row;
            this.col = cell;
            this.via = via;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell1 = (Cell) o;
            return row == cell1.row &&
                    col == cell1.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    private static final class Trie {
        private final TrieNode root;

        private Trie() {
            this.root = new TrieNode();
        }

        private void insert(final String word) {
            if (word == null || word.equals("")) {
                return;
            }
            TrieNode node = root;
            for (final char c : word.toLowerCase().toCharArray()) {
                node = node.getOrCreate(c);
            }
            node.markEndWord();
        }

        private boolean search(final String word) {
            if (word == null || word.equals("")) {
                return false;
            }
            TrieNode node = root;
            for (final char c : word.toLowerCase().toCharArray()) {
                TrieNode child = node.getChild(c);
                if (child == null) {
                    return false;
                }
                node = child;
            }
            return node.isEndWord();
        }
    }

    private static final class TrieNode {
        private static final int NUM_CHILDREN = 26;
        private final TrieNode[] children = new TrieNode[NUM_CHILDREN];
        private boolean isEndWord;

        private static int index(final char c) {
            return c - 'a';
        }

        private static char value(final int index) {
            return (char) (index + 'a');
        }

        private TrieNode getOrCreate(final char c) {
            final int index = index(c);
            if (this.children[index] == null) {
                this.children[index] = new TrieNode();
            }
            return this.children[index];
        }

        private TrieNode getChild(final char c) {
            return this.children[index(c)];
        }

        private void markEndWord() {
            this.isEndWord = true;
        }

        private void unMarkEndWord() {
            this.isEndWord = true;
        }

        private boolean isEndWord() {
            return this.isEndWord;
        }

        private boolean isLeaf() {
            for (final TrieNode n : children) {
                if (n != null) {
                    return false;
                }
            }
            return true;
        }

    }
}
