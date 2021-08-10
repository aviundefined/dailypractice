package com.avi.practice.company.google;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by navinash on 10/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TheMostSimilarPathInAGraphTest {

    @Test
    public void mostSimilar1() {
        final TheMostSimilarPathInAGraph solver = new TheMostSimilarPathInAGraph();
        final int n = 5;
        final int[][] roads = {{0, 2}, {0, 3}, {1, 2}, {1, 3}, {1, 4}, {2, 4}};
        final String[] names = {"ATL", "PEK", "LAX", "DXB", "HND"};
        final String[] targetPath = {"ATL", "DXB", "HND", "LAX"};
        final List<Integer> expected = Arrays.asList(0, 2, 4, 2);
        final List<Integer> actual = solver.mostSimilar(n, roads, names, targetPath);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
    }

    @Test
    public void mostSimilar2() {
        final TheMostSimilarPathInAGraph solver = new TheMostSimilarPathInAGraph();
        final int n = 4;
        final int[][] roads = {{1, 0}, {2, 0}, {3, 0}, {2, 1}, {3, 1}, {3, 2}};
        final String[] names = {"ATL", "PEK", "LAX", "DXB"};
        final String[] targetPath = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQR", "STU", "VWX"};
        final List<Integer> expected = Arrays.asList(0, 1, 0, 1, 0, 1, 0, 1);
        final List<Integer> actual = solver.mostSimilar(n, roads, names, targetPath);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
    }
}