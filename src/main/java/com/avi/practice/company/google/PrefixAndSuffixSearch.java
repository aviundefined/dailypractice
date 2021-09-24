package com.avi.practice.company.google;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by navinash on 19/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrefixAndSuffixSearch {


    static final class WordFilter {
        private final Trie trie = new Trie();

        public WordFilter(final String[] words) {
            for (final String word : words) {
                trie.addWord(word);
            }
        }

        public int f(final String prefix, final String suffix) {
            return trie.filter(prefix, suffix);
        }
    }

    private static final class TrieNode {
        private final TrieNode[] children = new TrieNode[27];
        private final TreeSet<String> words = new TreeSet<>((a, b) -> {
            if (b.length() != a.length()) {
                return b.length() - a.length();
            }
            return b.compareTo(a);
        });
    }

    private static final class Trie {
        private static final String SEP = "{";
        private final TrieNode root = new TrieNode();
        private final Map<String, Integer> wordIds = new HashMap<>();
        int counter = 0;

        public void addWord(String word) {
            if (word == null || word.length() == 0 || "".equals(word.trim())) {
                return;
            }

            if (wordIds.containsKey(word)) {
                wordIds.put(word, counter);
                counter++;
                return;
            }
            wordIds.put(word, counter);
            counter++;
            // apple
            // {apple
            // e{apple
            // le{apple
            // ple{apple
            // pple{apple
            // apple{apple

            for (int i = word.length(); i >= 0; i--) {
                final String prefix = word.substring(i);
                _addWord(word, prefix + SEP + word);
            }
        }

        public Set<String> search(final String s) {
            TrieNode curr = root;
            for (final char c : s.toCharArray()) {
                final int idx = c - 'a';
                if (curr.children[idx] == null) {
                    return Collections.emptySet();
                }
                curr = curr.children[idx];
            }
            // found the word
            // get ids
            return new TreeSet<>(curr.words);

        }

        private void _addWord(final String word, final String s) {
            TrieNode curr = root;
            for (final char c : s.toCharArray()) {
                final int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();

                }
                curr.children[idx].words.add(word);
                curr = curr.children[idx];
            }
        }

        public int filter(String prefix, String suffix) {
            final Set<String> words = search(suffix + SEP + prefix);
            if (words.size() == 0) {
                return -1;
            }

            return wordIds.get(words.iterator().next());

        }
    }
}
