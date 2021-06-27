package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 20/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RangeModuleTest {

    @Test
    public void testUsecase1() {
        /*
         *
         * ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
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

}