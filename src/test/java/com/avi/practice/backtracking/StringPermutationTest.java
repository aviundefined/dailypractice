package com.avi.practice.backtracking;

import org.junit.Test;

/**
 * Created by navinash on 20/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class StringPermutationTest {

    @Test
    public void printAll() {
        {
            final String s = "abc";
            final StringPermutation solver = new StringPermutation(s);
            solver.printAll();;
        }

        {
            final String s = "abcd";
            final StringPermutation solver = new StringPermutation(s);
            solver.printAll();;
        }

        {
            final String s = "abcde";
            final StringPermutation solver = new StringPermutation(s);
            solver.printAll();;
        }

    }
}