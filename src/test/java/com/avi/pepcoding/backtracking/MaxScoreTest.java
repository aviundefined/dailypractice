package com.avi.pepcoding.backtracking;

import org.junit.Test;

/**
 * Created by navinash on 25/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxScoreTest {

    @Test
    public void maxScore1() {
        final String[] words = {"dog", "cat", "dad", "good"};
        final int[] scores = {
                1, 0, 9, 5, 0, 0, 3, 0,
                0, 0, 0, 0, 0, 0, 2, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0
        };

        final int[] charMap = {
                1, 1, 1, 3, 0, 0, 1, 0,
                0, 0, 0, 0, 0, 0, 2, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0
        };
        final MaxScore solver = new MaxScore();
        final MaxScore.Result result = solver.maxScore(words, charMap, scores);
        System.out.println(result);
    }
}