package com.avi.practice.leetcode.problems.medium;

/**
 * Created by navinash on 26/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int subSum = Integer.MAX_VALUE;
        int total = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if (total < subSum) {
                index = (i + 1) % gas.length;
                subSum = total;
            }
        }
        return total >= 0 ? index % gas.length : -1;
    }
}
