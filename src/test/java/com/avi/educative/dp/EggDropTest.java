package com.avi.educative.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 17/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class EggDropTest {

    private static final EggDrop solver = new EggDrop();

    @Test
    public void attempts() {
        {
            final int eggs = 1;
            final int floors = 100;
            final int expected = 100;
            final int actual = solver.attempts(eggs, floors);
            Assert.assertEquals(String.format("eggs: %s, floors: %s", eggs, floors), expected, actual);
        }
        {
            final int eggs = 2;
            final int floors = 6;
            final int expected = 3;
            final int actual = solver.attempts(eggs, floors);
            Assert.assertEquals(String.format("eggs: %s, floors: %s", eggs, floors), expected, actual);
        }
        {
            final int eggs = 2;
            final int floors = 100;
            final int expected = 14;
            final int actual = solver.attempts(eggs, floors);
            Assert.assertEquals(String.format("eggs: %s, floors: %s", eggs, floors), expected, actual);
        }
        {
            final int eggs = 2;
            final int floors = 36;
            final int expected = 8;
            final int actual = solver.attempts(eggs, floors);
            Assert.assertEquals(String.format("eggs: %s, floors: %s", eggs, floors), expected, actual);
        }
        {
            final int eggs = 3;
            final int floors = 100;
            final int expected = 9;
            final int actual = solver.attempts(eggs, floors);
            Assert.assertEquals(String.format("eggs: %s, floors: %s", eggs, floors), expected, actual);
        }
        {
            final int eggs = 3;
            final int floors = 36;
            final int expected = 6;
            final int actual = solver.attempts(eggs, floors);
            Assert.assertEquals(String.format("eggs: %s, floors: %s", eggs, floors), expected, actual);
        }
    }
}