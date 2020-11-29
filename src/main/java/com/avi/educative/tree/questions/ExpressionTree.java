package com.avi.educative.tree.questions;

import java.util.Stack;

/**
 * Created by navinash on 26/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ExpressionTree extends BinaryTree<Character> {

    public Node<Character> construct(final String postfix) {
        if (postfix == null || postfix.length() < 3) {
            return null;
        }
        final Stack<Node<Character>> s = new Stack<>();
        for (final char c : postfix.toCharArray()) {
            if (isOperator(c)) {
                final Node<Character> op = new Node<>(c);
                op.setRight(s.pop());
                op.setLeft(s.pop());
                s.push(op);
            } else {
                s.push(new Node<>(c));
            }
        }
        return s.pop();
    }

    public int eval() {
        System.out.println();
        return _eval(root);
    }

    private int _eval(Node<Character> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return Character.getNumericValue(root.getData());
        }

        final int leftValue = _eval(root.getLeft());
        final int rightValue = _eval(root.getRight());
        final Character operator = root.getData();
        switch (operator) {
            case '+':
                return leftValue + rightValue;
            case '-':
                return leftValue - rightValue;
            case '*':
                return leftValue * rightValue;
            case '/':
                return leftValue / rightValue;
        }
        return 0;
    }

    private boolean isOperator(final char c) {
        switch (c) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
            default:
                return false;
        }
    }

}
