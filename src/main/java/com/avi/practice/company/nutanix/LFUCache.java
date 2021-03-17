package com.avi.practice.company.nutanix;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 28/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LFUCache {
    private final int capacity;
    private final Map<Integer, DoublyLinkedList<Node>> headPtrByFrequency = new HashMap<>();
    private final Map<Integer, Node> nodesByKey = new HashMap<>();
    private int size;
    private int minFrequency = Integer.MAX_VALUE;

    LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        minFrequency = 0;
    }

    int get(final int key) {
        // Get the Key
        final Node node = nodesByKey.get(key);
        if (node == null) {
            return -1;
        }
        return updateNode(key, node);
    }

    private int updateNode(int key, Node node) {
        final int oldFrequency = node.frequency;
        // Remove from oldFrequency LRUCache
        final DoublyLinkedList<Node> oldList = headPtrByFrequency.get(oldFrequency);
        if (oldList != null) {
            oldList.remove(node);
            if (oldList.size == 0) {
                this.headPtrByFrequency.remove(oldFrequency);
            }
            if (minFrequency > oldFrequency && oldList.size > 0) {
                minFrequency = oldFrequency;
            }
        }
        // if present the,
        final int newFrequency = node.incrementFrequency();
        // Add in newFrequency LRUCache
        final DoublyLinkedList<Node> newList = headPtrByFrequency.computeIfAbsent(newFrequency, f -> new DoublyLinkedList<>());
        newList.addToHead(key, newFrequency);

        if (minFrequency > newFrequency && newList.size > 0) {
            minFrequency = newFrequency;
        }
        return node.value;
    }

    void put(int key, int value) {
        // if key is present then
        // the flow is pretty much same as get
        // only difference is update the new value then
        // delete from old frequency doubly linked list
        // add in new frequency doubly linked list
        final Node node = nodesByKey.get(key);
        if (node != null) {
            node.value = value;
            updateNode(key, node);
        } else {
            // if node not present
            // then add in frequency 1 list
            final DoublyLinkedList<Node> newList = headPtrByFrequency.computeIfAbsent(1, f -> new DoublyLinkedList<>());
            // add node in newList
            final LFUCache.Node newNode = newList.addToHead(key, value);
            nodesByKey.put(key, newNode);
            size++;
            if (size > capacity) {
                this.size--;
                // remove tail from minimumFrequency
                final DoublyLinkedList<Node> minFreqList = headPtrByFrequency.get(minFrequency);
                minFreqList.popFromTail();
                if (minFreqList.size == 0) {
                    for (final Map.Entry<Integer, DoublyLinkedList<Node>> e : headPtrByFrequency.entrySet()) {
                        if (e.getValue().size > 0 && e.getKey() < minFrequency) {
                            minFrequency = e.getKey();
                        }
                    }
                }
            }
        }
    }


    private static final class Node {
        private final int key;
        private int value;
        private int frequency;
        private Node prev;
        private Node next;

        private Node(final int key) {
            this.key = key;
            this.frequency = 1;
        }

        private int incrementFrequency() {
            return ++this.frequency;
        }
    }

    private static final class DoublyLinkedList<Node> {
        private LFUCache.Node head;
        private LFUCache.Node tail;
        private int size = 0;


        public LFUCache.Node addToHead(int key, int value) {
            final LFUCache.Node node = new LFUCache.Node(key);
            node.value = value;
            if (this.size == 0) {
                this.head = node;
                this.tail = node;
            } else {
                this.head.prev = node;
                node.next = head;
                this.head = node;
            }
            this.size++;
            return node;
        }


        public LFUCache.Node popFromTail() {
            if (this.size == 0) {
                return null;
            }

            final LFUCache.Node currentTail = this.tail;
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

        public void remove(final LFUCache.Node node) {
            if (node == null) {
                return;
            }
            if (this.size == 0) {
                return;
            }
            final LFUCache.Node prev = node.prev;
            final LFUCache.Node next = node.next;
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
            this.size--;
        }
    }

}
