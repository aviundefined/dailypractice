package com.avi.practice.leetcode.problems.medium;

/**
 * Created by navinash on 26/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int total = 0;
        int index = 0;
        for(int i = 0; i < gas.length; i++) {
            final int consumed = gas[i] - cost[i];
            tank += consumed;
            if(tank <= 0) {
                index = index + 1;
                tank = 0;
            }
            total += consumed;
        }
        return total < 0  ? -1 : index;
    }
}
