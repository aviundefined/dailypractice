package com.avi.practice.strings;

/**
 * Created by navinash on 19/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class PermutationPractice {

    final void printPermutations(final String s) {
        if (isEmpty(s)) {
            return;
        }

        final int n = s.length();
        final char[] chars = s.toCharArray();
        _printPermutations(chars, 0, n - 1);
    }

    private void _printPermutations(char[] chars, int l, int r) {
        if (l == r) {
            System.out.println(String.valueOf(chars));
            return;
        }

        for (int i = l; i <= r; i++) {
            swap(chars, l, i);
            _printPermutations(chars, l + 1, r);
            swap(chars, l, i);
        }
    }

    final void swap(final char[] chars, final int l, final int r) {
        final char tmp = chars[r];
        chars[r] = chars[l];
        chars[l] = tmp;
    }

    final boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }
}
