package com.avi.practice.company.google;

/**
 * Created by navinash on 26/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        final int[][] points = new int[4][2];
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        for (int i = 0; i < points.length; i++) {
            swap(points, 0, i);
            boolean isSquare = _validSquare(points[0], points[1], points[2], points[3]);
            swap(points, 0, i);
            if (isSquare) {
                return true;
            }
        }
        return false;
    }

    private void swap(int[][] points, int i, int j) {
        final int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    public boolean _validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // points construct square if
        // for any point p1, we can find three points such that
        // p1-p2 = a
        // p1-p3 = a

        final double p1p2 = distance(p1, p2);
        final double p2p3 = distance(p2, p3);
        final double p3p4 = distance(p3, p4);
        final double p4p1 = distance(p4, p1);
        final double p1p3 = distance(p1, p3);
        final double p2p4 = distance(p2, p4);


        if (p1p2 == 0 || p2p3 == 0 || p3p4 == 0 || p4p1 == 0 || p1p3 == 0 || p2p4 == 0) {
            return false;
        }

        if (p1p2 == p2p3 && p2p3 == p3p4 && p3p4 == p4p1 && p1p3 == p2p4) {
            return true;
        }

        return false;
    }

    private double distance(final int[] p1, final int[] p2) {
        final int deltaX = p1[0] - p2[0];
        final int deltaY = p1[1] - p2[1];
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY) * 1.00D;
    }

}
