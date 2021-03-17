package com.avi.practice.leetcode.weeklycontest.num226;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
 * <p>
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
 * <p>
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 * <p>
 * Return the original array nums. If there are multiple solutions, return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: adjacentPairs = [[2,1],[3,4],[3,2]]
 * Output: [1,2,3,4]
 * Explanation: This array has all its adjacent pairs in adjacentPairs.
 * Notice that adjacentPairs[i] may not be in left-to-right order.
 * Example 2:
 * <p>
 * Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * Output: [-2,4,1,-3]
 * Explanation: There can be negative numbers.
 * Another solution is [-3,1,4,-2], which would also be accepted.
 * Example 3:
 * <p>
 * Input: adjacentPairs = [[100000,-100000]]
 * Output: [100000,-100000]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 105
 * -105 <= nums[i], ui, vi <= 105
 * There exists some nums that has adjacentPairs as its pairs.
 */
public class RestoreTheArrayFromAdjacentPairs {

    public int[] restoreArray(int[][] adjacentPairs) {
        final Map<Integer, List<Integer>> graphEdges = new HashMap<>();
        // build frequency map
        for (final int[] pair : adjacentPairs) {
            graphEdges.compute(pair[0], (k, nodes) -> {
                if (nodes == null) {
                    nodes = new ArrayList<>();
                }
                nodes.add(pair[1]);
                return nodes;
            });
            graphEdges.compute(pair[1], (k, nodes) -> {
                if (nodes == null) {
                    nodes = new ArrayList<>();
                }
                nodes.add(pair[0]);
                return nodes;
            });
        }
        // find starting element
        Integer startElem = null;
        for (final Map.Entry<Integer, List<Integer>> e : graphEdges.entrySet()) {
            if (e.getValue().size() == 1) {
                startElem = e.getKey();
                break;
            }
        }
        // do bfs from that element
        final int[] arr = new int[adjacentPairs.length + 1];
        final Set<Integer> visited = new HashSet<>();
        final Queue<Integer> q = new LinkedList<>();

        q.add(startElem);
        int i = 0;
        while (!q.isEmpty()) {
            final Integer curr = q.poll();
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            arr[i] = curr;
            i++;
            final List<Integer> adjacents = graphEdges.get(curr);
            for (final int adjacent : adjacents) {
                if (visited.contains(adjacent)) {
                    continue;
                }
                q.add(adjacent);
            }
        }
        return arr;
    }
}
