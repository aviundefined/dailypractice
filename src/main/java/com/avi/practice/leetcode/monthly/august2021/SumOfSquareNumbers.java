package com.avi.practice.leetcode.monthly.august2021;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by navinash on 26/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SumOfSquareNumbers {


    public boolean judgeSquareSum_LinearSearch(int c) {
        if (c <= 2) {
            return true;
        }

        if (isSquare(c)) {
            return true;
        }


        // now do a binary search over candidates
        for (int  a = 1; a * a <= c; a++) {
            final int bSquare = c - (a * a);
            if (isSquare(bSquare)) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum_UsingMap(int c) {
        if (c <= 2) {
            return true;
        }

        if (isSquare(c)) {
            return true;
        }

        final Set<Long> candidates = new HashSet<>();
        for (long squares = 1; squares * squares <= c; squares++) {
            candidates.add(squares * squares);
        }

        // now do a binary search over candidates
        for (final long aSquare : candidates) {
            final long bSquare = c - aSquare;
            if (candidates.contains(bSquare)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSquare(final int n) {
        final int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return true;
        }
        return false;
    }

    public boolean judgeSquareSum_BinarySearch(int c) {
        if (c <= 2) {
            return true;
        }

        if (isSquare(c)) {
            return true;
        }


        // now do a binary search over candidates
        for (int  a = 1; a * a <= c; a++) {
            final int bSquare = c - (a * a);
            if (binarySearch(1, bSquare, bSquare)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int start, int end, int max) {
        if(start > end) {
            return false;
        }

        final int mid = start + (end - start)/2;
        if(mid * mid == max) {
            return true;
        }
        if(mid * mid > max) {
            return binarySearch(start, mid - 1, max);
        }
        return binarySearch(mid + 1, end, max);
    }
}
