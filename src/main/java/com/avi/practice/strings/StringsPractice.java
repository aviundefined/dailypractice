package com.avi.practice.strings;

import com.avi.practice.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by navinash on 11/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class StringsPractice {

    private static final Set<String> dictionary = new HashSet<>();

    static {
        dictionary.add("a");
        dictionary.add("service");
        dictionary.add("system");
        dictionary.add("out");
        dictionary.add("put");
        dictionary.add("output");
        dictionary.add("outputs");
        dictionary.add("is");
        dictionary.add("invalid");
        dictionary.add("i");
        dictionary.add("love");
        dictionary.add("you");
        dictionary.add("this");
        dictionary.add("test");
        dictionary.add("string");
        dictionary.add("like");
        dictionary.add("to");
        dictionary.add("drink");
        dictionary.add("tea");
        dictionary.add("coffee");
        dictionary.add("bee");
        dictionary.add("bees");
        dictionary.add("best");
        dictionary.add("bear");
        dictionary.add("beer");
        dictionary.add("bot");
        dictionary.add("bottom");
        dictionary.add("bottoms");
        dictionary.add("up");
        dictionary.add("ups");
        dictionary.add("the");
        dictionary.add("happy");
        dictionary.add("dog");
        dictionary.add("went");
        dictionary.add("park");
        dictionary.add("on");
        dictionary.add("sunny");
        dictionary.add("day");
    }

    /**
     * Time:  O(length of string)
     * Space: O(length of string)
     */
    static String maximumLengthSubstringWithNoDuplicates(final String str) {
        if (str == null || str.length() == 0 || str.trim().equals("")) {
            return str;
        }

        final int n = str.length();
        final char[] chars = str.toCharArray();
        int s = 0, e = 1, max = -1, sIdx = 0, eIdx = 0;
        final Map<Character, Integer> counts = new LinkedHashMap<>();
        counts.put(chars[s], 1);
        while (s <= e && e < n) {
            if (!counts.containsKey(chars[e])) {
                counts.put(chars[e], 1);
                if (e - s >= max) {
                    max = e - s;
                    sIdx = s;
                    eIdx = e;
                }
                e++;
                continue;
            }

            final int v = counts.get(chars[e]);
            counts.put(chars[e], v + 1);
            while (s <= e && counts.get(chars[e]) > 1) {
                if (counts.get(chars[e]) == 1) {
                    break;
                }
                final int curr = counts.get(chars[s]);
                if (curr == 1) {
                    counts.remove(chars[s]);
                } else {
                    counts.put(chars[s], curr - 1);
                }
                s++;
            }
            e++;
        }

        final char[] subStr = new char[eIdx - sIdx + 1];
        for (int i = 0; i < subStr.length; i++) {
            subStr[i] = chars[sIdx + i];
        }
        return String.valueOf(subStr);
    }

    static List<String> splitSentence(final String word) {
        final List<String> sentences = new ArrayList<>();
        final Queue<String> sentence = new LinkedList<>();
        _splitSentence(word, 0, sentence, sentences);
         return sentences;
    }

    private static String queueToSpaceSeparatedString(Collection<String> sentence) {
        final StringBuilder sb = new StringBuilder();
        for (final String s : sentence) {
            sb.append(s).append(" ");
        }
        return sb.toString();
    }

    private static void _splitSentence(
            final String word,
            final int start,
            final Queue<String> sentence,
            final List<String> sentences) {
        if (start == word.length()) {
            sentences.add(queueToSpaceSeparatedString(sentence));
            return;
        }
        for (int i = start; i <= word.length(); i++) {
            final String part = word.substring(start, i);
            if (dictionary.contains(part)) {
                sentence.add(part);
                _splitSentence(word, i, sentence, sentences);
                sentence.poll();
            }
        }
    }


    static String getSentence(final String word) {
        return _getSentence(word, 0);
    }

    private static String _getSentence(final String str, int currIndex) {
        if (CommonUtils.isEmpty(str)) {
            return "";
        }
        if (dictionary.contains(str)) {
            return str;
        }
        currIndex++;
        final String firstPart = str.substring(0, currIndex);
        final String secondPart = str.substring(currIndex);
        if (dictionary.contains(firstPart)) {
            return firstPart + " " + _getSentence(secondPart, 0);
        } else {
            return _getSentence(str, currIndex);
        }
    }
}
