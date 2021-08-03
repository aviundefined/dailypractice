package com.avi.pepcoding.stack_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by navinash on 02/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SlidingWindowMaximum {

    public final int[] maxSlidingWindow_Deque(final int[] arr, final int k) {
        if (arr == null || arr.length < k) {
            return new int[]{};
        }

        final int n = arr.length;
        final int[] result = new int[n - k + 1];
        final Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && arr[q.peekFirst()] < arr[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        result[0] = arr[q.peekFirst()];

        for (int resultIndex = 1, j = k; j < n; resultIndex++, j++) {
            // remove the last element if not in range
            if (!q.isEmpty() && j - q.peekFirst() >= k) {
                q.removeFirst();
            }

            while (!q.isEmpty() && arr[q.peekLast()] < arr[j]) {
                q.removeLast();
            }
            q.addLast(j);
            result[resultIndex] = arr[q.peekFirst()];
        }
        return result;
    }

    public final int[] maxSlidingWindow_Stack(final int[] arr, final int k) {
        if (arr == null || arr.length < k) {
            return new int[]{};
        }

        final int n = arr.length;
        final int[] result = new int[n - k + 1];
        final Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        final int[] nextGreaterRight = new int[n];
        nextGreaterRight[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            nextGreaterRight[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n - k + 1; i++) {
            int j = i;
            while (nextGreaterRight[j] < i + k) {
                j = nextGreaterRight[j];
            }
            result[i] = arr[j];
        }
        return result;
    }
}
