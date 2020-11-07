package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 11/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NextPermutationTest {

    @Test
    public void next() {
        final NextPermutation solver = new NextPermutation();
        String s = "12345";
        String next = solver.next(s);
        String expected = "12354";
        Assert.assertEquals(s, expected, next);

        s = next;
        expected = "12435";
        next = solver.next(s);
        Assert.assertEquals(s, expected, next);

        s = next;
        expected = "12453";
        next = solver.next(s);
        Assert.assertEquals(s, expected, next);

        s = next;
        expected = "12534";
        next = solver.next(s);
        Assert.assertEquals(s, expected, next);

        s = next;
        expected = "12543";
        next = solver.next(s);
        Assert.assertEquals(s, expected, next);

        s = "6215430";
        expected = "6230145";
        next = solver.next(s);
        Assert.assertEquals(s, expected, next);
    }

    @Test
    public void all() {
        final NextPermutation solver = new NextPermutation();
        String s = "12345";
        System.out.println(s);
        while (!CommonUtils.isEmpty(s)) {
            final String next = solver.next(s);
            System.out.println(next);
            s = next;
        }
    }


    @Test
    public void all_Duplicates() {
        final NextPermutation solver = new NextPermutation();
        {
            String s = "11233";
            System.out.println(s);
            while (!CommonUtils.isEmpty(s)) {
                final String next = solver.next(s);
                System.out.println(next);
                s = next;
            }

        }

        {
            String s = "HHHVV";
            System.out.println(s);
            while (!CommonUtils.isEmpty(s)) {
                final String next = solver.next(s);
                System.out.println(next);
                s = next;
            }

        }

    }


    @Test
    public void kthPermutation() {
        final NextPermutation solver = new NextPermutation();
        {
            final String s = "HHHVV";
            final int k = 1;
            final String expected = "HHHVV";
            final String actual = solver.kthPermutation(s, k);
            Assert.assertEquals(String.format("%s : %d", s, k), expected, actual);
        }

        {
            final String s = "HHHVV";
            final int k = 2;
            final String expected = "HHVHV";
            final String actual = solver.kthPermutation(s, k);
            Assert.assertEquals(String.format("%s : %d", s, k), expected, actual);
        }

    }
}
