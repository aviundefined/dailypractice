package com.avi.practice.company.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * You are given an array of words where each word consists of lowercase English letters.
 * <p>
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
 * <p>
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 * <p>
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
 * Example 2:
 * <p>
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 * Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 * Example 3:
 * <p>
 * Input: words = ["abcd","dbqca"]
 * Output: 1
 * Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
 * ["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of lowercase English letters.
 */
public class LongestStringChainV2 {

    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        if (words.length == 1) {
            return 1;
        }

        final Set<String> dict = new HashSet<>(Arrays.asList(words));
        final Map<String, Set<String>> dp = new HashMap<>();
        final Set<String> max = new HashSet<>();
        for (final String word : words) {
            final Set<String> curr = dfs(word, dict, dp);
            if (curr.size() > max.size()) {
                max.clear();
                max.addAll(curr);
            }
        }
        return max.size();
    }

    private Set<String> dfs(String word, Set<String> dict, Map<String, Set<String>> dp) {
        if (word == null || "".equals(word)) {
            return new HashSet<>();
        }
        if (!dict.contains(word)) {
            return new HashSet<>();
        }
        if (dp.containsKey(word)) {
            return dp.get(word);
        }

        final Set<String> max = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            final StringBuilder sb = new StringBuilder(word);
            final StringBuilder candidate = sb.deleteCharAt(i);
            final Set<String> curr = dfs(candidate.toString(), dict, dp);
            if (curr.size() > max.size()) {
                max.clear();
                max.addAll(curr);
            }
        }
        max.add(word);
        dp.put(word, max);
        return max;
    }

}
