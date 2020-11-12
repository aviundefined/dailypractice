package com.avi.practice.company.microsoft;

import com.avi.practice.bit.BitUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BinaryRepresentation {

    public final String binary(int number) {
        final List<Integer> list = new ArrayList<>();
        while (number > 0) {
            list.add(number % 2);
            number = number / 2;
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    final String binary2ndApproach(final int number) {
        final List<Integer> list = new ArrayList<>();
        final int numBits = BitUtils.numBits(number);
        for (int i = 1; i <= numBits; i++) {
            list.add(BitUtils.extractKthBit(number, i));
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
