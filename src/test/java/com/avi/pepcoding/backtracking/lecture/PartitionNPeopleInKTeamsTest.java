package com.avi.pepcoding.backtracking.lecture;

import junit.framework.TestCase;

/**
 * Created by navinash on 30/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PartitionNPeopleInKTeamsTest extends TestCase {

    public void testGetAllTeams() {
        final PartitionNPeopleInKTeams solver = new PartitionNPeopleInKTeams();
        final int n = 4;
        final int k = 3;
        solver.getAllTeams(n, k);
    }
}