package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by navinash on 18/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        final Set<String> dict = new HashSet<>();
        for(final String word : words) {
            dict.add(word);
        }

        final List<String> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(isSentencPossible(words[i], dict)) {
                result.add(words[i]);
            }
        }

        return result;
    }

    private boolean isSentencPossible(final String word, final Set<String> dict) {
        final boolean[] dp = new boolean[word.length()];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < i; j++) {
                final String prefix = word.substring(j, i);
                if(dict.contains(prefix)) {
                    dp[i] = true;;
                    continue;
                }
            }
        }
        return dp[word.length() - 1];
    }
}
