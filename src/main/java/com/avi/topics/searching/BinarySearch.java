package com.avi.topics.searching;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 21/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class BinarySearch {

    private static final int NOT_FOUND = -1;
    private final int[] arr;
    private final int n;

    BinarySearch(final int[] arr) {
        if (CommonUtils.isEmpty(arr)) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        this.arr = arr;
        this.n = arr.length;
    }

    final int rotatedSearch(final int key) {
        int left = 0;
        int right = n - 1;
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
        return NOT_FOUND;
    }

    final int findRecursive(final int x) {
        return _findRecursive(0, n - 1, x);
    }

    final int findIterative(final int x) {
        return _findIterative(0, n - 1, x);
    }

    final int occurrences(final int x) {
        final int firstIndex = findFirstIterative(x);
        if (firstIndex == NOT_FOUND) {
            return 0;
        }
        final int lastIndex = findLastIterative(x);
        return lastIndex - firstIndex + 1;
    }

    final int findFirstRecursive(final int x) {
        int idx = _findRecursive(0, n - 1, x);
        // if not found then simply return it
        if (idx == NOT_FOUND) {
            return idx;
        }
        int minIdx = idx;
        // x found at idx , not try to find smaller idx
        while (idx != NOT_FOUND) {
            idx = _findRecursive(0, idx - 1, x);
            if (idx != NOT_FOUND) {
                minIdx = idx;
            }
        }
        return minIdx;
    }

    final int findLastRecursive(final int x) {
        int idx = _findRecursive(0, n - 1, x);
        // if not found then simply return it
        if (idx == NOT_FOUND) {
            return idx;
        }
        int maxIdx = idx;
        // x found at idx , not try to find largest idx
        while (idx != NOT_FOUND) {
            idx = _findRecursive(idx + 1, n - 1, x);
            if (idx != NOT_FOUND) {
                maxIdx = idx;
            }
        }
        return maxIdx;
    }

    final int findFirstIterative(final int x) {
        int idx = _findIterative(0, n - 1, x);
        // if not found then simply return it
        if (idx == NOT_FOUND) {
            return idx;
        }
        int minIdx = idx;
        // x found at idx , not try to find smaller idx
        while (idx != NOT_FOUND) {
            idx = _findIterative(0, idx - 1, x);
            if (idx != NOT_FOUND) {
                minIdx = idx;
            }
        }
        return minIdx;
    }

    final int findFirstIndexApproach2(final int x) {
        int left = 0;
        int right = n - 1;
        int first = Integer.MAX_VALUE;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if (arr[mid] == x) {
                first = Math.min(first, mid);
                right = mid - 1;
            } else if (x < arr[mid]) {
                right = mid - 1;
            } else if (x > arr[mid]) {
                left = mid + 1;
            }
        }
        if (first == Integer.MAX_VALUE) {
            return NOT_FOUND;
        }
        return first;
    }

    final int findLastIterative(final int x) {
        int idx = _findIterative(0, n - 1, x);
        // if not found then simply return it
        if (idx == NOT_FOUND) {
            return idx;
        }
        int maxIdx = idx;
        // x found at idx , not try to find largest idx
        while (idx != NOT_FOUND) {
            idx = _findIterative(idx + 1, n - 1, x);
            if (idx != NOT_FOUND) {
                maxIdx = idx;
            }
        }
        return maxIdx;
    }

    final int findLastIndexApproach2(final int x) {
        int left = 0;
        int right = n;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (arr[left] == x) {
            return left;
        }
        return NOT_FOUND;
    }

    /**
     * Returns value less or equal to x
     */
    final int floor(final int x) {
        final int floorIdx = _floorIndex(x);
        if (floorIdx == NOT_FOUND) {
            return Integer.MAX_VALUE; // indicator that floor not found
        }
        return arr[floorIdx];
    }

    /**
     * Returns value greater or equal to x
     */
    final int ceiling(final int x) {
        final int ceilingIdx = _ceilingIndex(x);
        if (ceilingIdx == NOT_FOUND) {
            return Integer.MIN_VALUE; // indicator that ceiling not found
        }
        return arr[ceilingIdx];
    }

    private int _ceilingIndex(final int x) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                if (mid == 0) {
                    return mid;
                } else //noinspection ConstantConditions
                    if (mid > 0) {
                        if (arr[mid - 1] == x) {
                            return mid - 1;
                        } else if (arr[mid - 1] < x) {
                            return mid;
                        }
                    }
                right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            }
        }
        return NOT_FOUND;
    }

    private int _floorIndex(int x) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            final int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else if (arr[mid] < x) {
                if (mid == n - 1) {
                    return mid;
                } else if (mid < n - 1) {
                    if (arr[mid + 1] == x) {
                        return mid + 1;
                    }
                    if (arr[mid + 1] > x) {
                        return mid;
                    }
                }
                left = mid + 1;
            }
        }
        return NOT_FOUND;
    }

    private int _findRecursive(final int left, final int right, final int x) {
        if (right < left) {
            return NOT_FOUND;
        }
        final int mid = (left + right) / 2;
        if (arr[mid] == x) {
            return mid;
        }
        if (arr[mid] > x) {
            return _findRecursive(left, mid - 1, x);
        }
        if (arr[mid] < x) {
            return _findRecursive(mid + 1, right, x);
        }
        return NOT_FOUND;
    }

    private int _findIterative(int left, int right, final int x) {
        if (right < left) {
            return NOT_FOUND;
        }
        while (left <= right) {
            final int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                right = mid - 1;
            }
            if (arr[mid] < x) {
                left = mid + 1;
            }
        }
        return NOT_FOUND;
    }
}
