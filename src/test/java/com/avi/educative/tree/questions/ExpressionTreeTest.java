package com.avi.educative.tree.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 26/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ExpressionTreeTest {

    @Test
    public void construct1() {
        final ExpressionTree et = new ExpressionTree();
        final String postfix = "ab+ef*g*-";
        final Node<Character> root = et.construct(postfix);
        et.setRoot(root);
        System.out.println();
        System.out.println("infix expression is");
        et.inOrder();
    }

    @Test
    public void construct2() {
        final ExpressionTree et = new ExpressionTree();
        final String postfix = "34+56*7*-";
        final Node<Character> root = et.construct(postfix);
        et.setRoot(root);
        System.out.println();
        System.out.println("infix expression is");
        et.inOrder();
        final int actual = et.eval();
        System.out.println();
        System.out.println(actual);
        final int expected  = -203;
        Assert.assertEquals(expected, actual);
    }
}