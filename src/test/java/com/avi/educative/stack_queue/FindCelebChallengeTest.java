package com.avi.educative.stack_queue;

import org.junit.Test;

/**
 * Created by navinash on 04/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FindCelebChallengeTest {

    private FindCelebChallenge solver = new FindCelebChallenge();

    @Test
    public void test() {
        int[][] party1 = {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
        };

        System.out.println(solver.findCelebrity(party1, 4));

        int [][] party2 = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,1},
                {0,1,1,0},
        };

        System.out.println(solver.findCelebrity(party2, 4));

        int[][] party3 = {
                {0, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 0},
        };

        System.out.println(solver.findCelebrity(party3, 4));
    }
}
