package com.avi.practice.game.jump;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by navinash on 25/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JumpGameVII {


    public boolean canReach(String s, int minJump, int maxJump) {
        return bfs(s, minJump, maxJump);
    }



    public boolean dp(String s, int minJump, int maxJump) {
        if(s == null || s.length() == 0) {
            return true;
        }

        final int n = s.length();
        if(s.charAt(0) != '0' || s.charAt(n - 1) != '0') {
            return false;
        }


        final boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for(int i = n - 2; i >=0; i--) {
            if(s.charAt(i) != '0') {
                dp[i] = false;
                continue;
            }
            int start = i + minJump;
            int end = Math.min(i + maxJump, n - 1);
            for(int j = start; j <= end; j++) {
                if(dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    private boolean bfs(String s, int minJump, int maxJump) {
        if(s == null || s.length() == 0) {
            return true;
        }
        final int n = s.length();
        if(s.charAt(0) != '0' || s.charAt(n - 1) != '0') {
            return false;
        }

        int farthestIndexExplored = 0;
        final Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()) {
            // remove mark* word add*
            final int curr = q.poll();
            if(curr == n - 1) {
                return true;
            }
            // add neigbhours
            int start = Math.max(farthestIndexExplored, curr + minJump);
            int end = Math.min(curr + maxJump, n - 1);
            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    q.offer(j);
                }
            }
            farthestIndexExplored = Math.max(farthestIndexExplored, end);
        }
        return false;
    }
}
