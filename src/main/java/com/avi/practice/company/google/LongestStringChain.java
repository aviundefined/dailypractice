package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
public class LongestStringChain {
    private final List<String> max = new ArrayList<>();

    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        if (words.length == 1) {
            return 1;
        }

        final Map<Integer, Set<String>> stringsByLength = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;

        for (final String word : words) {
            final int size = word.length();
            stringsByLength.computeIfAbsent(size, k -> new HashSet<>()).add(word);
            if (size < minLength) {
                minLength = size;
            }
            if (size > maxLength) {
                maxLength = size;
            }
        }

        final Set<String> startWords = stringsByLength.get(maxLength);
        for (final String word : startWords) {
            final List<String> currentResult = new ArrayList<>();
            dfs(word, maxLength, stringsByLength, currentResult, minLength);
        }
        return max.size();
    }

    private void dfs(String word, int currentLength, Map<Integer, Set<String>> stringsByLength, List<String> currentResult, int minLength) {
        if (currentLength < minLength) {
            if (max.size() < currentResult.size()) {
                max.clear();
                max.addAll(new ArrayList<>(currentResult));
            }
            return;
        }
        // add current word in chain
        currentResult.add(word);
        final Set<String> nextLevelWords = stringsByLength.getOrDefault(currentLength - 1, new HashSet<>());
        for (int i = 0; i < word.length(); i++) {
            final String candidate;
            if (i == 0) {
                candidate = word.substring(i + 1);
            } else if (i == word.length() - 1) {
                candidate = word.substring(0, i);
            } else {
                candidate = word.substring(0, i) + word.substring(i + 1);
            }
            if (nextLevelWords.contains(candidate)) {
                dfs(candidate, currentLength - 1, stringsByLength, currentResult, minLength);
            } else {
                if (max.size() < currentResult.size()) {
                    max.clear();
                    max.addAll(new ArrayList<>(currentResult));
                }
            }
        }
        currentResult.remove(currentResult.size() - 1);

        // without adding current word
        for (final String newWord : nextLevelWords) {
            dfs(newWord, currentLength - 1, stringsByLength, new ArrayList<>(), minLength);
        }
    }
}
