package com.avi.practice.company.microsoft;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CalculateSentenceDifficulty {

    public final int difficulty(final String sentence) {
        if (sentence == null || sentence.trim().length() == 0) {
            return 0;
        }
        final String[] words = sentence.trim().split(" ");
        int numHardWords = 0;
        int numEasyWords = 0;
        for (final String word : words) {
            if (isHard(word)) {
                numHardWords++;
            } else {
                numEasyWords++;
            }
        }
        return (5 * numHardWords) + (3 * numEasyWords);
    }

    private boolean isHard(final String word) {
        if (word == null || word.trim().length() == 0) {
            return false;
        }

        final char[] chars = word.trim().toLowerCase().toCharArray();
        final int n = chars.length;
        int numVows = 0;
        int numCons = 0;
        int numConsecutiveCons = 0;
        int l = 0;
        int r = 0;
        while (l <= r && r < n) {
            if (isVowel(chars[r])) {
                numVows++;
                r++;
                l = r;
                numConsecutiveCons = 0;
            } else {
                numCons++;
                numConsecutiveCons++;
                r++;
            }
            if (numConsecutiveCons >= 4) {
                return true;
            }
        }
        return numCons > numVows;
    }

    private boolean isVowel(final char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}
