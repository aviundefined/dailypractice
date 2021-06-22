package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 21/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class InsertIntervalTest {

    private static final InsertInterval solver = new InsertInterval();

    @Test
    public void insertV1_1() {
        final int[][] intervals = {
                {1, 3},
                {6, 9}
        };
        final int[] newInterval = {2, 5};
        final int[][] expected = {
                {1, 5},
                {6, 9}
        };
        final int[][] actual = solver.insertV1(intervals, newInterval);
        System.out.println(" ----- intervals -------");
        for (final int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------");
        System.out.println("New Interval: " + Arrays.toString(newInterval));
        System.out.println(" ----- merged intervals -------");
        for (final int[] row : actual) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(String.format("%sth element", i), expected[i], actual[i]);
        }
        System.out.println("--------------");
    }

    @Test
    public void insertV1_2() {
        final int[][] intervals = {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}};
        final int[] newInterval = {4,8};
        final int[][] expected = {
                {1, 2},
                {3, 10},
                {12, 16}
        };
        final int[][] actual = solver.insertV1(intervals, newInterval);
        System.out.println(" ----- intervals -------");
        for (final int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------");
        System.out.println("New Interval: " + Arrays.toString(newInterval));
        System.out.println(" ----- merged intervals -------");
        for (final int[] row : actual) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(String.format("%sth element", i), expected[i], actual[i]);
        }
        System.out.println("--------------");
    }

    @Test
    public void insertV1_3() {
        final int[][] intervals = {};
        final int[] newInterval = {5,7};
        final int[][] expected = {
                {5, 7}
        };
        final int[][] actual = solver.insertV1(intervals, newInterval);
        System.out.println(" ----- intervals -------");
        for (final int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------");
        System.out.println("New Interval: " + Arrays.toString(newInterval));
        System.out.println(" ----- merged intervals -------");
        for (final int[] row : actual) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(String.format("%sth element", i), expected[i], actual[i]);
        }
        System.out.println("--------------");
    }

    @Test
    public void insertV1_4() {
        final int[][] intervals = {{1,5}};
        final int[] newInterval = {2, 3};
        final int[][] expected = {
                {1, 5}
        };
        final int[][] actual = solver.insertV1(intervals, newInterval);
        System.out.println(" ----- intervals -------");
        for (final int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------");
        System.out.println("New Interval: " + Arrays.toString(newInterval));
        System.out.println(" ----- merged intervals -------");
        for (final int[] row : actual) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(String.format("%sth element", i), expected[i], actual[i]);
        }
        System.out.println("--------------");
    }

    @Test
    public void insertV1_5() {
        final int[][] intervals = {{1,5}};
        final int[] newInterval = {2, 7};
        final int[][] expected = {
                {1, 7}
        };
        final int[][] actual = solver.insertV1(intervals, newInterval);
        System.out.println(" ----- intervals -------");
        for (final int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------");
        System.out.println("New Interval: " + Arrays.toString(newInterval));
        System.out.println(" ----- merged intervals -------");
        for (final int[] row : actual) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(String.format("%sth element", i), expected[i], actual[i]);
        }
        System.out.println("--------------");
    }

    @Test
    public void insertV1_6() {
        final int[][] intervals = {{1,5}};
        final int[] newInterval = {0, 3};
        final int[][] expected = {
                {0, 5}
        };
        final int[][] actual = solver.insertV1(intervals, newInterval);
        System.out.println(" ----- intervals -------");
        for (final int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------");
        System.out.println("New Interval: " + Arrays.toString(newInterval));
        System.out.println(" ----- merged intervals -------");
        for (final int[] row : actual) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(String.format("%sth element", i), expected[i], actual[i]);
        }
        System.out.println("--------------");
    }

    @Test
    public void insertV2_1() {
        final int[][] intervals = {
                {1, 3},
                {6, 9}
        };
        final int[] newInterval = {2, 5};
        final int[][] expected = {
                {1, 5},
                {6, 9}
        };
        final int[][] actual = solver.insertV2(intervals, newInterval);
        System.out.println(" ----- intervals -------");
        for (final int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------");
        System.out.println("New Interval: " + Arrays.toString(newInterval));
        System.out.println(" ----- merged intervals -------");
        for (final int[] row : actual) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(String.format("%sth element", i), expected[i], actual[i]);
        }
        System.out.println("--------------");
    }

    @Test
    public void insertV2_2() {
        final int[][] intervals = {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}};
        final int[] newInterval = {4,8};
        final int[][] expected = {
                {1, 2},
                {3, 10},
                {12, 16}
        };
        final int[][] actual = solver.insertV2(intervals, newInterval);
        System.out.println(" ----- intervals -------");
        for (final int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------");
        System.out.println("New Interval: " + Arrays.toString(newInterval));
        System.out.println(" ----- merged intervals -------");
        for (final int[] row : actual) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(String.format("%sth element", i), expected[i], actual[i]);
        }
        System.out.println("--------------");
    }

    @Test
    public void insertV2_3() {
        final int[][] intervals = {};
        final int[] newInterval = {5,7};
        final int[][] expected = {
                {5, 7}
        };
        final int[][] actual = solver.insertV2(intervals, newInterval);
        System.out.println(" ----- intervals -------");
        for (final int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------");
        System.out.println("New Interval: " + Arrays.toString(newInterval));
        System.out.println(" ----- merged intervals -------");
        for (final int[] row : actual) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(String.format("%sth element", i), expected[i], actual[i]);
        }
        System.out.println("--------------");
    }

    @Test
    public void insertV2_4() {
        final int[][] intervals = {{1,5}};
        final int[] newInterval = {2, 3};
        final int[][] expected = {
                {1, 5}
        };
        final int[][] actual = solver.insertV2(intervals, newInterval);
        System.out.println(" ----- intervals -------");
        for (final int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------");
        System.out.println("New Interval: " + Arrays.toString(newInterval));
        System.out.println(" ----- merged intervals -------");
        for (final int[] row : actual) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(String.format("%sth element", i), expected[i], actual[i]);
        }
        System.out.println("--------------");
    }

    @Test
    public void insertV2_5() {
        final int[][] intervals = {{1,5}};
        final int[] newInterval = {2, 7};
        final int[][] expected = {
                {1, 7}
        };
        final int[][] actual = solver.insertV2(intervals, newInterval);
        System.out.println(" ----- intervals -------");
        for (final int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------");
        System.out.println("New Interval: " + Arrays.toString(newInterval));
        System.out.println(" ----- merged intervals -------");
        for (final int[] row : actual) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(String.format("%sth element", i), expected[i], actual[i]);
        }
        System.out.println("--------------");
    }

    @Test
    public void insertV2_6() {
        final int[][] intervals = {{1,5}};
        final int[] newInterval = {0, 3};
        final int[][] expected = {
                {0, 5}
        };
        final int[][] actual = solver.insertV2(intervals, newInterval);
        System.out.println(" ----- intervals -------");
        for (final int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------");
        System.out.println("New Interval: " + Arrays.toString(newInterval));
        System.out.println(" ----- merged intervals -------");
        for (final int[] row : actual) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(String.format("%sth element", i), expected[i], actual[i]);
        }
        System.out.println("--------------");
    }
}