package com.avi.practice.arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.avi.practice.arrays.ArrayPractice.FOUND;
import static com.avi.practice.arrays.ArrayPractice.NOT_FOUND;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by navinash on 14/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ArrayPracticeTest {

    private static final int[][] M_3_X_3 = new int[3][3];
    private static final int[][] M_4_X_4 = new int[4][4];
    private static final int[][] M_5_X_5 = new int[5][5];
    private static final int[][] M_4_X_3 = new int[4][3];
    private static final int[][] M_3_X_4 = new int[3][4];
    private static final int[][] M_5_X_3 = new int[5][3];

    static {
        M_3_X_3[0][0] = 1;
        M_3_X_3[0][1] = 2;
        M_3_X_3[0][2] = 3;
        M_3_X_3[1][0] = 4;
        M_3_X_3[1][1] = 5;
        M_3_X_3[1][2] = 6;
        M_3_X_3[2][0] = 7;
        M_3_X_3[2][1] = 8;
        M_3_X_3[2][2] = 9;


        M_4_X_4[0][0] = 1;
        M_4_X_4[0][1] = 2;
        M_4_X_4[0][2] = 3;
        M_4_X_4[0][3] = 4;
        M_4_X_4[1][0] = 5;
        M_4_X_4[1][1] = 6;
        M_4_X_4[1][2] = 7;
        M_4_X_4[1][3] = 8;
        M_4_X_4[2][0] = 9;
        M_4_X_4[2][1] = 10;
        M_4_X_4[2][2] = 11;
        M_4_X_4[2][3] = 12;
        M_4_X_4[3][0] = 13;
        M_4_X_4[3][1] = 14;
        M_4_X_4[3][2] = 15;
        M_4_X_4[3][3] = 16;

        M_5_X_5[0][0] = 1;
        M_5_X_5[0][1] = 2;
        M_5_X_5[0][2] = 3;
        M_5_X_5[0][3] = 4;
        M_5_X_5[0][4] = 5;
        M_5_X_5[1][0] = 6;
        M_5_X_5[1][1] = 7;
        M_5_X_5[1][2] = 8;
        M_5_X_5[1][3] = 9;
        M_5_X_5[1][4] = 10;
        M_5_X_5[2][0] = 11;
        M_5_X_5[2][1] = 12;
        M_5_X_5[2][2] = 13;
        M_5_X_5[2][3] = 14;
        M_5_X_5[2][4] = 15;
        M_5_X_5[3][0] = 16;
        M_5_X_5[3][1] = 17;
        M_5_X_5[3][2] = 18;
        M_5_X_5[3][3] = 19;
        M_5_X_5[3][4] = 20;
        M_5_X_5[4][0] = 21;
        M_5_X_5[4][1] = 22;
        M_5_X_5[4][2] = 23;
        M_5_X_5[4][3] = 24;
        M_5_X_5[4][4] = 25;

        M_4_X_3[0][0] = 1;
        M_4_X_3[0][1] = 2;
        M_4_X_3[0][2] = 3;
        M_4_X_3[1][0] = 4;
        M_4_X_3[1][1] = 5;
        M_4_X_3[1][2] = 6;
        M_4_X_3[2][0] = 7;
        M_4_X_3[2][1] = 8;
        M_4_X_3[2][2] = 9;
        M_4_X_3[3][0] = 10;
        M_4_X_3[3][1] = 11;
        M_4_X_3[3][2] = 12;

        M_3_X_4[0][0] = 1;
        M_3_X_4[0][1] = 2;
        M_3_X_4[0][2] = 3;
        M_3_X_4[0][3] = 4;
        M_3_X_4[1][0] = 5;
        M_3_X_4[1][1] = 6;
        M_3_X_4[1][2] = 7;
        M_3_X_4[1][3] = 8;
        M_3_X_4[2][0] = 9;
        M_3_X_4[2][1] = 10;
        M_3_X_4[2][2] = 11;
        M_3_X_4[2][3] = 12;

        M_5_X_3[0][0] = 1;
        M_5_X_3[0][1] = 2;
        M_5_X_3[0][2] = 3;
        M_5_X_3[1][0] = 4;
        M_5_X_3[1][1] = 5;
        M_5_X_3[1][2] = 6;
        M_5_X_3[2][0] = 7;
        M_5_X_3[2][1] = 8;
        M_5_X_3[2][2] = 9;
        M_5_X_3[3][0] = 10;
        M_5_X_3[3][1] = 11;
        M_5_X_3[3][2] = 12;
        M_5_X_3[4][0] = 13;
        M_5_X_3[4][1] = 14;
        M_5_X_3[4][2] = 15;
    }


    private ArrayPractice tool;

    @Before
    public void setup() {
        tool = new ArrayPractice();
    }

    @After
    public void tearDown() {
        tool = null;
    }

    @Test
    public void spiralOrder() {
        {
            final int[] spiral = tool.spiralOrder(M_3_X_3);
            tool.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrder(M_4_X_4);
            tool.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrder(M_5_X_5);
            tool.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrder(M_4_X_3);
            tool.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrder(M_3_X_4);
            tool.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrder(M_5_X_3);
            tool.printArr(spiral);
        }
    }

    @Test
    public void spiralOrderApproach2() {
        {
            final int[] spiral = tool.spiralOrderApproach2(M_3_X_3);
            tool.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrderApproach2(M_4_X_4);
            tool.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrderApproach2(M_5_X_5);
            tool.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrderApproach2(M_4_X_3);
            tool.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrderApproach2(M_3_X_4);
            tool.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrderApproach2(M_5_X_3);
            tool.printArr(spiral);
        }
    }

    @Test
    public void zigZag() {
        final ArrayPractice tool = new ArrayPractice();
        {
            final int[] zigZag = tool.zigZagOrder(M_3_X_3);
            tool.printArr(zigZag);
        }
        {
            final int[] zigZag = tool.zigZagOrder(M_4_X_4);
            tool.printArr(zigZag);
        }
        {
            final int[] zigZag = tool.zigZagOrder(M_5_X_5);
            tool.printArr(zigZag);
        }
        {
            final int[] zigZag = tool.zigZagOrder(M_4_X_3);
            tool.printArr(zigZag);
        }
        {
            final int[] zigZag = tool.zigZagOrder(M_3_X_4);
            tool.printArr(zigZag);
        }
        {
            final int[] zigZag = tool.zigZagOrder(M_5_X_3);
            tool.printArr(zigZag);
        }
    }

    @Test
    public void coverPoints() {
        {
            int[] a = {0, 1, 1};
            int[] b = {0, 1, 2};
            Assert.assertEquals(2, tool.coverPoints(a, b));
        }


        {
            int[] a = {0, 1, 1};
            int[] b = {0, 1, 2, 4};
            assertThatThrownBy(() -> tool.coverPoints(a, b))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format("Invalid input: Length of both array should be equal. Length of A : [%d], Length of B : [%d]", a.length, b.length))
                    .hasNoCause();
        }

    }

    @Test
    public void maxSpecialProduct() {
        final int[] a = {5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9};
        Assert.assertEquals(80, tool.maxSpecialProduct(a));
        Assert.assertEquals(80, tool.maxSpecialProductStack(a));
    }

    @Test
    public void nobleInteger() {
        {
            final int[] a = {5, 6, 2};
            Assert.assertEquals(FOUND, tool.nobleInteger(a));
        }
        {
            final int[] a = {1, 2, 7, 0, 9, 3, 6, 0, 6};
            Assert.assertEquals(NOT_FOUND, tool.nobleInteger(a));
        }
        {
            final int[] a = {-4, -2, 0, -1, -6};
            Assert.assertEquals(FOUND, tool.nobleInteger(a));
        }

        {
            final int[] a = {8, 4, -9, 8, 5, -1, 7, 5, 3};
            Assert.assertEquals(NOT_FOUND, tool.nobleInteger(a));
        }
    }

    @Test
    public void nobleIntegerApproach2() {
        {
            final int[] a = {5, 6, 2};
            Assert.assertEquals(FOUND, tool.nobleIntegerApproach2(a));
        }
        {
            final int[] a = {1, 2, 7, 0, 9, 3, 6, 0, 6};
            Assert.assertEquals(NOT_FOUND, tool.nobleIntegerApproach2(a));
        }
        {
            final int[] a = {-4, -2, 0, -1, -6};
            Assert.assertEquals(FOUND, tool.nobleIntegerApproach2(a));
        }

        {
            final int[] a = {0, 3, 3, 3, 4, 5, 6};
            Assert.assertEquals(FOUND, tool.nobleIntegerApproach2(a));
        }

        {
            final int[] a = {-4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5};
            Assert.assertEquals(NOT_FOUND, tool.nobleIntegerApproach2(a));
        }

        {
            final int[] a = {8, 4, -9, 8, 5, -1, 7, 5, 3};
            Assert.assertEquals(NOT_FOUND, tool.nobleIntegerApproach2(a));
        }
    }

    @Test
    public void performOps() {
        final List<Integer> a1 = Arrays.asList(1, 2, 3, 4);
        final List<Integer> a2 = Arrays.asList(5, 6, 7, 8);
        final List<Integer> a3 = Arrays.asList(9, 10, 11, 12);
        final List<List<Integer>> a = new ArrayList<>();
        a.add(a1);
        a.add(a2);
        a.add(a3);
        List<List<Integer>> b = tool.performOps(a);
        for (List<Integer> integers : b) {
            for (int integer : integers) {
                System.out.print(integer + " ");
            }
        }
    }
}