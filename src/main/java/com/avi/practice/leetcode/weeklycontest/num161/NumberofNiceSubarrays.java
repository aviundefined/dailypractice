package com.avi.practice.leetcode.weeklycontest.num161;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by navinash on 03/11/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NumberofNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        final int n = nums.length;
        if (k > n) {
            return 0;
        }
        if (n == 1 && k <= 1) {
            if (nums[0] % 2 != 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int count = 0;
        final Map<Integer, Boolean> isOddByIndex = new HashMap<>(); // if odd true then true else false
        final Queue<Integer> starts = new LinkedList<>();
        int s = 0;
        int e = 0;
        int numOdds = 0;
        starts.add(0);
        while (s <= e) {
            if (e <= n - 1 && !isOddByIndex.containsKey(e)) {
                final int curr = nums[e];
                final boolean isOdd = curr % 2 != 0;
                isOddByIndex.put(e, isOdd);
                if (isOdd) {
                    numOdds++;
                }
                // reach to end don't increase end now
                if (e != n - 1) {
                    e++;
                }
            }
            if (numOdds == k) {
                count++;
                while (s <= e) {
                    final boolean isStartOdd = isOddByIndex.get(s);
                    if (!isStartOdd) {
                        // if start is odd then if we will remove the s then number of odds will decrease
                        count++;
                        s++;
                    }

                }
            }


        }
        return count;
    }
}
