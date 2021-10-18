package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 18/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MKAverageTest {

    @Test
    public void testUseCase1() {
        /*
         * ["MKAverage", "addElement", "addElement", "calculateMKAverage", "addElement", "calculateMKAverage", "addElement", "addElement", "addElement", "calculateMKAverage"]
         * [[3, 1], [3], [1], [], [10], [], [5], [5], [5], []]
         * Output
         * [null, null, null, -1, null, 3, null, null, null, 5]
         */

        final int m = 3;
        final int k = 1;
        final MKAverage solver = new MKAverage(m , k);
        solver.addElement(3);
        solver.addElement(1);
        Assert.assertEquals(-1, solver.calculateMKAverage());
        solver.addElement(10);
        Assert.assertEquals(3, solver.calculateMKAverage());
        solver.addElement(5);
        solver.addElement(5);
        solver.addElement(5);
        Assert.assertEquals(5, solver.calculateMKAverage());

    }
}