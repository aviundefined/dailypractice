package com.avi.pepcoding.stack_queues;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 03/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class InfixEvaluatorTest {

    @Test
    public void evaluate1() {
        final InfixEvaluator solver = new InfixEvaluator();
        final String expression = "2+(5-3*6/2)";
        final int expected = -2;
        final int actual = solver.evaluate(expression);
        Assert.assertEquals(expression, expected, actual);
    }
}