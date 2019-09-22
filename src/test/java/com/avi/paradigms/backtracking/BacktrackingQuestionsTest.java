package com.avi.paradigms.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 22/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BacktrackingQuestionsTest {

    @Test
    public void solveNumOfLengthBLessThanC() {
        {
            final List<Integer> arr = Arrays.asList(0, 1, 5);
            final int targetLength = 1;
            final int targetNumber = 2;
            final int expected = 2;
            System.out.println(String.format("List: %s, targetLength=[%s], targetNumber=[%s]", arr, targetLength, targetNumber));
            final int solutions = BacktrackingQuestions.solveNumOfLengthBLessThanC(arr, targetLength, targetNumber);
            Assert.assertEquals(expected, solutions);
        }
        {
            final List<Integer> arr = Arrays.asList(0, 1, 2, 5);
            final int targetLength = 2;
            final int targetNumber = 21;
            final int expected = 5;
            System.out.println(String.format("List: %s, targetLength=[%s], targetNumber=[%s]", arr, targetLength, targetNumber));
            final int solutions = BacktrackingQuestions.solveNumOfLengthBLessThanC(arr, targetLength, targetNumber);
            Assert.assertEquals(expected, solutions);
        }
    }
}
