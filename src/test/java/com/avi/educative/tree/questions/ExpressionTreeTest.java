package com.avi.educative.tree.questions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 26/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ExpressionTreeTest {

    @Test
    public void construct() {

        final ExpressionTree et = new ExpressionTree();
        final String postfix = "ab+ef*g*-";
        final Node<Character> root = et.construct(postfix);
        et.setRoot(root);
        System.out.println("infix expression is");
        et.inOrder();
    }
}