package com.avi.pepcoding.backtracking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by navinash on 23/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GenerateAbbreviationsTest {
    private static final GenerateAbbreviations solver = new GenerateAbbreviations();

    @Test
    public void generate1() {
        final String s = "pep";
        final List<String> abbreviations = solver.generate(s);
        System.out.println(abbreviations);
    }

    @Test
    public void generate2() {
        final String s = "avinash";
        final List<String> abbreviations = solver.generate(s);
        System.out.println(abbreviations);
    }

    @Test
    public void generate3() {
        final String s = "shristi";
        final List<String> abbreviations = solver.generate(s);
        System.out.println(abbreviations);
    }
}