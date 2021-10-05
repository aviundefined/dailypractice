package com.avi.practice.company.google;

/**
 * Created by navinash on 04/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DesignAddSearchWordsDataStructure {

    static final class WordDictionary {
        private final Trie trie = new Trie();

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {

        }

        private static int index(final char c) {
            return c - 'a';
        }

        public void addWord(String word) {
            trie.add(word);
        }

        public boolean search(String word) {
            return trie.search(word);
        }

        private static final class Trie {
            private final TrieNode root = new TrieNode();

            private void add(final String word) {
                if (word == null || "".equals(word)) {
                    return;
                }

                TrieNode curr = root;
                for (final char c : word.toLowerCase().toCharArray()) {
                    final int idx = index(c);
                    if (curr.children[idx] == null) {
                        curr.children[idx] = new TrieNode();
                    }
                    curr = curr.children[idx];
                }
                curr.isEndWord = true;
            }

            private boolean search(final String word) {
                if (word == null || "".equals(word)) {
                    return false;
                }
                return _search(0, word.toLowerCase().toCharArray(), root);
            }

            private boolean _search(final int index, final char[] chars, final TrieNode curr) {
                if (curr == null) {
                    return false;
                }
                if (index >= chars.length) {
                    return curr.isEndWord;
                }

                // current can be "."
                if (chars[index] == '.') {
                    for (final TrieNode child : curr.children) {
                        if (child != null) {
                            final boolean found = _search(index + 1, chars, child);
                            if (found) {
                                return true;
                            }
                        }
                    }
                } else {
                    final int idx = index(chars[index]);
                    if (curr.children[idx] == null) {
                        return false;
                    }
                    return _search(index + 1, chars, curr.children[idx]);
                }
                return false;
            }
        }

        private static final class TrieNode {
            private final TrieNode[] children = new TrieNode[26];
            private boolean isEndWord = false;
        }
    }
}
