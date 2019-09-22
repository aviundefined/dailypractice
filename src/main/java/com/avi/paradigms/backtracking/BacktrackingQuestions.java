package com.avi.paradigms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 22/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class BacktrackingQuestions {
    private BacktrackingQuestions() {

    }

    static int solveNumOfLengthBLessThanC(List<Integer> A, int B, int C) {
        ArrayList<Integer> number = new ArrayList<>();
        while (C != 0) {
            number.add(0, C % 10);
            C /= 10;
        }
        if (number.size() < B) {
            return 0;
        } else if (number.size() > B) {
            boolean isZero = zeroPresent(A, 0);
            if (isZero && B > 1) {
                return (A.size() - 1) * ((int) Math.pow(A.size(), B - 1));
            } else {
                return (int) Math.pow(A.size(), B);
            }
        } else {
            return calculate(A, number, 0, B);
        }
    }

    private static boolean zeroPresent(List<Integer> A, int num) {
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == num) {
                return true;
            }
        }
        return false;
    }

    private static int calculate(List<Integer> A, ArrayList<Integer> number, int index, int B) {
        if (index == B) {
            return 0;
        }
        int lessthan = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < number.get(index)) {
                if (A.get(i) == 0 && index == 0 && B > 1) {
                    lessthan--;
                }
                lessthan++;
            }
        }
        int result = lessthan * ((int) Math.pow(A.size(), B - index - 1));
        boolean isPresent = zeroPresent(A, number.get(index));
        if (isPresent) {
            result = result + (calculate(A, number, index + 1, B));
        }
        return result;
    }

}
