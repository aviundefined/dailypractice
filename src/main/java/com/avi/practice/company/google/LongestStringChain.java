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
        int max = 1;
        final Map<String, Integer> dp = new HashMap<>();
        for (int i = maxLength; i >= minLength; i--) {
            if (stringsByLength.containsKey(i)) {
                final Set<String> startWords = stringsByLength.get(i);
                for (final String word : startWords) {
                    final int curr = dfs(null, word, i, stringsByLength, minLength, dp);
                    if (curr > max) {
                       max = curr;
                    }
                }
            }
        }
        System.out.println(max);
        return max;
    }

    private int dfs(
            final String lastWord,
            final String word,
            final int currentLength,
            final Map<Integer, Set<String>> stringsByLength,
            final int minLength,
            final Map<String, Integer> dp) {
        if (currentLength < minLength) {
            return 0;
        }
        if (lastWord != null && !isPredecessor(word, lastWord)) {
            return 0;
        }
        if (dp.containsKey(word)) {
            return dp.get(word);
        }
        int max = 1;

        final Set<String> nextCandidates = stringsByLength.getOrDefault(currentLength - 1, new HashSet<>());
        for (final String candidate : nextCandidates) {
            int count = 1 + dfs(word, candidate, currentLength - 1, stringsByLength, minLength, dp);
            if (max < count) {
                max = count;
            }
        }
        dp.put(word, max);
        return dp.get(word);
    }

    public int longestStrChainAndPrintResult(String[] words) {
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
        final List<String> max = new ArrayList<>();
        final Map<String, Set<String>> dp = new HashMap<>();
        for (int i = maxLength; i >= minLength; i--) {
            if (stringsByLength.containsKey(i)) {
                final Set<String> startWords = stringsByLength.get(i);
                for (final String word : startWords) {
                    final Set<String> curr = dfsTrackResult(null, word, i, stringsByLength, minLength, dp);
                    if (curr.size() > max.size()) {
                        max.clear();
                        max.addAll(new HashSet<>(curr));
                    }
                }
            }
        }
        System.out.println(max);
        return max.size();
    }

    private Set<String> dfsTrackResult(
            final String lastWord,
            final String word,
            final int currentLength,
            final Map<Integer, Set<String>> stringsByLength,
            final int minLength,
            final Map<String, Set<String>> dp) {
        if (currentLength < minLength) {
            return new HashSet<>();
        }
        if (lastWord != null && !isPredecessor(word, lastWord)) {
            return new HashSet<>();
        }
        if (dp.containsKey(word)) {
            return dp.get(word);
        }
        final Set<String> max = new HashSet<>();

        final Set<String> nextCandidates = stringsByLength.getOrDefault(currentLength - 1, new HashSet<>());
        for (final String candidate : nextCandidates) {
            final Set<String> current = dfsTrackResult(word, candidate, currentLength - 1, stringsByLength, minLength, dp);
            if (max.size() < current.size()) {
                max.clear();
                max.addAll(current);
            }
        }
        max.add(word);
        dp.put(word, max);
        return dp.get(word);
    }

    final boolean isPredecessor(final String smallWord, final String largeWord) {
        if (smallWord == null && largeWord == null) {
            return false;
        }
        if (smallWord == null && largeWord.length() == 1) {
            return true;
        }
        if (smallWord == null || largeWord == null) {
            return false;
        }

        if (smallWord.length() + 1 != largeWord.length()) {
            return false;
        }

        int i = 0;
        int j = 0;
        int mismatch = 0;
        while (i < smallWord.length() && j < largeWord.length()) {
            if (smallWord.charAt(i) == largeWord.charAt(j)) {
                i++;
                j++;
                continue;
            }

            if (smallWord.charAt(i) != largeWord.charAt(j)) {
                mismatch++;
                // Case1: r, C1r
                // Case 2: r, rC1
                // Case 3: r1r2, r1C1r2
                if (mismatch > 1) {
                    return false;
                }
                if (mismatch == 1) {
                    if (j == 0) {
                        final String remaining = largeWord.substring(1);
                        if (remaining.equals(smallWord)) {
                            return true;
                        }
                    }
                    if (j == largeWord.length() - 1) {
                        return true;
                    }
                }
                j++;

            }
        }
        return mismatch <= 1;
    }
}
