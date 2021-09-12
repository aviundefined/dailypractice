package com.avi.practice.company.compass;

import org.junit.Test;

import java.util.List;

/**
 * Created by navinash on 12/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AllPossibleStartingEndingLocationsTest {

    @Test
    public void getStartEndLocations1() {
        final AllPossibleStartingEndingLocations solver = new AllPossibleStartingEndingLocations();
        final String[][]   paths = {
                {"A", "B"},
                {"A", "C"},
                {"B", "K"},
                {"C", "K"},
                {"E", "L"},
                {"F", "G"},
                {"J", "M"},
                {"E", "F"},
                {"G", "H"},
                {"G", "I"},
                {"C", "G"}
        };
        final List<List<String>> allPaths = solver.getStartEndLocations(paths);
        System.out.println(allPaths);
    }
}