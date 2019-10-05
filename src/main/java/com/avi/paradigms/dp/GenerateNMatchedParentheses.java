package com.avi.paradigms.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 05/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class GenerateNMatchedParentheses {

    final List<String> solve(final int n) {
        final List<String> result = new ArrayList<>();
        _solve(n, n, "", result);
        return result;
    }

    private void _solve(final int left, final int right, final String s, final List<String> result) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > 0) {
            _solve(left - 1, right, s + "(", result);
        }
        if (left < right) {
            _solve(left, right - 1, s + ")", result);
        }
    }
}
