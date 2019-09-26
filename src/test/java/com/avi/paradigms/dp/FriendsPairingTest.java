package com.avi.paradigms.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 26/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FriendsPairingTest {

    @Test
    public void pairs() {
        final FriendsPairing solver = new FriendsPairing();
        {
            final int numberOfPeople = 0;
            final int expected = 0;
            final int actual = solver.pairs(numberOfPeople);
            Assert.assertEquals(String.valueOf(numberOfPeople), expected, actual);
        }
        {
            final int numberOfPeople = 1;
            final int expected = 1;
            final int actual = solver.pairs(numberOfPeople);
            Assert.assertEquals(String.valueOf(numberOfPeople), expected, actual);
        }
        {
            final int numberOfPeople = 2;
            final int expected = 2;
            final int actual = solver.pairs(numberOfPeople);
            Assert.assertEquals(String.valueOf(numberOfPeople), expected, actual);
        }
        {
            final int numberOfPeople = 3;
            final int expected = 4;
            final int actual = solver.pairs(numberOfPeople);
            Assert.assertEquals(String.valueOf(numberOfPeople), expected, actual);
        }
        {
            final int numberOfPeople = 4;
            final int expected = 10;
            final int actual = solver.pairs(numberOfPeople);
            Assert.assertEquals(String.valueOf(numberOfPeople), expected, actual);
        }
        {
            final int numberOfPeople = 5;
            final int expected = 26;
            final int actual = solver.pairs(numberOfPeople);
            Assert.assertEquals(String.valueOf(numberOfPeople), expected, actual);
        }
        {
            final int numberOfPeople = 6;
            final int expected = 76;
            final int actual = solver.pairs(numberOfPeople);
            Assert.assertEquals(String.valueOf(numberOfPeople), expected, actual);
        }
    }
}
