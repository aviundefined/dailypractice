package com.avi.practice.company.google;

/**
 * Created by navinash on 18/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintDiagonalZigZag {

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
                if (row >= m && col < n) {
                    i = row - 1;
                    j = col;
                } else {
                    i = row - 2;
                    j = col - 1;
                }
                isDown = !isDown;
            } else {
                int row = i;
                int col = j;
                while (row >= 0 && col >= 0) {
                    System.out.println(arr[row][col]);
                    done++;
                    row--;
                    col--;
                }
                if (col < 0 && row >= 0) {
                    i = row;
                    j = col + 1;
                } else {
                    i = row + 1;
                    j = col + 2;
                }
                isDown = !isDown;
            }
        }
    }
}
