package com.avi.practice.company.microsoft.leetcode.medium;

/**
 * Created by navinash on 20/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revers1 = reverse(l1);
        ListNode revers2 = reverse(l2);
        int sum = revers1.val + revers2.val;
        int carry = sum / 10;
        int value = sum % 10;
        ListNode result = new ListNode(value);
        ListNode head = result;
        revers1 = revers1.next;
        revers2 = revers2.next;
        while (revers1 != null && revers2 != null) {
            final ListNode curr = new ListNode();
            sum = revers1.val + revers2.val + carry;
            carry = sum / 10;
            value = sum % 10;
            curr.val = value;
            head.next = curr;
            head = head.next;
            revers1 = revers1.next;
            revers2 = revers2.next;
        }

        while (revers1 != null) {
            final ListNode curr = new ListNode();
            sum = revers1.val + carry;
            carry = sum / 10;
            value = sum % 10;
            curr.val = value;
            head.next = curr;
            head = head.next;
            revers1 = revers1.next;
        }

        while (revers2 != null) {
            final ListNode curr = new ListNode();
            sum = revers2.val + carry;
            carry = sum / 10;
            value = sum % 10;
            curr.val = value;
            head.next = curr;
            head = head.next;
            revers2 = revers2.next;
        }
        if (carry != 0) {
            final ListNode curr = new ListNode();
            value = carry % 10;
            curr.val = value;
            head.next = curr;
            head = head.next;
        }
        final ListNode answer = reverse(result);
        return answer;
    }

    public ListNode reverse(final ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public static final class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        void print() {
            ListNode curr = this;
            while (curr != null) {
                System.out.print(curr.val + ",");
                curr = curr.next;
            }
            System.out.println();
        }
    }

}
