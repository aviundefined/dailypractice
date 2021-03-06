package com.avi.practice.graph.pepcoding;

import com.avi.pepcoding.graph.GetAllPaths;
import com.avi.pepcoding.graph.Graph;
import org.junit.Test;

import java.util.List;

/**
 * Created by navinash on 01/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GetAllPathsTest {

    private static final GetAllPaths solver = new GetAllPaths();

    @Test
    public void allPaths11() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph1();
        final int src = 1;
        final int dst = 7;
        final List<List<Integer>> allPaths = solver.allPaths(graph, src, dst);
        for(final List<Integer> path : allPaths) {
            System.out.println(path);
        }
        System.out.println("-------------");
    }

    @Test
    public void allPaths12() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph2();
        final int src = 1;
        final int dst = 7;
        final List<List<Integer>> allPaths = solver.allPaths(graph, src, dst);
        for(final List<Integer> path : allPaths) {
            System.out.println(path);
        }
        System.out.println("-------------");
    }

    @Test
    public void allPaths21() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph1();
        final int src = 1;
        final int dst = 7;
        final List<List<Integer>> allPaths = solver.allPaths2(graph, src, dst);
        for(final List<Integer> path : allPaths) {
            System.out.println(path);
        }
        System.out.println("-------------");
    }

    @Test
    public void allPaths22() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph2();
        final int src = 1;
        final int dst = 7;
        final List<List<Integer>> allPaths = solver.allPaths2(graph, src, dst);
        for(final List<Integer> path : allPaths) {
            System.out.println(path);
        }
        System.out.println("-------------");
    }

}