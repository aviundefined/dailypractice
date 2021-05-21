package com.avi.practice.graph.pepcoding;

import com.avi.pepcoding.graph.ConnectedComponents;
import com.avi.pepcoding.graph.Graph;
import org.junit.Test;

import java.util.List;

/**
 * Created by navinash on 01/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ConnectedComponentsTest {
    private static final ConnectedComponents solver = new ConnectedComponents();

    @Test
    public void connectedComponents1() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph1();
        final List<List<Integer>> connectedComponents = solver.connectedComponents(graph);
        for(final List<Integer> components : connectedComponents) {
            System.out.println(components);
        }
        System.out.println("-------------------");
    }

    @Test
    public void connectedComponents2() {
        final Graph graph = GraphTestUtils.getTestUndirectedGraph2();
        final List<List<Integer>> connectedComponents = solver.connectedComponents(graph);
        for(final List<Integer> components : connectedComponents) {
            System.out.println(components);
        }
        System.out.println("-------------------");
    }
}