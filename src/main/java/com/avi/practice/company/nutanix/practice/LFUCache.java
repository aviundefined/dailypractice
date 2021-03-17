package com.avi.practice.company.nutanix.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 28/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LFUCache {

    // 2 : 1 <-> 2 <-> 3
    // 3 : 4 <-> 5
    private final int capacity;
    private final Map<Integer, DoublyLinkedList> listPointersByFreq = new HashMap<>();
    private final Map<Integer, Node> cache = new HashMap<>();
    private int size;
    private int minFreq = Integer.MAX_VALUE;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public final int get(final int key) {
        if (this.capacity == 0) {
            return -1;
        }
        // if key is not present return -1;
        // if key is present then
        //      - get the value
        //      - increase the counter for key
        //      - return the value
        final Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // remove node from old frequency DoublyLinkedList
        updateNode(key, node);
        // add node to head of few frequency DoublyLinkedList
        return node.value;
    }

    public final void put(final int key, final int value) {
        if (this.capacity == 0) {
            return;
        }
        // if key is not present then
        //      - insert key and value in cache
        //      - for key counter will be set to 1
        //      - if size of the cache hits the capacity then remove the least recent key from the minimum counter keys
        // if key is present then
        //      - update the value
        //      - for key counter will be increased by 1
        final Node node = this.cache.get(key);
        if (node != null) {
            node.value = value;
            updateNode(key, node);
        } else {
            if (this.size < this.capacity) {
                this.size++;
            } else {
                final DoublyLinkedList minFreqList = this.listPointersByFreq.get(minFreq);
                final Node deletedNode = minFreqList.removeFromTail();
                if (deletedNode != null) {
                    this.cache.remove(deletedNode.key);
                }
            }

            final Node newNode = new Node(key);
            newNode.value = value;
            minFreq = 1;
            final DoublyLinkedList newList = this.listPointersByFreq.computeIfAbsent(1, f -> new DoublyLinkedList());
            newList.addToHead(newNode);
            this.cache.put(key, newNode);
        }
    }

    private void updateNode(int key, Node node) {
        // remove node from old frequency DoublyLinkedList
        final int oldFreq = node.frequency;
        final DoublyLinkedList oldList = this.listPointersByFreq.get(oldFreq);
        oldList.delete(node);
        if (oldList.size == 0 && oldFreq == minFreq) {
            minFreq++;
        }
        // Create new Node whose key and value will be same frequency will be incremented by 1
        final Node newNode = new Node(key);
        newNode.value = node.value;
        newNode.frequency = oldFreq + 1;
        final DoublyLinkedList newList = this.listPointersByFreq.computeIfAbsent(newNode.frequency, f -> new DoublyLinkedList());
        newList.addToHead(newNode);
        // update newNode in cache as well
        this.cache.put(key, newNode);
    }

    private static final class Node {
        private final int key;
        private int value;
        private int frequency;
        private Node prev;
        private Node next;

        private Node(int key) {
            this.key = key;
            this.frequency = 1;
        }
    }

    private static final class DoublyLinkedList {
        private Node head;
        private Node tail;
        private int size = 0;

        // h <-> n1 <-> n2 <-> n3 <-> n5 <-> t
        // add n6 to head
        // n6 <-> h <-> n1 <-> n2 <-> n3 <-> n5 <-> t
        private void addToHead(final Node node) {
            if (this.size == 0) {
                this.head = node;
                this.tail = node;
            } else {
                this.head.prev = node;
                node.next = this.head;
                node.prev = null;
                this.head = node;
            }
            this.size++;
        }

        // h <-> n1 <-> n2 <-> n3 <-> n5 <-> t
        private void delete(final Node node) {
            if (node == null) {
                return;
            }
            if (this.size == 0) {
                return;
            }
            if (head == node && tail == node && this.size == 1) {
                head = null;
                tail = null;
            } else if (head == node) {
                final Node currentHead = this.head;
                this.head = this.head.next;
                this.head.prev = null;
                currentHead.next = null;
            } else if (tail == node) {
                final Node currentTail = this.tail;
                this.tail = currentTail.prev;
                this.tail.next = null;
                currentTail.next = null;
            } else {
                final Node prev = node.prev;
                final Node next = node.next;
                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                }
            }

            this.size--;
        }

        // h <-> n1 <-> n2 <-> n3 <-> n5 <-> t
        // // h <-> n1 <-> n2 <-> n3 <-> n5
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
                currentTail.next = null;
            }
            this.size--;
            return currentTail;
        }
    }
}
