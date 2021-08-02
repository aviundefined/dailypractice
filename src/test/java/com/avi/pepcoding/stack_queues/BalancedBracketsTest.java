package com.avi.pepcoding.stack_queues;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 02/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BalancedBracketsTest {

    @Test
    public void isBalanced1() {
        final BalancedBrackets solver = new BalancedBrackets();
        final String s = "[(a+b)+2*(c+d)*{e/f}]";
        final boolean expected = true;
        final boolean actual = solver.isBalanced(s);
        Assert.assertEquals(s, expected, actual);
    }
}