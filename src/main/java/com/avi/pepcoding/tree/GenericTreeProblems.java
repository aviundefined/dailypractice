package com.avi.pepcoding.tree;

import com.avi.pepcoding.tree.model.GenericNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by navinash on 15/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GenericTreeProblems {

    public final GenericNode construct(final int[] arr) {
        if (arr == null) {
            return null;
        }
        GenericNode root = null;
        final Stack<GenericNode> s = new Stack<>();
        for (final int num : arr) {
            if (num == -1) {
                if (s.isEmpty()) {
                    throw new IllegalArgumentException("Not a valid euler path arr:" + Arrays.toString(arr));
                }
                s.pop();
            } else {
                final GenericNode t = new GenericNode(num);
                if (s.isEmpty()) {
                    root = t;
                } else {
                    s.peek().getChildren().add(t);
                }
                s.push(t);
            }
        }
        return root;
    }

    public final void display(final GenericNode root) {
        String str = root.getData() + "-->";
        for (final GenericNode child : root.getChildren()) {
            str += child.getData() + ",";
        }
        System.out.println(str);
        for (final GenericNode child : root.getChildren()) {
            display(child);
        }
    }

    public final int sizeIterative(final GenericNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        final Stack<GenericNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            count++;
            final GenericNode curr = s.pop();
            for (final GenericNode child : curr.getChildren()) {
                s.push(child);
            }
        }
        return count;
    }

    public int sizeRecursive(GenericNode root) {
        int size = 0;
        for (final GenericNode child : root.getChildren()) {
            size += sizeRecursive(child);
        }
        return size + 1;
    }

    public int max(GenericNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int max = root.getData();
        for (final GenericNode child : root.getChildren()) {
            max = Math.max(max, max(child));
        }
        return max;
    }

    public int height(GenericNode root) {
        if (root == null) {
            return 0;
        }

        int height = -1;
        for (final GenericNode child : root.getChildren()) {
            height = Math.max(height, height(child));
        }
        return height + 1;
    }

    public void preOrder(final GenericNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getData());
        for (final GenericNode child : root.getChildren()) {
            preOrder(child);
        }
    }

    public void postOrder(final GenericNode root) {
        if (root == null) {
            return;
        }
        for (final GenericNode child : root.getChildren()) {
            postOrder(child);
        }
        System.out.println(root.getData());
    }

    public void levelOrder(final GenericNode root) {
        if (root == null) {
            return;
        }
        final Queue<GenericNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            // remove mark* word add* -> remove work add (for tree)
            final GenericNode curr = q.poll();
            System.out.println(curr.getData());
            q.addAll(curr.getChildren());
        }
    }

    public void levelOrderWithLevels(final GenericNode root) {
        final Map<Integer, List<Integer>> nodesByLevel = new TreeMap<>();
        _levelOrderWithLevels(root, 0, nodesByLevel);
        for (final Map.Entry<Integer, List<Integer>> e : nodesByLevel.entrySet()) {
            System.out.printf("Level: %d: Nodes: %s\n", e.getKey(), e.getValue());
        }
    }

    public void levelOrderZigZag(final GenericNode root) {
        final Map<Integer, List<Integer>> nodesByLevel = new TreeMap<>();
        _levelOrderWithLevels(root, 0, nodesByLevel);
        for (final Map.Entry<Integer, List<Integer>> e : nodesByLevel.entrySet()) {
            if (e.getKey() % 2 == 0) {
                System.out.println(e.getValue());
            } else {
                Collections.reverse(e.getValue());
                System.out.println(e.getValue());
            }
        }
    }

    public void levelOrderWithLevelsTwoQueue(final GenericNode root) {
        if (root == null) {
            return;
        }
        Queue<GenericNode> mq = new ArrayDeque<>();
        Queue<GenericNode> cq = new ArrayDeque<>();
        mq.add(root);
        while (!mq.isEmpty()) {
            final GenericNode curr = mq.poll();
            System.out.print(curr.getData() + ",");
            for (final GenericNode child : curr.getChildren()) {
                cq.add(child);
            }
            if (mq.isEmpty()) {
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    public void levelOrderZigZagTwoStack(final GenericNode root) {
        if (root == null) {
            return;
        }
        Stack<GenericNode> mq = new Stack<>();
        Stack<GenericNode> cq = new Stack<>();
        mq.add(root);
        boolean isLeftToRight = true;
        while (!mq.isEmpty()) {
            final GenericNode curr = mq.pop();
            System.out.print(curr.getData() + ",");
            if (isLeftToRight) {
                for (final GenericNode child : curr.getChildren()) {
                    cq.push(child);
                }
            } else {
                for (int i = curr.getChildren().size() - 1; i >= 0; i--) {
                    cq.add(curr.getChildren().get(i));
                }
            }
            if (mq.isEmpty()) {
                mq = cq;
                cq = new Stack<>();
                isLeftToRight = !isLeftToRight;
                System.out.println();
            }
        }
    }

    public void mirror(final GenericNode root) {
        if (root == null) {
            return;
        }
        for (final GenericNode child : root.getChildren()) {
            mirror(child);
        }
        Collections.reverse(root.getChildren());
    }

    public void removeLeaves(final GenericNode root) {
        if (root == null) {
            return;
        }
        for (int i = root.getChildren().size() - 1; i >= 0; i--) {
            final GenericNode child = root.getChildren().get(i);
            if (child.getChildren().size() == 0) {
                root.getChildren().remove(i);
            }
        }
        for (final GenericNode child : root.getChildren()) {
            removeLeaves(child);
        }
    }

    public GenericNode linearize(final GenericNode root) {
        if (root == null || root.getChildren().size() == 0) {
            return root;
        }
        final GenericNode lastTail = linearize(root.getChildren().get(root.getChildren().size() - 1));
        while (root.getChildren().size() > 1) {
            final GenericNode last = root.getChildren().remove(root.getChildren().size() - 1);
            final GenericNode secondLastTail = linearize(root.getChildren().get(root.getChildren().size() - 1));
            secondLastTail.getChildren().add(last);
        }
        return lastTail;
    }

    private void _levelOrderWithLevels(GenericNode root, int level, Map<Integer, List<Integer>> nodesByLevel) {
        if (root == null) {
            return;
        }
        nodesByLevel.computeIfAbsent(level, k -> new ArrayList<>()).add(root.getData());
        for (final GenericNode child : root.getChildren()) {
            _levelOrderWithLevels(child, level + 1, nodesByLevel);
        }
    }
}
