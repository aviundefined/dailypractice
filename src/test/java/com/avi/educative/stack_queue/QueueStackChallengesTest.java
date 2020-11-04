package com.avi.educative.stack_queue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 04/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class QueueStackChallengesTest {

    private final QueueStackChallenges solver = new QueueStackChallenges();

    @Test
    public void reverseFirstK() {

        final Queue<Integer> queue = new Queue<>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);

        solver.reverseFirstK(queue, 5);

        System.out.print("Queue: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }


    @Test
    public void evaluatePostFix() {
        {
            final String expression = "921*-8-4+";
            final int expected = 3;
            final int actual = QueueStackChallenges.evaluatePostFix(expression);
            Assert.assertEquals(expression, expected, actual);
        }
    }

    @Test
    public void getNextGreaterNumber() {
        {
            int[] arr = {4, 6, 3, 2, 8, 1, 11};
            int[] expected = {6, 8, 8, 8, 11, 11, -1};
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(expected));
            int[] actual = solver.getNextGreaterNumber(arr);
            System.out.println(Arrays.toString(expected));
            Assert.assertArrayEquals(actual, expected);
            System.out.println("------------------------");
        }

        {
            int[] arr = {1, 3, 8, 4, 10, 5};
            int[] expected = {3, 8, 10, 10, -1, -1};
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(expected));
            int[] actual = solver.getNextGreaterNumber(arr);
            System.out.println(Arrays.toString(expected));
            Assert.assertArrayEquals(actual, expected);
            System.out.println("------------------------");
        }
    }

    @Test
    public void isBalanced() {
        {
            final String exp = "{[()]}";
            final boolean expected = true;
            final boolean actual  = QueueStackChallenges.isBalanced(exp);
            Assert.assertEquals(exp, expected, actual);
        }
        {
            final String exp = "[{(}]";
            final boolean expected = false;
            final boolean actual  = QueueStackChallenges.isBalanced(exp);
            Assert.assertEquals(exp, expected, actual);
        }
    }
}