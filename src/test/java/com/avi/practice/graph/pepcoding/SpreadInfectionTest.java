package com.avi.practice.graph.pepcoding;

import com.avi.pepcoding.graph.Graph;
import com.avi.pepcoding.graph.SpreadInfection;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 03/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SpreadInfectionTest {

    private static final SpreadInfection solver = new SpreadInfection();

    @Test
    public void infected1() {
        /*   1 ------ 3 ----- 5
         *   |        |      |  \
         *   |        |      |   \
         *   |        |      |    \
         *   2 ------ 4      6---- 7
         */
        final Graph graph = GraphTestUtils.getTestUndirectedGraph1();
        final int source = 1;
        final int t = 3;
        final int expected = 5;
        final int infected = solver.infected(graph, source, t);
        Assert.assertEquals(expected, infected);
    }

    @Test
    public void infected2() {
        /*   1 ------ 3 ----- 5
         *   |        |      |  \
         *   |        |      |   \
         *   |        |      |    \
         *   2 ------ 4      6---- 7
         */
        final Graph graph = GraphTestUtils.getTestUndirectedGraph1();
        final int source = 6;
        final int t = 3;
        final int expected = 4;
        final int infected = solver.infected(graph, source, t);
        Assert.assertEquals(expected, infected);
    }

    @Test
    public void infected3() {
        /*   1        3       5
         *   |        |      |  \
         *   |        |      |   \
         *   |        |      |    \
         *   2        4      6---- 7
         */
        final Graph graph = GraphTestUtils.getTestUndirectedGraph2();
        final int source = 1;
        final int t = 3;
        final int expected = 2;
        final int infected = solver.infected(graph, source, t);
        Assert.assertEquals(expected, infected);
    }


    @Test
    public void infected4() {
        /*   1        3       5
         *   |        |      |  \
         *   |        |      |   \
         *   |        |      |    \
         *   2        4      6---- 7
         */
        final Graph graph = GraphTestUtils.getTestUndirectedGraph2();
        final int source = 6;
        final int t = 3;
        final int expected = 3;
        final int infected = solver.infected(graph, source, t);
        Assert.assertEquals(expected, infected);
    }

    @Test
    public void infected5() {
        /*   1        3 ----- 5
         *   |        |       |
         *   |        |       |
         *   |        |       |
         *   2 ------ 4      6---- 7
         */
        final Graph graph = GraphTestUtils.getTestUndirectedGraph4();
        final int source = 1;
        final int t = 3;
        final int expected = 3;
        final int infected = solver.infected(graph, source, t);
        Assert.assertEquals(expected, infected);
    }

    @Test
    public void infected6() {
        /*   1 ------ 3 ----- 5
         *   |        |      |  \
         *   |        |      |   \
         *   |        |      |    \
         *   2 ------ 4      6---- 7
         */
        final Graph graph = GraphTestUtils.getTestUndirectedGraph1();
        final int source = 3;
        final int t = 3;
        final int expected = 7;
        final int infected = solver.infected(graph, source, t);
        Assert.assertEquals(expected, infected);
    }


    @Test
    public void infected7() {
        /*   1 ------ 3 ----- 5
         *   |        |      |  \
         *   |        |      |   \
         *   |        |      |    \
         *   2 ------ 4      6---- 7
         */
        final Graph graph = GraphTestUtils.getTestUndirectedGraph1();
        final int source = 3;
        final int t = 2;
        final int expected = 4;
        final int infected = solver.infected(graph, source, t);
        Assert.assertEquals(expected, infected);
    }
}