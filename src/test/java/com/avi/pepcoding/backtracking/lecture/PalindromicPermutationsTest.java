package com.avi.pepcoding.backtracking.lecture;

import junit.framework.TestCase;

/**
 * Created by navinash on 30/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PalindromicPermutationsTest extends TestCase {

    public void testPrintAllPalindromicPermutations1() {
        final String s = "aabbc";
        final PalindromicPermutations solver = new PalindromicPermutations();
        System.out.printf(" ------- %s -------\n",s);
        solver.printAllPalindromicPermutations(s);
        System.out.println("------------------");
    }


    public void testPrintAllPalindromicPermutations2() {
        final String s = "aabbcddeeffff";
        final PalindromicPermutations solver = new PalindromicPermutations();
        System.out.printf(" ------- %s -------\n",s);
        solver.printAllPalindromicPermutations(s);
        System.out.println("------------------");
    }
}