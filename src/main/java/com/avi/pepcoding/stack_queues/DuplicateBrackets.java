package com.avi.pepcoding.stack_queues;

import java.util.Stack;

/**
 * Created by navinash on 02/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DuplicateBrackets {

    public final boolean isDuplicateBracket(final String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        final Stack<Character> st = new Stack<>();
        for (final char c : s.toCharArray()) {
            if (c == ')') {
                if (st.isEmpty()) {
                    throw new RuntimeException("Invalid expression: " + s);
                }
                if (st.peek() == '(') {
                    return true;
                }
                while (!st.isEmpty() && st.peek() != '(') {
                    st.pop();
                }
                st.pop();
            } else {
                st.push(c);
            }
        }
        return false;
    }
}
