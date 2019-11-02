package com.avi.paradigms.bitmanipulation;

/**
 * Created by navinash on 02/11/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class BitWiseOperations {

    static int sum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        while (b != 0) {
            final int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static boolean kthBitSet(final long num, final int k) {
        return (1 & num >> (k - 1)) == 1;
    }
}
