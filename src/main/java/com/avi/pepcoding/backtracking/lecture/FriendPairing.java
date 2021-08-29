package com.avi.pepcoding.backtracking.lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 29/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FriendPairing {

    public List<String> getAllCombinations(final int n) {
        if (n == 0) {
            return Collections.emptyList();
        }

        final List<String> result = new ArrayList<>();
        backtrack(0, "", n, new boolean[n], result);
        return result;
    }

    private void backtrack(int index, String curr, int n, boolean[] used, List<String> result) {
        if (index >= n) {
            result.add(curr);
            return;
        }

        if (used[index]) {
            backtrack(index + 1, curr, n, used, result);
        } else {
            used[index] = true;
            backtrack(index + 1, curr + "(" + index + ")", n, used, result);
            used[index] = false;

            used[index] = true;
            for (int i = index + 1; i < n; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                backtrack(index + 1, curr + "(" + index + "," + i + ")", n, used, result);
                used[i] = false;
            }
            used[index] = false;
        }
    }
}
