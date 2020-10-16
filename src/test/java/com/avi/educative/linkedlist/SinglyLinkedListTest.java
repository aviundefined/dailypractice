package com.avi.educative.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 15/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SinglyLinkedListTest {

    @Test
    public void isEmpty() {
        final SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void insertAtHead() {
        final SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Assert.assertTrue(list.isEmpty());

        list.insertAtHead(5);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(1, list.getSize());
        Assert.assertEquals(5, list.getHead().getData().intValue());

        list.insertAtHead(10);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(2, list.getSize());
        Assert.assertEquals(10, list.getHead().getData().intValue());

        list.insertAtHead(15);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(3, list.getSize());
        Assert.assertEquals(15, list.getHead().getData().intValue());

        list.insertAtHead(20);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(4, list.getSize());
        Assert.assertEquals(20, list.getHead().getData().intValue());

        list.print();
    }

    @Test
    public void insertAtEnd() {
        final SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Assert.assertTrue(list.isEmpty());

        list.insertAtEnd(5);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(1, list.getSize());
        Assert.assertEquals(5, list.getHead().getData().intValue());

        list.insertAtEnd(10);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(2, list.getSize());
        Assert.assertEquals(5, list.getHead().getData().intValue());

        list.insertAtEnd(15);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(3, list.getSize());
        Assert.assertEquals(5, list.getHead().getData().intValue());

        list.insertAtEnd(20);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(4, list.getSize());
        Assert.assertEquals(5, list.getHead().getData().intValue());

        list.print();
    }

    @Test
    public void insertAfter() {
        final SinglyLinkedList<Integer> list = createSLL();

        list.print();

        list.insertAfter(20, 25);
        list.print();

    }

    @Test
    public void searchNode() {
        final SinglyLinkedList<Integer> list = createSLL();
        list.print();
        Assert.assertTrue(list.searchNode(75));
        Assert.assertFalse(list.searchNode(40));
        Assert.assertFalse(list.searchNode(20));
        list.insertAfter(20, 25);
        Assert.assertTrue(list.searchNode(20));
    }

    @Test
    public void deleteAtHead() {
        final SinglyLinkedList<Integer> list = createSLL();
        list.print();
        while (!list.isEmpty()) {
            list.deleteAtHead();
            list.print();
        }
    }

    @Test
    public void deleteAtEnd() {
        final SinglyLinkedList<Integer> list = createSLL();
        list.print();
        while (!list.isEmpty()) {
            list.deleteAtEnd();
            list.print();
        }
    }

    @Test
    public void deleteByValue() {
        final SinglyLinkedList<Integer> list = createSLL();
        list.print();

        Assert.assertTrue(list.searchNode(45));
        list.deleteByValue(45);
        Assert.assertFalse(list.searchNode(45));


        Assert.assertTrue(list.searchNode(95));
        list.deleteByValue(95);
        Assert.assertFalse(list.searchNode(95));

        Assert.assertTrue(list.searchNode(5));
        list.deleteByValue(5);
        Assert.assertFalse(list.searchNode(5));

    }

    private SinglyLinkedList<Integer> createSLL() {
        final SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
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