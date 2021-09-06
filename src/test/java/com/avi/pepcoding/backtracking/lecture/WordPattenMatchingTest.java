package com.avi.pepcoding.backtracking.lecture;

import junit.framework.TestCase;

/**
 * Created by navinash on 04/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class WordPattenMatchingTest extends TestCase {

    public void testAllPossibilities() {
        final WordPattenMatching solver = new WordPattenMatching();
        final String s = "mzaddytzaddy";
        final String pattern = "abcb";
        solver.allPossibilities(s, pattern);
    }
}