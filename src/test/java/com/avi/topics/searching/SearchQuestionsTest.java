package com.avi.topics.searching;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 21/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SearchQuestionsTest {

    @Test
    public void findListInList() {
        {
            final List<Integer> parent = Arrays.asList(5, 10, 20);
            final List<Integer> target = Arrays.asList(10, 20);
            final int expected = 1;
            final int startIndex = SearchQuestions.findListInList(parent, target);
            Assert.assertEquals(expected, startIndex);
        }
        {
            final List<Integer> parent = Arrays.asList(1, 2, 1, 2, 3, 4, 5);
            final List<Integer> target = Arrays.asList(1, 2, 3, 4);
            final int expected = 2;
            final int startIndex = SearchQuestions.findListInList(parent, target);
            Assert.assertEquals(expected, startIndex);
        }
        {
            final List<Integer> parent = Arrays.asList(1, 2, 2, 1, 2, 3);
            final List<Integer> target = Arrays.asList(1, 2, 3, 4);
            final int expected = -1;
            final int startIndex = SearchQuestions.findListInList(parent, target);
            Assert.assertEquals(expected, startIndex);
        }
    }
}
