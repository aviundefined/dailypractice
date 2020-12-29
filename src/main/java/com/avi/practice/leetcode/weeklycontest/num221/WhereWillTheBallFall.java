package com.avi.practice.leetcode.weeklycontest.num221;

/**
 * Created by navinash on 28/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.
 * <p>
 * Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.
 * <p>
 * A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.
 * A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.
 * We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom. A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.
 * <p>
 * Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping the ball from the ith column at the top, or -1 if the ball gets stuck in the box.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
 * Output: [1,-1,-1,-1,-1]
 * Explanation: This example is shown in the photo.
 * Ball b0 is dropped at column 0 and falls out of the box at column 1.
 * Ball b1 is dropped at column 1 and will get stuck in the box between column 2 and 3 and row 1.
 * Ball b2 is dropped at column 2 and will get stuck on the box between column 2 and 3 and row 0.
 * Ball b3 is dropped at column 3 and will get stuck on the box between column 2 and 3 and row 0.
 * Ball b4 is dropped at column 4 and will get stuck on the box between column 2 and 3 and row 1.
 * Example 2:
 * <p>
 * Input: grid = [[-1]]
 * Output: [-1]
 * Explanation: The ball gets stuck against the left wall.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] is 1 or -1
 */
public class WhereWillTheBallFall {

    public int[] findBall(int[][] grid) {
        final int row = grid.length;
        final int col = grid[0].length;
        final int[] result = new int[col];
        for (int j = 0; j < col; j++) {
            result[j] = j;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                final int c = result[j];
                if (c == -1) {
                    continue;
                }
                final int nextCol = c + grid[i][j];
                if (nextCol < 0 || nextCol >= col || grid[i][c] == -grid[i][nextCol]) {
                    result[j] = -1;
                    continue;
                }
                result[j] += grid[i][c];
            }
        }
        return result;
    }
}
