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

    private void backtrack(int i, String curr, int n, boolean[] used, List<String> result) {
        if (i >= n) {
            result.add(curr);
            return;
        }

        if (used[i]) {
            backtrack(i + 1, curr, n, used, result);
        } else {
            used[i] = true;
            backtrack(i + 1, curr + "(" + i + ")", n, used, result);
            used[i] = false;

            used[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (used[j]) {
                    continue;
                }
                used[j] = true;
                backtrack(i + 1, curr + "(" + i + "," + j + ")", n, used, result);
                used[j] = false;
            }
            used[i] = false;
        }
    }
}
