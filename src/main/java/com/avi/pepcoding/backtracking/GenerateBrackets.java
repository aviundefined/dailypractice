package com.avi.pepcoding.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 15/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GenerateBrackets {

    public List<String> get(final int numBrackets) {
        if (numBrackets <= 0) {
            return Collections.emptyList();
        }

        final List<String> result = new ArrayList<>();
        recurse(numBrackets, numBrackets, new StringBuilder(), 0, result);
        return result;
    }

    private void recurse(
            int openRemaining,
            int closeRemaining,
            StringBuilder sb,
            int oldLength,
            List<String> result) {
        if (openRemaining < 0 || closeRemaining < 0) {
            return;
        }
        if (openRemaining == 0 && closeRemaining == 0) {
            result.add(sb.toString());
            return;
        }

        if (openRemaining > 0) {
            sb.append("(");
            recurse(openRemaining - 1, closeRemaining, sb, sb.length(), result);
            sb.setLength(oldLength);
        }
        if (closeRemaining > openRemaining) {
            sb.append(")");
            recurse(openRemaining, closeRemaining - 1, sb, sb.length(), result);
            sb.setLength(oldLength);
        }

    }
}
