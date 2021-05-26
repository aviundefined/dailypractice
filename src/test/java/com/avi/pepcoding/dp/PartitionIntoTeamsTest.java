package com.avi.pepcoding.dp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 26/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PartitionIntoTeamsTest {

    private static final PartitionIntoTeams solver = new PartitionIntoTeams();

    @Test
    public void divideNPlayersIntoKTeams() {
        final int n = 4;
        final int k = 3;
        final long expected = 6L;
        final long actual = solver.divideNPlayersIntoKTeams(n, k);
        Assert.assertEquals(String.format("(%s, %s)", n, k), expected, actual);
    }
}