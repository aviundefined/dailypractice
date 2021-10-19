package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 18/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintDiagonalZigZag {

    final int UP = 0;
    final int DOWN = 1;

    public void print(final int[][] arr) {
        final int m = arr.length;
        final int n = arr[0].length;
        int done = 0;
        boolean isDown = true;
        int i = m - 1;
        int j = 0;
        while (done < m * n) {
            if (isDown) {
                int row = i;
                int col = j;
                while (row < m && col < n) {
                    System.out.println(arr[row][col]);
                    done++;
                    row++;
                    col++;
                }
                if (done > m * n) {
                    break;
                }
                // row >= m || col >= n
                if (row >= m && col < n) {
                    i = row - 1;
                    j = col;
                } else {
                    i = row - 2;
                    j = col - 1;
                }
                isDown = false;
            } else {
                int row = i;
                int col = j;
                while (row >= 0 && col >= 0) {
                    System.out.println(arr[row][col]);
                    done++;
                    row--;
                    col--;
                }
                if (done > m * n) {
                    break;
                }
                if (col < 0 && row >= 0) {
                    i = row;
                    j = col + 1;
                } else {
                    i = row + 1;
                    j = col + 2;
                }
                isDown = true;
            }
        }
    }

    public List<Integer> getZigZag(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int dir = DOWN;
        int x = m - 1, y = 0;//start
        List<Integer> list = new ArrayList<>();

        while (true) {
            list.add(matrix[x][y]);
            if (x == 0 && y == n - 1) { break; }
            if (dir == DOWN) {
                if (x == m - 1 && y == n - 1) {//right bottom
                    dir = UP;
                    x--;//same column, moving up from right bottom
                } else if (x == m - 1) {//hit last row
                    dir = UP;
                    y++;//just move column to right
                } else if (y == n - 1) {//hit last column
                    dir = UP;
                    x--;//move row up
                } else {//not boundary condition
                    x++;
                    y++;//DONT update direction
                }
            } else {//dir == UP
                if (x == 0 && y == 0) {//left up
                    dir = DOWN;
                    y++;//same row, moving right from left up
                } else if (x == 0) {//hit first row
                    dir = DOWN;
                    y++;//just move column to right
                } else if (y == 0) {//hit first column
                    dir = DOWN;
                    x--;//move row up
                } else {//not boundary condition
                    x--;
                    y--;//DONT update direction
                }
            }
        }//while


        return list;
    }
}
