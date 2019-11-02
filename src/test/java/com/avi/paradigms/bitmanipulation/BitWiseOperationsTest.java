package com.avi.paradigms.bitmanipulation;

import com.avi.practice.maths.MathPractice;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 02/11/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BitWiseOperationsTest {

    @Test
    public void kthBitSet() {
        int k1 = 1; // 1 bit means 0
        int k2 = 2; // 1 bit means 1
        int k3 = 3; // 1 bit means 1
        int k4 = 4; // 1 bit means 1
        final MathPractice math = new MathPractice();
        {
            final int num = 2;
            final String binary = math.decimalToBinary(num);
            Assert.assertFalse(String.format("%s bit in binary: %s", k1, binary), BitWiseOperations.kthBitSet(num, k1));
            Assert.assertTrue(String.format("%s bit in binary: %s", k2, binary), BitWiseOperations.kthBitSet(num, k2));
            Assert.assertFalse(String.format("%s bit in binary: %s", k3, binary), BitWiseOperations.kthBitSet(num, k3));
            Assert.assertFalse(String.format("%s bit in binary: %s", k4, binary), BitWiseOperations.kthBitSet(num, k4));
        }
        {
            final int num = 3;
            final String binary = math.decimalToBinary(num);
            Assert.assertTrue(String.format("%s bit in binary: %s", k1, binary), BitWiseOperations.kthBitSet(num, k1));
            Assert.assertTrue(String.format("%s bit in binary: %s", k2, binary), BitWiseOperations.kthBitSet(num, k2));
            Assert.assertFalse(String.format("%s bit in binary: %s", k3, binary), BitWiseOperations.kthBitSet(num, k3));
            Assert.assertFalse(String.format("%s bit in binary: %s", k4, binary), BitWiseOperations.kthBitSet(num, k4));
        }
    }

    @Test
    public void sum() {
        {
            final int a = 0;
            final int b = randInt();
            final int expected = b;
            final int actual = BitWiseOperations.sum(a, b);
            Assert.assertEquals(String.format("Sum: [%s, %s]", a, b), expected, actual);
        }
        {
            final int a = randInt();
            final int b = 0;
            final int expected = a;
            final int actual = BitWiseOperations.sum(a, b);
            Assert.assertEquals(String.format("Sum: [%s, %s]", a, b), expected, actual);
        }
        {
            final int a = randInt();
            final int b = randInt();
            final int expected = a + b;
            final int actual = BitWiseOperations.sum(a, b);
            Assert.assertEquals(String.format("Sum: [%s, %s]", a, b), expected, actual);
        }
    }

    private static int randInt() {
        return randInt(1000);
    }

    private static int randInt(final int n) {
        return (int) (Math.random() * n) + 5;
    }
}