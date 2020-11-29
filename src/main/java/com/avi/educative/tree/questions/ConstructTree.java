package com.avi.educative.tree.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 30/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ConstructTree<T> {

    private int preIndex = 0;
    private final Map<T, Integer> inorderIndexByValue = new HashMap<>();
    private final T[] inorder;
    private final T[] preorder;

    public ConstructTree(final T[] inorder, final T[] preorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexByValue.put(inorder[i], i);
        }
    }

    public final Node<T> constructFromInorderAndPreorder() {
        if (inorder == null || preorder == null || inorder.length != preorder.length || inorder.length == 0) {
            return null;
        }

        return _constructFromInorderAndPreorder(0, inorder.length - 1);
    }

    private Node<T> _constructFromInorderAndPreorder(final int start, final int end) {
        if (start > end) {
            return null;
        }

        final Node<T> root = new Node<>(preorder[preIndex++]);

        if (start == end) {
            return root;
        }
        final int index = _search(root.getData());
        root.setLeft(_constructFromInorderAndPreorder(start, index - 1));
        root.setRight(_constructFromInorderAndPreorder(index + 1, end));
        return root;
    }

    private int _search(T data) {
        return inorderIndexByValue.getOrDefault(data, -1);
    }
}
