package com.avi.educative.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 08/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CheckAncestorsTest {

    @Test
    public void findAncestors() {

        BinarySearchTree bsT = new BinarySearchTree();

        bsT.insert(6);

        bsT.insert(4);
        bsT.insert(9);
        bsT.insert(5);
        bsT.insert(2);
        bsT.insert(8);

        final String ancestors = CheckAncestors.findAncestors(bsT.getRoot(), 8);
        System.out.println(ancestors);
    }
}