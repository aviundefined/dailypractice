package com.avi;

/**
 * Created by navinash on 31/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MainClass {

    public static void main(String[] args) {
        /*
         *                              (x2,y2)
         *
         *
         *
         *      (x1,y1)
         *
         *      tan(A) = (y2-y1)/(x2 - x1)
         *      A = tanInverse((y2-y1)/(x2 - x1)) -> radian
         *      Degree = A * 180/pie
         */

        final int[] point1 = {0, 0};
        final int[] point2 = {8, 8};
        System.out.println(angle(point1, point2));
    }

    private static double angle(final int[] point1, final int[] point2) {
        final int deltaY = point1[1] - point2[1];
        final int deltaX = point1[0] - point2[0];
        return Math.toDegrees(Math.atan2(deltaY, deltaX));
    }
}
