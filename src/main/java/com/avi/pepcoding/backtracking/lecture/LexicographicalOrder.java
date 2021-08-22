package com.avi.pepcoding.backtracking.lecture;

/**
 * Created by navinash on 23/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LexicographicalOrder {


    public final void printLexicographicalOrder(final int n) {
        if (n == 0) {
            return;
        }

        for (int i = 1; i <= 9; i++) {
            recurse(i, n);
        }
    }

    private void recurse(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        for (int j = 0; j <= 9; j++) {
            recurse(i * 10 + j, n);
        }
    }
}
