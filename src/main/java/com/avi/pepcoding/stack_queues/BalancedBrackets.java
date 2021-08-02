package com.avi.pepcoding.stack_queues;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by navinash on 02/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BalancedBrackets {

    private static final Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public final boolean isBalanced(final String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        final Stack<Character> st = new Stack<>();
        for (final char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                final char matching = map.get(c);
                if (st.isEmpty()) {
                    return false;
                }
                while (!st.isEmpty() && st.peek() != matching) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    return false;
                }
                if (st.peek() != matching) {
                    return false;
                }
                st.pop();
            } else if (c == '(' || c == '{' || c == ']') {
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
