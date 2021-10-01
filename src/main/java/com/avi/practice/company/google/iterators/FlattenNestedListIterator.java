package com.avi.practice.company.google.iterators;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by navinash on 01/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FlattenNestedListIterator {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    static final class NestedIterator implements Iterator<Integer> {
        private final Stack<NestedInteger> st = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                st.push(nestedList.get(i));
            }
        }

        @Override
        public boolean hasNext() {
            while (!st.isEmpty() && !st.peek().isInteger()) {
                final NestedInteger curr = st.pop();
                for (int i = curr.getList().size() - 1; i >= 0; i--) {
                    st.push(curr.getList().get(i));
                }
            }
            return !st.isEmpty();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                return null;
            }
            return st.pop().getInteger();
        }
    }
}
