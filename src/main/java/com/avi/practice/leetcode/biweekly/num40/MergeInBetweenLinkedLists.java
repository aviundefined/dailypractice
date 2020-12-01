package com.avi.practice.leetcode.biweekly.num40;

/**
 * Created by navinash on 01/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * You are given two linked lists: list1 and list2 of sizes n and m respectively.
 * <p>
 * Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
 * <p>
 * The blue edges and nodes in the following figure incidate the result:
 * <p>
 * <p>
 * Build the result list and return its head.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * Output: [0,1,2,1000000,1000001,1000002,5]
 * Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
 * Example 2:
 * <p>
 * <p>
 * Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
 * Explanation: The blue edges and nodes in the above figure indicate the result.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= list1.length <= 104
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 104
 */
public class MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // first find out the prev element of ath node
        ListNode prevA = list1;
        while (prevA != null) {
            if (prevA.next.val == a) {
                break;
            }
            prevA = prevA.next;
        }
        // Now find out the next node of b
        ListNode curr = prevA;
        ListNode nextB = curr.next;
        while (curr != null && nextB != null) {
            if (curr.val == b) {
                break;
            }
            curr = curr.next;
            nextB = curr.next;
        }
        // Now find the tail of list2
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }

        prevA.next = list2;
        tail2.next = nextB;
        return list1;
    }


    public static class ListNode {
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
    }
}
