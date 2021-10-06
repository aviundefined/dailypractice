package com.avi.practice.company.google;

/**
 * Created by navinash on 05/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumSpeedToArriveOnTime {

    public int minSpeedOnTime(int[] dist, double hour) {

        final int hourInt = (int) Math.ceil(hour);
        if (hourInt < dist.length) {
            return -1;
        }
        int low = 1;
        int high = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            final int mid = low + (high - low) / 2;
            if (canReachOffice(mid, hour, dist)) {
                min = Math.min(mid, min);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return min;
    }


    private boolean canReachOffice(int speed, double hour, final int[] dist) {
        double time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            final int curr = dist[i] % speed == 0 ? dist[i] / speed : dist[i] / speed + 1;
            time += curr;
        }
        time += (dist[dist.length - 1] * 1.00D / speed);
        return time <= hour;
    }
}
