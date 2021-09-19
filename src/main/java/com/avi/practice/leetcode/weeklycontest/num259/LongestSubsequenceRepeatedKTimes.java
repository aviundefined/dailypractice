package com.avi.practice.leetcode.weeklycontest.num259;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are given a string s of length n, and an integer k. You are tasked to find the longest subsequence repeated k times in string s.
 * <p>
 * A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
 * <p>
 * A subsequence seq is repeated k times in the string s if seq * k is a subsequence of s, where seq * k represents a string constructed by concatenating seq k times.
 * <p>
 * For example, "bba" is repeated 2 times in the string "bababcba", because the string "bbabba", constructed by concatenating "bba" 2 times, is a subsequence of the string "bababcba".
 * Return the longest subsequence repeated k times in string s. If multiple such subsequences are found, return the lexicographically largest one. If there is no such subsequence, return an empty string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * example 1
 * Input: s = "letsleetcode", k = 2
 * Output: "let"
 * Explanation: There are two longest subsequences repeated 2 times: "let" and "ete".
 * "let" is the lexicographically largest one.
 * Example 2:
 * <p>
 * Input: s = "bb", k = 2
 * Output: "b"
 * Explanation: The longest subsequence repeated 2 times is "b".
 * Example 3:
 * <p>
 * Input: s = "ab", k = 2
 * Output: ""
 * Explanation: There is no subsequence repeated 2 times. Empty string is returned.
 * Example 4:
 * <p>
 * Input: s = "bbabbabbbbabaababab", k = 3
 * Output: "bbbb"
 * Explanation: The longest subsequence "bbbb" is repeated 3 times in "bbabbabbbbabaababab".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == s.length
 * 2 <= k <= 2000
 * 2 <= n < k * 8
 * s consists of lowercase English letters.
 */
public class LongestSubsequenceRepeatedKTimes {

    private static final String MARKER = "";

    public String longestSubsequenceRepeatedK(String s, int k) {
        if (k == 0) {
            return "";
        }

        // append [a,z] in curr string level 1
        // check if curr string is a subsequence of s , k times then it's a candidate
        // we can use bfs for that and last result in the bfs will be the longest and lexicographically largest as well

        final Queue<String> q = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            q.offer(String.valueOf((char) ('a' + i)));
        }
        q.offer(MARKER);
        String result = "";
        while (!q.isEmpty()) {
            // remove mark* work add*
            final String curr = q.poll();
            if (curr.equals(MARKER)) {
                if (!q.isEmpty()) {
                    q.offer(MARKER);
                }
                continue;
            }
            // curr subsequence exists k times , store that result
            // add next possible subsequence is Queue
            if (isSubsequenceExists(curr, s, k)) {
                result = curr;
                for (int i = 0; i < 26; i++) {
                    q.offer(curr + (char) ('a' + i));
                }
            }

        }
        return result;
    }

    private boolean isSubsequenceExists(String subsequence, String s, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < s.length() && j < subsequence.length()) {
            if (subsequence.charAt(j) == s.charAt(i)) {
                i++;
                j++;
                if (j == subsequence.length()) {
                    count++;
                    if (count >= k) {
                        return true;
                    }
                    j = 0;
                }
            } else {
                i++;
            }
        }
        return count >= k;
    }
}
