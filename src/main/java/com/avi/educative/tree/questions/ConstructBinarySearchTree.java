package com.avi.educative.tree.questions;

/**
 * Created by navinash on 01/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ConstructBinarySearchTree {
    private int preIndex = 0;
    private final int size;
    private final int[] preoder;

    public ConstructBinarySearchTree(final int[] preorder) {
        this.preoder = preorder;
        this.size = preorder.length;
    }

    public Node<Integer> construct() {
        if (preoder == null || preoder.length == 0) {
            return null;
        }

        if (preoder.length == 1) {
            return new Node<>(preoder[0]);
        }

        return _construct(0, size - 1);
    }

    private Node<Integer> _construct(int start, int end) {
        if (preIndex >= size || start > end) {
            return null;
        }
        final Node<Integer> root = new Node<>(preoder[preIndex]);
        if (start == end) {
            return root;
        }
        preIndex++;
        final int index = _findFirstElementGreaterThanVal(root.getData(), start, end);
        root.setLeft(_construct(preIndex, index - 1));
        root.setRight(_construct(index + 1, end));
        return root;
    }

    private int _findFirstElementGreaterThanVal(final int data, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (preoder[i] >= data) {
                return i;
            }
        }
        return -1;
    }
}
