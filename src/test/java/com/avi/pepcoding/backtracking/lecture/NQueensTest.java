package com.avi.pepcoding.backtracking.lecture;

import junit.framework.TestCase;

/**
 * Created by navinash on 22/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NQueensTest extends TestCase {

    public void testPrintAllConfigurations4() {
        final NQueens solver =new NQueens();
        final int n = 4;
        System.out.printf("-------- %s --------\n", n);
        solver.printAllConfigurations(n);
    }

    public void testPrintAllConfigurations5() {
        final NQueens solver =new NQueens();
        final int n = 5;
        System.out.printf("-------- %s --------\n", n);
        solver.printAllConfigurations(n);
    }

    public void testPrintAllConfigurations6() {
        final NQueens solver =new NQueens();
        final int n = 6;
        System.out.printf("-------- %s --------\n", n);
        solver.printAllConfigurations(n);
    }

    public void testPrintAllConfigurations7() {
        final NQueens solver =new NQueens();
        final int n = 7;
        System.out.printf("-------- %s --------\n", n);
        solver.printAllConfigurations(n);
    }

    public void testPrintAllConfigurations8() {
        final NQueens solver =new NQueens();
        final int n = 8;
        System.out.printf("-------- %s --------\n", n);
        solver.printAllConfigurations(n);
    }
}