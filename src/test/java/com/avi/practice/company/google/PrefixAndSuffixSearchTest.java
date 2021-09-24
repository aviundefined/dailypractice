package com.avi.practice.company.google;

import com.avi.practice.company.google.PrefixAndSuffixSearch.WordFilter;
import org.junit.Test;

/**
 * Created by navinash on 19/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrefixAndSuffixSearchTest {

    @Test
    public void testUseCase1() {
        final String[] words = {"apple"};
        final WordFilter solver = new WordFilter(words);
        {
            final int id = solver.f("a", "e");
            System.out.println(id);
        }

    }


    @Test
    public void testUseCase2() {
        final String[] words = {"cabaabaaaa", "ccbcababac", "bacaabccba", "bcbbcbacaa", "abcaccbcaa", "accabaccaa", "cabcbbbcca", "ababccabcb", "caccbbcbab", "bccbacbcba"};
        final WordFilter solver = new WordFilter(words);
        System.out.println(solver.f("bccbacbcba", "a"));
        System.out.println(solver.f("ab", "abcaccbcaa"));
        System.out.println(solver.f("a", "aa"));
        System.out.println(solver.f("cabaaba", "abaaaa"));
        System.out.println(solver.f("cacc", "accbbcbab"));
        System.out.println(solver.f("ccbcab", "bac"));
        System.out.println(solver.f("bac", "cba"));
        System.out.println(solver.f("ac", "accabaccaa"));
        System.out.println(solver.f("bcbb", "aa"));
        System.out.println(solver.f("ccbca", "cbcababac"));

    }

    @Test
    public void testUseCase3() {
        final String[] words = {"abccaa", "abcaa"};
        final WordFilter solver = new WordFilter(words);
        System.out.println(solver.f("a", "aa"));
    }

    @Test
    public void testUseCase4() {
        final String[] words = {"abcaccbcaa","accabaccaa"};
        final WordFilter solver = new WordFilter(words);
        System.out.println(solver.f("a", "aa"));
    }


}