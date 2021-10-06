package com.avi.practice.company.google;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by navinash on 06/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BoldWordsInString {
    public String boldWords(String[] words, String s) {

        final List<Range> ranges = new ArrayList<>();
        for (final String word : words) {
            int index = s.indexOf(word, -1);
            while (index != -1) {
                ranges.add(new Range(index, index + word.length()));
                index++;
                index = s.indexOf(word, index);
            }
        }

        final List<Range> merged = merge(ranges);
        //  System.out.println(merged);
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (Range range : merged) {
            sb.append(s, start, range.start);
            sb.append("<b>");
            sb.append(s, range.start, range.end);
            sb.append("</b>");
            start = range.end;
        }
        if (start < s.length()) {
            sb.append(s.substring(start));
        }
        return sb.toString();
    }

    private List<Range> merge(final List<Range> ranges) {
        if (ranges.size() == 0) {
            return ranges;
        }
        final List<Range> merged = new ArrayList<>();
        ranges.sort((a, b) -> {
            return a.start - b.start;
        });
        final Stack<Range> st = new Stack<>();
        for (int i = ranges.size() - 1; i >= 0; i--) {
            st.push(ranges.get(i));
        }
        merged.add(st.pop());
        while (!st.isEmpty()) {
            final Range last = merged.get(merged.size() - 1);
            final Range pop = st.pop();
            if (last.end >= pop.start) {
                // last  --------
                // pop        ---------

                // last ------------------
                // pop      ---------
                final int start = last.start;
                final int end = Math.max(pop.end, last.end);
                merged.remove(merged.size() - 1);
                merged.add(new Range(start, end));
            } else {
                merged.add(pop);
            }
        }
        return merged;
    }

    private static final class Range {
        private final int start;
        private final int end;

        private Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "(" + start + "," + end + ")";
        }
    }
}
