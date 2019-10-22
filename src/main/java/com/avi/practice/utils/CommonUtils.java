package com.avi.practice.utils;

import java.util.Collection;
import java.util.Map;

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

    public static void printArr(final char[] arr) {
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

    public static void printMatrix(final boolean[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        for (boolean[] rows : matrix) {
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

    public static boolean isEmpty(Object[][] arr) {
        return arr == null || arr.length == 0 || arr[0].length == 0;
    }

    public static boolean isEmpty(int[][] arr) {
        return arr == null || arr.length == 0 || arr[0].length == 0;
    }

    public static boolean isEmpty(Object[] arr) {
        return arr == null || arr.length == 0;
    }

    public static boolean isEmpty(int[] arr) {
        return arr == null || arr.length == 0;
    }

    public static boolean isEmpty(String arr) {
        return arr == null || arr.trim().length() == 0;
    }


    public static void swap(final int[] arr, int i, int j) {
        final int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(final char[] arr, int i, int j) {
        final char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(final Object[] arr, int i, int j) {
        final Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static boolean isEmpty(final Collection<?> col) {
        return col == null || col.isEmpty();
    }

    public static boolean isEmpty(final Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static int max(final int a, final int b, final int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static int min(final int a, final int b, final int c) {
        return Math.min(Math.min(a, b), c);
    }
}
