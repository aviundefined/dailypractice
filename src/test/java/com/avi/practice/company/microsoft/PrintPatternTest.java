package com.avi.practice.company.microsoft;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintPatternTest {

    private static final PrintPattern solver = new PrintPattern();

    @Test
    public void print1() {
        final int n = 16;
        final int diff = 5;
        solver.print(n, diff);
    }

    @Test
    public void print2() {
        final int n = 10;
        final int diff = 5;
        solver.print(n, diff);
    }
}