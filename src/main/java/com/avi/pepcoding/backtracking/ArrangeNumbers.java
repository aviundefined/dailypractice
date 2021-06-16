package com.avi.pepcoding.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by navinash on 16/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ArrangeNumbers {

    public List<List<String>> arrangements(final int n, final String operators) {
        if (n == 0) {
            return Collections.emptyList();
        }

        if (n == 1) {
            return Collections.singletonList(Collections.singletonList("1"));
        }

        final String[] arr = new String[n + operators.length()];

        for (int i = 0, idx = 1; i < operators.length(); i++, idx += 2) {
            arr[idx] = String.valueOf(operators.charAt(i));
        }

        final List<List<String>> result = new ArrayList<>();
        final Set<Integer> visited = new HashSet<>();
        for(int i = 1; i <=n; i++) {
            arr[0] = String.valueOf(i);
            visited.add(i);
            backtrack(2, n, arr, visited, result);
            arr[0] = null;
            visited.remove(i);
        }
        return result;
    }

    private void backtrack(final int index, final int n, final String[] arr, Set<Integer> visited, final List<List<String>> result) {
        if (index >= arr.length) {
            final List<String> arrangement = new ArrayList<>(Arrays.asList(arr));
            result.add(arrangement);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited.contains(i) && canPlace(arr, index, i)) {
                arr[index] = String.valueOf(i);
                visited.add(i);
                backtrack(index + 2, n, arr, visited, result);
                arr[index] = null;
                visited.remove(i);
            }
        }
    }

    private boolean canPlace(String[] arr, int index, int i) {
        if (index == 0) {
            return true;
        }

        final int lastNumber = Integer.parseInt(arr[index - 2]);
        final String op = arr[index - 1];
        // lastNumber < i
        if ("<".equals(op) && lastNumber < i) {
            return true;
        }

        // lastNumber > i
        if (">".equals(op) && lastNumber > i) {
            return true;
        }
        return false;
    }
}
