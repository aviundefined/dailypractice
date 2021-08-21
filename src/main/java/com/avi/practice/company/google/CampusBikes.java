package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * On a campus represented on the X-Y plane, there are n workers and m bikes, with n <= m.
 * <p>
 * You are given an array workers of length n where workers[i] = [xi, yi] is the position of the ith worker. You are also given an array bikes of length m where bikes[j] = [xj, yj] is the position of the jth bike. All the given positions are unique.
 * <p>
 * Assign a bike to each worker. Among the available bikes and workers, we choose the (workeri, bikej) pair with the shortest Manhattan distance between each other and assign the bike to that worker.
 * <p>
 * If there are multiple (workeri, bikej) pairs with the same shortest Manhattan distance, we choose the pair with the smallest worker index. If there are multiple ways to do that, we choose the pair with the smallest bike index. Repeat this process until there are no available workers.
 * <p>
 * Return an array answer of length n, where answer[i] is the index (0-indexed) of the bike that the ith worker is assigned to.
 * <p>
 * The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * Output: [1,0]
 * Explanation: Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].
 * Example 2:
 * <p>
 * <p>
 * Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * Output: [0,2,1]
 * Explanation: Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2, thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1. So the output is [0,2,1].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == workers.length
 * m == bikes.length
 * 1 <= n <= m <= 1000
 * workers[i].length == bikes[j].length == 2
 * 0 <= xi, yi < 1000
 * 0 <= xj, yj < 1000
 * All worker and bike locations are unique.
 */
public class CampusBikes {
    private static int distance(final int[] p1, final int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public int[] assignBikes_PriorityQueue_TLE(int[][] workers, int[][] bikes) {
        if (workers == null || bikes == null || workers.length == 0 || bikes.length == 0) {
            return new int[]{};
        }
        final int numWorkers = workers.length;
        final int numBikes = bikes.length;
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });
        for (int bikeIndex = 0; bikeIndex < numBikes; bikeIndex++) {
            for (int workerIndex = 0; workerIndex < numWorkers; workerIndex++) {
                pq.offer(new int[]{distance(bikes[bikeIndex], workers[workerIndex]), workerIndex, bikeIndex});
            }
        }

        final boolean[] bikesUsed = new boolean[numBikes];
        final int[] result = new int[numWorkers];
        Arrays.fill(result, -1);
        int assigned = 0;
        while (!pq.isEmpty() && assigned < numWorkers) {
            final int[] curr = pq.poll();
            if (result[curr[1]] == -1 && !bikesUsed[curr[2]]) {
                result[curr[1]] = curr[2];
                bikesUsed[curr[2]] = true;
                assigned++;
            }
        }
        return result;
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        if (workers == null || bikes == null || workers.length == 0 || bikes.length == 0) {
            return new int[]{};
        }
        final int numWorkers = workers.length;
        final int numBikes = bikes.length;
        int maxDistance = Integer.MIN_VALUE;
        final Map<Integer, List<int[]>> distanceBuckets = new HashMap<>();
        for (int workerIndex = 0; workerIndex < numWorkers; workerIndex++) {
            for (int bikeIndex = 0; bikeIndex < numBikes; bikeIndex++) {
                final int distance = distance(workers[workerIndex], bikes[bikeIndex]);
                maxDistance = Math.max(distance, maxDistance);
                final List<int[]> workerBikesPairs = distanceBuckets.computeIfAbsent(distance, k -> new ArrayList<>());
                workerBikesPairs.add(new int[]{workerIndex, bikeIndex});
            }
        }


        final boolean[] bikesUsed = new boolean[numBikes];
        final int[] result = new int[numWorkers];
        Arrays.fill(result, -1);
        int assigned = 0;
        for (int i = 0; i <= maxDistance && assigned < numWorkers; i++) {
            if (!distanceBuckets.containsKey(i)) {
                continue;
            }
            final List<int[]> workerBikePairs = distanceBuckets.get(i);
            for (final int[] workerBikePair : workerBikePairs) {
                if (result[workerBikePair[0]] == -1 && !bikesUsed[workerBikePair[1]]) {
                    result[workerBikePair[0]] = workerBikePair[1];
                    bikesUsed[workerBikePair[1]] = true;
                    assigned++;
                }
            }
        }
        return result;

    }
}
