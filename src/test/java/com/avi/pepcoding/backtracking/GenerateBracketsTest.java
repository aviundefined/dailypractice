package com.avi.pepcoding.backtracking;

import org.junit.Test;

import java.util.List;

/**
 * Created by navinash on 15/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GenerateBracketsTest {

    @Test
    public void get() {

        final GenerateBrackets solver = new GenerateBrackets();
        {
            final List<String> actual = solver.get(3);
            System.out.println(actual);
        }
        {
            final List<String> actual = solver.get(5);
            System.out.println(actual);
        }

    }
}