package com.avi.practice.leetcode.weeklycontest.num157;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PlayWithChips {

    public int minCostToMoveChips(int[] chips) {
        if (chips == null || chips.length <= 1) {
            return 0; // null or length 0 or 1 all at one place return 0;
        }

        // even to even move free
        // odd to odd move free
        // odd to even cost 1
        // even to odd cost 1
        // simply count number of chips at even position and number of chips at odd position and return the minimum
        // as if odd chips are less then move all odd chips to even position then even to even free and vice versa
        int numberOfChipsAtOddPosition = 0, numberOfChipsAtEvenPosition = 0;
        for (final int pos : chips) {
            if (pos % 2 == 0) {
                numberOfChipsAtEvenPosition++;
            } else {
                numberOfChipsAtOddPosition++;
            }
        }
        return Math.min(numberOfChipsAtEvenPosition, numberOfChipsAtOddPosition);
    }

    public int minCostToMoveChipsSlow(int[] chips) {
        if (chips == null || chips.length <= 1) {
            return 0; // null or length 0 or 1 all at one place return 0;
        }
        final int n = chips.length;
        final Map<Integer, Integer> chipsByPosition = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final int pos = chips[i];
            chipsByPosition.compute(pos, (key, existing) -> {
                if (existing == null) {
                    return 1;
                }
                return existing + 1;
            });
        }
        int minMoves = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int moveAllAtI = 0;
            for (final Map.Entry<Integer, Integer> e : chipsByPosition.entrySet()) {
                final int pos = e.getKey();
                final int numberOfElements = e.getValue();
                final int delta = Math.abs(pos - i) % 2;
                if (delta == 1) {
                    moveAllAtI += numberOfElements;
                }
            }
            minMoves = Math.min(moveAllAtI, minMoves);
        }
        return minMoves;
    }
}
