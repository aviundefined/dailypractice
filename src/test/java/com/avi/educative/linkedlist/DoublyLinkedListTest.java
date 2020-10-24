package com.avi.educative.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 16/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DoublyLinkedListTest {

    @Test
    public void isEmpty() {
    }

    @Test
    public void deleteByValue() {
        final DoublyLinkedList<Integer> dll = createDLL();
        dll.print();
        Assert.assertTrue(dll.searchNode(25));
        dll.deleteByValue(25);
        Assert.assertFalse(dll.searchNode(25));
        dll.print();
    }

    private DoublyLinkedList<Integer> createDLL() {
        final DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAtHead(5);
        list.insertAtHead(15);
        list.insertAtHead(25);
        list.insertAtHead(35);
        list.insertAtHead(45);
        list.insertAtHead(55);
        list.insertAtHead(65);
        list.insertAtHead(75);
        list.insertAtHead(85);
        list.insertAtHead(95);
        return list;
    }
}