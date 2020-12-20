package com.avi.practice.company.microsoft.leetcode.medium;

import com.avi.practice.company.microsoft.leetcode.medium.AddTwoNumbersII.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 20/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AddTwoNumbersIITest {

    private static final AddTwoNumbersII solver = new AddTwoNumbersII();
    @Test
    public void addTwoNumbers1() {

        final ListNode l1 = new ListNode(7);
        final ListNode l1next1 = new ListNode(2);
        final ListNode l1next2 = new ListNode(4);
        final ListNode l1next3 = new ListNode(3);
        l1.next = l1next1;
        l1next1.next = l1next2;
        l1next2.next = l1next3;
        l1next3.next = null;

        final ListNode l2 = new ListNode(5);
        final ListNode l2next1 = new ListNode(6);
        final ListNode l2next2 = new ListNode(4);
        l2.next = l2next1;
        l2next1.next = l2next2;
        l2next2.next = null;

        final ListNode output = solver.addTwoNumbers(l1, l2);
        output.print();
    }

    @Test
    public void addTwoNumbers2() {
        final ListNode l1 = new ListNode(5);
        final ListNode l2 = new ListNode(5);

        final ListNode output = solver.addTwoNumbers(l1, l2);
        output.print();

    }

    @Test
    public void addTwoNumbers3() {
        final ListNode l1 = new ListNode(1);
        final ListNode l2 = new ListNode(9);
        final ListNode l2next1 = new ListNode(9);
        l2.next = l2next1;

        final ListNode output = solver.addTwoNumbers(l1, l2);
        output.print();

    }
}