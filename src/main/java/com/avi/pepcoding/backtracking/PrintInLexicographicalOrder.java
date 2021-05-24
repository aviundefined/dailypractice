package com.avi.pepcoding.backtracking;

/**
 * Created by navinash on 25/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintInLexicographicalOrder {

    public void print(final int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
    }

    private void dfs(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        for (int j = 0; j < 10; j++) {
            dfs(10 * i + j, n);
        }
    }
}
