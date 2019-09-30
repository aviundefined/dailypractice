package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 26/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SubsetProblemTest {

    @Test
    public void solutionExists() {
        final int[] a = {3, 34, 4, 12, 5, 2};
        CommonUtils.printArr(a);
        final SubsetProblem solver = new SubsetProblem(a);
        {
            final int sum = 1;
            final boolean expected = false;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 2;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 3;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 4;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 5;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 6;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 7;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 8;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 9;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 10;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 11;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 12;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 13;
            final boolean expected = false;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 14;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 15;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 16;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 17;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 18;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 19;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 20;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 21;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 22;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 23;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 24;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 25;
            final boolean expected = false;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 26;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 27;
            final boolean expected = false;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 28;
            final boolean expected = false;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 29;
            final boolean expected = false;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 30;
            final boolean expected = false;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 31;
            final boolean expected = false;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 32;
            final boolean expected = false;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 33;
            final boolean expected = false;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 34;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 35;
            final boolean expected = false;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 36;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 37;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 38;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 60;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 61;
            final boolean expected = false;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
        {
            final int sum = 62;
            final boolean expected = false;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
    }

    @Test
    public void solutionExists1() {
        final int[] a = {1, 2, 7, 5};
        CommonUtils.printArr(a);
        final SubsetProblem solver = new SubsetProblem(a);
        {
            final int sum = 8;
            final boolean expected = true;
            final boolean solutionExists = solver.isSolutionExists(sum);
            Assert.assertEquals(String.valueOf(sum), expected, solutionExists);
        }
    }

    @Test
    public void count() {
        final int[] a = {3, 34, 4, 1, 12, 5, 2, 8};
        CommonUtils.printArr(a);
        final SubsetProblem solver = new SubsetProblem(a);
        {
            final int sum = 9;
            final int expected = 4;
            final int actual = solver.countSubSetForGivenSum(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
        {
            final int sum = 5;
            final int expected = 3;
            final int actual = solver.countSubSetForGivenSum(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
        {
            final int sum = 7;
            final int expected = 3;
            final int actual = solver.countSubSetForGivenSum(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
    }

    @Test
    public void countDivisibleByM() {
        {
            final int[] a = {3, 1, 7, 5};
            CommonUtils.printArr(a);
            final SubsetProblem solver = new SubsetProblem(a);
            {
                final int m = 6;
                final int expected = 2;
                final int actual = solver.countDivisibleByM(m);
                Assert.assertEquals(String.valueOf(m), expected, actual);
            }
            {
                final int m = 3;
                final int expected = 5;
                final int actual = solver.countDivisibleByM(m);
                Assert.assertEquals(String.valueOf(m), expected, actual);
            }
        }
    }

    @Test
    public void isDivisibleByMSumExists() {
        {
            final int[] a = {3, 1, 7, 5};
            CommonUtils.printArr(a);
            final SubsetProblem solver = new SubsetProblem(a);
            {
                final int m = 6;
                final boolean expected = true;
                final boolean actual = solver.isDivisibleByMSumExists(m);
                Assert.assertEquals(String.valueOf(m), expected, actual);
            }
            {
                final int m = 4;
                final boolean expected = true;
                final boolean actual = solver.isDivisibleByMSumExists(m);
                Assert.assertEquals(String.valueOf(m), expected, actual);
            }
            {
                final int m = 9;
                final boolean expected = true;
                final boolean actual = solver.isDivisibleByMSumExists(m);
                Assert.assertEquals(String.valueOf(m), expected, actual);
            }
            {
                final int m = 14;
                final boolean expected = false;
                final boolean actual = solver.isDivisibleByMSumExists(m);
                Assert.assertEquals(String.valueOf(m), expected, actual);
            }
        }
    }

    @Test
    public void maxSubsetDivisiblePairs() {
        {
            final int[] a = {1, 3, 6, 13, 17, 18};
            CommonUtils.printArr(a);
            final SubsetProblem solver = new SubsetProblem(a);
            final int expected = 4;
            final int actual = solver.maxSubsetDivisiblePairs();
            Assert.assertEquals(expected, actual);
        }
        {
            final int[] a = {3, 15, 5, 10, 20};
            CommonUtils.printArr(a);
            final SubsetProblem solver = new SubsetProblem(a);
            final int expected = 3;
            final int actual = solver.maxSubsetDivisiblePairs();
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void subsetsSum() {
        final int[] a = {3, 34, 4, 1, 12, 5, 2, 8};
        CommonUtils.printArr(a);
        final SubsetProblem solver = new SubsetProblem(a);
        {
            final int sum = 9;
            final int expected = 4;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
        {
            final int sum = 5;
            final int expected = 3;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
        {
            final int sum = 7;
            final int expected = 3;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
    }

    @Test
    public void subsetsSum1() {
        final int[] a = {1, 2, 3, 4, 5};
        CommonUtils.printArr(a);
        final SubsetProblem solver = new SubsetProblem(a);
        {
            final int sum = 1;
            final int expected = 1;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(sum + " -> " + actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
        {
            final int sum = 2;
            final int expected = 1;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(sum + " -> " + actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
        {
            final int sum = 3;
            final int expected = 2;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(sum + " -> " + actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
        {
            final int sum = 4;
            final int expected = 2;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(sum + " -> " + actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
        {
            final int sum = 5;
            final int expected = 3;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(sum + " -> " + actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
        {
            final int sum = 5;
            final int expected = 3;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(sum + " -> " + actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
        {
            final int sum = 6;
            final int expected = 3;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(sum + " -> " + actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
        {
            final int sum = 7;
            final int expected = 3;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(sum + " -> " + actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
        {
            final int sum = 8;
            final int expected = 3;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(sum + " -> " + actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
        {
            final int sum = 9;
            final int expected = 3;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(sum + " -> " + actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
        {
            final int sum = 10;
            final int expected = 3;
            final SubsetProblem.Result actual = solver.subsetsSum(sum);
            Assert.assertNotNull(actual);
            System.out.println(sum + " -> " + actual);
            Assert.assertEquals(String.valueOf(sum), expected, actual.subsets.size());
        }
    }

}
