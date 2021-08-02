package com.avi.pepcoding.stack_queues;

import java.util.Stack;

/**
 * Created by navinash on 02/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class StockSpan {

    public final int[] stockSpan(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        final int n = arr.length;
        final int[] result = new int[n];
        result[0] = 1;
        final Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        return result;
    }
}
