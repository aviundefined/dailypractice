package com.avi.practice.leetcode.weeklycontest.num163;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by navinash on 22/11/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GridShiftTest {

    @Test
    public void shiftGrid_1() {
        final GridShift shifter = new GridShift();
        {
            final int[][] grid = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            final int k = 1;
            CommonUtils.printMatrix(grid);
            final List<List<Integer>> expected = new ArrayList<>();
            {
                final List<Integer> row = new ArrayList<>();
                row.add(9);
                row.add(1);
                row.add(2);
                expected.add(row);
            }
            {
                final List<Integer> row = new ArrayList<>();
                row.add(3);
                row.add(4);
                row.add(5);
                expected.add(row);
            }
            {
                final List<Integer> row = new ArrayList<>();
                row.add(6);
                row.add(7);
                row.add(8);
                expected.add(row);
            }
            final List<List<Integer>> shifted = shifter.shiftGrid(grid, k);
            System.out.println(shifted);
            Assert.assertEquals(expected, shifted);
        }
    }


    @Test
    public void shiftGrid_2() {
        final GridShift shifter = new GridShift();
        {
            final int[][] grid = {
                    {3, 8, 1, 9},
                    {19, 7, 2, 5},
                    {4, 6, 11, 10},
                    {12, 0, 21, 13}
            };

            final int k = 4;
            CommonUtils.printMatrix(grid);
            // [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
            final List<List<Integer>> expected = new ArrayList<>();
            {
                final List<Integer> row = new ArrayList<>();
                row.add(12);
                row.add(0);
                row.add(21);
                row.add(13);
                expected.add(row);
            }
            {
                final List<Integer> row = new ArrayList<>();
                row.add(3);
                row.add(8);
                row.add(1);
                row.add(9);
                expected.add(row);
            }
            {
                final List<Integer> row = new ArrayList<>();
                row.add(19);
                row.add(7);
                row.add(2);
                row.add(5);
                expected.add(row);
            }
            {
                final List<Integer> row = new ArrayList<>();
                row.add(4);
                row.add(6);
                row.add(11);
                row.add(10);
                expected.add(row);
            }
            final List<List<Integer>> shifted = shifter.shiftGrid(grid, k);
            System.out.println(shifted);
            Assert.assertEquals(expected, shifted);
        }
    }
}