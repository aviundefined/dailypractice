package com.avi.pepcoding.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 25/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxScore {

    private final List<String> set = new ArrayList<>();
    private int max = Integer.MIN_VALUE;

    public Result maxScore(final String[] words, final int[] charMap, final int[] scores) {
        if (words == null || words.length == 0) {
            return new Result(0, Collections.emptyList());
        }

        final List<String> current = new ArrayList<>();
        backtrack(words, 0, 0, charMap, scores, current);
        return new Result(max, set);
    }

    private void backtrack(
            final String[] words,
            final int position,
            final int currentScore,
            final int[] charMap,
            final int[] scores,
            final List<String> current) {
        if (currentScore > max) {
            set.clear();
            max = currentScore;
            set.addAll(new ArrayList<>(current));
        }

        if (position == words.length) {
            return;
        }

        // exclude the current word
        backtrack(words, position + 1, currentScore, charMap, scores, current);
        // include the current word if possible
        final String currentWord = words[position];
        int extraScore = 0;
        boolean include = true;
        for (final char c : currentWord.toLowerCase().toCharArray()) {
            if (charMap[c - 'a'] <= 0) {
                include = false;
            }
            extraScore += scores[c - 'a'];
            charMap[c - 'a']--;
        }
        if (include) {
            current.add(currentWord);
            backtrack(words, position + 1, currentScore + extraScore, charMap, scores, current);
            current.remove(current.size() - 1);
        }
        for (final char c : currentWord.toLowerCase().toCharArray()) {
            charMap[c - 'a']++;
        }
    }

    static final class Result {
        private final int score;
        private final List<String> words;

        public Result(int score, List<String> words) {
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


}
