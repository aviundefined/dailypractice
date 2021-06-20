package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by navinash on 20/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        if (nums.length == 1) {
            return Collections.singletonList(0);
        }
        // copy arr
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        Arrays.sort(copy);
        int counter = 1;
        final Map<Integer, Integer> newValueByValue = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            if (!newValueByValue.containsKey(copy[i])) {
                newValueByValue.put(copy[i], counter);
                counter++;
            }
        }

        copy = new int[nums.length + 1];
        copy[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            copy[i + 1] = newValueByValue.get(nums[i]);
        }

        final int[] result = new int[nums.length];
        final int[] fenwickArr = new int[counter];
        for (int i = copy.length - 1; i >= 1; i--) {
            final int value = query(fenwickArr, copy[i]);
            result[i - 1] = value;
            update(fenwickArr, copy[i]);
        }
        final List<Integer> out = new ArrayList<>();
        for (final int a : result) {
            out.add(a);
        }
        return out;
    }

    private int query(final int[] arr, final int value) {
        // since we are interested in values less than value so start will be value - 1
        int valuesLessThanValue = 0;
        for (int i = value - 1; i > 0; i = i - (i & -i)) {
            valuesLessThanValue += (arr[i]);
        }
        return valuesLessThanValue;
    }

    private void update(final int[] arr, final int value) {
        // value is fenwick index as arr is already 1-based index so just update the value
        for (int i = value; i < arr.length; i = i + (i & -i)) {
            arr[i]++;
        }
    }

    static final class FenwickTree {
        final int[] fenwickArr;

        FenwickTree(final int[] arr) {
            this.fenwickArr = new int[arr.length + 1];
            this.fenwickArr[0] = 0; // 1 - based indexing so just adding 0 at 0th index
            // now ith index of arr will be fenwick arr i + 1;
            for (int i = 0; i < arr.length; i++) {
                update(i, arr[i]);
            }
        }

        final void print() {
            System.out.println(Arrays.toString(this.fenwickArr));
        }

        final void update(final int index, final int delta) {
            // this index is based on arr so it will be updated to 1
            final int fenwickIndex = index + 1;
            for (int i = fenwickIndex; i < fenwickArr.length; i = i + (i & -i)) {
                this.fenwickArr[i] += delta;
            }
        }

        final int rangeSum(final int startIndex, final int endIndex) {
            return sum(endIndex) - sum(startIndex - 1);
        }

        private int sum(final int index) {
            // this index is based on arr so it will be updated to 1
            final int fenwickIndex = index + 1;
            int sum = 0;
            for (int i = fenwickIndex; i > 0; i = i - (i & -i)) {
                sum += (this.fenwickArr[i]);
            }
            return sum;
        }
    }
}
