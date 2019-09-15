package com.avi.practice.arrays;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by navinash on 14/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
class ArrayPractice {

    static final int FOUND = 1;
    static final int NOT_FOUND = -1;

    /**
     * Input:
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ],
     * [ 10, 11, 12 ]
     * Output:
     * [1, 2, 3, 6, 5, 4, 7, 8, 9, 12, 11, 10]
     */
    final int[] zigZagOrder(final int[][] A) {
        final int row = A.length;
        final int col = A[0].length;
        final int[] zigZag = new int[row * col];
        int k = 0;
        for (int i = 0; i < row; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < col; j++) {
                    zigZag[k] = A[i][j];
                    k++;
                }
            } else {
                for (int j = col - 1; j >= 0; j--) {
                    zigZag[k] = A[i][j];
                    k++;
                }
            }
        }
        return zigZag;
    }

    /**
     * Input:
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * output:
     * [1, 2, 3, 6, 9, 8, 7, 4, 5]
     */
    final int[] spiralOrder(final int[][] A) {
        final int row = A.length;
        final int col = A[0].length;
        final int[] spiral = new int[row * col];
        int k = 0;
        int level = 0;
        int rowIndex = row - 1;
        int colIndex = col - 1;
        while (k < spiral.length) {
            for (int i = level; i <= colIndex - level; i++) {
                spiral[k] = A[level][i];
                k++;
            }

            if (k < spiral.length) {
                for (int i = level + 1; i <= rowIndex - 1 - level; i++) {
                    spiral[k] = A[i][colIndex - level];
                    k++;
                }
            }

            if (k < spiral.length) {
                for (int i = colIndex - level; i >= level; i--) {
                    spiral[k] = A[row - 1 - level][i];
                    k++;
                }
            }

            if (k < spiral.length) {
                for (int i = rowIndex - 1 - level; i >= level + 1; i--) {
                    spiral[k] = A[i][level];
                    k++;
                }
            }
            level++;
        }

        return spiral;
    }

    /**
     * Input:
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * output:
     * [1, 2, 3, 6, 9, 8, 7, 4, 5]
     */
    final int[] spiralOrderApproach2(final int[][] A) {
        final int R = 0;
        final int D = 1;
        final int L = 2;
        final int U = 3;
        final int row = A.length;
        final int col = A[0].length;
        final int[] spiral = new int[row * col];

        int t = 0, b = row - 1, l = 0, r = col - 1;
        int dir = 0;
        int k = 0;
        while (t <= b && l <= r) {
            if (dir == R) {
                for (int i = l; i <= r; i++) {
                    spiral[k++] = A[t][i];
                }
                t++;
                dir = D;
            } else if (dir == D) {
                for (int i = t; i <= b; i++) {
                    spiral[k++] = A[i][r];
                }
                r--;
                dir = L;
            } else if (dir == L) {
                for (int i = r; i >= l; i--) {
                    spiral[k++] = A[b][i];
                }
                b--;
                dir = U;
            } else //noinspection ConstantConditions
                if (dir == U) {
                    for (int i = b; i >= t; i--) {
                        spiral[k++] = A[i][l];
                    }
                    l++;
                    dir = R;
                }
        }
        return spiral;
    }


    //    (x+1, y),
    //    (x - 1, y),
    //    (x, y+1),
    //    (x, y-1),
    //    (x-1, y-1),
    //    (x+1,y+1),
    //    (x-1,y+1),
    //    (x+1,y-1)
    final int coverPoints(int[] A, int[] B) {
        if (A.length != B.length) {
            throw new IllegalArgumentException(String.format("Invalid input: Length of both array should be equal. Length of A : [%d], Length of B : [%d]", A.length, B.length));
        }
        // A is X coordinate of i th point
        // B is Y coordinate of i th point
        int min = 0;
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            final int x = Math.abs(A[i] - A[i + 1]);
            final int y = Math.abs(B[i] - B[i + 1]);
            min = min + Math.max(x, y);
        }
        return min;
    }

    final void printArr(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");

            }
        }
        System.out.println();
    }

    final void printArr(final Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");

            }
        }
        System.out.println();
    }

    final boolean isEmpty(Object[] intervals) {
        return intervals == null || intervals.length == 0;
    }


    final int maxSpecialProduct(int[] A) {
        final int n = A.length;
        long max = 0L;
        for (int i = 1; i <= n - 2; i++) {
            int rightSplValIdx = Integer.MAX_VALUE;
            int leftSplValIdx = Integer.MIN_VALUE;
            // i > j
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] > A[i]) {
                    leftSplValIdx = j;
                    break;
                }
            }
            // j > i
            for (int j = i + 1; j <= n - 1; j++) {
                if (A[j] > A[i]) {
                    rightSplValIdx = j;
                    break;
                }
            }
            if (rightSplValIdx != Integer.MAX_VALUE && leftSplValIdx != Integer.MIN_VALUE) {
                max = Math.max(rightSplValIdx * leftSplValIdx, max);
            }
        }
        return (int) (max % 1000000007);
    }

    final int maxSpecialProductStack(final int[] A) {
        int[] left = getLeftSpecialValue(A);
        int[] right = getRightSpecialValue(A);
        long max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Long.max(max, (long) left[i] * right[i]);
        }
        return (int) (max % 1000000007);
    }

    private int[] getLeftSpecialValue(final int[] a) {
        final int n = a.length;
        final int[] leftSplVals = new int[n];
        final Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        leftSplVals[0] = 0;
        for (int i = 1; i <= n - 1; i++) {
            while (!q.isEmpty()) {
                // if on top of stack found value greater than a[i] then max j found for which a[j] > a[i]
                if (a[q.getLast()] > a[i]) {
                    break;
                }
                // else remove that index
                q.removeLast();
            }
            leftSplVals[i] = q.isEmpty() ? 0 : q.getLast();
            q.addLast(i);
        }
        return leftSplVals;
    }

    private int[] getRightSpecialValue(final int[] a) {
        final int n = a.length;
        final int[] rightSplVals = new int[n];
        final Deque<Integer> q = new ArrayDeque<>();
        q.add(n - 1);
        rightSplVals[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            while (!q.isEmpty()) {
                // if on top of stack found greater than a[i] then min index found for which a[j] > a[i]
                if (a[q.getLast()] > a[i]) {
                    break;
                }
                q.removeLast();
            }
            rightSplVals[i] = q.isEmpty() ? 0 : q.getLast();
            q.addLast(i);
        }
        return rightSplVals;
    }

    final int nobleInteger(int[] A) {
        Arrays.sort(A);
        final int n = A.length;
        // Base case, if last entry after the sorting is 0 then already FOUND
        if (A[n - 1] == 0) {
            return FOUND;
        }
        // Index i -> Number of integer greater than a[i]
        final Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(n - 1, 0);
        int lastDuplicate = 0;
        for (int i = n - 2; i >= 0; i--) {
            final int last = map.get(i + 1);
            if (A[i] == A[i + 1]) {
                map.put(i, last);
                lastDuplicate++;
            } else {
                map.put(i, last + 1 + lastDuplicate);
                lastDuplicate = 0;
            }
            if (map.get(i) == A[i]) {
                return FOUND;
            }
        }
        return NOT_FOUND;
    }

    final int nobleIntegerApproach2(int[] A) {
        Arrays.sort(A);
        final int n = A.length;
        for (int i = 0; i <= n - 1; i++) {
            // Handle duplicates
            if (i < n - 1 && A[i] == A[i + 1]) {
                continue;
            }
            if (A[i] == n - 1 - i) {
                return FOUND;
            }
        }
        return NOT_FOUND;
    }

    final List<List<Integer>> performOps(List<List<Integer>> A) {
        final List<List<Integer>> B = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }

    enum Action {
        GT,
        LT
    }

    final int[] wave(int[] A) {
        final int n = A.length;
        Arrays.sort(A);
        Action action = Action.GT;
        for (int i = 1; i <= n - 1; i++) {
            if (action == Action.GT) {
                if (A[i - 1] < A[i]) {
                    final int tmp = A[i];
                    A[i] = A[i - 1];
                    A[i - 1] = tmp;
                }
                action = Action.LT;
            } else //noinspection ConstantConditions
                if (action == Action.LT) {
                    if (A[i - 1] > A[i]) {
                        final int tmp = A[i];
                        A[i] = A[i - 1];
                        A[i - 1] = tmp;
                    }
                    action = Action.GT;
                }
        }
        return A;
    }

    final int[] waveApproach2(int[] a) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i = i + 2) {
            int temp = a[i];
            a[i] = a[i + 1];
            a[i + 1] = temp;
        }
        return a;
    }

    final List<Interval> insertIntoNonOverlappingIntervals(final List<Interval> intervals, final Interval newInterval) {
        final List<Interval> copyIntervals = new ArrayList<>(intervals);
        copyIntervals.add(newInterval);
        final int n = copyIntervals.size();
        final Interval[] merged = getMergedNonOverlappingIntervals(copyIntervals.toArray(new Interval[n]));
        if (isEmpty(merged)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(merged));
    }

    final List<Interval> insertIntoNonOverlappingIntervalsApproach2(List<Interval> intervals, Interval newInterval) {
        //noinspection UnnecessaryLocalVariable
        final Interval current = newInterval;
        int i = 0;
        while (i < intervals.size()) {
            Interval in = intervals.get(i);
            if (in.end < current.start) {
                i++;
            } else if (in.start > current.end) {
                intervals.add(i, current);
                break;
            } else {
                current.start = Math.min(in.start, current.start);
                current.end = Math.max(in.end, current.end);
                intervals.remove(i);
            }
        }
        if (i == intervals.size()) {
            intervals.add(current);
        }
        return intervals;
    }

    final Interval[] getMergedNonOverlappingIntervals(final Interval[] intervals) {
        if (isEmpty(intervals) || intervals.length == 1) {
            return intervals;
        }
        final int n = intervals.length;
        // sort the array first
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        // after sorting on start of interval, there can be only two cases
        //   1) second interval is non overlapping with first one i.e first.end < second.start: simply push in stack
        //   2) second interval is overlapping with first one i.e first.end < second.end, then update end of stack top element
        final Stack<Interval> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 1; i <= n - 1; i++) {
            final Interval top = stack.peek();
            // current interval doesn't overlap with top of the stack, so simply push it
            final Interval curr = intervals[i];
            if (top.end < curr.start) {
                stack.push(curr);
            } else if (top.end < curr.end) {
                top.end = curr.end;
            }
        }

        int i = stack.size() - 1;
        final Interval[] nonOverlappingIntervals = new Interval[stack.size()];
        while (!stack.isEmpty()) {
            nonOverlappingIntervals[i] = stack.pop();
            i--;
        }
        return nonOverlappingIntervals;
    }

    static final class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(final int s, final int e) {
            start = s;
            end = e;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return start == interval.start &&
                    end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return "(" + start + "," + end + ")";
        }
    }
}
