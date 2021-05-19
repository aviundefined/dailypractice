package com.avi.practice.leetcode.problems.medium;

import org.junit.Test;

import java.util.List;

/**
 * Created by navinash on 19/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AnalyzeUserWebsiteVisitPatternTest {

    @Test
    public void mostVisitedPattern1() {
        final String[] username = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        final int[] timestamp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final String[] website = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
        final AnalyzeUserWebsiteVisitPattern solve = new AnalyzeUserWebsiteVisitPattern();
        final List<String> top = solve.mostVisitedPattern(username, timestamp, website);
        System.out.println(top);
    }

    @Test
    public void mostVisitedPattern2() {
        final String[] username = {"u1", "u1", "u1", "u2", "u2", "u2"};
        final int[] timestamp = {1, 2, 3, 4, 5, 6};
        final String[] website = {"a", "b", "a", "a", "b", "c"};
        final AnalyzeUserWebsiteVisitPattern solve = new AnalyzeUserWebsiteVisitPattern();
        final List<String> top = solve.mostVisitedPattern(username, timestamp, website);
        System.out.println(top);
    }

    @Test
    public void mostVisitedPattern3() {
        final String[] username = {"u1", "u1", "u1", "u2", "u2", "u2"};
        final int[] timestamp = {1, 2, 3, 4, 5, 6};
        final String[] website = {"a", "b", "c", "a", "b", "a"};
        final AnalyzeUserWebsiteVisitPattern solve = new AnalyzeUserWebsiteVisitPattern();
        final List<String> top = solve.mostVisitedPattern(username, timestamp, website);
        System.out.println(top);
    }
}