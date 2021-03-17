package com.avi.practice.company.nutanix;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by navinash on 20/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return new ListNode();
        }
        final int k = lists.length;
        final PriorityQueue<Element> queue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o.value));
        final Map<Integer, ListNode> currNodeByListIndex = new HashMap<>();
        for (int i = 0; i < k; i++) {
            queue.add(new Element(i, lists[i].val));
            currNodeByListIndex.put(i, lists[i]);
        }
        final ListNode merged = new ListNode();
        ListNode current = merged;
        ListNode prev = null;
        while (!queue.isEmpty()) {
            final Element element = queue.poll();
            current.val = element.value;
            current.next = new ListNode();
            prev = current;
            current = current.next;
            final ListNode currNode = currNodeByListIndex.get(element.listNumber);
            if (currNode.next != null) {
                currNodeByListIndex.put(element.listNumber, currNode.next);
                queue.add(new Element(element.listNumber, currNode.next.val));
            } else {
                currNodeByListIndex.remove(element.listNumber);
            }
        }
        prev.next = null;
        return merged;
    }

    private static final class Element {
        private final int listNumber;
        private final int value;

        private Element(int listNumber, int value) {
            this.listNumber = listNumber;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "listNumber=" + listNumber +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        final int k = 4;
        final PriorityQueue<Element> queue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o.value));
        queue.add(new Element(0, 200));
        queue.add(new Element(1, 1));
        queue.add(new Element(0, 4));
        queue.add(new Element(2, 0));
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        {
            final int size = 3;
            final PriorityQueue<Integer> q = new PriorityQueue<>(size, (o1, o2) -> o1 - o2);
            final int[] nums = {4, 5, 8, 2};

            for(int num: nums) {
                if(q.size() < size) {
                    q.add(num);
                }else {
                    if(num > q.peek()) {
                        q.poll();
                        q.add(num);
                    }
                }
            }

            final TreeSet<Character> set = new TreeSet<>();

            System.out.println(q.peek());
        }

    }

    static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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
