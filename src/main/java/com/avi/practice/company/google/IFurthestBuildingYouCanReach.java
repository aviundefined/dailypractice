package com.avi.practice.company.google;

import java.util.PriorityQueue;

/**
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 *
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 *
 * While moving from building i to building i+1 (0-indexed),
 *
 * If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
 * If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * Output: 4
 * Explanation: Starting at building 0, you can follow these steps:
 * - Go to building 1 without using ladders nor bricks since 4 >= 2.
 * - Go to building 2 using 5 bricks. You must use either bricks or ladders because 2 < 7.
 * - Go to building 3 without using ladders nor bricks since 7 >= 6.
 * - Go to building 4 using your only ladder. You must use either bricks or ladders because 6 < 9.
 * It is impossible to go beyond building 4 because you do not have any more bricks or ladders.
 * Example 2:
 *
 * Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * Output: 7
 * Example 3:
 *
 * Input: heights = [14,3,19,3], bricks = 17, ladders = 0
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 105
 * 1 <= heights[i] <= 106
 * 0 <= bricks <= 109
 * 0 <= ladders <= heights.length
 */
public interface IFurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) ;

    final class FurthestBuildingYouCanReachMinHeapApproach implements IFurthestBuildingYouCanReach {

        @Override
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            if(heights == null || heights.length == 0) {
                return 0;
            }
            final int n = heights.length;
            // use Min heap to track difference between building where ladders are used first to cross, when ladders are consumed
            // then remove the ladder used for smallest difference and use bricks for that

            final PriorityQueue<Integer> usedLadders = new PriorityQueue<>();
            for(int i = 0; i < n - 1; i++) {
                final int jumps = heights[i + 1] - heights[i];
                // next build is smaller or equal to can be crossed directly
                if(jumps <= 0) {
                    continue;
                }
                usedLadders.offer(jumps);
                if(usedLadders.size() <= ladders) {
                    continue;
                }

                bricks -= usedLadders.poll();
                if(bricks < 0) {
                    return i;
                }
            }
            return n - 1;
        }
    }

    final class FurthestBuildingYouCanReachMaxHeapApproach implements IFurthestBuildingYouCanReach {

        @Override
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            if(heights == null || heights.length == 0) {
                return 0;
            }
            final int n = heights.length;
            // use Max heap to track difference between building where bricks are used first to cross, when bricks are consumed
            // and no ladders left then return, else used the max difference for ladders and increase bricks

            final PriorityQueue<Integer> usedBricks = new PriorityQueue<>((a, b) -> b-a);
            for(int i = 0; i < n - 1; i++) {
                final int jumps = heights[i + 1] - heights[i];
                // next build is smaller or equal to can be crossed directly
                if(jumps <= 0) {
                    continue;
                }
                usedBricks.offer(jumps);
                bricks -= jumps;
                if(bricks < 0 && ladders == 0) {
                    return i;
                }

                if(bricks < 0){
                    bricks += usedBricks.poll();
                    ladders--;
                }
            }
            return n - 1;
        }
    }

}
