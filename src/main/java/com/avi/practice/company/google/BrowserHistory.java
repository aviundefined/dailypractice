package com.avi.practice.company.google;

/**
 * Created by navinash on 17/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BrowserHistory {
    private Node head;
    private int curr;
    private int size;

    public BrowserHistory(String homepage) {
        this.head = new Node(homepage);
        this.curr = 0;
        this.size = 1;

    }

    public void visit(String url) {
        final Node node = new Node(url);
        head.next = node;
        node.prev = head;
        head = node;
        curr++;
        size++;
    }

    public String back(int steps) {
        steps = Math.min(curr, steps);
        // 0.    1.   2.    3.     4  h
        // w1 -> w2 -> w3 -> w4 -> w5
        Node node = head;
        while (steps > 0 && curr > 0 && node.prev != null) {
            final Node prev = node.prev;
            node = prev;
            curr--;
            steps--;
        }
        head = node;
        return node.value;
    }

    public String forward(int steps) {
        steps = Math.min(size - curr - 1, steps);
        Node node = head;
        while (steps > 0 && curr < size && node.next != null) {
            final Node next = node.next;
            node = next;
            steps--;
            curr++;
        }
        head = node;
        return node.value;
    }

    private static final class Node {
        private final String value;
        private Node next;
        private Node prev;

        private Node(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }
}
