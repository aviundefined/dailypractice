package com.avi;

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
 * Created by navinash on 18/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ScratchPad {

    public static void main(String[] args) {
        final String[] username = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        final int[] timestamp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final String[] website = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
        final ScratchPad solve = new ScratchPad();
        final List<String> top = solve.mostVisitedPattern(username, timestamp, website);
        System.out.println(top);
    }

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
        final Map<ThreeSequence, Set<String>> usersBySequence = new HashMap<>();
        int maxUsers = 0;
        List<ThreeSequence> max = new ArrayList<>();
        for (final Map.Entry<String, ArrayList<Tuple>> e : tuplesByUser.entrySet()) {
            final String user = e.getKey();
            final List<Tuple> books = e.getValue();
            for (int i = 0; i < books.size(); i++) {
                for (int j = i + 1; j < books.size(); j++) {
                    for (int k = j + 1; k < books.size(); k++) {
                        final ThreeSequence sequence = new ThreeSequence(books.get(i).book, books.get(j).book, books.get(k).book);
                        final Set<String> users = usersBySequence.computeIfAbsent(sequence, sq -> new HashSet<>());
                        users.add((user));
                        if (users.size() >= maxUsers) {
                            max.add(sequence);
                            maxUsers = users.size();
                        }
                    }
                }
            }
        }

        if (max.size() == 0) {
            return Collections.emptyList();
        }
        Collections.sort(max);
        final List<String> top = new ArrayList<>();
        top.add(max.get(0).book1);
        top.add(max.get(0).book2);
        top.add(max.get(0).book3);
        return top;
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

    private static final class ThreeSequence implements Comparable<ThreeSequence> {
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

        @Override
        public int compareTo(ThreeSequence o) {
            if (!this.book1.equals(o.book1)) {
                return this.book1.compareTo(o.book1);
            }
            if (!this.book2.equals(o.book2)) {
                return this.book2.compareTo(o.book2);
            }
            return this.book3.compareTo(o.book3);
        }
    }
}
