package com.avi.practice.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 15/04/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FindTheWinnerOfTheCircularGame {

    public int findTheWinner(int n, int k) {
        final List<Integer> friends = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }
        int cur = 0;
        while (friends.size() > 1) {
            cur = (cur + k - 1) % (friends.size());
            friends.remove(cur);
        }
        return friends.get(0);
    }
}
