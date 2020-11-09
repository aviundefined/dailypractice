package com.avi.practice.leetcode.weeklycontest.num215;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by navinash on 09/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * A string s is called good if there are no two different characters in s that have the same frequency.
 * <p>
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 * <p>
 * The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 * Example 2:
 * <p>
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 * Example 3:
 * <p>
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s contains only lowercase English letters.
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        final Map<Character, Integer> countMap = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            countMap.compute(s.charAt(i), (key, value) -> {
                if (value == null) {
                    return 1;
                }

                return ++value;
            });
        }
        final List<Integer> charCounts = new ArrayList<>(countMap.values());
        charCounts.sort((o1, o2) -> Integer.compare(o2, o1));
        int result = 0;
        int maxAllowedFrequency = charCounts.get(0);
        for (final int frequency : charCounts) {
            if (frequency <= maxAllowedFrequency) {
                maxAllowedFrequency = frequency - 1;
            } else {
                if (maxAllowedFrequency > 0) {
                    result += frequency - maxAllowedFrequency;
                    maxAllowedFrequency = maxAllowedFrequency - 1;
                } else {
                    result += frequency;
                    maxAllowedFrequency = 0;
                }
            }
        }
        return result;
    }
}
