package com.avi.educative.tree;

import org.junit.Test;

/**
 * Created by navinash on 08/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CheckKthMaxTest {

    @Test
    public void findKthMaxSolution1() {

        BinarySearchTree bsT = new BinarySearchTree();

        bsT.insert(6);

        bsT.insert(4);
        bsT.insert(9);
        bsT.insert(5);
        bsT.insert(2);
        bsT.insert(8);

        System.out.println(CheckKthMax.findKthMaxSolution1(bsT.getRoot(), 3));
        System.out.println(CheckKthMax.findKthMaxSolution1(bsT.getRoot(), 5));
    }

    @Test
    public void findKthMaxSolution2() {

        BinarySearchTree bsT = new BinarySearchTree();

        bsT.insert(6);

        bsT.insert(4);
        bsT.insert(9);
        bsT.insert(5);
        bsT.insert(2);
        bsT.insert(8);

        System.out.println(CheckKthMax.findKthMaxSolution2(bsT.getRoot(), 3));
        System.out.println(CheckKthMax.findKthMaxSolution2(bsT.getRoot(), 5));
    }
}