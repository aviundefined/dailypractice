package com.avi.practice.game.jump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by navinash on 25/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FrogJump {

    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0) {
            return true;
        }

        final Map<Integer, Set<Integer>> jumpsByStones = new HashMap<>();
        for(final int stone : stones) {
            jumpsByStones.put(stone, new HashSet<>());
        }

        jumpsByStones.get(stones[0]).add(1);
        final int lastStone = stones[stones.length - 1];
        for(final int stone : stones) {
            final Set<Integer> jumps = jumpsByStones.get(stone);
            for(final int jump : jumps) {
                final int dst = stone + jump;
                if(dst == lastStone) {
                    return true;
                }
                if(jumpsByStones.containsKey(dst)) {
                    if(jump - 1 > 0) {
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
        if(stones == null || stones.length == 0) {
            return true;
        }
        return false;
    }
}
