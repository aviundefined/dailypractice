package com.avi.pepcoding.backtracking.lecture;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by navinash on 22/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintAbbreviationsTest extends TestCase {

    public void testAllAbbreviations1() {
        final PrintAbbreviations solver = new PrintAbbreviations();
        final String s = "pep";
        final List<String> allAbbreviations = solver.allAbbreviations(s);
        System.out.println(allAbbreviations);
    }

    public void testAllAbbreviations2() {
        final PrintAbbreviations solver = new PrintAbbreviations();
        final String s = "avinash";
        final List<String> allAbbreviations = solver.allAbbreviations(s);
        System.out.println(allAbbreviations);
    }
}