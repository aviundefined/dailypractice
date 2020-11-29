package com.avi.practice.company.microsoft.interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumEvenSumSubsequenceOfLengthK {

    public final int maxEvenSum(final int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return -1;
        }
        final List<Integer> evenElements = new ArrayList<>();
        final List<Integer> oddElements = new ArrayList<>();
        for (final int a : arr) {
            if (a % 2 == 0) {
                evenElements.add(a);
            } else {
                oddElements.add(a);
            }
        }
        evenElements.sort(Integer::compareTo);
        oddElements.sort(Integer::compareTo);
        // choose K elements from evenElements in decreasing order
        int i = evenElements.size() - 1;
        int j = oddElements.size() - 1;
        int maxSum = 0;

        while (k > 0) { // If current num elements is odd then we have to choose even element
            if (k % 2 == 1) {
                if (i < 0) { // if no even elements left then even sum is not possible
                    return -1;
                }
                // choose largest available even number
                maxSum += evenElements.get(i);
                i--;
                k--;
            } else if (i >= 1 && j >= 1) { // if both even and odd has two-2 elements available then choose from that which will maximize the sum
                final int evenSum = evenElements.get(i) + evenElements.get(i - 1);
                final int oddSum = oddElements.get(j) + oddElements.get(j - 1);
                if (evenSum >= oddSum) {
                    maxSum += evenSum;
                    i = i - 2;
                } else {
                    maxSum += oddSum;
                    j = j - 2;
                }
                k = k - 2;
            } else if (i >= 1) { // if even has two elements use those
                maxSum += evenElements.get(i) + evenElements.get(i - 1);
                i = i - 2;
                k = k - 2;
            } else if (j >= 1) { // if odd has two elements use those
                maxSum += oddElements.get(j) + oddElements.get(j - 1);
                j = j - 2;
                k = k - 2;
            }
        }
        return maxSum;
    }
}
