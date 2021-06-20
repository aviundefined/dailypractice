package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 19/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TextJustification {

    private static int score(final int lengthConsumed, final int maxWidth) {
        return (int) (Math.pow((maxWidth - lengthConsumed), 2));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }
        if (words.length == 1) {
            return Collections.singletonList(words[0]);
        }

        final int n = words.length;
        // define badness of each line is we try to fit ith to jth word in that -> badness[i][j]

        final BadnessScore[][] badness = new BadnessScore[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                // try to fit word from i to j in single line
                if (gap == 0) {
                    final int length = words[i].length();
                    final int score = score(length, maxWidth);
                    badness[i][j] = new BadnessScore(score, length, length);
                } else {
                    // get current word length, i.e. jth word
                    final int currentWordLength = words[j].length();
                    final int lastLength = badness[i][j - 1].length;
                    final int lastWordLength = badness[i][j - 1].wordLength;
                    final int length = lastLength + currentWordLength + 1;
                    final int wordLength = lastWordLength + currentWordLength;
                    if (length > maxWidth) {
                        badness[i][j] = new BadnessScore(Integer.MAX_VALUE, maxWidth, wordLength);
                    } else {
                        final int score = score(length, maxWidth);
                        badness[i][j] = new BadnessScore(score, length, wordLength);
                    }
                }
            }
        }

//        for (final BadnessScore[] row : badness) {
//            System.out.println(Arrays.toString(row));
//        }

        final int[] cost = new int[n]; // stores cost to fit [i,j] words in one line
        final int[] indexes = new int[n]; // stores the last index what stored for stat index

        final int j = n - 1;
        cost[j] = badness[j][j].score;
        indexes[j] = j + 1;
        for (int i = j - 1; i >= 0; i--) {
            cost[i] = badness[i][j].score;
            indexes[i] = j + 1;
            for (int k = i; k < j; k++) {
                if (badness[i][k].score != Integer.MAX_VALUE) {
                    final int currentCost = (badness[i][k].score + cost[k + 1]);
                    if (currentCost < cost[i]) {
                        cost[i] = currentCost;
                        indexes[i] = k + 1;
                    }
                }
            }
        }
        //    System.out.println("Cost: " + Arrays.toString(cost));
        //  System.out.println("indexes: " + Arrays.toString(indexes));

        final List<String> result = new ArrayList<>();
        int startIndex = 0;
        int lastIndex = -1;
        while (startIndex < n && lastIndex <= n) {
            lastIndex = indexes[startIndex];
            final String sb = arrange(words, startIndex, lastIndex, badness, maxWidth);
            result.add(sb);
            startIndex = lastIndex;
        }
        return result;
    }


    private String arrange(
            final String[] words,
            final int startIndex,
            final int lastIndex,
            final BadnessScore[][] badness,
            final int maxWidth) {
        // how many words = lastIndex - startIndex
        final int numWords = lastIndex - startIndex;
        final int wordLength = badness[startIndex][lastIndex - 1].wordLength;
        final int spaceLeftForSpaces = maxWidth - wordLength;
        final int numOfSpaces = numWords == 1 ? spaceLeftForSpaces : spaceLeftForSpaces / (numWords - 1);

        final StringBuilder sb = new StringBuilder();


        for (int i = startIndex; i < lastIndex; i++) {
            sb.append(words[i]);
            final int spaceLeft = maxWidth - sb.length();
            if (spaceLeft > 0) {
                for (int j = 0; j < numOfSpaces; j++) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    private static final class BadnessScore {
        private final int score;
        private final int length;
        private final int wordLength;

        public BadnessScore(int score, int length, final int wordLength) {
            this.score = score;
            this.length = length;
            this.wordLength = wordLength;
        }

        @Override
        public String toString() {
            return "(" + score + "," + length + "," + wordLength + ")";
        }
    }
}
