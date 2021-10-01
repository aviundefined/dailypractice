package com.avi.practice.company.google.iterators;

import com.avi.practice.company.google.iterators.FlattenNestedListIterator.NestedIterator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 01/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FlattenNestedListIteratorTest {

    @Test
    public void testUseCase() {
        List<FlattenNestedListIterator.NestedInteger> nestedList = new ArrayList<>();
        final NestedIterator itr = new NestedIterator(nestedList);
    }
}