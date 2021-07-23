package com.avi.practice.game;

import java.util.Arrays;

/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * There are n stones in a pile. On each player's turn, they can remove a stone from the pile and receive points based on the stone's value. Alice and Bob may value the stones differently.
 * <p>
 * You are given two integer arrays of length n, aliceValues and bobValues. Each aliceValues[i] and bobValues[i] represents how Alice and Bob, respectively, value the ith stone.
 * <p>
 * The winner is the person with the most points after all the stones are chosen. If both players have the same amount of points, the game results in a draw. Both players will play optimally. Both players know the other's values.
 * <p>
 * Determine the result of the game, and:
 * <p>
 * If Alice wins, return 1.
 * If Bob wins, return -1.
 * If the game results in a draw, return 0.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: aliceValues = [1,3], bobValues = [2,1]
 * Output: 1
 * Explanation:
 * If Alice takes stone 1 (0-indexed) first, Alice will receive 3 points.
 * Bob can only choose stone 0, and will only receive 2 points.
 * Alice wins.
 * Example 2:
 * <p>
 * Input: aliceValues = [1,2], bobValues = [3,1]
 * Output: 0
 * Explanation:
 * If Alice takes stone 0, and Bob takes stone 1, they will both have 1 point.
 * Draw.
 * Example 3:
 * <p>
 * Input: aliceValues = [2,4,3], bobValues = [1,6,7]
 * Output: -1
 * Explanation:
 * Regardless of how Alice plays, Bob will be able to have more points than Alice.
 * For example, if Alice takes stone 1, Bob can take stone 2, and Alice takes stone 0, Alice will have 6 points to Bob's 7.
 * Bob wins.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == aliceValues.length == bobValues.length
 * 1 <= n <= 105
 * 1 <= aliceValues[i], bobValues[i] <= 100
 */
public class StoneGameVI {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        final int[][] combined = new int[aliceValues.length][2];
        for (int i = 0; i < aliceValues.length; i++) {
            combined[i][0] = aliceValues[i];
            combined[i][1] = bobValues[i];
        }

        Arrays.sort(combined, (a, b) -> (b[0] - a[0]) + (b[1] - a[1]));
        int scoreDiff = 0;
        boolean isAliceTurn = true;
        for (final int[] num : combined) {
            if (isAliceTurn) {
                scoreDiff += num[0];
            } else {
                scoreDiff -= num[1];
            }
            isAliceTurn = !isAliceTurn;
        }

        if (scoreDiff == 0) {
            return 0;
        }
        return scoreDiff > 0 ? 1 : -1;
    }
}
