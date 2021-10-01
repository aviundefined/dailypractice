package com.avi.practice.company.google.iterators;

import com.avi.practice.company.google.iterators.DesignCompressedStringIterator.StringIterator;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 01/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DesignCompressedStringIteratorTest {

    @Test
    public void testUseCase1() {
        final String s = "L1e2t1C1o1d1e1";
        final StringIterator itr = new StringIterator(s);
        Assert.assertEquals('L', itr.next());
        Assert.assertEquals('e', itr.next());
        Assert.assertEquals('e', itr.next());
        Assert.assertEquals('t', itr.next());
        Assert.assertEquals('C', itr.next());
        Assert.assertEquals('o', itr.next());
        Assert.assertEquals(true, itr.hasNext());
        Assert.assertEquals('d', itr.next());
        Assert.assertEquals(true, itr.hasNext());
    }

}