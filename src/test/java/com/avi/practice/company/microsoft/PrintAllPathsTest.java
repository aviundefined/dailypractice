package com.avi.practice.company.microsoft;

import org.junit.Test;

import java.util.List;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintAllPathsTest {

    private static final PrintAllPaths solver = new PrintAllPaths();
    @Test
    public void getPathsDP() {
        {
            final int[][] a = {
                    {1, 2},
                    {3, 4}
            };
            final List<List<Integer>> paths = solver.getPathsDP(a);
            System.out.println(paths);
            System.out.println("----------------------");
        }
        {
            final int[][] a = {
                    {1, 2, 3},
                    {4, 5, 6}
            };
            final List<List<Integer>> paths = solver.getPathsDP(a);
            System.out.println(paths);
            System.out.println("----------------------");
        }
    }
}