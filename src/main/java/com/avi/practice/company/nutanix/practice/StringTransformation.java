package com.avi.practice.company.nutanix.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * Approach:
 * <p>
 * 1. Add both strings s1 and s2 in helper array
 * <p>
 * 2. Construct Graph
 * <p>
 *      - add edge form a given word to all the words which can be transformed by changing one character only
 * <p>
 * 3. Then do dfs starting from first string to second string and add all the paths which are possible
 *
 * <p>
 * Example
 * s1 = "cat"
 * <p
 * s2 = "pet"
 * <p>
 * helperArray = ["mat", "dol", "col", "cel", "lot", "dot", cet", "dat"] -> helper array is small
 *<p>
 * [cat, mat, dat, dot, dol, col, cel, cet, pet]
 * <p>
 * [cat, cet, pet]
 * <p>
 * [cat, dat, dot, dol, col, cel, cet, pet]
 */
public class StringTransformation {

    public final List<List<String>> convert(final String s1, final String s2, final String[] helperArray) {

        // Add both strings in array and modify the helperArray
        final String[] modifiedHelperArray = new String[helperArray.length + 2];
        modifiedHelperArray[0] = s1;
        modifiedHelperArray[1] = s2;
        for (int i = 2; i < modifiedHelperArray.length; i++) {
            modifiedHelperArray[i] = helperArray[i - 2];
        }
        // Now construct the graph by adding edges for the words which can be transformed by changing by one character only
        final Graph graph = new Graph();
        for (int i = 0; i < modifiedHelperArray.length; i++) {
            for (int j = 0; j < modifiedHelperArray.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isOneCharacterDistance(modifiedHelperArray[i], modifiedHelperArray[j])) {
                    graph.addEdge(modifiedHelperArray[i], modifiedHelperArray[j]);
                }
            }
        }

        // dfs to start from s1 to s2 and print all paths
        final List<List<String>> results = new ArrayList<>(); // result array to keep track of path
        final List<String> currentPath = new ArrayList<>(); // list  to  track current path
        currentPath.add(s1);
        final Set<String> visited = new HashSet<>();
        visited.add(s1);
        dfs(s1, s2, graph, visited, currentPath, results);
        return results;
    }

    private void dfs(
            final String current,
            final String target,
            Graph graph,
            final Set<String> visited,
            final List<String> currentPath,
            final List<List<String>> results) {
        if (current.equals(target)) {
            results.add(new ArrayList<>(currentPath));
            return;
        }
        final Set<String> edges = graph.getEdges(current);
        if (edges != null) {
            for (final String nextHop : edges) {
                if (visited.contains(nextHop)) {
                    continue;
                }
                visited.add(nextHop);
                currentPath.add(nextHop);
                dfs(nextHop, target, graph, visited, currentPath, results);
                currentPath.remove(currentPath.size() - 1);
                visited.remove(nextHop);
            }
        }
    }

    private boolean isOneCharacterDistance(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    private static final class Graph {
        private final Map<String, Set<String>> adjacencyList = new HashMap<>();

        private void addEdge(final String source, final String end) {
            adjacencyList.computeIfAbsent(source, c -> new HashSet<>()).add(end);
        }

        private Set<String> getEdges(final String source) {
            return this.adjacencyList.get(source);
        }
    }

    public static void main(String[] args) {
       final String s1 = "";
       final String s2 = "";
        System.out.println("---" + s1 + s2 + "----");
    }
}
