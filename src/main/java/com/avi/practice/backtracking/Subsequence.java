package com.avi.practice.backtracking;

import com.avi.practice.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by navinash on 20/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class Subsequence {

    private final int[] arr;
    private final int n;

    Subsequence(final int[] arr) {
        if (CommonUtils.isEmpty(arr)) {
            throw new IllegalArgumentException("Array is empty");
        }
        this.arr = arr;
        this.n = arr.length;
    }

    final Collection<List<Integer>> all() {
        final Set<List<Integer>> subsequences = new LinkedHashSet<>();
        for (int i = 1; i <= n; i++) {
            subsequences.addAll(ofLengthK(i));
        }
        return subsequences;
    }

    final Collection<List<Integer>> ofLengthK(final int k) {
        if (k > n) {
            return Collections.emptySet();
        }
        final Set<List<Integer>> subsequences = new LinkedHashSet<>();
        _ofLengthK(0, k, subsequences);
        return subsequences;
    }

    private void _ofLengthK(final int idx, final int length, Collection<List<Integer>> subsequences) {
        if (idx == length) {
            final List<Integer> set = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                set.add(arr[i]);
            }
            Collections.sort(set);
            subsequences.add(set);
            return;
        }

        for (int i = idx; i < n; i++) {
            final List<Integer> candidate = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                candidate.add(arr[j]);
            }
            Collections.sort(candidate);
            CommonUtils.swap(arr, idx, i);
            _ofLengthK(idx + 1, length, subsequences);
            CommonUtils.swap(arr, idx, i);
        }
    }
}
