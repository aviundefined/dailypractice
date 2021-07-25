package com.avi.practice.game.jump;

/**
 * Created by navinash on 25/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        final int n = nums.length;
        final boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] == 0) {
                dp[i] = false;
                continue;
            }
            dp[i] = false;
            for(int j = i + 1; j <= i + nums[i] && j < n; j++) {
                if(dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
