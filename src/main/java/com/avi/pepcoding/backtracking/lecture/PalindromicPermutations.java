package com.avi.pepcoding.backtracking.lecture;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by navinash on 30/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PalindromicPermutations {

    public void printAllPalindromicPermutations(final String s) {
        if (s == null) {
            return;
        }
        if (s.equals("")) {
            System.out.println();
            return;
        }

        final Map<Character, Integer> freqMap = new HashMap<>();
        for (final char c : s.toCharArray()) {
            freqMap.compute(c, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
        }
        int numOdds = 0;
        final Set<Character> keys = new HashSet<>(freqMap.keySet());
        Character oddChar = null;
        int length = 0;
        for (final Character c : keys) {
            final int freq = freqMap.get(c);
            if (freq % 2 == 1) {
                numOdds++;
                oddChar = c;
            }
            if (numOdds > 1) {
                System.out.println("");
                return;
            }
            freqMap.put(c, freq / 2);
            length += freq / 2;
        }

        recurse("", length, oddChar, freqMap);
    }

    private void recurse(String curr, int length, Character oddChar, Map<Character, Integer> freqMap) {
        if (curr.length() >= length) {
            // reverse the string;
            String reverse = "";
            for (int i = curr.length() - 1; i >= 0; i--) {
                reverse += curr.charAt(i);
            }
            if (oddChar == null) {
                System.out.println(curr + reverse);
            } else {
                System.out.println(curr + oddChar + reverse);
            }
            return;
        }

        for (final char c : freqMap.keySet()) {
            final int freq = freqMap.get(c);
            if (freq > 0) {
                freqMap.put(c, freq - 1);
                recurse(curr + c, length, oddChar, freqMap);
                freqMap.put(c, freq + 1);
            }
        }
    }


}
