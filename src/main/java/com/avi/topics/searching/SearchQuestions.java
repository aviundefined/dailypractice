package com.avi.topics.searching;

import com.avi.practice.utils.CommonUtils;

import java.util.List;

/**
 * Created by navinash on 21/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class SearchQuestions {

    private SearchQuestions() {

    }

    static int findListInList(final List<Integer> parent, final List<Integer> target) {
        if (CommonUtils.isEmpty(parent) || CommonUtils.isEmpty(target)) {
            return -1;
        }
        final int n = parent.size();
        final int m = target.size();
        if (m > n) {
            return -1;
        }
        int startIdx = -1;
        int matched = 0;
        int i = 0;
        while (matched < m && i <= n - 1) {
            if (parent.get(i).equals(target.get(matched))) {
                if (matched == 0) {
                    startIdx = i;
                }
                matched++;
                i++;
                continue;
            }
            matched = 0;
            if (startIdx == -1) {
                i++;
            } else {
                i = startIdx + 1;
            }
            startIdx = -1;
        }
        if (matched == m) {
            return startIdx;
        }
        return -1;
    }

    static int findMinimumElementInRotatedSortedArray(final int[] arr) {
        if (CommonUtils.isEmpty(arr)) {
            return -1;
        }
        final int n = arr.length;
        if (n == 1) {
            return -1;
        }
        if (arr[0] < arr[n - 1]) {
            return -1;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (left == right) {
                return left;
            }
            final int mid = (left + right) / 2;
            if (arr[mid] < arr[right]) {
                right = mid; // means arr[mid] to arr[right] is sorted so min point can be between left to mid
            } else {
                left = mid + 1; // if arr[mid] == right or arr[mid] > arr[right] in both the cases min will be in mid + 1 to right
            }
        }
        return -1;
    }

    static int rotatedSearch(final int[] arr, final int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[left] <= arr[mid]) {
                if (key >= arr[left] && key <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (key >= arr[mid] && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
