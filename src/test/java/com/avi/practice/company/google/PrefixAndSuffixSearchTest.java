package com.avi.practice.company.google;

import com.avi.practice.company.google.PrefixAndSuffixSearch.WordFilter;
import org.junit.Test;

/**
 * Created by navinash on 19/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrefixAndSuffixSearchTest {

    @Test
    public void testUseCase1() {
        final String[] words = {"apple"};
        final WordFilter solver = new WordFilter(words);
        {
            final int id = solver.f("a", "e");
            System.out.println(id);
        }

    }

}