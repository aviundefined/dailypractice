package com.avi.practice.game.stone;

/**
 * Alice and Bob continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones.
 * <p>
 * Alice and Bob take turns, with Alice starting first.  Initially, M = 1.
 * <p>
 * On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
 * <p>
 * The game continues until all the stones have been taken.
 * <p>
 * Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [2,7,9,4,4]
 * Output: 10
 * Explanation:  If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total. If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's larger.
 * Example 2:
 * <p>
 * Input: piles = [1,2,3,4,5,100]
 * Output: 104
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 104
 */
public class StoneGameII {

    public int stoneGameII(int[] piles) {
        if (piles == null || piles.length == 0) {
            return 0;
        }
        if (piles.length == 1) {
            return piles[0];
        }

        if (piles.length == 2) {
            return Math.max(piles[0], piles[1]);
        }
        final int m = 1;
        return recurse(piles, 0, m, true, new int[piles.length][piles.length], new int[piles.length][piles.length]);
    }

    private int recurse(int[] piles, int index, int m, boolean isAliceTurn, int[][] aliceScores, int[][] bobScores) {
        if (index >= piles.length || m >= piles.length) {
            return 0;
        }

        if (isAliceTurn) {
            if (aliceScores[index][m] > 0) {
                return aliceScores[index][m];
            }
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int i = index; i <= index + 2 * m - 1 && i < piles.length; i++) {
                sum += piles[i];
                max = Math.max(max, sum + recurse(piles, i + 1, Math.max(m, i - index + 1), false, aliceScores, bobScores));
            }
            aliceScores[index][m] = max;
            return max;
        } else {
            if (bobScores[index][m] > 0) {
                return bobScores[index][m];
            }
            int min = Integer.MAX_VALUE;
            for (int i = index; i <= index + 2 * m - 1 && i < piles.length; i++) {
                min = Math.min(min, recurse(piles, i + 1, Math.max(m, i - index + 1), true, aliceScores, bobScores));
            }
            bobScores[index][m] = min;
            return min;
        }
    }
}
