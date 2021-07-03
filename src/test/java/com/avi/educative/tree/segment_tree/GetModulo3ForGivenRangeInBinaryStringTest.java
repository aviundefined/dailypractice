package com.avi.educative.tree.segment_tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 02/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GetModulo3ForGivenRangeInBinaryStringTest {

    @Test
    public void test() {
        final String binaryString = "101100";
        final GetModulo3ForGivenRangeInBinaryString solver = new GetModulo3ForGivenRangeInBinaryString(binaryString);
        Assert.assertEquals(2, solver.getModulo3(0, 5));
        Assert.assertEquals(2, solver.getModulo3(0, 2));
        Assert.assertEquals(1, solver.getModulo3(3, 5));
        Assert.assertEquals(2, solver.getModulo3(0, 1));
        Assert.assertEquals(1, solver.getModulo3(2, 2));
        Assert.assertEquals(2, solver.getModulo3(3, 4));
        Assert.assertEquals(0, solver.getModulo3(5, 5));
        Assert.assertEquals(1, solver.getModulo3(0, 0));
        Assert.assertEquals(0, solver.getModulo3(1, 1));
        Assert.assertEquals(1, solver.getModulo3(3, 3));
        Assert.assertEquals(0, solver.getModulo3(4, 4));
        Assert.assertEquals(0, solver.getModulo3(2, 5));
    }
}