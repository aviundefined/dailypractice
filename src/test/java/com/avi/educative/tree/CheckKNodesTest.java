package com.avi.educative.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 08/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CheckKNodesTest {

    @Test
    public void findKNodes() {

        BinarySearchTree bsT = new BinarySearchTree();

        bsT.insert(6);
        bsT.insert(4);
        bsT.insert(9);
        bsT.insert(5);
        bsT.insert(2);
        bsT.insert(8);
        bsT.insert(12);
        bsT.insert(10);
        bsT.insert(14);

        final String ancestors = CheckKNodes.findKNodes(bsT.getRoot(),2);
        System.out.println(ancestors);
    }
}