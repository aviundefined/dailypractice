package com.avi.pepcoding.graph.additionquestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 04/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CriticalConnectionsNetworkTest {

    @Test
    public void criticalConnections1() {
        final CriticalConnectionsNetwork solver = new CriticalConnectionsNetwork();
        final int n = 4;
        final List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        final List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 3));
        final List<List<Integer>> actual = solver.criticalConnections(n, connections);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void criticalConnections2() {
        final CriticalConnectionsNetwork solver = new CriticalConnectionsNetwork();
        final int n = 5;
        final List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(1, 0));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(3, 2));
        connections.add(Arrays.asList(4, 2));
        connections.add(Arrays.asList(4, 3));
        connections.add(Arrays.asList(3, 0));
        connections.add(Arrays.asList(4, 0));
        final List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 1));
        final List<List<Integer>> actual = solver.criticalConnections(n, connections);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void criticalConnections3() {
        final CriticalConnectionsNetwork solver = new CriticalConnectionsNetwork();
        final int n = 6;
        final List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        connections.add(Arrays.asList(3, 4));
        connections.add(Arrays.asList(4, 5));
        connections.add(Arrays.asList(5, 3));
        final List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 3));
        final List<List<Integer>> actual = solver.criticalConnections(n, connections);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void criticalConnectionsBruteForce1() {
        final CriticalConnectionsNetwork solver = new CriticalConnectionsNetwork();
        final int n = 4;
        final List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        final List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 3));
        final List<List<Integer>> actual = solver.criticalConnectionsBruteForce(n, connections);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void criticalConnectionsBruteForce2() {
        final CriticalConnectionsNetwork solver = new CriticalConnectionsNetwork();
        final int n = 5;
        final List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(1, 0));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(3, 2));
        connections.add(Arrays.asList(4, 2));
        connections.add(Arrays.asList(4, 3));
        connections.add(Arrays.asList(3, 0));
        connections.add(Arrays.asList(4, 0));
        final List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 1));
        final List<List<Integer>> actual = solver.criticalConnectionsBruteForce(n, connections);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void criticalConnectionsBruteForce3() {
        final CriticalConnectionsNetwork solver = new CriticalConnectionsNetwork();
        final int n = 6;
        final List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        connections.add(Arrays.asList(3, 4));
        connections.add(Arrays.asList(4, 5));
        connections.add(Arrays.asList(5, 3));
        final List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 3));
        final List<List<Integer>> actual = solver.criticalConnectionsBruteForce(n, connections);
        Assert.assertEquals(expected, actual);
    }
}