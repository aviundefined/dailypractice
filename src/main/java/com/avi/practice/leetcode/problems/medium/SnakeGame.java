package com.avi.practice.leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by navinash on 29/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SnakeGame {

    private final int width;
    private final int height;
    private final Deque<Cell> snake = new ArrayDeque<>();
    private final Map<Integer, Cell> food = new HashMap<>();
    private final Set<Cell> used = new HashSet<>();
    private int score = 0;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        final Cell start = new Cell(0, 0);
        snake.push(start);
        used.add(start);
        for (int i = 0; i < food.length; i++) {
            final int[] coordinate = food[i];
            this.food.put(i, new Cell(coordinate[0], coordinate[1]));
        }
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        final Direction dir = Direction.direction(direction);
        final Cell peek = snake.peekFirst();
        final Cell newHead;
        switch (dir) {
            case UP:
                newHead = new Cell(peek.row - 1, peek.column);
                break;
            case DOWN:
                newHead = new Cell(peek.row + 1, peek.column);
                break;
            case LEFT:
                newHead = new Cell(peek.row, peek.column - 1);
                break;
            case RIGHT:
                newHead = new Cell(peek.row, peek.column + 1);
                break;
            default:
                throw new IllegalArgumentException("Invalid direction:" + dir);
        }

        // if new head is out of bound - game over
        if (newHead.row < 0 || newHead.row >= height || newHead.column < 0 || newHead.column >= width) {
            return -1;
        }
        final Cell foodCell = food.getOrDefault(score, null);
        if (newHead.equals(foodCell)) { // if food is present on new head -> remove from food and increase snake length;
            score++;
        } else { // food is not present on snake new head, remove snake tail and remove from used
            final Cell cell = snake.pollLast();
            used.remove(cell);
        }
        // if new head is used - game over
        if (used.contains(newHead)) {
            return -1;
        }
        // add new head in used
        used.add(newHead);
        snake.addFirst(newHead);
        return score;
    }

    private enum Direction {
        UP("U"),
        DOWN("D"),
        LEFT("L"),
        RIGHT("R");
        private final String direction;

        Direction(String direction) {
            this.direction = direction;
        }

        private static Direction direction(final String value) {
            for (final Direction direction : Direction.values()) {
                if (direction.direction.equals(value.toUpperCase())) {
                    return direction;
                }
            }
            throw new IllegalArgumentException("Please provide valid value: " + value);
        }
    }

    private static final class Cell {
        private final int row;
        private final int column;

        private Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return row == cell.row &&
                    column == cell.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }
}
