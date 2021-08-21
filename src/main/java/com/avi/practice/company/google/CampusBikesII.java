package com.avi.practice.company.google;

/**
 * Created by navinash on 21/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CampusBikesII {

    private int[][] workers;
    private int[][] bikes;
    int min = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        if(workers == null || bikes == null || workers.length == 0 || bikes.length == 0) {
            return 0;
        }

        // try assigning jth bike to ith worker and calculate distance
        this.workers = workers;
        this.bikes = bikes;
        final boolean[] bikesUsed = new boolean[this.bikes.length];
        dfs(0, 0, bikesUsed);
        return min;
    }

    private void dfs(int workerIndex, int currDistance, boolean[] bikesUsed) {
        if(workerIndex >= workers.length) {
            min = Math.min(currDistance, min);
            return;
        }

        if(currDistance > min) {
            return;
        }

        for(int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
            if(bikesUsed[bikeIndex]) {
                continue;
            }
            bikesUsed[bikeIndex] = true;
            dfs(
                    workerIndex + 1,
                    currDistance + distance(workers[workerIndex], bikes[bikeIndex]),
                    bikesUsed
            );
            bikesUsed[bikeIndex] = false;
        }
    }

    private static int distance(final int[] p1, final int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
