package com.avi.practice.game.jump;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by navinash on 27/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class OddEvenJump {

    public int oddEvenJumps(int[] arr) {
        return oddEvenJumps_TreeMap(arr);
    }

    private int oddEvenJumps_TreeMap(final int[] arr) {
        if (arr == null || arr.length == 0) {

            return 0;
        }
        final int n = arr.length;
        if (n == 1) {
            return 1;
        }

        final TreeMap<Integer, Integer> indexes = new TreeMap<>();
        indexes.put(arr[n - 1], n - 1);
        final boolean[] odd = new boolean[n];
        final boolean[] even = new boolean[n];
        odd[n - 1] = true;
        even[n - 1] = true;
        int result = 1;
        for (int i = n - 2; i >= 0; i--) {
            final Map.Entry<Integer, Integer> oddJump = indexes.ceilingEntry(arr[i]);
            final Map.Entry<Integer, Integer> evnJump = indexes.floorEntry(arr[i]);
            if (oddJump != null) {
                // if can take a odd jump from this index
                odd[i] = even[oddJump.getValue()];
            }
            if (evnJump != null) {
                even[i] = odd[evnJump.getValue()];
            }
            if (odd[i]) {
                result++;
            }
            indexes.put(arr[i], i);
        }
        return result;
    }


    private int oddEvenJumps_Stack(final int[] arr) {
        if (arr == null || arr.length == 0) {

            return 0;
        }
        final int n = arr.length;
        if (n == 1) {
            return 1;
        }
        final int[] odd = reachableIndexes(arr, true);
        final int[] even = reachableIndexes(arr, false);

        final boolean[] oddJumps = new boolean[n];
        final boolean[] evenJumps = new boolean[n];
        oddJumps[n - 1] = true;
        evenJumps[n - 1] = true;
        int result = 1;
        for (int i = n - 2; i >= 0; i--) {
            oddJumps[i] = odd[i] != -1 && evenJumps[odd[i]];
            evenJumps[i] = even[i] != -1 && oddJumps[even[i]];
            if (oddJumps[i]) {
                result++;
            }
        }
        return result;
    }


    private int[] reachableIndexes(int[] arr, boolean isOdd) {
        Integer[] indexes = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) indexes[i] = i;
        if (isOdd) {
            Arrays.sort(indexes, (i, j) -> arr[i] == arr[j] ? i - j : arr[i] - arr[j]);
        }
        else {
            Arrays.sort(indexes, (i, j) -> arr[i] == arr[j] ? i - j : arr[j] - arr[i]);
        }


        final int[] result = new int[arr.length];
        Arrays.fill(result, arr.length);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && indexes[i] > stack.peek()) {
                result[stack.pop()] = indexes[i];
            }
            stack.push(indexes[i]);
        }

        return result;
    }
}
