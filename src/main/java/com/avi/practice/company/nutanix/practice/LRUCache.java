package com.avi.practice.company.nutanix.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 28/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LRUCache {

    private final int capacity;
    private final Node head;
    private final Node tail;
    private final Map<Integer, Node> cache = new HashMap<>();
    private int size;

    public LRUCache(final int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node(0);
        this.tail = new Node(0);
    }

    // h <-> n1 <-> n2 <-> n3 <-> n4 <-> n5 <-> t
    // access n4
    // h <-> n4 <-> n1 <-> n2 <-> n3 <-> n5 <-> t
    public final int get(final int key) {
        // if key doesn't exist then return -1
        // if key exists then
        //      - get the value
        //      - move key to the front as it's recently used now
        //      - return value
        final Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // delete node and add after head
        final Node deletedNode = this.delete(node);
        addAfterHead(deletedNode);
        return node.value;
    }


    public final void put(final int key, final int value) {
        // if key exists then
        //      - update the value against key
        //      - move the key to the front as it's recently used now
        // if key doesn't exist then
        //      - add a key to the front as it's recently used now
        //      - if size of cache is hit, remove the element from tail
        final Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            // delete node and add after head
            final Node deletedNode = this.delete(node);
            addAfterHead(deletedNode);
        } else {
            final Node newNode = new Node(key);
            newNode.value = value;
            addAfterHead(newNode);
            this.cache.put(key, newNode);
            this.size++;
            if (this.size > this.capacity) {
                // delete from tail and delete it from cache as well
                final Node tail = deleteFromTail();
                this.cache.remove(tail.key);
            }
        }
    }

    // h <-> n1 <-> n2 <-> n3 <-> n4 <-> n5 <-> t
    // delete n4
    // h <-> n1 <-> n2 <-> n3 <-> n5 <-> t
    private Node delete(final Node node) {
        final Node prev = node.prev;
        final Node next = node.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        return node;
    }

    // h <-> n1 <-> n2 <-> n3 <-> n5 <-> t
    // add n4
    // h <-> n4 <-> n1 <-> n2 <-> n3 <-> n5 <-> t
    private void addAfterHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // h <-> n1 <-> n2 <-> n3 <-> n5 <-> t
    // h <-> n1 <-> n2 <-> n3 <-> t
    // return n5;
    private Node deleteFromTail() {
        return delete(tail.prev);
    }


    private static final class Node {
        private final int key;
        private int value;
        private Node prev;
        private Node next;

        private Node(int key) {
            this.key = key;
        }
    }
}
