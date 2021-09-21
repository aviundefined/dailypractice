package com.avi.practice.company.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        private final TrieNode[] children = new TrieNode[26];
        private final Set<Integer> wordIds = new HashSet<>();
    }

    private static final class Trie {
        private final TrieNode root = new TrieNode();
        private final Map<String, Integer> idByWord = new HashMap<>();
        private final Map<Integer, String> wordById = new HashMap<>();
        private int counter = 0;

        private void addWord(final String word) {
            if (word == null || word.length() == 0 || "".equals(word.trim())) {
                return;
            }
            final boolean isWordAlreadyExist = idByWord.containsKey(word);
            idByWord.put(word, counter);
            wordById.put(counter, word);
            final int id = counter;
            counter++;

            if (isWordAlreadyExist) {
                return;
            }
            TrieNode curr = root;
            for (final char c : word.toLowerCase().toCharArray()) {
                final int childIdx = c - 'a';
                if (curr.children[childIdx] == null) {
                    curr.children[childIdx] = new TrieNode();
                }
                curr.children[childIdx].wordIds.add(id);
                curr = curr.children[childIdx];
            }
        }

        private Set<Integer> prefixSearch(final String prefix) {
            if (prefix == null || prefix.length() == 0 || "".equals(prefix.trim())) {
                return new HashSet<>();
            }

            TrieNode curr = root;
            final Set<Integer> wordIds = new HashSet<>();
            boolean isFound = true;
            for (final char c : prefix.toLowerCase().toCharArray()) {
                final int childIdx = c - 'a';
                if (curr.children[childIdx] == null) {
                    isFound = false;
                    break;
                }
                curr = curr.children[childIdx];
            }
            if (isFound) {
                wordIds.addAll(curr.wordIds);
            }
            return wordIds;
        }

        private int filter(final String prefix, final String suffix) {
            final Set<Integer> wordIds = prefixSearch(prefix);
            if (wordIds.size() == 0) {
                return -1;
            }
            String result = "";
            int maxLen = 0;
            int id = -1;
            for (final int wordId : wordIds) {
                final String word = wordById.get(wordId);
                if (word.endsWith(suffix)) {
                    if (maxLen < word.length()) {
                        result = word;
                        maxLen = word.length();
                        id = idByWord.get(word);
                    } else if (maxLen == word.length() && word.compareTo(result) > 0) {
                        result = word;
                        id = idByWord.get(word);
                    }
                }
            }
            return id;
        }
    }
}
