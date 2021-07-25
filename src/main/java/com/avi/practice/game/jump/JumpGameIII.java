package com.avi.practice.game.jump;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by navinash on 25/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        if(arr == null || arr.length == 0) {
            return false;
        }

        final int n = arr.length;
        final Queue<Integer> q = new LinkedList<>();
        final boolean[] visited = new boolean[n];
        q.offer(start);

        while(!q.isEmpty()){
            // remove mark* work add*
            final int curr = q.poll();
            if(visited[curr]) {
                continue;
            }
            visited[curr] = true;
            if(arr[curr] == 0) {
                return true;
            }
            final int next1 = curr + arr[curr];
            if(next1 < n && !visited[next1]) {
                q.offer(next1);
            }
            final int next2 = curr - arr[curr];
            if(next2 >= 0 && !visited[next2]) {
                q.offer(next2);
            }
        }
        return false;
    }
}
