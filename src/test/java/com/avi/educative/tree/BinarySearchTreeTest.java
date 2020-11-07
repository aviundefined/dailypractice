package com.avi.educative.tree;

import org.junit.Test;

/**
 * Created by navinash on 07/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BinarySearchTreeTest {

    @Test
    public void insert() {
        final BinarySearchTree bsT = new BinarySearchTree();
        bsT.insert(6);
        bsT.insert(4);
        bsT.insert(9);
        bsT.insert(5);
        bsT.insert(2);
        bsT.insert(8);
        bsT.insert(12);
        bsT.insert(10);
        bsT.insert(14);
        bsT.printTree(bsT.getRoot());
    }

    @Test
    public void search() {
        final BinarySearchTree bsT = new BinarySearchTree();

        bsT.insert(6);
        bsT.insert(4);
        bsT.insert(9);
        bsT.insert(5);
        bsT.insert(2);
        bsT.insert(8);
        bsT.insert(12);
        bsT.insert(10);
        bsT.insert(14);
        System.out.println(">> Tree <<");
        bsT.printTree(bsT.getRoot());

        Node temp = bsT.search(5);
        if (temp != null) {
            System.out.println("\n" + temp.getData() + " found in Tree !");
        } else {
            System.out.println("\n5 not found in Tree !");
        }
        temp = bsT.search(51);
        if (temp != null) {
            System.out.println("\n" + temp.getData() + " found in Tree !");
        } else {
            System.out.println("51 not found in Tree !");
        }
    }

    @Test
    public void delete() {
        BinarySearchTree bsT = new BinarySearchTree();

        bsT.insert(6);
        bsT.insert(7);
        bsT.insert(8);
        bsT.insert(12);
        bsT.insert(1);
        bsT.insert(15);


        System.out.print("Tree : ");
        bsT.printTree(bsT.getRoot());


        System.out.print("\nDeleting Node 6: ");
        bsT.delete(6);
        bsT.printTree(bsT.getRoot());

        System.out.print("\nDeleting Node 15: ");
        bsT.delete(15);
        bsT.printTree(bsT.getRoot());

        System.out.print("\nDeleting Node 1: ");
        bsT.delete(1);
        bsT.printTree(bsT.getRoot());
    }
}