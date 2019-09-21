package com.avi.topics.searching;

import com.avi.practice.utils.CommonUtils;

import java.util.List;

/**
 * Created by navinash on 21/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class SearchQuestions {

    private SearchQuestions() {

    }

    static int findListInList(final List<Integer> parent, final List<Integer> target) {
        if (CommonUtils.isEmpty(parent) || CommonUtils.isEmpty(target)) {
            return -1;
        }
        final int n = parent.size();
        final int m = target.size();
        if (m > n) {
            return -1;
        }
        int startIdx = -1;
        int matched = 0;
        int i = 0;
        while (matched < m && i <= n - 1) {
            if (parent.get(i).equals(target.get(matched))) {
                if (matched == 0) {
                    startIdx = i;
                }
                matched++;
                i++;
                continue;
            }
            matched = 0;
            if (startIdx == -1) {
                i++;
            } else {
                i = startIdx + 1;
            }
            startIdx = -1;
        }
        if (matched == m) {
            return startIdx;
        }
        return -1;
    }
}
