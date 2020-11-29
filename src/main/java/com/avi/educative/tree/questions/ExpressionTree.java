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
