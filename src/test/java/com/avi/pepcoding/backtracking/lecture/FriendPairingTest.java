package com.avi.pepcoding.backtracking.lecture;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by navinash on 29/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FriendPairingTest extends TestCase {

    public void testGetAllCombinations() {
        final FriendPairing solver = new FriendPairing();
        final int n = 4;
        final List<String> allCombinations = solver.getAllCombinations(n);
        System.out.println(allCombinations);
    }
}