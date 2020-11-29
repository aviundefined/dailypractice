package com.avi.practice.company.microsoft.interviewbit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        final String[] numStrs = new String[nums.length];
        int i = 0;
        for (final int a : nums) {
            numStrs[i++] = String.valueOf(a);
        }
        Arrays.sort(numStrs, new CustomComparator());
        final StringBuilder sb = new StringBuilder();
        boolean trailingZeros = true;
        for (final String s : numStrs) {
            if (trailingZeros && s.equals("0")) {
                continue;
            }
            // first non zero hit
            trailingZeros = false;
            sb.append(s);
        }
        final String s = sb.toString();
        return s.equals("") ? "0" : s;
    }

    public String largestNumber(final List<Integer> A) {
        A.sort(new CustomIntegerComparator());
        final StringBuilder sb = new StringBuilder();
        boolean trailingZeros = true;
        for (final int s : A) {
            if (trailingZeros && s == 0) {
                continue;
            }
            // first non zero hit
            trailingZeros = false;
            sb.append(s);
        }
        final String s = sb.toString();
        return s.equals("") ? "0" : s;
    }

    private static final class CustomComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String a = o1 + o2;
            String b = o2 + o1;
            return b.compareTo(a);
        }
    }


    private static final class CustomIntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            String a = o1 + String.valueOf(o2);
            String b = o2 + String.valueOf(o1);
            return b.compareTo(a);
        }
    }

}
