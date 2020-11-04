package com.avi.educative.stack_queue;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 04/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class StackTest {

    @Test
    public void test() {
        final Stack<Integer> stack = new Stack<>(5);
        Assert.assertTrue("Empty", stack.isEmpty());
        Assert.assertFalse("Not full", stack.isFull());

        stack.push(1);
        Assert.assertFalse("Not Empty", stack.isEmpty());
        Assert.assertFalse("Not full", stack.isFull());
        stack.push(2);
        Assert.assertFalse("Not Empty", stack.isEmpty());
        Assert.assertFalse("Not full", stack.isFull());
        stack.push(3);
        Assert.assertFalse("Not Empty", stack.isEmpty());
        Assert.assertFalse("Not full", stack.isFull());
        stack.push(4);
        Assert.assertFalse("Not Empty", stack.isEmpty());
        Assert.assertFalse("Not full", stack.isFull());
        stack.push(5);
        Assert.assertFalse("Not Empty", stack.isEmpty());
        Assert.assertTrue("Full", stack.isFull());

        System.out.println(stack.pop());
        Assert.assertFalse("Not Empty", stack.isEmpty());
        Assert.assertFalse("Not full", stack.isFull());

        System.out.println(stack.pop());
        Assert.assertFalse("Not Empty", stack.isEmpty());
        Assert.assertFalse("Not full", stack.isFull());

        System.out.println(stack.pop());
        Assert.assertFalse("Not Empty", stack.isEmpty());
        Assert.assertFalse("Not full", stack.isFull());

        System.out.println(stack.pop());
        Assert.assertFalse("Not Empty", stack.isEmpty());
        Assert.assertFalse("Not full", stack.isFull());

        System.out.println(stack.pop());
        Assert.assertTrue("Empty", stack.isEmpty());
        Assert.assertFalse("Not full", stack.isFull());
    }
}