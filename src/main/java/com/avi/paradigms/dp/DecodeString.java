package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by navinash on 05/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DecodeString {

    private final String s;
    private final int n;
    private final int[] dp;
    private final char[] chars;

    private static final Map<String, String> decodings = new HashMap<>();

    {
        decodings.put("1", "A");
        decodings.put("2", "B");
        decodings.put("3", "C");
        decodings.put("4", "D");
        decodings.put("5", "E");
        decodings.put("6", "F");
        decodings.put("7", "G");
        decodings.put("8", "H");
        decodings.put("9", "I");
        decodings.put("10", "J");
        decodings.put("11", "K");
        decodings.put("12", "L");
        decodings.put("13", "M");
        decodings.put("14", "N");
        decodings.put("15", "O");
        decodings.put("16", "P");
        decodings.put("17", "Q");
        decodings.put("18", "R");
        decodings.put("19", "S");
        decodings.put("20", "T");
        decodings.put("21", "U");
        decodings.put("22", "V");
        decodings.put("23", "W");
        decodings.put("24", "X");
        decodings.put("25", "Y");
        decodings.put("26", "Z");
    }

    DecodeString(String s) {
        this.s = s;
        this.n = CommonUtils.isEmpty(s) ? 0 : s.length();
        this.chars = CommonUtils.isEmpty(s) ? null : s.toCharArray();
        this.dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println("Decoding problem for string: " + s);
    }

    final int countRecursive() {
        return _count(0);
    }

    final int countIterative() {
        if (n == 0 || n == 1) {
            return 1;
        }

        final int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (chars[i - 1] > '0') {
                count[i] += count[i - 1];
            }
            if ((chars[i - 2] == '1' || chars[i - 2] == '2') && chars[i - 1] <= '6') {
                count[i] += count[i - 2];
            }
        }
        return count[n];
    }

    final void printAllDecodings() {
        if (n == 0) {
            System.out.println("");
        }
        _printAllDecodings(0, "");
    }

    final List<String> getAllDecodings() {
        if (n == 0) {
            return Collections.emptyList();
        }
        final List<String> result = new ArrayList<>();
        _getAllDecodings(0, "", result);
        return result;
    }

    final List<String> getAllDecodingsIterative() {
        if (n == 0) {
            return Collections.emptyList();
        }
        if (n == 1) {
            return Collections.singletonList(s);
        }
        final Map<Integer, List<String>> decodingsByIndex = new HashMap<>();
        decodingsByIndex.put(0, Lists.newArrayList());
        if (chars[0] > '0') {
            decodingsByIndex.put(1, Lists.newArrayList(decodings.get(String.valueOf(chars[0]))));
        } else {
            decodingsByIndex.put(1, Lists.newArrayList());
        }

        for (int i = 2; i <= n; i++) {
            final List<String> allDecodings = new ArrayList<>();
            final String singleChar = decodings.get(String.valueOf(chars[i - 1]));
            if (!CommonUtils.isEmpty(singleChar)) {
                if (CommonUtils.isEmpty(decodingsByIndex.get(i - 1))) {
                    allDecodings.addAll(Lists.newArrayList(singleChar));
                } else {
                    for (final String str : decodingsByIndex.get(i - 1)) {
                        allDecodings.add(str + singleChar);
                    }
                }
            }

            final String twoChar = decodings.get(String.valueOf(chars[i - 2]) + String.valueOf(chars[i - 1]));
            if (!CommonUtils.isEmpty(twoChar)) {
                if (CommonUtils.isEmpty(decodingsByIndex.get(i - 2))) {
                    allDecodings.addAll(Lists.newArrayList(twoChar));
                } else {
                    for (final String str : decodingsByIndex.get(i - 2)) {
                        allDecodings.add(str + twoChar);
                    }
                }
            }
            decodingsByIndex.put(i, allDecodings);
        }
        return decodingsByIndex.get(n);
    }

    private void _printAllDecodings(
            final int currentPointer,
            final String currentDecoding) {
        if (currentPointer >= n) {
            System.out.println(currentDecoding);
        }

        if (currentPointer + 1 <= n) {
            final String singleCharString = s.substring(currentPointer, currentPointer + 1);
            if (isValid(singleCharString)) {
                _printAllDecodings(currentPointer + 1, currentDecoding + decodings.get(singleCharString));
            }
        }
        if (currentPointer + 2 <= n) {
            final String twoCharString = s.substring(currentPointer, currentPointer + 2);
            if (isValid(twoCharString)) {
                _printAllDecodings(currentPointer + 2, currentDecoding + decodings.get(twoCharString));
            }
        }
    }


    private void _getAllDecodings(
            final int currentPointer,
            final String currentDecoding,
            final List<String> result) {
        if (currentPointer >= n) {
            result.add(currentDecoding);
        }

        if (currentPointer + 1 <= n) {
            final String singleCharString = s.substring(currentPointer, currentPointer + 1);
            if (isValid(singleCharString)) {
                _getAllDecodings(currentPointer + 1, currentDecoding + decodings.get(singleCharString), result);
            }
        }
        if (currentPointer + 2 <= n) {
            final String twoCharString = s.substring(currentPointer, currentPointer + 2);
            if (isValid(twoCharString)) {
                _getAllDecodings(currentPointer + 2, currentDecoding + decodings.get(twoCharString), result);
            }
        }
    }

    private List<String> _getAllDecodingsMemoization(
            final int currentPointer,
            final String currentDecoding,
            final Map<Integer, List<String>> decodingsByPointer) {
        if (currentPointer >= n) {
            return Collections.singletonList(currentDecoding);
        }
        if (decodingsByPointer.containsKey(currentPointer)) {
            return decodingsByPointer.get(currentPointer);
        }
        final List<String> allDecodings = new ArrayList<>();
        if (currentPointer + 1 <= n) {
            final String singleCharString = s.substring(currentPointer, currentPointer + 1);
            if (isValid(singleCharString)) {
                allDecodings.addAll(
                        _getAllDecodingsMemoization(
                                currentPointer + 1,
                                currentDecoding + decodings.get(singleCharString),
                                decodingsByPointer));
            }
        }
        if (currentPointer + 2 <= n) {
            final String twoCharString = s.substring(currentPointer, currentPointer + 2);
            if (isValid(twoCharString)) {
                allDecodings.addAll(
                        _getAllDecodingsMemoization(
                                currentPointer + 2,
                                currentDecoding + decodings.get(twoCharString),
                                decodingsByPointer));
            }
        }
        decodingsByPointer.put(currentPointer, allDecodings);
        return allDecodings;
    }


    private int _count(final int currentPointer) {
        if (currentPointer >= n) {
            return 1; // reached to the end
        }

        if (dp[currentPointer] != -1) {
            return dp[currentPointer]; // already solved
        }
        int totalWays = 0;
        // check is currentPointer + 1 is valid
        if (currentPointer + 1 <= n) {
            final String singleCharString = s.substring(currentPointer, currentPointer + 1);
            if (isValid(singleCharString)) {
                totalWays += _count(currentPointer + 1);
            }
        }

        if (currentPointer + 2 <= n) {
            final String twoCharString = s.substring(currentPointer, currentPointer + 2);
            if (isValid(twoCharString)) {
                totalWays += _count(currentPointer + 2);
            }
        }

        dp[currentPointer] = totalWays;
        return totalWays;
    }

    private boolean isValid(final String str) {
        if (str.length() == 0) {
            return false;
        }
        final int v = Integer.parseInt(str);
        return v >= 1 && v <= 26;
    }
}
