package com.avi.pepcoding.backtracking.lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 22/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintAbbreviations {

    public List<String> allAbbreviations(final String s) {
        if (s == null || s.length() == 0) {
            return Collections.emptyList();
        }

        final List<String> result = new ArrayList<>();
        recurse(s, 0, "", 0, result);
        return result;
    }


    private void recurse(final String s, final int index, final String answerSoFar, final int count, final List<String> result) {
        if (index >= s.length()) {
            if (count > 0) {
                result.add(answerSoFar + count);
            } else {
                result.add(answerSoFar);
            }
            return;
        }
        recurse(s, index + 1, answerSoFar, count + 1, result);
        if (count > 0) {
            recurse(s, index + 1, answerSoFar + count + s.charAt(index), 0, result);
        } else {
            recurse(s, index + 1, answerSoFar + s.charAt(index), 0, result);
        }
    }

}
