package com.avi.practice.leetcode.weeklycontest.num158;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class QueenThatCanAttackKing {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        if (queens == null || queens.length == 0 || queens[0].length == 0) {
            return Collections.emptyList();
        }
        final Set<ChessBlock> queenBlocks = new LinkedHashSet<>();
        for (final int[] queen : queens) {
            queenBlocks.add(new ChessBlock(queen[0], queen[1]));
        }
        final ChessBlock kingBlock = new ChessBlock(king[0], king[1]);
        final List<List<Integer>> results = new ArrayList<>();
        // explore right direction from king
        for (int j = kingBlock.col; j < 8; j++) {
            final ChessBlock block = new ChessBlock(kingBlock.row, j);
            if (queenBlocks.contains(block)) {
                final List<Integer> r = new ArrayList<>();
                r.add(block.row);
                r.add(block.col);
                results.add(r);
                break;
            }
        }
        // explore left direction from king
        for (int j = kingBlock.col; j >= 0; j--) {
            final ChessBlock block = new ChessBlock(kingBlock.row, j);
            if (queenBlocks.contains(block)) {
                final List<Integer> r = new ArrayList<>();
                r.add(block.row);
                r.add(block.col);
                results.add(r);
                break;
            }
        }
        // explore down direction from king
        for (int i = kingBlock.row; i < 8; i++) {
            final ChessBlock block = new ChessBlock(i, kingBlock.col);
            if (queenBlocks.contains(block)) {
                final List<Integer> r = new ArrayList<>();
                r.add(block.row);
                r.add(block.col);
                results.add(r);
                break;
            }
        }
        // explore up direction from king
        for (int i = kingBlock.row; i >= 0; i--) {
            final ChessBlock block = new ChessBlock(i, kingBlock.col);
            if (queenBlocks.contains(block)) {
                final List<Integer> r = new ArrayList<>();
                r.add(block.row);
                r.add(block.col);
                results.add(r);
                break;
            }
        }
        // explore right , up from king
        for (int i = kingBlock.row, j = kingBlock.col; i >= 0 && j < 8; i--, j++) {
            final ChessBlock block = new ChessBlock(i, j);
            if (queenBlocks.contains(block)) {
                final List<Integer> r = new ArrayList<>();
                r.add(block.row);
                r.add(block.col);
                results.add(r);
                break;
            }
        }
        // explore right , down from king
        for (int i = kingBlock.row, j = kingBlock.col; i < 8 && j < 8; i++, j++) {
            final ChessBlock block = new ChessBlock(i, j);
            if (queenBlocks.contains(block)) {
                final List<Integer> r = new ArrayList<>();
                r.add(block.row);
                r.add(block.col);
                results.add(r);
                break;
            }
        }
        // explore left , up from king
        for (int i = kingBlock.row, j = kingBlock.col; i >= 0 && j >= 0; i--, j--) {
            final ChessBlock block = new ChessBlock(i, j);
            if (queenBlocks.contains(block)) {
                final List<Integer> r = new ArrayList<>();
                r.add(block.row);
                r.add(block.col);
                results.add(r);
                break;
            }
        }
        // explore left , down from king
        for (int i = kingBlock.row, j = kingBlock.col; i < 8 && j >= 0; i++, j--) {
            final ChessBlock block = new ChessBlock(i, j);
            if (queenBlocks.contains(block)) {
                final List<Integer> r = new ArrayList<>();
                r.add(block.row);
                r.add(block.col);
                results.add(r);
                break;
            }
        }
        return results;
    }

    private static class ChessBlock {
        private final int row;
        private final int col;

        private ChessBlock(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ChessBlock that = (ChessBlock) o;
            return row == that.row &&
                    col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "[" + row + ", " + col + "]";
        }
    }
}
