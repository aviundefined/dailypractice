package com.avi.practice.company.nutanix.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 28/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MRUQueue {

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;
    private int size = 0;

    public MRUQueue(int n) {
        this.capacity = n;
        for (int i = 1; i <= n; i++) {
            final Node node = addToTail(i);
            map.put(i, node);
        }
    }

    public int fetch(int k) {
        if (k > this.capacity || k > size) {
            return -1;
        }

        // get the node for given index
        final Node node = map.remove(k);
        // now delete that node
        final Node deletedNode = delete(node);
        // insert at tail
        addToTail(node.value);
        // update reference in map
        this.map.put(this.size, deletedNode);
        return node.value;
    }

    // h -> n1 -> n2 -> n3 -> t
    private Node addToTail(final int value) {
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
        return node;
    }

    // h -> n1 -> n2 -> n3 -> t
    private Node delete(final Node node) {
        if (this.size == 0 || node == null) {
            return null;
        }
        this.size--;
        if (this.head == node && this.tail == node) {
            this.head = null;
            this.tail = null;
            node.next = null;
            node.prev = null;
            return node;
        } else if (this.head == node) {
            Node currentHead = this.head;
            this.head = currentHead.next;
            this.head.prev = null;
            currentHead.next = null;
            return currentHead;
        } else if (this.tail == node) {
            Node currentTail = this.tail;
            this.tail = currentTail.prev;
            this.tail.next = null;
            currentTail.prev = null;
            return currentTail;
        } else {
            final Node prev = node.prev;
            final Node next = node.next;
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
            node.next = null;
            node.prev = null;
            return node;
        }
    }

    private static final class Node {
        private final int value;
        private Node prev;
        private Node next;

        private Node(final int value) {
            this.value = value;
        }
    }
}
