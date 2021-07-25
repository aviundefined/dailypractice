package com.avi.practice.game.jump;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by navinash on 25/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JumpGameII {

    public int jump(int[] nums) {
        return jump_DP(nums);
    }

    private static final int marker = -1;
    public int jump_BFS(final int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        final int n = nums.length;
        final Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        q.offer(marker);
        int jumps = 0;
        final boolean[] visited = new boolean[n];
        while(!q.isEmpty()) {
            // remove mark* work add*
            final int curr = q.poll();
            if(curr == marker) {
                if(!q.isEmpty()) {
                    q.offer(marker);
                    jumps++;
                }
            }else {
                if(visited[curr]) {
                    continue;
                }
                visited[curr] = true;
                if(curr == n - 1) {
                    return jumps;
                }
                if(nums[curr] != 0) {
                    for(int i = curr + 1; i <= curr + nums[curr] && i < n; i++) {
                        if(!visited[i]) {
                            q.offer(i);
                        }
                    }
                }
            }
        }
        return -1;
    }
    public int jump_DP(final int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        final int n = nums.length;
        final int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for(int j = i + 1; j <= i + nums[i] & j < n; j++) {
                min = Math.min(min, dp[j]);
            }
            if(min != Integer.MAX_VALUE) {
                dp[i] = 1 + min;
            }else {
                dp[i] = Integer.MAX_VALUE;
            }
        }
        return dp[0];
    }
}
