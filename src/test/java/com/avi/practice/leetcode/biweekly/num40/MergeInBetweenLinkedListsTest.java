package com.avi.practice.leetcode.biweekly.num40;

import com.avi.practice.leetcode.biweekly.num40.MergeInBetweenLinkedLists.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 01/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MergeInBetweenLinkedListsTest {

    private static final MergeInBetweenLinkedLists solver = new MergeInBetweenLinkedLists();

    @Test
    public void mergeInBetween() {
        final int[] arr1 = {0, 1, 2, 3, 4, 5};
        final int[] arr2 = {1000000, 1000001, 1000002};
        final int a = 3;
        final int b = 4;
        final int[] expectedArr = {0, 1, 2, 1000000, 1000001, 1000002, 5};
        final ListNode list1 = list(arr1);
        final ListNode list2 = list(arr2);
        final ListNode expected = list(expectedArr);
        final ListNode actual = solver.mergeInBetween(list1, a, b, list2);
        print(actual);
        assertList(expected, actual);
    }

    private ListNode list(int[] arr) {
        final ListNode list1 = new ListNode(arr[0]);
        ListNode head = list1;
        for (int i = 1; i < arr.length; i++) {
            ListNode curr = new ListNode(arr[i]);
            head.next = curr;
            head = curr;
        }
        return list1;
    }

    private void print(final ListNode list) {
        ListNode head = list;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private void assertList(final ListNode expected, final ListNode actual) {
        ListNode expectedHead = expected;
        ListNode actualdHead = actual;
        while (expectedHead != null) {
            Assert.assertEquals(String.valueOf(expectedHead.val), expectedHead.val, actualdHead.val);
            expectedHead = expectedHead.next;
            actualdHead = actualdHead.next;
        }
    }
}