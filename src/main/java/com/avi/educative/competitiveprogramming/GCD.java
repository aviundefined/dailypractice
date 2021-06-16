package com.avi.educative.competitiveprogramming;

/**
 * Created by navinash on 16/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GCD {

    public final int gcd(final int a, final int b) {
        if(a == 0) {
            return b;
        }
        if(b == 0) {
            return a;
        }

        // a -> 100, b -> 20 -> gcd(20, 100 % 20)
        // a -> 24, b -> 15 -> gcd(15, 24 % 15) -> gcd(15, 9) -> gcd(9, 15 % 9) -> gcd(9, 6) -> gcd(6, 9 % 6) -> gcd(6, 3) -> gcd(3, 6 % 3) -> gcd(3,0) -> return 3;
        return a >= b ? gcd(b, a % b) : gcd(a, b % a);
    }
}
