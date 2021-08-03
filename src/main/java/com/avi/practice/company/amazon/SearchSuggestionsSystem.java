package com.avi.practice.company.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by navinash on 03/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SearchSuggestionsSystem {

    private static final int MAX = 3;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if(products == null
                || products.length == 0
                || searchWord == null
                || searchWord.length() == 0
                || "".equals(searchWord.trim())) {
            return Collections.emptyList();
        }
        final Trie trie = new Trie();
        for(final String word : products) {
            trie.add(word);
        }
        final List<List<String>> result = new ArrayList<>();
        String prefix = "";
        for(final char c : searchWord.toCharArray()) {
            prefix += String.valueOf(c);
            final TreeSet<String> words = trie.search(prefix);
            final Iterator<String> itr = words.iterator();
            int count = 0;
            final List<String> current = new ArrayList<>();
            while(count < MAX && itr.hasNext()) {
                current.add(itr.next());
                count++;
            }
            result.add(current);
        }
        return result;
    }

    private static final class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private boolean isEndWord = false;
        private final TreeSet<String> words = new TreeSet<>();
    }

    private static final class Trie {
        private final TrieNode root = new TrieNode();

        private void add(final String word) {
            if(word == null || word.length() == 0 || "".equals(word.trim())) {
                return;
            }

            TrieNode current = root;
            for(final char c : word.toCharArray()) {
                final int index = c - 'a';
                if(current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current.words.add(word);
                current = current.children[index];
            }
            current.isEndWord = true;
            current.words.add(word);
        }

        private TreeSet<String> search(final String prefix) {
            if(prefix == null || prefix.length() == 0) {
                return new TreeSet<>();
            }

            TrieNode current = root;
            for(final char c : prefix.toCharArray()) {
                final int index = c - 'a';
                if(current.children[index] == null) {
                    return new TreeSet<>();
                }
                current = current.children[index];
            }
            return current.words;
        }
    }
}
