package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by navinash on 17/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class AutocompleteSystem {

    private static final int MAX_RESULT = 3;

    private final Trie trie = new Trie();
    private final Map<String, Sentence> sentenceMap = new HashMap<>();
    private final StringBuilder currentPrefix = new StringBuilder();


    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            final Sentence sentence = new Sentence(sentences[i], times[i]);
            trie.add(sentence);
            sentenceMap.put(sentences[i], sentence);
        }
    }

    private static int index(final char c) {
        if (c == ' ') {
            return 0;
        }
        return c - 'a' + 1;
    }

    public List<String> input(char c) {
        if (c != '#') {
            currentPrefix.append(c);
            final Set<Sentence> sentences = trie.get(currentPrefix.toString());
            if (sentences == null || sentences.size() == 0) {
                return Collections.emptyList();
            }
            final List<String> result = new ArrayList<>();
            int count = 0;
            final Iterator<Sentence> itr = sentences.iterator();
            while (count < MAX_RESULT && itr.hasNext()) {
                result.add(itr.next().s);
                count++;
            }
            return result;
        }

        final String s = currentPrefix.toString();
        currentPrefix.setLength(0);
        // check if s already exists then remove it from each of it's prefixes and update new
        final Sentence oldSentence;
        final Sentence newSentence;
        if (sentenceMap.containsKey(s)) {
            oldSentence = sentenceMap.get(s);
            newSentence = new Sentence(s, oldSentence.count + 1);
        } else {
            oldSentence = null;
            newSentence = new Sentence(s, 1);
        }
        sentenceMap.put(s, newSentence);
        trie.update(oldSentence, newSentence);
        return Collections.emptyList();
    }

    private static final class Sentence implements Comparable<Sentence> {
        private final String s;
        private final int count;

        public Sentence(String s, int count) {
            this.s = s;
            this.count = count;
        }

        @Override
        public int compareTo(Sentence o) {
            if (this.count == o.count) {
                return this.s.compareTo(o.s);
            }
            return o.count - this.count;
        }
    }

    private static final class Trie {
        TrieNode root = new TrieNode();

        private void add(final Sentence sentence) {
            update(null, sentence);
        }

        private void update(final Sentence oldSentence, final Sentence newSentence) {
            // first is space + 26 alphabets
            TrieNode current = root;
            for (final char c : newSentence.s.toCharArray()) {
                final int idx = index(c);
                if (current.children[idx] == null) {
                    current.children[idx] = new TrieNode();
                }
                if (oldSentence != null) {
                    current.children[idx].sentences.remove(oldSentence);
                }
                current.children[idx].sentences.add(newSentence);
                current = current.children[idx];
            }
        }

        private Set<Sentence> get(final String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return Collections.emptySet();
            }

            TrieNode current = root;

            for (final char c : prefix.toCharArray()) {
                final int idx = index(c);
                if (current.children[idx] == null) {
                    return Collections.emptySet();
                }
                current = current.children[idx];
            }

            if (current == null) {
                return Collections.emptySet();
            }
            return current.sentences;
        }
    }

    private static final class TrieNode {

        private final TrieNode[] children = new TrieNode[27]; // small characters + space
        private final TreeSet<Sentence> sentences = new TreeSet<>();

    }
}
