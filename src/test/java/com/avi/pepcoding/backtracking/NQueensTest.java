package com.avi.pepcoding.backtracking;

import org.junit.Test;

/**
 * Created by navinash on 24/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NQueensTest {
    private static final NQueens solver = new NQueens();

    @Test
    public void place4() {
        final int n = 4;
        solver.place(n);
    }

    @Test
    public void place5() {
        final int n = 4;
        solver.place(n);
    }

    @Test
    public void place8() {
        final int n = 8;
        solver.place(n);
    }
}