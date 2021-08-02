package com.avi.pepcoding.stack_queues;


import java.util.Stack;

/**
 * Created by navinash on 02/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LargestAreaHistogram {

    public final int largestRectangleArea(final int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        final int n = heights.length;

        final int[] nextSmallerRight = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        nextSmallerRight[n - 1] = n;
        for(int i = n - 2; i >=0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
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
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nextSmallerLeft[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            final int currArea = heights[i] * (nextSmallerRight[i] - nextSmallerLeft[i] - 1);
            max = Math.max(currArea, max);
        }
        return max;
    }
}
