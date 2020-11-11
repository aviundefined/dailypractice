package com.avi.practice.bit;

/**
 * Created by navinash on 11/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BitUtils {

    public static int toggleKthBit(final int number, final int k) {
        return (number ^ (1 << (k - 1)));
    }

    public static int numBits(final int number) {
        return (int) (Math.log(number) / Math.log(2)) + 1;
    }

    public static int invertBits(int number) {
        final int bits = numBits(number);
        for (int i = 1; i <= bits; i++) {
            number = toggleKthBit(number, i);
        }
        return number;
    }

    public static int invertBits(int number, final int bits) {
        for (int i = 1; i <= bits; i++) {
            number = toggleKthBit(number, i);
        }
        return number;
    }

    public static int twosComplement(final int number) {
        return invertBits(number, 32) + 1;
    }

    public static int unsetRightMostSetBit(final int number) {
        return number - (number & twosComplement(number));
    }
}
