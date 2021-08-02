package com.avi.pepcoding.stack_queues;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 02/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DuplicateBracketsTest {

    @Test
    public void isDuplicateBracket1() {
        final DuplicateBrackets solver = new DuplicateBrackets();
        final String s = "((a+b)+(c+d))";
        final boolean expected = false;
        final boolean actual = solver.isDuplicateBracket(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void isDuplicateBracket2() {
        final DuplicateBrackets solver = new DuplicateBrackets();
        final String s = "(a+b)+((c+d))";
        final boolean expected = true;
        final boolean actual = solver.isDuplicateBracket(s);
        Assert.assertEquals(s, expected, actual);
    }
}