package com.avi.practice.game.stone;

/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * There are n stones arranged in a row. On each player's turn, while the number of stones is more than one, they will do the following:
 * <p>
 * Choose an integer x > 1, and remove the leftmost x stones from the row.
 * Add the sum of the removed stones' values to the player's score.
 * Place a new stone, whose value is equal to that sum, on the left side of the row.
 * The game stops when only one stone is left in the row.
 * <p>
 * The score difference between Alice and Bob is (Alice's score - Bob's score). Alice's goal is to maximize the score difference, and Bob's goal is the minimize the score difference.
 * <p>
 * Given an integer array stones of length n where stones[i] represents the value of the ith stone from the left, return the score difference between Alice and Bob if they both play optimally.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: stones = [-1,2,-3,4,-5]
 * Output: 5
 * Explanation:
 * - Alice removes the first 4 stones, adds (-1) + 2 + (-3) + 4 = 2 to her score, and places a stone of
 * value 2 on the left. stones = [2,-5].
 * - Bob removes the first 2 stones, adds 2 + (-5) = -3 to his score, and places a stone of value -3 on
 * the left. stones = [-3].
 * The difference between their scores is 2 - (-3) = 5.
 * Example 2:
 * <p>
 * Input: stones = [7,-6,5,10,5,-2,-6]
 * Output: 13
 * Explanation:
 * - Alice removes all stones, adds 7 + (-6) + 5 + 10 + 5 + (-2) + (-6) = 13 to her score, and places a
 * stone of value 13 on the left. stones = [13].
 * The difference between their scores is 13 - 0 = 13.
 * Example 3:
 * <p>
 * Input: stones = [-10,-12]
 * Output: -22
 * Explanation:
 * - Alice can only make one move, which is to remove both stones. She adds (-10) + (-12) = -22 to her
 * score and places a stone of value -22 on the left. stones = [-22].
 * The difference between their scores is (-22) - 0 = -22.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == stones.length
 * 2 <= n <= 105
 * -104 <= stones[i] <= 104
 */
public class StoneGameVIII {

    public int stoneGameVIII(int[] stones) {
        final int[] prefix = new int[stones.length - 1];
        prefix[0] = stones[0] + stones[1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + stones[i + 1];
        }

        final int n = prefix.length;
        int max = prefix[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, prefix[i] - max);
        }
        return max;
    }
}
