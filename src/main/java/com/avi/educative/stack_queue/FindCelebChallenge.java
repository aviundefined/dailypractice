package com.avi.educative.stack_queue;

/**
 * Created by navinash on 04/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FindCelebChallenge {

    public int findCelebrity(int[][] party, int numPeople) {

        final Stack<Integer> s = new Stack<>(numPeople);
        for (int i = 0; i < numPeople; i++) {
            s.push(i);
        }

        int celebrity = -1;
        while (!s.isEmpty()) {
            final int person1 = s.pop();
            if (s.isEmpty()) {
                celebrity = person1;
                break;
            }
            final int person2 = s.pop();
            final boolean oneKnowsSecond = firstKnowsSecond(party, person1, person2);
            final boolean secondKnowsOne = firstKnowsSecond(party, person2, person1);
            // person1 knows person2 but person2 doesn't know person1
            if (oneKnowsSecond && !secondKnowsOne) {
                s.push(person2);
            }
            // person2 knows person1 but person1 doesn't know person2
            if (secondKnowsOne && !oneKnowsSecond) {
                s.push(person1);
            }
        }

        if(celebrity == -1) {
            return -1;
        }
        for (int i = 0; i < numPeople; i++) {
            if(celebrity == i) {
                continue;
            }
            final boolean celebrityKnowsIth = firstKnowsSecond(party, celebrity, i);
            if (celebrityKnowsIth) {
                return -1;
            }
            final boolean ithKnowsCelebrity = firstKnowsSecond(party, i, celebrity);
            if (!ithKnowsCelebrity) {
                return -1;
            }
        }
        return celebrity;
    }

    private static boolean firstKnowsSecond(int[][] party, final int first, final int second) {
        return party[first][second] == 1;
    }
}
