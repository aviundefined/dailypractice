package com.avi.practice.backtracking;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 20/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class StringPermutation {

    private final char[] chars;
    private final int n;

    StringPermutation(final String s) {
        if (s == null || s.trim().length() == 0) {
            this.chars = null;
        } else {
            this.chars = s.toCharArray();
        }
        this.n = this.chars == null ? 0 : this.chars.length;
    }

    void printAll() {
        if (this.chars == null || this.chars.length == 0) {
            System.out.println("String is empty. No Permutation exists");
            return;
        }
        System.out.println("Print all permutations of string: " + String.valueOf(chars));
        _permutations(0, n);
        System.out.println();
    }

    void printOfLengthK(final int k) {
        if (this.chars == null || this.chars.length == 0) {
            System.out.println("String is empty. No Permutation exists");
            return;
        }
        System.out.println(String.format("Print all permutations of string [%s] of length [%s]", String.valueOf(chars), k));
        final char[] sol = new char[k];
        _permutations(0, k, sol);
        System.out.println();
    }

    private void _permutations(final int idx, final int k) {
        if (idx == k) {
            CommonUtils.printArr(chars);
            return;
        }

        for (int i = idx; i < n; i++) {
            _swap(idx, i);
            _permutations(idx + 1, k);
            _swap(idx, i);
        }
    }

    private void _permutations(final int idx, final int k, final char[] sol) {
        if (idx == k) {
            CommonUtils.printArr(sol);
            return;
        }

        for (int i = idx; i < n; i++) {
            _swap(idx, i);
            //noinspection ManualArrayCopy
            for (int j = 0; j < k; j++) {
                sol[j] = chars[j];
            }
            _permutations(idx + 1, k, sol);
            _swap(idx, i);
            //noinspection ManualArrayCopy
            for (int j = 0; j < k; j++) {
                sol[j] = chars[j];
            }
        }
    }

    private void _swap(final int i, final int j) {
        final char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
