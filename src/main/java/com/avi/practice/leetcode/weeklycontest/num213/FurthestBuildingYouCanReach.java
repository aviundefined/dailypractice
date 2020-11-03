package com.avi.practice.leetcode.weeklycontest.num213;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by navinash on 03/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 * <p>
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 * <p>
 * While moving from building i to building i+1 (0-indexed),
 * <p>
 * If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
 * If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 * <p>
 * Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * Output: 4
 * Explanation: Starting at building 0, you can follow these steps:
 * - Go to building 1 without using ladders nor bricks since 4 >= 2.
 * - Go to building 2 using 5 bricks. You must use either bricks or ladders because 2 < 7.
 * - Go to building 3 without using ladders nor bricks since 7 >= 6.
 * - Go to building 4 using your only ladder. You must use either bricks or ladders because 6 < 9.
 * It is impossible to go beyond building 4 because you do not have any more bricks or ladders.
 * Example 2:
 * <p>
 * Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * Output: 7
 * Example 3:
 * <p>
 * Input: heights = [14,3,19,3], bricks = 17, ladders = 0
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= heights.length <= 105
 * 1 <= heights[i] <= 106
 * 0 <= bricks <= 109
 * 0 <= ladders <= heights.length
 */
public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return 1;
        }

        if (heights.length == 2) {
            if (heights[1] <= heights[0]) {
                return 2;
            }
        }
        final Integer[] diff = new Integer[heights.length];
        diff[0] = 0;
        for (int i = 1; i < heights.length; i++) {
            diff[i] = heights[i] - heights[i - 1];
        }
        int start = 0;
        int end = heights.length - 1;
        int result = 0;
        while (start <= end) {
            boolean reached = false;
            int mid = start + (end - start) / 2;
            final Integer[] arr = Arrays.copyOfRange(diff, 0, mid + 1);
            Arrays.sort(arr, Collections.reverseOrder());
            int copyLadders = ladders;
            int idx = 0;
            while (copyLadders > 0) {
                idx++;
                if (idx < arr.length && arr[idx] > 0) {
                    copyLadders--;
                }
                if (idx >= mid) {
                    reached = true;
                    break;
                }
            }
            if (!reached) {
                int copyBricks = bricks;
                while (copyBricks > 0) {
                    if (idx < arr.length && arr[idx] > 0) {
                        copyBricks -= arr[idx];
                    }
                    idx++;
                    if (idx >= mid) {
                        reached = true;
                        break;
                    }
                }
            }

            if (!reached) {
                while (idx < arr.length && arr[idx] <= 0) {
                    idx++;
                    if (idx >= mid) {
                        reached = true;
                        break;
                    }
                }
            }

            if (reached) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return result;
    }
}
