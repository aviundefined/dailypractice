package com.avi.educative.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 08/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CheckKthMax {

    public static int findKthMaxSolution1(Node root, int k) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }

        final List<Integer> list = new ArrayList<>();
        _inOrderTraversal(root, list);
        if (k <= list.size()) {
            return list.get(list.size() - k);
        }
        return Integer.MIN_VALUE;
    }


    public static int findKthMaxSolution2(Node root, Integer k) {
        final Counter counter = new Counter();
        return _findKthMaxSolution2(root, k, counter);
    }

    private static int _findKthMaxSolution2(final Node root, final int k, Counter counter) {
        if (root == null || counter.get() >= k) {
            return Integer.MIN_VALUE;
        }

        _findKthMaxSolution2(root.getRight(), k, counter);


        if (counter.incrementGet() == k) {
            return root.getData();

        }
        return _findKthMaxSolution2(root.getLeft(), k, counter);
    }

    private static void _inOrderTraversal(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        _inOrderTraversal(root.getLeft(), list);
        list.add(root.getData());
        _inOrderTraversal(root.getRight(), list);
    }

    private static final class Counter {
        private int count = 0;

        private void increment() {
            count++;
        }

        private void decrement() {
            count--;
        }

        private int incrementGet() {
            increment();
            return this.count;
        }

        private int decrementGet() {
            decrement();
            return this.count;
        }

        private int get() {
            return this.count;
        }

    }
}
