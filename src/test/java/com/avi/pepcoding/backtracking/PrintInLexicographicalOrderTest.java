package com.avi.pepcoding.backtracking;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 25/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintInLexicographicalOrderTest {

    private static final PrintInLexicographicalOrder solver = new PrintInLexicographicalOrder();

    @Test
    public void print100() {
        final int n = 100;
        solver.print(n);
        System.out.println("-----------------");
    }

    @Test
    public void print1000() {
        final int n = 1000;
        solver.print(n);
        System.out.println("-----------------");
    }
}