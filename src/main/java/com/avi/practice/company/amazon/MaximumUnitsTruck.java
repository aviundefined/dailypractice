package com.avi.practice.company.amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by navinash on 13/11/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumUnitsTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // greedy
        // sort on maximum number of units
        Arrays.sort(boxTypes, (a, b) -> b[0] - a[0]);

        return -1;
    }

    private static final int[] origin = {0, 0};

    public int[][] kClosest(int[][] points, int k) {
        // max heap
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (int) (distanceSquare(b, origin) - distanceSquare(a, origin)));

        for(final int[] point : points) {
            pq.offer(point);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        final int[][] result = new int[pq.size()][2];
        for(int i = 0; i < result.length; i++) {
            final int[] p = pq.poll();
            result[i][0] = p[0];
            result[i][1] = p[1];
        }
        return result;
    }


    private long distanceSquare(final int[] p1, final int[] p2) {
        final int dx = (p1[0] - p2[0]) ;
        final int dy = (p1[1] - p2[1]) ;
        return (1L * dx * dx) + (1L * dy * dy);
    }
}
