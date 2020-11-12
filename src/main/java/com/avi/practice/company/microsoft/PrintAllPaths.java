package com.avi.practice.company.microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintAllPaths {

    public final List<List<Integer>> getPathsDP(final int[][] a) {
        if (a == null || a.length == 0) {
            return Collections.emptyList();
        }

        final int m = a.length;
        final int n = a[0].length;
        final Paths[][] dp = new Paths[m][n];

        dp[0][0] = new Paths();
        final List<Integer> l = new ArrayList<>();
        l.add(a[0][0]);
        dp[0][0].paths.add(l);
        for (int i = 1; i < n; i++) {
            dp[0][i] = new Paths();
            final List<Integer> list = new ArrayList<>(dp[0][i - 1].paths.get(0));
            list.add(a[0][i]);
            dp[0][i].paths.add(list);
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = new Paths();
            final List<Integer> list = new ArrayList<>(dp[i - 1][0].paths.get(0));
            list.add(a[i][0]);
            dp[i][0].paths.add(list);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = new Paths();
                for (final List<Integer> path : dp[i][j - 1].paths) {
                    final List<Integer> list = new ArrayList<>(path);
                    list.add(a[i][j]);
                    dp[i][j].paths.add(list);
                }
                for (final List<Integer> path : dp[i - 1][j].paths) {
                    final List<Integer> list = new ArrayList<>(path);
                    list.add(a[i][j]);
                    dp[i][j].paths.add(list);
                }
            }
        }
        return dp[m - 1][n - 1].paths;
    }

    private static final class Paths {
        private final List<List<Integer>> paths = new ArrayList<>();
    }
}
