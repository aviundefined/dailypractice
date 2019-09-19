package com.avi.practice.arrays;

import com.avi.practice.arrays.ArrayPractice.Interval;
import com.avi.practice.utils.CommonUtils;
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
            CommonUtils.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrder(M_4_X_4);
            CommonUtils.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrder(M_5_X_5);
            CommonUtils.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrder(M_4_X_3);
            CommonUtils.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrder(M_3_X_4);
            CommonUtils.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrder(M_5_X_3);
            CommonUtils.printArr(spiral);
        }
    }

    @Test
    public void spiralOrderApproach2() {
        {
            final int[] spiral = tool.spiralOrderApproach2(M_3_X_3);
            CommonUtils.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrderApproach2(M_4_X_4);
            CommonUtils.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrderApproach2(M_5_X_5);
            CommonUtils.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrderApproach2(M_4_X_3);
            CommonUtils.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrderApproach2(M_3_X_4);
            CommonUtils.printArr(spiral);
        }
        {
            final int[] spiral = tool.spiralOrderApproach2(M_5_X_3);
            CommonUtils.printArr(spiral);
        }
    }

    @Test
    public void zigZag() {
        final ArrayPractice tool = new ArrayPractice();
        {
            final int[] zigZag = tool.zigZagOrder(M_3_X_3);
            CommonUtils.printArr(zigZag);
        }
        {
            final int[] zigZag = tool.zigZagOrder(M_4_X_4);
            CommonUtils.printArr(zigZag);
        }
        {
            final int[] zigZag = tool.zigZagOrder(M_5_X_5);
            CommonUtils.printArr(zigZag);
        }
        {
            final int[] zigZag = tool.zigZagOrder(M_4_X_3);
            CommonUtils.printArr(zigZag);
        }
        {
            final int[] zigZag = tool.zigZagOrder(M_3_X_4);
            CommonUtils.printArr(zigZag);
        }
        {
            final int[] zigZag = tool.zigZagOrder(M_5_X_3);
            CommonUtils.printArr(zigZag);
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
            final int[] a = {-4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8,
                    0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1,
                    -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0,
                    -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8,
                    7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4,
                    -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2,
                    -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5};
            Assert.assertEquals(NOT_FOUND, tool.nobleInteger(a));
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
            final int[] a = {-4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8,
                    0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1,
                    -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0,
                    -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8,
                    7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4,
                    -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2,
                    -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5};
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

    @Test
    public void wave() {
        {
            final int[] a = {1, 2, 3, 4};
            CommonUtils.printArr(a);
            final int[] expected = {2, 1, 4, 3};
            final int[] wave = tool.wave(a);
            CommonUtils.printArr(wave);
            Assert.assertArrayEquals(expected, wave);
        }

        {
            final int[] a = {5, 1, 3, 2, 4};
            CommonUtils.printArr(a);
            final int[] expected = {2, 1, 4, 3, 5};
            final int[] wave = tool.wave(a);
            CommonUtils.printArr(wave);
            Assert.assertArrayEquals(expected, wave);
        }
    }

    @Test
    public void waveApproach2() {
        {
            final int[] a = {1, 2, 3, 4};
            CommonUtils.printArr(a);
            final int[] expected = {2, 1, 4, 3};
            final int[] wave = tool.waveApproach2(a);
            CommonUtils.printArr(wave);
            Assert.assertArrayEquals(expected, wave);
        }

        {
            final int[] a = {5, 1, 3, 2, 4};
            CommonUtils.printArr(a);
            final int[] expected = {2, 1, 4, 3, 5};
            final int[] wave = tool.waveApproach2(a);
            CommonUtils.printArr(wave);
            Assert.assertArrayEquals(expected, wave);
        }
    }

    @Test
    public void compareWaveAndWaveApproach2() {
        final int n = randInt();
        for (int i = 0; i <= n; i++) {
            final int[] a = randIntArr();
            final int[] wave = tool.wave(a);
            final int[] waveApproach2 = tool.waveApproach2(a);
            Assert.assertArrayEquals(waveApproach2, wave);
        }

    }

    @Test
    public void mergeOverlappingIntervals() {
        final Interval[] arr = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        CommonUtils.printArr(arr);
        final Interval[] nonOverlappingIntervals = tool.getMergedNonOverlappingIntervals(arr);
        CommonUtils.printArr(nonOverlappingIntervals);
        System.out.println("================================");
        final int n = randInt(10);
        for (int i = 0; i <= n; i++) {
            final int m = randInt(10);
            final Interval[] intervals = new Interval[m];
            for (int j = 0; j < m; j++) {
                final int s = randInt(100);
                final Interval interval = new Interval(s, s + randInt(4));
                intervals[j] = interval;
            }
            CommonUtils.printArr(intervals);
            System.out.println("---------------------");
            CommonUtils.printArr(tool.getMergedNonOverlappingIntervals(intervals));
            System.out.println("================================");
        }
    }


    @Test
    public void compareInsertIntoNonOverlappingIntervals() {
        final int n = randInt(10);
        for (int i = 0; i <= n; i++) {
            final int m = randInt(10);
            final List<Interval> intervals = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                final int s = randInt(100);
                intervals.add(new Interval(s, s + randInt(4)));
            }
            final int start = randInt();
            final Interval newInterval = new Interval(start, start + randInt(5));
            System.out.println(intervals);
            final List<Interval> intervals1 = tool.insertIntoNonOverlappingIntervals(intervals, newInterval);
            System.out.println(intervals1);
        }
    }

    @Test
    public void insertIntoNonOverlappingIntervals() {
        /*
         * Input : Set : [1, 2], [6, 9]
         *         New interval : [3, 5]
         * Output : [1, 2], [3, 5], [6, 9]
         */
        final Interval i1= new Interval(1, 2);
        final Interval i2= new Interval(6, 9);
        final Interval newInterval = new Interval(3, 5);
        final List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        final List<Interval> merged = tool.insertIntoNonOverlappingIntervals(intervals, newInterval);
        System.out.println(merged);
    }
    private static int randInt() {
        return randInt(1000);
    }

    private static int randInt(final int n) {
        return (int) (Math.random() * n) + 5;
    }
    private static int[] randIntArr() {
        final int n = randInt();
        final int[] a = new int[n];
        for (int i = 0; i <= n - 1; i++) {
            a[i] = randInt();
        }
        return a;
    }
}