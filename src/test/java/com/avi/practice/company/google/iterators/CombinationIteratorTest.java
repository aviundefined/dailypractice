package com.avi.practice.company.google.iterators;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 01/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CombinationIteratorTest {

    @Test
    public void test() {
        final String characters = "abc";
        final int combinationLength = 2;
        final CombinationIterator itr = new CombinationIterator(characters, combinationLength);
        Assert.assertEquals("ab", itr.next());
        Assert.assertEquals(true, itr.hasNext());
        Assert.assertEquals("ac", itr.next());
        Assert.assertEquals(true, itr.hasNext());
        Assert.assertEquals("bc", itr.next());
        Assert.assertEquals(false, itr.hasNext());
    }
}