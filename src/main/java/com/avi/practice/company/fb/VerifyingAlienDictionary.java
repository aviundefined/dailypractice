package com.avi.practice.company.fb;

import java.util.HashMap;
import java.util.Map;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 * <p>
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 * <p>
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */
public class VerifyingAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {

        final Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            final String currWord = words[i];
            final String nextWord = words[i + 1];
            if (!inOrder(currWord, nextWord, orderMap)) {
                return false;
            }
        }
        return true;
    }

    private boolean inOrder(String currWord, String nextWord, Map<Character, Integer> orderMap) {
        if (currWord == null && nextWord == null) {
            return true;
        }

        if (currWord == null && nextWord != null) {
            return true;
        }
        if (currWord != null && nextWord == null) {
            return false;
        }

        if (currWord.equals(nextWord)) {
            return true;
        }

        final int currWordLength = currWord.length();
        final int nextWordLength = nextWord.length();
        int curr = 0;
        int next = 0;
        while (curr < currWordLength && next < nextWordLength) {
            final int currIdx = orderMap.get(currWord.charAt(curr));
            final int nextIdx = orderMap.get(nextWord.charAt(next));
            if (nextIdx < currIdx) {
                return false;
            }
            curr++;
            next++;
        }
        return true;
    }
}
