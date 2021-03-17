package com.avi.practice.company.nutanix.practice;

/**
 * Created by navinash on 28/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DoublyLinkedList {

    private final int capacity;
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    //h -> n1  -> n2 -> n3 -> t
    public void addToHead(final int value) {
        final Node node = new Node(value);
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
        this.size++;
    }

    //h -> n1  -> n2 -> n3 -> t
    public void addToTail(final int value) {
        final Node node = new Node(value);
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    // h -> n1  -> n2 -> n3 -> t
    // h -> n1  -> n2 -> n3(t)
    public Node removeFromTail() {
        if (this.size == 0) {
            return null;
        }
        final Node currentTail = this.tail;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = currentTail.prev;
            this.tail.next = null;
            currentTail.prev = null;
        }
        this.size--;
        return currentTail;
    }


    // h -> n1  -> n2 -> n3 -> t
    // n1  -> n2 -> n3 -> t
    public Node removeFromHead() {
        if (this.size == 0) {
            return null;
        }
        final Node currentHead = this.head;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = currentHead.next;
            this.head.prev = null;
            currentHead.next = null;
        }
        this.size--;
        return currentHead;
    }

    public void remove(final Node node) {
        if (node == null) {
            return;
        }
        final Node prev = node.prev;
        final Node next = node.next;
        if(prev != null) {
            prev.next = next;
        }
        if(next != null) {
            next.prev = prev;
        }
        this.size--;
    }

    private static final class Node {
        private final int value;
        private Node prev;
        private Node next;

        private Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
