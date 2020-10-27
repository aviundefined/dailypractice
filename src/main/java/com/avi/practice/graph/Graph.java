package com.avi.practice.graph;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by navinash on 27/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public abstract class Graph {

    protected final Map<Vertex, List<Vertex>> adjList;

    protected Graph(int numVertices) {
        this.adjList = new LinkedHashMap<>(numVertices);
    }

    public Map<Vertex, List<Vertex>> getAdjList() {
        return adjList;
    }


    public abstract void addEdge(final Vertex src, final Vertex dst);

    public abstract int numEdges();

    public boolean checkPath(final Vertex src, final Vertex dst) {
        if (src.equals(dst)) {
            return true;
        }
        final Map<Vertex, Boolean> visited = new HashMap<>();
        final Stack<Vertex> s = new Stack<>();
        s.add(src);
        visited.put(src, true);
        while (!s.isEmpty()) {
            final Vertex curr = s.pop();
            final List<Vertex> vertices = this.getAdjList().get(curr);
            if (vertices != null && vertices.size() != 0) {
                for (final Vertex neighbour : vertices) {
                    if (!visited.getOrDefault(neighbour, false)) {
                        if (neighbour.equals(dst)) {
                            return true;
                        }
                        s.push(neighbour);
                        visited.put(neighbour, true);
                    }
                }
            }
        }
        return false;
    }


    public final void bfs() {
        final Map<Vertex, Boolean> visited = new HashMap<>();
        for (final Vertex v : adjList.keySet()) {
            bfs(v, visited);
        }
        System.out.println();
    }

    public final void dfs() {
        final Map<Vertex, Boolean> visited = new HashMap<>();
        for (final Vertex v : adjList.keySet()) {
            dfs(v, visited);
        }
        System.out.println();
    }

    public Vertex findMotherVertx() {
        final Map<Vertex, Boolean> visited = new HashMap<>();
        Vertex lastVertex = null;
        for (final Vertex v : this.getAdjList().keySet()) {
            if (!visited.containsKey(v) || !visited.get(v)) {
                dfs(v, visited);
                lastVertex = v;
            }
        }
        visited.clear();
        dfs(lastVertex, visited);

        for (final Vertex v : this.getAdjList().keySet()) {
            if (!visited.containsKey(v) || !visited.get(v)) {
                return null;
            }
        }
        return lastVertex;
    }

    private void bfs(final Vertex v, final Map<Vertex, Boolean> visited) {
        if (visited.containsKey(v)) {
            return;
        }
        final Queue<Vertex> q = new LinkedList<>();
        q.add(v);
        while (!q.isEmpty()) {
            final Vertex peek = q.poll();
            if (!visited.containsKey(peek) || !visited.get(peek)) {
                visited.put(peek, true);
                System.out.print(peek.id + ",");
                final List<Vertex> vertices = this.adjList.get(peek);
                if (vertices != null && vertices.size() != 0) {
                    q.addAll(vertices);
                }
            }
        }
    }

    private void dfs(final Vertex v, final Map<Vertex, Boolean> visited) {
        if (visited.containsKey(v)) {
            return;
        }
        final Stack<Vertex> s = new Stack<>();
        s.add(v);
        while (!s.isEmpty()) {
            final Vertex peek = s.pop();
            if (!visited.containsKey(peek) || !visited.get(peek)) {
                visited.put(peek, true);
                System.out.print(peek.id + ",");
                final List<Vertex> vertices = this.adjList.get(peek);
                if (vertices != null && vertices.size() != 0) {
                    for (final Vertex n : vertices) {
                        s.push(n);
                    }
                }
            }
        }
    }

    public static class Vertex {
        private final String id;

        public Vertex(final String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(id, vertex.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
