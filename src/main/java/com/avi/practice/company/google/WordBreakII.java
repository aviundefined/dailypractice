package com.avi.practice.company.google;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by navinash on 18/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class WordBreakII {

    public final int numOfSentences(final String word, final List<String> words) {
        if(word == null || word.length() == 0 || words == null || words.size() == 0) {
            return 0;
        }

        final Set<String> dict = new HashSet<>(words);
        final int n = word.length();
        final int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                final String prefix = word.substring(j, i+1);
                if(dict.contains(prefix)) {
                    dp[i] += dp[j];
                }
            }
        }
        return dp[n - 1];
    }
}
