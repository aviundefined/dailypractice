package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 03/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ReconstructItineraryTest {

    @Test
    public void findItinerary1() {
        final ReconstructItinerary solver = new ReconstructItinerary();
        final List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        final List<String> expected = Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC");
        final List<String> actual = solver.findItinerary(tickets);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void findItinerary2() {
        final ReconstructItinerary solver = new ReconstructItinerary();
        final List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));
        final List<String> expected = Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
        final List<String> actual = solver.findItinerary(tickets);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findItinerary3() {
        final ReconstructItinerary solver = new ReconstructItinerary();
        final List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("EZE", "AXA"));
        tickets.add(Arrays.asList("TIA", "ANU"));
        tickets.add(Arrays.asList("ANU", "JFK"));
        tickets.add(Arrays.asList("JFK", "ANU"));
        tickets.add(Arrays.asList("ANU", "EZE"));
        tickets.add(Arrays.asList("TIA", "ANU"));
        tickets.add(Arrays.asList("AXA", "TIA"));
        tickets.add(Arrays.asList("TIA", "JFK"));
        tickets.add(Arrays.asList("ANU", "TIA"));
        tickets.add(Arrays.asList("JFK", "TIA"));
        final List<String> expected = Arrays.asList("JFK", "ANU", "EZE", "AXA", "TIA", "ANU", "JFK", "TIA", "ANU", "TIA", "JFK");
        final List<String> actual = solver.findItinerary(tickets);
        Assert.assertEquals(expected, actual);
    }
}