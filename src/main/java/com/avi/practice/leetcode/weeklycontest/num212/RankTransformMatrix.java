package com.avi.practice.leetcode.weeklycontest.num212;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by navinash on 02/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * Given an m x n matrix, return a new matrix answer where answer[row][col] is the rank of matrix[row][col].
 * <p>
 * The rank is an integer that represents how large an element is compared to other elements. It is calculated using the following rules:
 * <p>
 * The rank is an integer starting from 1.
 * If two elements p and q are in the same row or column, then:
 * If p < q then rank(p) < rank(q)
 * If p == q then rank(p) == rank(q)
 * If p > q then rank(p) > rank(q)
 * The rank should be as small as possible.
 * It is guaranteed that answer is unique under the given rules.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[1,2],[3,4]]
 * Output: [[1,2],[2,3]]
 * Explanation:
 * The rank of matrix[0][0] is 1 because it is the smallest integer in its row and column.
 * The rank of matrix[0][1] is 2 because matrix[0][1] > matrix[0][0] and matrix[0][0] is rank 1.
 * The rank of matrix[1][0] is 2 because matrix[1][0] > matrix[0][0] and matrix[0][0] is rank 1.
 * The rank of matrix[1][1] is 3 because matrix[1][1] > matrix[0][1], matrix[1][1] > matrix[1][0], and both matrix[0][1] and matrix[1][0] are rank 2.
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[7,7],[7,7]]
 * Output: [[1,1],[1,1]]
 * Example 3:
 * <p>
 * <p>
 * Input: matrix = [[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]
 * Output: [[4,2,3],[1,3,4],[5,1,6],[1,3,4]]
 * Example 4:
 * <p>
 * <p>
 * Input: matrix = [[7,3,6],[1,4,5],[9,8,2]]
 * Output: [[5,1,4],[1,2,3],[6,3,1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 500
 * -109 <= matrix[row][col] <= 10^9
 */
public class RankTransformMatrix {

    public int[][] matrixRankTransform(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        final Cell[] cells = new Cell[n * m];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cells[idx] = new Cell(matrix[i][j], i, j);
                idx++;
            }
        }
        // Sort cells array
        Arrays.sort(cells, Comparator.comparingInt(o -> o.value));
        // Meta-data to maintain row and col max
        final Map<Integer, RankValue> rowMax = new HashMap<>(n);
        final Map<Integer, RankValue> colMax = new HashMap<>(m);

        final int[][] ranks = new int[n][m];
        for (final Cell cell : cells) {
            final RankValue currRowMax = rowMax.computeIfAbsent(cell.row, k -> new RankValue(Integer.MIN_VALUE, 0));
            final RankValue currColMax = colMax.computeIfAbsent(cell.col, k -> new RankValue(Integer.MIN_VALUE, 0));

            final int rowRank;
            if (currRowMax.value == cell.value) {
                rowRank = currRowMax.rank;
            } else {
                rowRank = currRowMax.rank + 1;
            }

            final int colRank;
            if (currColMax.value == cell.value) {
                colRank = currColMax.rank;
            } else {
                colRank = currColMax.rank + 1;
            }
            final int rank = Math.max(rowRank, colRank);
            ranks[cell.row][cell.col] = rank;
            rowMax.put(cell.row, new RankValue(cell.value, rank));
            colMax.put(cell.col, new RankValue(cell.value, rank));
        }
        return ranks;
    }

    private static final class Cell {
        private final int value;
        private final int row;
        private final int col;

        public Cell(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return value == cell.value &&
                    row == cell.row &&
                    col == cell.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, row, col);
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "value=" + value +
                    ", row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    private static class RankValue {
        private final int value;
        private final int rank;

        public RankValue(int value, int rank) {
            this.value = value;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "RankValue{" +
                    "value=" + value +
                    ", rank=" + rank +
                    '}';
        }
    }
}
