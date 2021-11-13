package com.avi.practice.company.microsoft;

/**
 * Created by navinash on 28/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MyHashMap {

    private static final int MODULO = 1000;

    private final Node[] values = new Node[MODULO];

    public MyHashMap() {

    }

    public void put(final int key, final int value) {
        final int idx = hash(key);
        if (values[idx] == null) {
            values[idx] = new Node(-1, -1);
        }
        final Node prev = find(values[idx], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }


    public int get(final int key) {
        final int idx = hash(key);

        if (values[idx] == null) {
            return -1;
        }
        final Node prev = find(values[idx], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }

    public void remove(final int key) {
        final int idx = hash(key);
        if (values[idx] == null) {
            return;
        }
        final Node prev = find(values[idx], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }

    private Node find(final Node head, final int key) {
        Node prev = null;
        Node curr = head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    private int hash(int key) {
        return key % MODULO;
    }

    private static final class Node {
        private final int key;
        private int value;
        private Node next;

        private Node(final int key, final int value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "(" + key + "," + value + ")";
        }
    }
}
