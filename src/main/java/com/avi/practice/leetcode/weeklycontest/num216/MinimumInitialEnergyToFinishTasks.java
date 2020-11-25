package com.avi.practice.leetcode.weeklycontest.num216;

import java.util.Arrays;

/**
 * Created by navinash on 24/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * You are given an array tasks where tasks[i] = [actuali, minimumi]:
 * <p>
 * actuali is the actual amount of energy you spend to finish the ith task.
 * minimumi is the minimum amount of energy you require to begin the ith task.
 * For example, if the task is [10, 12] and your current energy is 11, you cannot start this task. However, if your current energy is 13, you can complete this task, and your energy will be 3 after finishing it.
 * <p>
 * You can finish the tasks in any order you like.
 * <p>
 * Return the minimum initial amount of energy you will need to finish all the tasks.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: tasks = [[1,2],[2,4],[4,8]]
 * Output: 8
 * Explanation:
 * Starting with 8 energy, we finish the tasks in the following order:
 * - 3rd task. Now energy = 8 - 4 = 4.
 * - 2nd task. Now energy = 4 - 2 = 2.
 * - 1st task. Now energy = 2 - 1 = 1.
 * Notice that even though we have leftover energy, starting with 7 energy does not work because we cannot do the 3rd task.
 * Example 2:
 * <p>
 * Input: tasks = [[1,3],[2,4],[10,11],[10,12],[8,9]]
 * Output: 32
 * Explanation:
 * Starting with 32 energy, we finish the tasks in the following order:
 * - 1st task. Now energy = 32 - 1 = 31.
 * - 2nd task. Now energy = 31 - 2 = 29.
 * - 3rd task. Now energy = 29 - 10 = 19.
 * - 4th task. Now energy = 19 - 10 = 9.
 * - 5th task. Now energy = 9 - 8 = 1.
 * Example 3:
 * <p>
 * Input: tasks = [[1,7],[2,8],[3,9],[4,10],[5,11],[6,12]]
 * Output: 27
 * Explanation:
 * Starting with 27 energy, we finish the tasks in the following order:
 * - 5th task. Now energy = 27 - 5 = 22.
 * - 2nd task. Now energy = 22 - 2 = 20.
 * - 3rd task. Now energy = 20 - 3 = 17.
 * - 1st task. Now energy = 17 - 1 = 16.
 * - 4th task. Now energy = 16 - 4 = 12.
 * - 6th task. Now energy = 12 - 6 = 6.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= tasks.length <= 105
 * 1 <= actual​i <= minimumi <= 104
 */
public class MinimumInitialEnergyToFinishTasks {
    public int minimumEffort(int[][] tasks) {
        int max = 0;
        int min = 0;
        for (final int[] task : tasks) {
            max += task[1];
            min += task[0];
        }
        final int n = tasks.length;
        Arrays.sort(tasks, (o1, o2) -> (o1[1] - o1[0]) - (o2[1] - o2[0]));
        int curr = max;
        while (min < max) {
            final int mid = min + (max - min) / 2;
            final boolean isPossible = _minimumEffortHelper(tasks, mid, n);
            if (isPossible) {
                if (mid < curr) {
                    curr = mid;
                }
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return curr;
    }

    private boolean _minimumEffortHelper(int[][] tasks, int effort, final int n) {
        for (int i = n - 1; i >= 0; i--) {
            if (effort < tasks[i][1]) {
                return false;
            }
            effort -= tasks[i][0];
        }
        return true;
    }
}
