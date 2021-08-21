package com.avi.pepcoding.stack_queues;


import java.util.Stack;

/**
 * Created by navinash on 14/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SmallestNumberFollowingPattern {

    public int smallestNumberFollowingPattern(final String pattern) {
        // pattern: ddiddidd
        if(pattern == null || pattern.length() == 0 || "".equals(pattern.trim())) {
            return 0;
        }

        final StringBuilder sb = new StringBuilder();
        final Stack<Integer> st = new Stack<>();
        int num = 1;
        for(final char c : pattern.toCharArray()) {
            if(c == 'd') {
                st.push(num);
                num++;
            }else{
                st.push(num);
                num++;
                while(!st.isEmpty()) {
                    sb.append(st.pop());
                }
            }
        }
        st.push(num);
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return Integer.parseInt(sb.toString());
    }
}
