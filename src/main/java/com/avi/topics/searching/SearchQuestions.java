package com.avi.topics.searching;

import com.avi.practice.utils.CommonUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 21/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class SearchQuestions {

    private SearchQuestions() {

    }

    static int findPivot(final int[] a) {
        final int n = CommonUtils.isEmpty(a) ? 0 : a.length;
        // if 0 or 1 element no pivot possible
        if (n <= 1) {
            return -1;
        }

        // if first element is smaller than last element then no pivot possible
        if (a[0] < a[n - 1]) {
            return -1;
        }

        int left = 0, right = n - 1;
        while (left <= right) {
            if (left == right) {
                return left;
            }
            final int mid = (left + right) / 2;
            if ((mid == 0 || a[mid] > a[mid - 1]) && (mid == n - 1 || a[mid] > a[mid + 1])) {
                return mid;
            }
            if (a[left] <= a[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
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

    static int findMissingNumberSumApproach(final int[] arr) {
        final int n = arr.length + 1;
        final int sum = (n * (n + 1)) / 2;
        int arrSum = 0;
        for (final int a : arr) {
            arrSum += a;
        }
        return sum - arrSum;
    }

    static int findMissingNumberXORApproach(final int[] arr) {
        final int n = arr.length;
        int xorOfAllN = 1;
        for (int i = 2; i <= n + 1; i++) {
            xorOfAllN = xorOfAllN ^ i;
        }

        int xorOfArr = arr[0];
        for (int i = 1; i < n; i++) {
            xorOfArr = xorOfArr ^ arr[i];
        }
        return xorOfAllN ^ xorOfArr;
    }

    static double medianSortedArraysEqualSize(final int[] arr1, final int[] arr2) {
        final int n1 = CommonUtils.isEmpty(arr1) ? 0 : arr1.length;
        final int n2 = CommonUtils.isEmpty(arr1) ? 0 : arr2.length;
        if (n1 != n2) {
            throw new IllegalArgumentException(String.format("This method can be used only for equal size of array. Arrays sizes are [%d], [%d]", n1, n2));
        }
        if (n1 == 0) {
            return -1;
        }
        return _medianSortedArraysEqualSize(arr1, arr2, n1);
    }

    private static double _medianSortedArraysEqualSize(final int[] arr1, final int[] arr2, final int n) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return (double) (arr1[0] + arr2[0]) / 2;
        }
        if (n == 2) {
            return (double) ((Math.max(arr1[0], arr2[0])) + Math.min(arr1[1], arr2[1])) / 2;
        }

        final double m1 = _median(arr1);
        final double m2 = _median(arr2);
        if (m1 == m2) {
            return m1;
        }

        if (m1 > m2) {
            if (n % 2 == 0) {
                // n = 6, so 0, 1, 2 & 3, 4, 5
                final int mid = n / 2 - 1; // 2
                final int[] newArr1 = new int[mid + 1];
                for (int i = 0; i <= mid; i++) {
                    newArr1[i] = arr1[i];
                }
                final int[] newArr2 = new int[mid + 1];
                for (int i = 0; i <= mid; i++) {
                    newArr2[i] = arr1[mid + 1 + i];
                }
                return _medianSortedArraysEqualSize(newArr1, newArr2, mid + 1);
            } else {
                // n = 7 so 0, 1, 2, 3 & 3, 4, 5, 6
                final int mid = n / 2;
                final int[] newArr1 = new int[mid + 1];
                for (int i = 0; i <= mid; i++) {
                    newArr1[i] = arr1[i];
                }
                final int[] newArr2 = new int[mid + 1];
                for (int i = 0; i <= mid; i++) {
                    newArr2[i] = arr2[mid + i];
                }
                return _medianSortedArraysEqualSize(newArr1, newArr2, mid + 1);
            }
        } else {
            if (n % 2 == 0) {
                // n = 6, so 0, 1, 2 & 3, 4, 5
                final int mid = n / 2 - 1; // 2
                final int[] newArr1 = new int[mid + 1];
                for (int i = 0; i <= mid; i++) {
                    newArr1[i] = arr1[mid + 1 + i];
                }
                final int[] newArr2 = new int[mid + 1];
                for (int i = 0; i <= mid; i++) {
                    newArr2[i] = arr2[i];
                }
                return _medianSortedArraysEqualSize(newArr1, newArr2, mid + 1);
            } else {
                // n = 7 so 0, 1, 2, 3 & 3, 4, 5, 6
                final int mid = n / 2;
                final int[] newArr1 = new int[mid + 1];
                for (int i = 0; i <= mid; i++) {
                    newArr1[i] = arr1[mid + i];
                }
                final int[] newArr2 = new int[mid + 1];
                for (int i = 0; i <= mid; i++) {
                    newArr2[i] = arr2[i];
                }
                return _medianSortedArraysEqualSize(newArr1, newArr2, mid + 1);
            }
        }
    }

    private static double _median(final int[] arr) {
        final int n = CommonUtils.isEmpty(arr) ? 0 : arr.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return arr[0];
        }
        if (n == 2) {
            return (double) (arr[0] + arr[1]) / 2;
        }
        if (n % 2 == 0) {
            return (double) (arr[n / 2 - 1] + arr[n / 2]) / 2;
        }
        return arr[n / 2];
    }

    static ClosetToZeroSumResult findClosetToZeroSum(final int[] arr) {
        final int n = CommonUtils.isEmpty(arr) ? 0 : arr.length;
        if (n < 2) {
            return null;
        }
        if (n == 2) {
            return new ClosetToZeroSumResult(arr[0], arr[1]);
        }
        Arrays.sort(arr);
        ClosetToZeroSumResult result = null;
        int minDiff = Integer.MAX_VALUE;
        int left = 0, right = n - 1;
        while (left < right) {
            final int sum = arr[left] + arr[right];
            if (sum == 0) {
                result = new ClosetToZeroSumResult(arr[left], arr[right]);
                break;
            }
            if (Math.abs(sum) < minDiff) {
                minDiff = Math.abs(sum);
                result = new ClosetToZeroSumResult(arr[left], arr[right]);
            }
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    static final class ClosetToZeroSumResult {
        private final int ele1;
        private final int ele2;

        private ClosetToZeroSumResult(final int ele1, final int ele2) {
            this.ele1 = ele1;
            this.ele2 = ele2;
        }

        final int sum() {
            return ele1 + ele2;
        }

        @Override
        public String toString() {
            return "{" + ele1 + "," + ele2 + ") -> " + Math.abs(ele1 + ele2);
        }
    }

}
