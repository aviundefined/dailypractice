package com.avi.practice.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by navinash on 19/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AnalyzeUserWebsiteVisitPattern {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        if (username == null || timestamp == null || website == null || username.length != timestamp.length || timestamp.length != website.length) {
            return Collections.emptyList();
        }
        final Tuple[] tuples = new Tuple[username.length];
        final Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < tuples.length; i++) {
            tuples[i] = new Tuple(username[i], timestamp[i], website[i]);
            counts.compute(username[i], (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
        }
        // sort first on user then , timestamps, in this way all
        Arrays.sort(tuples);
        final Map<String, ArrayList<Tuple>> tuplesByUser = new HashMap<>();
        for (final Tuple tuple : tuples) {
            if (counts.get(tuple.user) < 2) {
                continue;
            }
            tuplesByUser.computeIfAbsent(tuple.user, k -> new ArrayList<>()).add(tuple);
        }
//        for (final Map.Entry<String, ArrayList<Tuple>> e : tuplesByUser.entrySet()) {
//            System.out.printf(" ---- %s -----\n", e.getKey());
//            System.out.println(e.getValue());
//        }
        final Map<ThreeSequence, Set<String>> usersBySeqeunce = new HashMap<>();
        int maxUsers = 0;
        List<ThreeSequence> max = new ArrayList<>();
        for (final Map.Entry<String, ArrayList<Tuple>> e : tuplesByUser.entrySet()) {
            final String user = e.getKey();
            final List<Tuple> books = e.getValue();
            for (int i = 0; i < books.size(); i++) {
                for (int j = i + 1; j < books.size(); j++) {
                    for (int k = j + 1; k < books.size(); k++) {
                        final ThreeSequence sequence = new ThreeSequence(books.get(i).book, books.get(j).book, books.get(k).book);
                        usersBySeqeunce.computeIfAbsent(sequence, sq -> new HashSet<>()).add(user);

                    }
                }
            }
        }

        final List<ThreeSequence> candidates = new ArrayList<>();
        int maxNumUsers = 0;
        for (final Map.Entry<ThreeSequence, Set<String>> e : usersBySeqeunce.entrySet()) {
            if (e.getValue().size() >= maxNumUsers) {
                if (e.getValue().size() > maxNumUsers) {
                    candidates.clear();
                }
                candidates.add(e.getKey());
                maxNumUsers = e.getValue().size();
            }
        }
        if (candidates.size() == 0) {
            return Collections.emptyList();
        }

        candidates.sort((o1, o2) -> {
            if (!o1.book1.equals(o2.book1)) {
                return o1.book1.compareTo(o2.book1);
            }
            if (!o1.book2.equals(o2.book2)) {
                return o1.book2.compareTo(o2.book2);
            }
            return o1.book3.compareTo(o2.book3);
        });

        final List<String> result = new ArrayList<>();
        result.add(candidates.get(0).book1);
        result.add(candidates.get(0).book2);
        result.add(candidates.get(0).book3);
        return result;
    }

    private static final class Tuple implements Comparable<Tuple> {
        private final String user;
        private final int ts;
        private final String book;

        private Tuple(final String user, final int ts, final String book) {
            this.user = user;
            this.ts = ts;
            this.book = book;
        }

        @Override
        public int compareTo(Tuple o) {
            if (!this.user.equals(o.user)) {
                return this.user.compareTo(o.user);
            }
            if (this.ts != o.ts) {
                return this.ts - o.ts;
            }
            return this.book.compareTo(o.book);
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "user='" + user + '\'' +
                    ", ts=" + ts +
                    ", book='" + book + '\'' +
                    '}';
        }
    }

    private static final class ThreeSequence {
        private final String book1;
        private final String book2;
        private final String book3;

        private ThreeSequence(String book1, String book2, String book3) {
            this.book1 = book1;
            this.book2 = book2;
            this.book3 = book3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ThreeSequence that = (ThreeSequence) o;
            return Objects.equals(book1, that.book1) &&
                    Objects.equals(book2, that.book2) &&
                    Objects.equals(book3, that.book3);
        }

        @Override
        public int hashCode() {
            return Objects.hash(book1, book2, book3);
        }
    }
}
