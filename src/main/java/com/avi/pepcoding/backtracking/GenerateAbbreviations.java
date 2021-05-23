package com.avi.pepcoding.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 23/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GenerateAbbreviations {

    public List<String> generate(final String s) {
        if (s == null || "".equals(s.trim())) {
            return Collections.emptyList();
        }

        final List<String> result = new ArrayList<>();
        recurse(s, "", 0, 0, result);
        return result;
    }

    private void recurse(final String s, final String answer, final int count, final int position, final List<String> result) {
        if (position == s.length()) {
            if (count == 0) {
                result.add(answer);
            } else {
                result.add(answer + count);
            }
            return;
        }

        // include current position
        if (count == 0) {
            recurse(s, answer + s.charAt(position), 0, position + 1, result);
        } else {
            recurse(s, answer + count + s.charAt(position), 0, position + 1, result);
        }

        // exclude
        recurse(s, answer, count + 1, position + 1, result);
    }
}
