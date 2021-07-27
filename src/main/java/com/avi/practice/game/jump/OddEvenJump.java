package com.avi.practice.game.jump;

/**
 * Created by navinash on 27/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class OddEvenJump {

    public int oddEvenJumps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        final int n = arr.length;
        if (n == 1) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            final Boolean[] visited = new Boolean[n];
            final boolean reached = dfs(i, arr, visited);
            if (reached) {
                return i;
            }
        }
        return -1;
    }

    private boolean dfs(int i, int[] arr, Boolean[] visited) {
        if (i == arr.length - 1) {
            return true;
        }
        if (visited[i] != null) {
            return visited[i];
        }
        for (int j = i + 1; j < arr.length; j = j + 2) {
            if (arr[i] > arr[j]) {
                break;
            }
            final boolean dfs = dfs(j, arr, visited);
            if (dfs) {
                visited[i] = true;
                return true;
            }
        }
        for (int j = i + 2; j < arr.length; j = j + 2) {
            if (arr[i] < arr[j]) {
                break;
            }
            final boolean dfs = dfs(j, arr, visited);
            if (dfs) {
                visited[i] = true;
                return true;
            }
        }
        visited[i] = false;
        return false;
    }
}
