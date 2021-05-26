package com.avi.pepcoding.dp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 26/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FriendsPairingTest {
    private static final FriendsPairing solver = new FriendsPairing();

    @Test
    public void pairs() {
        final int n = 5;
        final int expected = 26;
        final int actual = solver.pairs(n);
        Assert.assertEquals(String.valueOf(n), expected, actual);
    }
}