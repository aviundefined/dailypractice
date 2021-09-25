package com.avi.practice.company.google;

import java.util.Arrays;

/**
 * Created by navinash on 25/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RangeSumQuery2D {

    public static class NumMatrix {

        private final int[][] matrix;
        private final SegmentTree[] segmentTreesByRow;
        private final int rows;
        private final int cols;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            this.rows = matrix.length;
            this.cols = matrix[0].length;
            this.segmentTreesByRow = new SegmentTree[rows];
            for (int i = 0; i < rows; i++) {
                this.segmentTreesByRow[i] = new SegmentTree(this.matrix[i]);
            }
            print();
        }

        public final void update(int row, int col, int val) {
            if (isInValid(row, col)) {
                return;
            }

            this.segmentTreesByRow[row].update(col, val);
            print();
        }

        public final int sumRegion(int row1, int col1, int row2, int col2) {
            if (isInValid(row1, col1) || isInValid(row2, col2)) {
                return 0;
            }
            int sum = 0;
            for (int i = row1; i <= row2 && i < rows; i++) {
                sum += this.segmentTreesByRow[i].rangeQuery(col1, col2);
            }
            return sum;
        }

        private boolean isInValid(int row, int col) {
            return row < 0 || col < 0 || row >= rows || col >= cols;
        }

        private void print() {
            System.out.println("-----------------------------");
            for(final int[] rows : matrix) {
                System.out.println(Arrays.toString(rows));
            }
        }
    }

    public static final class SegmentTree {
        private final int[] arr;
        private final int[] st;
        private final int n;

        public SegmentTree(final int[] arr) {
            this.arr = arr;
            this.n = arr.length;
            this.st = new int[4 * n];
            build(0, n - 1, 0);
        }

        public final void build(int left, int right, int segmentIndex) {
            if (left == right) {
                this.st[segmentIndex] = this.arr[left];
                return;
            }
            final int mid = left + (right - left) / 2;
            build(left, mid, 2 * segmentIndex + 1);
            build(mid + 1, right, 2 * segmentIndex + 2);
            st[segmentIndex] = st[2 * segmentIndex + 1] + st[2 * segmentIndex + 2];
        }

        public final void update(final int index, final int value) {
            _update(0, n - 1, 0, index, value);
        }

        public int rangeQuery(final int left, final int right) {
            return _getRangeSum(0, n - 1, 0, left, right);
        }

        private int _getRangeSum(int left, int right, int segmentIndex, int qLeft, int qRight) {
            // complete overlap
            if (qLeft <= left && right <= qRight) {
                return st[segmentIndex];
            }
            // no overlap
            if (qLeft > right || qRight < left) {
                return 0;
            }

            final int mid = left + (right - left) / 2;
            return _getRangeSum(left, mid, 2 * segmentIndex + 1, qLeft, qRight) + _getRangeSum(mid + 1, right, 2 * segmentIndex + 2, qLeft, qRight);
        }

        private void _update(int left, int right, int segmentIndex, int index, int value) {
            if (left == right) {
                this.arr[index] = value;
                this.st[segmentIndex] = value;
                return;
            }
            final int mid = left + (right - left) / 2;
            if (index <= mid) {
                _update(left, mid, 2 * segmentIndex + 1, index, value);
            } else {
                _update(mid + 1, right, 2 * segmentIndex + 2, index, value);
            }
            st[segmentIndex] = st[2 * segmentIndex + 1] + st[2 * segmentIndex + 2];
        }
    }
}
