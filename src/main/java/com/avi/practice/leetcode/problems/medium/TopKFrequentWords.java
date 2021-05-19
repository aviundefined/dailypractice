package com.avi.practice.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by navinash on 19/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        final Map<String, Word> wordFreqMap = new HashMap<>();
        for (final String word : words) {
            wordFreqMap.compute(word, (w, v) -> {
                if (v == null) {
                    return new Word(word);
                }
                v.inc();
                return v;
            });
        }

        final PriorityQueue<Word> q = new PriorityQueue<>();
        for (final Word word : wordFreqMap.values()) {
            if (q.isEmpty()) {
                q.add(word);
                continue;
            }
            if (q.size() < k) {
                q.add(word);
                continue;
            }
            final Word peek = q.peek();
            if (peek.compareTo(word) < 0) {
                q.poll();
                q.add(word);
            }
        }

        final List<String> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll().word);
        }
        Collections.reverse(result);
        return result;
    }

    private static final class Word implements Comparable<Word> {
        private final String word;
        private int freq;

        private Word(final String word) {
            this.word = word;
            this.freq = 1;
        }

        private void inc() {
            this.freq++;
        }

        public int compareTo(final Word o) {
            if (this.freq != o.freq) {
                return this.freq - o.freq;
            }
            return o.word.compareTo(this.word);
        }
    }
}
