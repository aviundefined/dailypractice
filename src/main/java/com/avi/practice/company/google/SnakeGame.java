package com.avi.practice.company.google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by navinash on 29/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SnakeGame {

    private final int[][] food;
    private final int width;
    private final int height;
    private final Set<Cell> occupied = new HashSet<>();
    private Deque<Cell> snake = new ArrayDeque<>();
    private int foodIndex = 0;

    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.width = width;
        this.height = height;
        snake.addFirst(new Cell(0, 0));
        occupied.add(new Cell(0, 0));
    }

    public int move(String direction) {
        final Dir dir = Dir.valueOf(direction);
        final Cell currHead = snake.getFirst();
        final Cell newHead = new Cell(currHead.x + dir.x, currHead.y + dir.y);
        if (hasHitWall(newHead)) {
            return -1;
        }
        // add new head
        snake.addFirst(newHead);
        // if food is available to eat
        if (foodIndex < this.food.length) {
            final int[] currFood = food[foodIndex];
            // if there is food at new index then snake will grow
            if (currFood[0] == newHead.x && currFood[1] == newHead.y) {
                foodIndex++;
            } else {
                // if not eaten food then it's tail will be gone
                final Cell tail = snake.removeLast();
                occupied.remove(tail);
            }
        } else {
            // if not eaten food then it's tail will be gone
            final Cell tail = snake.removeLast();
            occupied.remove(tail);
        }

        if (occupied.contains(newHead)) {
            return -1;
        }

        occupied.add(newHead);
        return snake.size() - 1;
    }

    private boolean hasHitWall(final Cell head) {
        if (head.x < 0 || head.y < 0 || head.x >= height || head.y >= width) {
            return true;
        }
        return false;
    }

    private enum Dir {
        U(-1, 0),
        D(1, 0),
        R(0, 1),
        L(0, -1);

        private final int x;
        private final int y;

        Dir(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    private static final class Cell {
        private final int x;
        private final int y;

        private Cell(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }

        public boolean equals(final Object o) {
            if (o == null) {
                return false;
            }
            final Cell c = (Cell) o;
            return c.x == this.x && c.y == this.y;
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}
