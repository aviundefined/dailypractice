package com.avi.practice.maths;

/**
 * Created by navinash on 27/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Power {


    public double myPow(double x, double n) {
        if (n == 0) {
            return 1D;
        }
        if (x == 0) {
            return 1D;
        }

       return recurse(x, (int) n);
    }

    private double recurse(double x, int n) {
        if (n == 0) {
            return 1D;
        }


        final double half = recurse(x, n / 2);
        if(n % 2 == 0) {
            return half * half;
        }
        if(n > 0) {
            return half * half * x;
        }

        return half * half / x;
    }
}
