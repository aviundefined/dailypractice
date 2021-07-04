package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by navinash on 03/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ReconstructItinerary {

    private static final String START_CITY = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {
        final Graph graph = new Graph();
        int i = 0;
        for (final List<String> ticket : tickets) {
            graph.addEdge(ticket.get(0), ticket.get(1), i);
            i++;
        }
        for (final Edge edge : graph.getEdges(START_CITY)) {
            final Set<Edge> visited = new HashSet<>();
            final List<String> current = new ArrayList<>();
            final List<String> result = new ArrayList<>();
            current.add(START_CITY);
            if (backtrack(edge, graph, visited, current, result, tickets.size())) {
                return result;
            }

        }
        return Collections.emptyList();
    }

    private boolean backtrack(Edge edge, Graph graph, Set<Edge> visited, List<String> current, List<String> result, int numTickets) {
        current.add(edge.dst);
        if (current.size() == numTickets + 1) {
            result.addAll(new ArrayList<>(current));
            return true;
        }
        visited.add(edge);

        for (final Edge nextEdge : graph.getEdges(edge.dst)) {
            if (!visited.contains(nextEdge)) {
                if (backtrack(nextEdge, graph, visited, current, result, numTickets)) {
                    return true;
                }
            }
        }
        current.remove(current.size() - 1);
        visited.remove(edge);
        return false;
    }

    private static final class Graph {
        private final Map<String, TreeSet<Edge>> addList = new HashMap<>();

        private void addEdge(final String src, final String dst, int ticketId) {
            this.addList.computeIfAbsent(src, k -> new TreeSet<>()).add(new Edge(src, dst, ticketId));
        }

        private Set<Edge> getEdges(final String src) {
            return this.addList.getOrDefault(src, new TreeSet<>());
        }
    }

    private static final class Edge implements Comparable<Edge> {
        private final String src;
        private final String dst;
        private final int ticketId;

        private Edge(String src, String dst, int ticketId) {
            this.src = src;
            this.dst = dst;
            this.ticketId = ticketId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return ticketId == edge.ticketId &&
                    Objects.equals(src, edge.src) &&
                    Objects.equals(dst, edge.dst);
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, dst, ticketId);
        }

        @Override
        public int compareTo(final Edge o) {
            if (this.dst.equals(o.dst)) {
                if (this.src.equals(o.src)) {
                    return this.ticketId - o.ticketId;
                } else {
                    return this.src.compareTo(o.dst);
                }
            }
            return this.dst.compareTo(o.dst);
        }
    }
}
