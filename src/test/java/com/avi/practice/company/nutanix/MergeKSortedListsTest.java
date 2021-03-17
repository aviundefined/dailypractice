package com.avi.practice.company.nutanix;

import com.avi.practice.company.nutanix.MergeKSortedLists.ListNode;
import org.junit.Test;

/**
 * Created by navinash on 20/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MergeKSortedListsTest {
private static final MergeKSortedLists solver = new MergeKSortedLists();
    @Test
    public void mergeKLists() {

        final int[][] arrs = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        final ListNode[] lists = new ListNode[arrs.length];
        for(int i = 0; i < arrs.length; i++) {
            lists[i] = fromArr(arrs[i]);
        }
        for (ListNode list : lists) {
            list.print();
        }

        final ListNode actual = solver.mergeKLists(lists);
        actual.print();

    }

    private static ListNode fromArr(final int[] arr) {
        ListNode head = new ListNode();
        ListNode curr = head;
        ListNode prev = null;
        for(final int a : arr) {
            curr.val = a;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }
}