package com.avi.practice.company.google;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by navinash on 01/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NumberMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        // create a Map of first letter -> and all words strating from that
        final Map<Character, Queue<String>> map = new HashMap<>();
        for(final String word : words) {
            map.computeIfAbsent(word.charAt(0), k -> new ArrayDeque<>()).offer(word);
        }
        int count = 0;
        for(final char c : s.toCharArray()) {
            final Queue<String> q = map.remove(c);
            if(q == null || q.isEmpty()) {
                continue;
            }
            final Queue<String> copyQ = new ArrayDeque<>(q);
            while(!copyQ.isEmpty()) {
                // poll element from queue
                final String word = copyQ.poll();
                if(word.length() == 1) {
                    count++;
                }else {
                    map.computeIfAbsent(word.charAt(1), k -> new ArrayDeque<>()).offer(word.substring(1));
                }
            }
        }
        return count;
    }

    public int numMatchingSubseq_BruteFroce(String s, String[] words) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for(final String word : words) {
            if(canMatched(s, word, 0, 0)) {
                count++;
            }
        }
        return count;
    }

    private boolean canMatched(
            final String bigWord,
            final String smallWord,
            final int bigIdx,
            final int smallIdx) {
        if(bigIdx >= bigWord.length() && smallIdx < smallWord.length()) {
            return false;
        }

        if(smallIdx >= smallWord.length()) {
            return true;
        }

        if(bigWord.charAt(bigIdx) == smallWord.charAt(smallIdx)) {
            return canMatched(bigWord, smallWord, bigIdx + 1, smallIdx + 1);
        }else {
            return canMatched(bigWord, smallWord, bigIdx + 1, smallIdx);
        }
    }
}
