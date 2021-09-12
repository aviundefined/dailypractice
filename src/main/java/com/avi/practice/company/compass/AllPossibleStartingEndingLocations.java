package com.avi.practice.company.compass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * letecode's avatar
 * letecode
 * 51
 * April 15, 2021 9:51 AM
 * <p>
 * 642 VIEWS
 * <p>
 * You work in an automated doll factory. Once dolls are assembled, they are sent to the shipping center via a series of autonomous delivery carts, each of which moves packages on a one-way route.
 * <p>
 * Given input that provides the (directed) steps that each cart takes as pairs, write a function that identifies all the start locations, and a collection of all of the possible ending locations for each start location.
 * <p>
 * In this diagram, starting locations are at the top and destinations are at the bottom - i.e. the graph is directed exclusively downward.
 * <p>
 * A         E      J       Key:  [Origins]
 * / \       / \      \             \
 * B   C     F   L      M            [Destinations]
 * \ /  \  /
 * K     G
 * / \
 * H   I
 * paths = [
 * ["A", "B"],
 * ["A", "C"],
 * ["B", "K"],
 * ["C", "K"],
 * ["E", "L"],
 * ["F", "G"],
 * ["J", "M"],
 * ["E", "F"],
 * ["G", "H"],
 * ["G", "I"],
 * ["C", "G"]
 * ]
 * Expected output (unordered):
 * <p>
 * [ "A": ["K", "H", "I"],
 * "E:" ["H", "L", "I"],
 * "J": ["M"] ]
 * N: Number of pairs in the input.
 */
public class AllPossibleStartingEndingLocations {

    public final List<List<String>> getStartEndLocations(final String[][] paths) {
        if (paths == null || paths.length == 0) {
            return Collections.emptyList();
        }

        final Graph graph = new Graph();
        for (final String[] path : paths) {
            graph.addEdge(path[0], path[1]);
        }

        final Set<String> visited = new HashSet<>();
        final List<List<String>> allPaths = new ArrayList<>();
        final Set<String> startNodes = graph.getStartNodes();
        final Set<String> endNodes = graph.getEndNodes();
        for (final String startNode : startNodes) {
            for (final String endNode : endNodes) {
                if (visited.contains(startNode) && visited.contains(endNode)) {
                    continue;
                }
                dfs(startNode, endNode, graph, visited, new ArrayList<>(), allPaths);
            }
        }
        return allPaths;
    }

    private void dfs(String startNode, String endNode, Graph graph, Set<String> visited, List<String> curr, List<List<String>> allPaths) {
        if (startNode.equals(endNode)) {
            curr.add(endNode);
            final List<String> tmp = new ArrayList<>(curr);
            allPaths.add(tmp);
            curr.remove(curr.size() - 1);
            return;
        }
        visited.add(startNode);
        curr.add(startNode);
        for (final String neighbour : graph.getNeighbours(startNode)) {
            if (visited.contains(neighbour)) {
                continue;
            }
            dfs(neighbour, endNode, graph, visited, curr, allPaths);
        }
        curr.remove(curr.size() - 1);
        visited.remove(startNode);

    }

    private static final class Graph {
        private final Map<String, Set<String>> adjList = new HashMap<>();
        private final Map<String, Integer> inDegrees = new HashMap<>();
        private final Map<String, Integer> outDegrees = new HashMap<>();


        private void addEdge(final String src, final String dst) {
            this.adjList.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
            this.inDegrees.putIfAbsent(src, 0);
            this.inDegrees.putIfAbsent(dst, 0);
            this.outDegrees.putIfAbsent(src, 0);
            this.outDegrees.putIfAbsent(dst, 0);
            this.inDegrees.compute(dst, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return 1 + v;
            });

            this.outDegrees.compute(src, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return 1 + v;
            });
        }

        private Set<String> getNeighbours(final String node) {
            return this.adjList.getOrDefault(node, new HashSet<>());
        }

        private Set<String> getStartNodes() {
            return this.inDegrees.entrySet()
                    .stream()
                    .filter(e -> e.getValue() == 0)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet());

        }

        private Set<String> getEndNodes() {
            return this.outDegrees.entrySet()
                    .stream()
                    .filter(e -> e.getValue() == 0)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet());
        }
    }

}
