package com.avi.practice.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by navinash on 21/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        final int n = nums2.length;
        final Map<Integer, Integer> indexByValue = new HashMap<>();
        final int[] nextGreaterValue = new int[n];
        final Stack<Integer> st = new Stack<>();
        nextGreaterValue[n - 1] = -1;
        st.push(nums2[n-1]);
        indexByValue.put(nums2[n - 1], n - 1);
        for(int i = n - 2; i >= 0; i--) {
            indexByValue.put(nums2[i], i);

            if(st.peek() > nums2[i]) {
                nextGreaterValue[i] = st.peek();
                st.push(nums2[i]);
            }else {
                while(!st.isEmpty() && st.peek() <= nums2[i]) {
                    st.pop();
                }
                if(st.isEmpty()) {
                    nextGreaterValue[i] = -1;
                }else {
                    nextGreaterValue[i] = st.peek();
                }
                st.push(nums2[i]);
            }
        }

        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            final int idx = indexByValue.get(nums1[i]);
            result[i] = nextGreaterValue[idx];
        }
        return result;
    }
}
