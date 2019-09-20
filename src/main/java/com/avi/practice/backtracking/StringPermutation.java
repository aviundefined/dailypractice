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
        _permutations(0);
        System.out.println();
    }

    private void _permutations(int idx) {
        if (idx == n) {
            CommonUtils.printArr(chars);
            return;
        }

        for (int i = idx; i < n; i++) {
            _swap(idx, i);
            _permutations(idx + 1);
            _swap(idx, i);
        }
    }

    private void _swap(final int i, final int j) {
        final char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
