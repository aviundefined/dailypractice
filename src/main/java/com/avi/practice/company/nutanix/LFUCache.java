package com.avi.practice.company.nutanix;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 28/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LFUCache {

    private final Map<Integer, Node> cache = new HashMap<>();
    private final Map<Integer, LRU> lruByFreq = new HashMap<>();
    private final int capacity;
    private int minFreq = 1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        final Node node = this.cache.get(key);
        if (node == null) {
            return -1;
        }
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = this.cache.get(key);
        if (node == null) {
            node = new Node(key, value);
            this.cache.put(key, node);
            this.lruByFreq.computeIfAbsent(node.frequency, k -> new LRU()).addNode(node);

            if (this.cache.size() > capacity) {
                final LRU minFreqLRU = this.lruByFreq.computeIfAbsent(minFreq, k -> new LRU());
                final Node deleteNode = minFreqLRU.popTail();
                this.cache.remove(deleteNode.key);
            }
            minFreq = 1;
        } else {
            node.value = value;
            updateNode(node);
        }
    }

    private void updateNode(final Node node) {
        // check current node frequency and inrease it
        final int oldFreq = node.frequency;
        // remove node from old freq
        final LRU oldLRU = lruByFreq.computeIfAbsent(oldFreq, k -> new LRU());
        oldLRU.deleteNode(node);
        // increase freqency
        node.frequency++;
        // add node in new frequency
        final LRU newLRU = lruByFreq.computeIfAbsent(node.frequency, k -> new LRU());
        newLRU.addNode(node);

        // old LRU has no element so now there is a chance that minFreq has to update
        if (oldLRU.size == 0 && minFreq == oldFreq) {
            minFreq = node.frequency;
        }
    }

    private static final class LRU {
        private final Node head = new Node(0, 0);
        private final Node tail = new Node(0, 0);
        private int size = 0;

        private LRU() {
            head.next = tail;
            tail.prev = head;
        }

        private void addNode(final Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        private void deleteNode(final Node node) {
            final Node prev = node.prev;
            final Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        private void moveToHead(final Node node) {
            deleteNode(node);
            addNode(node);
        }

        private Node popTail() {
            final Node tailNode = tail.prev;
            deleteNode(tailNode);
            return tailNode;
        }

    }

    private static final class Node {
        private final int key;
        private int value;
        private int frequency;

        private Node next;
        private Node prev;

        private Node(final int key, final int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

}
