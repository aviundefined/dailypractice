package com.avi.paradigms.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 11/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NextPermutationTest {

    @Test
    public void next() {
        final NextPermutation solver = new NextPermutation();
        String s = "12345";
        String next = solver.next(s);
        String expected = "12354";
        Assert.assertEquals(s, expected, next);

        s = next;
        expected = "12435";
        next = solver.next(s);
        Assert.assertEquals(s, expected, next);

        s = next;
        expected = "12453";
        next = solver.next(s);
        Assert.assertEquals(s, expected, next);

        s = next;
        expected = "12534";
        next = solver.next(s);
        Assert.assertEquals(s, expected, next);

    }
}
