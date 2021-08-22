package com.avi.pepcoding.backtracking.lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 22/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxScore {

    private String[] words;
    private int[] charMap;
    private int[] scores;

    private Result max = new Result(0, Collections.emptyList());

    public Result maxScore(final String[] words, final int[] charMap, final int[] scores) {
        if (words == null || words.length == 0 || charMap == null || scores == null) {
            return new Result(0, Collections.emptyList());
        }
        this.words = words;
        this.charMap = charMap;
        this.scores = scores;

        backtrack(0, 0, new ArrayList<>());
        return max;
    }

    private void backtrack(int index, int score, ArrayList<String> curr) {
        if (index >= words.length) {
            if (score > max.score) {
                max = new Result(score, new ArrayList<>(curr));
            }
            return;
        }

        final Pair pair = canUseWord(words[index]);
        if (pair.canUse) {
            useWords(pair.charCounts);
            curr.add(words[index]);
            backtrack(index + 1, score + score(pair.charCounts), curr);
            unUseWords(pair.charCounts);
            curr.remove(curr.size() - 1);
        }

        backtrack(index + 1, score, curr);
    }

    private int score(int[] charCounts) {
        int score = 0;
        for (int i = 0; i < charCounts.length; i++) {
            score += (charCounts[i] * scores[i]);
        }
        return score;
    }

    private void useWords(final int[] charCounts) {
        for (int i = 0; i < charCounts.length; i++) {
            charMap[i] -= charCounts[i];
        }
    }

    private void unUseWords(final int[] charCounts) {
        for (int i = 0; i < charCounts.length; i++) {
            charMap[i] += charCounts[i];
        }
    }

    private Pair canUseWord(String word) {
        final int[] charCounts = new int[26];
        for (final char c : word.toLowerCase().toCharArray()) {
            final int idx = c - 'a';
            charCounts[idx]++;
            if (charCounts[idx] > charMap[idx]) {
                return new Pair(false);
            }
        }
        final Pair pair = new Pair(true);
        pair.charCounts = charCounts;
        return pair;
    }

     static final class Result {
         final int score;
         final List<String> words;

        private Result(int score, List<String> words) {
            this.score = score;
            this.words = words;
        }

         @Override
         public String toString() {
             return "Result{" +
                     "score=" + score +
                     ", words=" + words +
                     '}';
         }
     }

    private static final class Pair {
        private final boolean canUse;
        private int[] charCounts;

        public Pair(boolean canUse) {
            this.canUse = canUse;
        }
    }
}
