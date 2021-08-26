package com.avi.practice.company.google;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by navinash on 25/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ShortestPathVisitingAllNodesTest extends TestCase {

    public void testShortestPathLength1() {
        final ShortestPathVisitingAllNodes solver = new ShortestPathVisitingAllNodes();
        final int[][] arr = {{1, 2, 3}, {0}, {0}, {0}};
        final int expected = 4;
        final int actual = solver.shortestPathLength(arr);
        Assert.assertEquals(expected, actual);
    }
}