package com.avi.practice.company.nutanix;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 20/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LRUCache {
    private final Map<Integer, Node> cache = new HashMap<>();
    private final int capacity;
    private final Node head;
    private final Node tail;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        head = new Node(0);
        tail = new Node(0);

        head.next = tail;
        head.prev = null;

        tail.next = null;
        tail.prev = head;
    }

    public final int get(final int key) {
        // check if key exists in cache if not then return -1
        final Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // node exists that means, we need to move that node at head as it's recently used
        moveToHead(node);
        return node.value;
    }

    public final void put(final int key, final int value) {
        // check if node exists in cache
        final Node node = cache.get(key);
        // if node already exists then simply update the node value and move to head
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }

        // node doesn't exist so now create a node and add to head
        // if size of the LRUCache increases then remove that from tail
        final Node newNode = new Node(key);
        newNode.value = value;
        cache.put(key, newNode);
        addToHead(newNode);
        size++;
        if (size > capacity) {
            final Node tail = removeFromTail();
            cache.remove(tail.key);
            size--;
        }
    }

    // Add node just after the head
    private void addToHead(final Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    final void removeNode(final Node node) {
        final Node next = node.next;
        final Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(final Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeFromTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    private static final class Node {
        private final int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key) {
            this.key = key;
        }
    }

}
