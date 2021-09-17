package com.avi.pepcoding.graph.union_find;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by navinash on 17/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
            return Collections.emptyList();
        }

        final Graph graph = new Graph();
        final Map<String, String> nameByEmail = new HashMap<>();
        for(final List<String> account : accounts) {
            final String name = account.get(0);
            if(account.size() >= 1) {
                for(int i = 2; i < account.size(); i++) {
                    graph.addEdge(account.get(1), account.get(i));
                    nameByEmail.put(account.get(i), name);
                }
                nameByEmail.put(account.get(1), name);
            }
        }

        final Set<String> visited = new HashSet<>();
        final List<List<String>> result = new ArrayList<>();
        for(final String email : nameByEmail.keySet()) {
            if(visited.contains(email)) {
                continue;
            }
            final Stack<String> st = new Stack<>();
            st.push(email);
            final Set<String> relatedEmails = new TreeSet<>();
            while(!st.isEmpty()) {
                final String curr = st.pop();
                if(visited.contains(curr)) {
                    continue;
                }
                relatedEmails.add(curr);
                visited.add(curr);
                for(final String nextEmail : graph.getNeighbours(curr)) {
                    if(visited.contains(nextEmail)) {
                        continue;
                    }
                    st.push(nextEmail);
                }
            }
            final List<String> curr = new ArrayList<>();
            curr.add(nameByEmail.get(email));
            curr.addAll(relatedEmails);
            result.add(curr);
        }
        return result;
    }

    private static final class Graph {
        private final Map<String, Set<String>> adjList = new HashMap<>();
        private void addEdge(final String src, final String dst) {
            this.adjList.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
            this.adjList.computeIfAbsent(dst, k -> new HashSet<>()).add(src);

        }

        private Set<String> getNeighbours(final String node) {
            return this.adjList.getOrDefault(node, new HashSet<>());
        }

        public String toString() {
            return adjList.toString();
        }
    }
}
