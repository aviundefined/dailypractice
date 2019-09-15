package com.avi.practice.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 15/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class MathPractice {

    final List<Integer> allFactors(final int A) {
        final ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= (A / 2 + 1); i++) {
            if (A % i == 0) {
                factors.add(i);
            }
        }
        if (A > 2) {
            factors.add(A);
        }
        return factors;
    }

    final List<Integer> allFactorsOptimized(final int A) {
        final ArrayList<Integer> factors = new ArrayList<>();
        final double sqrt = Math.sqrt(A);
        for (int i = 1; i <= sqrt; i++) {
            if (A % i == 0) {
                if (A / i == i) {
                    factors.add(i);
                } else {
                    factors.add(i);
                    factors.add(A / i);
                }
            }
        }
        Collections.sort(factors);
        return factors;
    }

    final int isPrime(final int A) {
        if (A == 1) {
            return 0;
        }
        if (A == 2 || A == 3) {
            return 1;
        }
        if (A % 2 == 0 || A % 3 == 0) {
            return 0;
        }
        final double sqrt = Math.sqrt(A);
        for (int i = 5; i <= sqrt; i = i + 6) {
            if (A % i == 0) {
                return 0;
            }
        }
        for (int i = 7; i <= sqrt; i = i + 6) {
            if (A % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
