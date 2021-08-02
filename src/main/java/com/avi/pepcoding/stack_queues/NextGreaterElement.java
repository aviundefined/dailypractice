package com.avi.pepcoding.stack_queues;


import java.util.Stack;

/**
 * Created by navinash on 02/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NextGreaterElement {

    public final int[] nextGreaterElements_from_right_to_left(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        final int n = arr.length;
        final int[] result = new int[n];
        final Stack<Integer> s = new Stack<>();
        s.push(arr[n - 1]);
        result[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() < arr[i]) {
                s.pop();
            }
            result[i] = s.isEmpty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        return result;
    }

    public final int[] nextGreaterElements_from_left_to_right(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        final int n = arr.length;
        final int[] result = new int[n];
        final Stack<Integer> s = new Stack<>();
        s.push(0); // push first index
        for (int i = 1; i < n; i++) {
            if (s.isEmpty()) {
                s.push(i);
                continue;
            }

            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                result[s.pop()] = arr[i];

            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            result[s.pop()] = -1;
        }
        return result;
    }
}
