package com.avi.practice.leetcode.biweekly.num40;

/**
 * Created by navinash on 01/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence. The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence. If word is not a substring of sequence, word's maximum k-repeating value is 0.
 * <p>
 * Given strings sequence and word, return the maximum k-repeating value of word in sequence.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: sequence = "ababc", word = "ab"
 * Output: 2
 * Explanation: "abab" is a substring in "ababc".
 * Example 2:
 * <p>
 * Input: sequence = "ababc", word = "ba"
 * Output: 1
 * Explanation: "ba" is a substring in "ababc". "baba" is not a substring in "ababc".
 * Example 3:
 * <p>
 * Input: sequence = "ababc", word = "ac"
 * Output: 0
 * Explanation: "ac" is not a substring in "ababc".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence and word contains only lowercase English letters.
 */
public class MaximumRepeatingSubstring {

    public int maxRepeating(String sequence, String word) {
        if (sequence == null || word == null || sequence.length() < word.length()) {
            return 0;
        }

        int max = 0;
        String patten = word;
        while (sequence.contains(patten)) {
            max++;
            patten += word;
        }
        return max;
    }
}
