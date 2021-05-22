package com.avi.practice.leetcode.problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by navinash on 21/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TicTacToe {

    private final String[][] board;
    private final int length;
    private final Map<Key, Integer> movesCount = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        this.length = n;
        this.board = new String[n][n];
        for (final String[] row : board) {
            Arrays.fill(row, "");
        }
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        this.board[row][col] = MOVE.move(player).value;
        final boolean isGameOver = checkIfGameOver(row, col, player);
        if (isGameOver) {
            return player;
        }
        return 0;
    }


    private boolean checkIfGameOver(final int row, final int col, final int player) {
        // now update relevant states
        // update row
        final int movesInRow = this.movesCount.compute(new Key(player, TYPE.ROW, row), (k, v) -> {
            if (v == null) {
                return 1;
            }
            return v + 1;
        });
        if (movesInRow == this.length) {
            return true;
        }
        // update column
        final int movesInCol = this.movesCount.compute(new Key(player, TYPE.COL, col), (k, v) -> {
            if (v == null) {
                return 1;
            }
            return v + 1;
        });
        if (movesInCol == this.length) {
            return true;
        }
        // update left diagonal is applicable
        if (row == col) {
            final int movesInLeftDiagonal = this.movesCount.compute(new Key(player, TYPE.DIAGONAL, 1), (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
            if (movesInLeftDiagonal == this.length) {
                return true;
            }
        }
        // update right diagonal is applicable
        if (row + col == this.length - 1) {
            final int movesInRightDiagonal = this.movesCount.compute(new Key(player, TYPE.DIAGONAL, 2), (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
            if (movesInRightDiagonal == this.length) {
                return true;
            }
        }
        return false;
    }

    private boolean gameFinished(final int player) {
        return false;
    }

    private enum TYPE {
        ROW,
        COL,
        DIAGONAL
    }

    private enum MOVE {
        X(1, "X"),
        O(2, "O");

        private final int player;
        private final String value;

        MOVE(int player, String value) {
            this.player = player;
            this.value = value;
        }

        private static MOVE move(final int player) {
            for (final MOVE move : MOVE.values()) {
                if (move.player == player) {
                    return move;
                }
            }
            throw new IllegalArgumentException("Invalid playerId: " + player);
        }
    }

    private final static class Key {
        private final int player;
        private final TYPE type;
        private final int id;

        private Key(int player, TYPE type, int id) {
            this.player = player;
            this.type = type;
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return player == key.player &&
                    id == key.id &&
                    type == key.type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(player, type, id);
        }
    }
}
