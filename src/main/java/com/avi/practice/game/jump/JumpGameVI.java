package com.avi.practice.game.jump;

import java.util.PriorityQueue;

/**
 * You are given a 0-indexed integer array nums and an integer k.
 * <p>
 * You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.
 * <p>
 * You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.
 * <p>
 * Return the maximum score you can get.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,-1,-2,4,-7,3], k = 2
 * Output: 7
 * Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.
 * Example 2:
 * <p>
 * Input: nums = [10,-5,-2,4,0,3], k = 3
 * Output: 17
 * Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.
 * Example 3:
 * <p>
 * Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length, k <= 105
 * -104 <= nums[i] <= 104
 */
public class JumpGameVI {

    public int maxResult(int[] nums, int k) {
        return maxResult_Optimized(nums, k);
    }

    private int maxResult_Optimized(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        final int n = nums.length;
        final int[] dp = new int[n];
        dp[0] = nums[0];
        final PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        q.offer(new int[]{0, dp[0]});
        for(int i = 1; i < n; i++) {
            while(!q.isEmpty() && q.peek()[0] < i - k) {
                q.poll();
            }
            dp[i] = nums[i] + dp[q.peek()[0]];
            q.offer(new int[]{i, dp[i]});
        }
        return dp[n - 1];
    }

    private int maxResult_BruteForce(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        final int n = nums.length;
        final int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[0] + nums[1];

        for(int i = 2; i < n; i++) {
            int start = Math.max(0, i - k);
            int max = Integer.MIN_VALUE;
            for(int j = start; j < i; j++) {
                max = Math.max(max, dp[j]);
            }
            dp[i] = max + nums[i];
        }
        return dp[n - 1];
    }
}
