package com.avi.paradigms.dp;

import com.avi.paradigms.dp.MaxSurvivalArea.Area;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 29/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxSurvivalAreaTest {

    @Test
    public void maxSurvival1() {
        final int powerA = 20;
        final int powerB = 8;
        final List<Area> areas = new ArrayList<>();
        areas.add(new Area(3, 2));
        areas.add(new Area(-5, -10));
        areas.add(new Area(-20, 5));
        final MaxSurvivalArea solver = new MaxSurvivalArea(powerA, powerB, areas);
        final int expected = 5;
        final int maxSurvival = solver.maxSurvival();
        Assert.assertEquals(expected, maxSurvival);
    }
}
