package com.avi.practice.company.microsoft.interviewbit;

import java.util.ArrayList;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        if (A == null || A.size() == 0) {
            final ArrayList<Integer> ret = new ArrayList<>();
            ret.add(1);
            return ret;
        }

        final ArrayList<Integer> ret = new ArrayList<>();
        int carry = 1;
        for (int i = A.size() - 1; i >= 0; i--) {
            int curr = A.get(i) + carry;
            if (curr >= 10) {
                carry = 1;
                curr = 0;
            } else {
                carry = 0;
            }
            ret.add(curr);
        }
        if (carry != 0) {
            ret.add(carry);
        }
        int l = 0, r = ret.size() - 1;
        boolean tailingZeros = true;
        while (l < r && l < ret.size()) {
            if (tailingZeros && ret.get(r) == 0) {
                ret.remove(r);
                r--;
                continue;
            }
            tailingZeros = false;
            final int tmp = ret.get(l);
            ret.set(l, ret.get(r));
            ret.set(r, tmp);
            l++;
            r--;
        }
        return ret;
    }
}
