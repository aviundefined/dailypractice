package com.avi.practice.utils;

/**
 * Created by navinash on 19/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class CommonUtils {
    private CommonUtils() {
        // Purely static class: so added private constructor to avoid creation of the instance
    }

    public static void printArr(final Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");

            }
        }
        System.out.println();
    }

    public static void printArr(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
        System.out.println();
    }

    public static void printMatrix(final Object[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        for (Object[] rows : matrix) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    System.out.print(rows[j]);
                } else {
                    System.out.print(rows[j] + ",");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMatrix(final int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        for (int[] rows : matrix) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    System.out.print(rows[j]);
                } else {
                    System.out.print(rows[j] + ",");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isEmpty(int[] arr) {
        return arr == null || arr.length == 0;
    }
}
