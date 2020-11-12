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

    public final List<List<Integer>> getPathsRecursive(final int[][] a) {
        if (a == null || a.length == 0) {
            return Collections.emptyList();
        }

        final int m = a.length;
        final int n = a[0].length;
        final List<List<Integer>> paths = new ArrayList<>();
        final int[] path = new int[m + n - 1];
        _getPathsRecursive(a, m, n, 0, 0, 0, path, paths);
        return paths;
    }

    private void _getPathsRecursive(int[][] a, int m, int n, int i, int j, int idx, int[] path, List<List<Integer>> paths) {
        path[idx] = a[i][j];
        if (i == m - 1) {
            for(int k = j + 1; k < n; k++) {
                path[idx + k - j] = a[i][k];
            }
            for(int k = 0; k < idx + n - j; k++) {

            }
        }
        if (j == n - 1) {
            for(int k = i + 1; k < m; k++) {
                path[idx + k - j] = a[k][j];
            }

        }
        _getPathsRecursive(a, m, n, i + 1, j, idx + 1, path, paths);
        _getPathsRecursive(a, m, n, i, j + 1, idx + 1, path, paths);
    }

    private static final class Paths {
        private final List<List<Integer>> paths = new ArrayList<>();
    }
}
