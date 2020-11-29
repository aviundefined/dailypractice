package com.avi.practice.company.microsoft;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * Given a number n, print following a pattern without using any loop.
 * <p>
 * Examples :
 * <p>
 * Input: n = 16
 * Output: 16, 11, 6, 1, -4, 1, 6, 11, 16
 * <p>
 * Input: n = 10
 * Output: 10, 5, 0, 5, 10
 */
public class PrintPattern {

    public void print(final int a, final int diff) {
        _printHelper(a, diff, a, true);
        System.out.println();
    }

    private void _printHelper(int curr, int diff, int max, boolean decreaseValue) {
        System.out.print(curr + ",");
        if (!decreaseValue && curr == max) {
            return;
        }

        if (decreaseValue) {
            // curr - diff <= 0 then have to flip the flag
            if (curr - diff <= 0) {
                _printHelper(curr - diff, diff, max, false);
            } else {
                _printHelper(curr - diff, diff, max, true);
            }
        } else {
            _printHelper(curr + diff, diff, max, false);
        }
    }
}
