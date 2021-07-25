package com.avi.practice.game.jump;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * Created by navinash on 25/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FrogJump {

    public boolean dp(int[] stones) {
        if (stones == null || stones.length == 0) {
            return true;
        }

        final Map<Integer, Set<Integer>> jumpsByStones = new HashMap<>();
        for (final int stone : stones) {
            jumpsByStones.put(stone, new HashSet<>());
        }

        jumpsByStones.get(stones[0]).add(1);
        final int lastStone = stones[stones.length - 1];
        for (final int stone : stones) {
            final Set<Integer> jumps = jumpsByStones.get(stone);
            for (final int jump : jumps) {
                final int dst = stone + jump;
                if (dst == lastStone) {
                    return true;
                }
                if (jumpsByStones.containsKey(dst)) {
                    if (jump - 1 > 0) {
                        jumpsByStones.get(dst).add(jump - 1);
                    }
                    jumpsByStones.get(dst).add(jump);
                    jumpsByStones.get(dst).add(jump + 1);
                }
            }
        }
        return false;
    }

    public boolean bfs(final int[] stones) {
        if (stones == null || stones.length == 0) {
            return true;
        }
        final Set<Integer> dict = new HashSet<>();
        for (final int stone : stones) {
            dict.add(stone);
        }
        final int lastStone = stones[stones.length - 1];
        final Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, 1));
        final Set<Pair> visited = new HashSet<>();
        while (!q.isEmpty()) {
            // remove mark* work add*
            final Pair curr = q.poll();
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            if (curr.stone == lastStone) {
                return true;
            }
            final int next = curr.stone + curr.jump;
            if (dict.contains(next)) {
                if (curr.jump - 1 > 0) {
                    final Pair jumpMinusOne = new Pair(next, curr.jump - 1);
                    if (!visited.contains(jumpMinusOne)) {
                        q.offer(jumpMinusOne);
                    }
                }
                final Pair jump = new Pair(next, curr.jump);
                if (!visited.contains(jump)) {
                    q.offer(jump);
                }
                final Pair jumpPlusOne = new Pair(next, curr.jump + 1);
                if (!visited.contains(jumpPlusOne)) {
                    q.offer(jumpPlusOne);
                }
            }
        }
        return false;
    }

    private static final class Pair {
        private final int stone;
        private final int jump;

        public Pair(int stone, int jump) {
            this.stone = stone;
            this.jump = jump;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return stone == pair.stone &&
                    jump == pair.jump;
        }

        @Override
        public int hashCode() {
            return Objects.hash(stone, jump);
        }
    }
}
