package com.avi.practice.leetcode.daily;

import java.util.Arrays;

/**
 * Created by navinash on 30/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SplitLinkedListParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        final int size = size(head);

        final int[] sizes = sizes(size, k);
        System.out.printf("size: %s, k: %s\n", size, k);
        System.out.printf("sizes: %s\n", Arrays.toString(sizes));
        final ListNode[] result = new ListNode[k];
        ListNode curr = head;
        for(int i = 0; i < k; i++) {
            final Pair split = split(curr, sizes[i]);
            result[i] = split.newHead;
            curr = split.curr;
        }
        return result;
    }

    public  Pair split(final ListNode head, final int numElements) {
        if(numElements == 0) {
            return new Pair(null, null);
        }
        ListNode newHead = new ListNode(head.val);
        ListNode newCurr = newHead;
        ListNode curr = head;
        int i = 1;
        while (i < numElements && curr.next != null) {
            newCurr.next = new ListNode(curr.next.val);
            curr = curr.next;
            newCurr = newCurr.next;
            i++;
        }
        return new Pair(newHead, curr.next);

    }

    static final class Pair {
         final ListNode newHead;
         final ListNode curr;


        private Pair(ListNode newHead, ListNode curr) {
            this.newHead = newHead;
            this.curr = curr;
        }
    }
    private int size(final ListNode head) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        return size;
    }

    private int[] sizes(final int size, final int k) {
        final int[] sizes = new int[k];
        if (size <= k) {
            for (int i = 0; i < size; i++) {
                sizes[i] = 1;
            }
            return sizes;
        }
        // size = 11, k = 3 -> 4, 4, 3
        final int mod = size % k;
        final int rem = size / k;
        for (int i = 0; i < k; i++) {
            sizes[i] = rem;
        }
        for (int i = 0; i < mod; i++) {
            sizes[i]++;
        }
        return sizes;
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

        public static void print(final ListNode head) {
            if(head == null) {
                System.out.println("null");
                return;
            }
            ListNode curr = head;
            while (curr != null) {
                System.out.print(curr.val + ",");
                curr = curr.next;
            }
            System.out.println();
        }
    }
}
