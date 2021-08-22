package com.avi.practice.company.google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 22/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ConfusingNumber {

    private static final Map<Integer, Integer> map = new HashMap<>();
    // {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
    static {
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, -1);
        map.put(3, -1);
        map.put(4, -1);
        map.put(5, -1);
        map.put(6, 9);
        map.put(7, -1);
        map.put(8, 8);
        map.put(9, 6);
    }

    public boolean confusingNumber(int n) {
        final long num = n;
        long rotatedNum = 0L;
        while(n > 0) {
            final int rem = (int) (n % 10);
            if(map.get(rem) < 0) {
                return false;
            }
            rotatedNum = rotatedNum * 10 + map.get(rem);
            n = n / 10;
        }

        return rotatedNum != num;
    }
}
