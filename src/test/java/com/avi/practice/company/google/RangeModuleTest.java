package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeSet;

/**
 * Created by navinash on 20/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RangeModuleTest {

    @Test
    public void testUseCase1() {
        /*
         *
         * ["RangeModuleNotWorking", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
         * [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
         * Output
         *[null, null, null, true, false, true]
         */
        final RangeModule solver = new RangeModule();
        solver.addRange(10, 20);
        solver.removeRange(14, 16);
        Assert.assertTrue(solver.queryRange(10, 14));
        Assert.assertFalse(solver.queryRange(13, 15));
        Assert.assertTrue(solver.queryRange(16, 17));
    }


    @Test
    public void testUseCase2() {
        /*
         *
         * ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
         * [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
         * Output
         *[null, null, null, true, false, true]
         */
        final RangeModule solver = new RangeModule();
        solver.addRange(10, 14);
        Assert.assertTrue(solver.queryRange(10, 13));
        Assert.assertTrue(solver.queryRange(10, 14));
        Assert.assertTrue(solver.queryRange(11, 13));
        solver.addRange(18, 20);
        solver.addRange(23, 26);
        solver.addRange(12, 24);
        Assert.assertTrue(solver.queryRange(10, 13));
        Assert.assertTrue(solver.queryRange(11, 13));
        Assert.assertTrue(solver.queryRange(10, 14));

    }

    @Test
    public void testUseCase1_NotWorking() {
        /*
         *
         * ["RangeModuleNotWorking", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
         * [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
         * Output
         *[null, null, null, true, false, true]
         */
        final RangeModuleNotWorking solver = new RangeModuleNotWorking();
        solver.addRange(10, 20);
        solver.removeRange(14, 16);
        Assert.assertTrue(solver.queryRange(10, 14));
        Assert.assertFalse(solver.queryRange(13, 15));
        Assert.assertTrue(solver.queryRange(16, 17));
    }


    @Test
    public void testUseCase2_NotWorking() {
        /*
         *
         * ["RangeModuleNotWorking", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
         * [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
         * Output
         *[null, null, null, true, false, true]
         */
        final RangeModuleNotWorking solver = new RangeModuleNotWorking();
        solver.addRange(10, 14);
        Assert.assertTrue(solver.queryRange(10, 13));
        Assert.assertTrue(solver.queryRange(10, 14));
        Assert.assertTrue(solver.queryRange(11, 13));
        solver.addRange(18, 20);
        solver.addRange(23, 26);
        solver.addRange(12, 24);
        Assert.assertTrue(solver.queryRange(10, 13));
        Assert.assertTrue(solver.queryRange(11, 13));
        Assert.assertTrue(solver.queryRange(10, 14));
    }

    @Test
    public void funWithTreeSet() {
        final TreeSet<Integer> set = new TreeSet<>();
        set.add(4);
        set.add(8);
        set.add(12);
        set.add(16);
        set.add(20);
        set.add(24);

        System.out.println(set.tailSet(10));
        System.out.println(set.headSet(10));
    }

}