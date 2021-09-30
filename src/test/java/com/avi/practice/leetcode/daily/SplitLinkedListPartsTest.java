package com.avi.practice.leetcode.daily;

import com.avi.practice.leetcode.daily.SplitLinkedListParts.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 30/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SplitLinkedListPartsTest {

    @Test
    public void splitListToParts1() {
        final SplitLinkedListParts solver  = new SplitLinkedListParts();
        final int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int k  = 3;
        ListNode head = new ListNode(arr[0]);
        ListNode node = head;
        for (int i = 1; i < arr.length; i++) {
            final ListNode curr = new ListNode(arr[i]);
            node.next = curr;
            node = curr;
        }
        final ListNode[] splits = solver.splitListToParts(head, k);
        for (final ListNode split : splits) {
            ListNode.print(split);
        }
    }


}