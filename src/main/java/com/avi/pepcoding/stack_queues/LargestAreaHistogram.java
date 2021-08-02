package com.avi.pepcoding.stack_queues;


import java.util.Arrays;
import java.util.Stack;

/**
 * Created by navinash on 02/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LargestAreaHistogram {

    public final int largestArea(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        final int n = arr.length;

        final int[] nextSmallerRight = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        nextSmallerRight[n - 1] = n;
        for(int i = n - 2; i >=0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nextSmallerRight[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        final int[] nextSmallerLeft = new int[n];
        st = new Stack<>();
        st.push(0);
        nextSmallerLeft[0] = -1;
        for(int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nextSmallerLeft[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        System.out.println("nextSmallerRight: "+ Arrays.toString(nextSmallerRight));
        System.out.println("nextSmallerLeft: "+ Arrays.toString(nextSmallerLeft));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            final int currArea = arr[i] * (nextSmallerRight[i] - nextSmallerLeft[i] - 1);
            max = Math.max(currArea, max);
        }
        return max;
    }
}
