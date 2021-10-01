package com.avi.practice.company.google;

import com.avi.practice.company.google.iterators.MergingIterator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by navinash on 29/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MergingIteratorTest {


    @Test
    public void test() {
        final List<Iterator<Integer>> itrs = new ArrayList<>();
        itrs.add(Arrays.asList(2, 5, 9).iterator());
        itrs.add(Arrays.asList(4, 10).iterator());
        MergingIterator itr = new MergingIterator(itrs);

        Assert.assertTrue(itr.hasNext()); // true
        Assert.assertEquals(2, itr.next().intValue());
        Assert.assertEquals(4, itr.next().intValue());
        Assert.assertEquals(5, itr.next().intValue());
        Assert.assertEquals(9, itr.next().intValue());
        Assert.assertEquals(10, itr.next().intValue());
        Assert.assertFalse(itr.hasNext()); // true
        boolean exceptionThrown = false;
        try {
            itr.next();
            Assert.fail();

        } catch (final RuntimeException ignored) {
            exceptionThrown = true;
        }
        Assert.assertTrue(exceptionThrown);
    }
}