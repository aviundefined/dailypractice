package com.avi.practice.company.google.iterators;


import java.util.Stack;

/**
 * Created by navinash on 01/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DesignCompressedStringIterator {

    static final class StringIterator {
        private final Stack<Pair> chars = new Stack<>();

        // L1e2t1C1o1d1e1
        public StringIterator(String compressedString) {
            final StringBuilder sb = new StringBuilder();
            for (int  i  = compressedString.length() - 1; i >= 0; i--) {
                final char c = compressedString.charAt(i);
                if (Character.isDigit(c)) {
                    sb.append(c);
                } else {
                    chars.push(new Pair(c, num(sb.toString())));
                    sb.setLength(0);
                }
            }
        }

        private int num(String s) {
            int num = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            return num;
        }

        public char next() {
            if (!hasNext()) {
                return ' ';
            }
            final Pair curr = chars.peek();
            if (curr.counts == 1) {
                chars.pop();
            } else {
                curr.counts--;
            }
            return curr.c;
        }

        public boolean hasNext() {
            return !chars.isEmpty();
        }

        private static final class Pair {
            private final char c;
            private int counts;

            private Pair(char c, int counts) {
                this.c = c;
                this.counts = counts;
            }
        }
    }
}
