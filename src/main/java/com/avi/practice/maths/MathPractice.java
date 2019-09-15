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
}
