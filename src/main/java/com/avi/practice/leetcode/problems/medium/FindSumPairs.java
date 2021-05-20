package com.avi.practice.leetcode.problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * You are given two integer arrays nums1 and nums2. You are tasked to implement a data structure that supports queries of two types:
 * <p>
 * Add a positive integer to an element of a given index in the array nums2.
 * Count the number of pairs (i, j) such that nums1[i] + nums2[j] equals a given value (0 <= i < nums1.length and 0 <= j < nums2.length).
 * Implement the FindSumPairs class:
 * <p>
 * FindSumPairs(int[] nums1, int[] nums2) Initializes the FindSumPairs object with two integer arrays nums1 and nums2.
 * void add(int index, int val) Adds val to nums2[index], i.e., apply nums2[index] += val.
 * int count(int tot) Returns the number of pairs (i, j) such that nums1[i] + nums2[j] == tot.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
 * [[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
 * Output
 * [null, 8, null, 2, 1, null, null, 11]
 * <p>
 * Explanation
 * FindSumPairs findSumPairs = new FindSumPairs([1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]);
 * findSumPairs.count(7);  // return 8; pairs (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) make 2 + 5 and pairs (5,1), (5,5) make 3 + 4
 * findSumPairs.add(3, 2); // now nums2 = [1,4,5,4,5,4]
 * findSumPairs.count(8);  // return 2; pairs (5,2), (5,4) make 3 + 5
 * findSumPairs.count(4);  // return 1; pair (5,0) makes 3 + 1
 * findSumPairs.add(0, 1); // now nums2 = [2,4,5,4,5,4]
 * findSumPairs.add(1, 1); // now nums2 = [2,5,5,4,5,4]
 * findSumPairs.count(7);  // return 11; pairs (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) make 2 + 5 and pairs (5,3), (5,5) make 3 + 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums1.length <= 1000
 * 1 <= nums2.length <= 105
 * 1 <= nums1[i] <= 109
 * 1 <= nums2[i] <= 105
 * 0 <= index < nums2.length
 * 1 <= val <= 105
 * 1 <= tot <= 109
 * At most 1000 calls are made to add and count each.
 */
public class FindSumPairs {
    private final Map<Integer, Set<Integer>> nums1ValueToIndexes = new HashMap<>();
    private final Map<Integer, Set<Integer>> nums2ValueToIndexes = new HashMap<>();
    private final int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            nums1ValueToIndexes.computeIfAbsent(nums1[i], k -> new HashSet<>()).add(i);
        }

        for (int i = 0; i < nums2.length; i++) {
            nums2ValueToIndexes.computeIfAbsent(nums2[i], k -> new HashSet<>()).add(i);
        }
        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        // find the value at old index
        final int oldValue = nums2[index];
        // remove it's index from map
        if (nums2ValueToIndexes.containsKey(oldValue)) {
            final Set<Integer> indexes = nums2ValueToIndexes.get(oldValue);
            indexes.remove(index);
            if (indexes.size() == 0) {
                nums2ValueToIndexes.remove(oldValue);
            }
        }
        // create or update new entry
        final int newVal = oldValue + val;
        nums2ValueToIndexes.computeIfAbsent(newVal, k -> new HashSet<>()).add(index);
        nums2[index] = newVal;
    }

    public int count(int tot) {
        int count = 0;
        // since num1Value indexes is smaller the iterate over that and query nums2ValueToIndexes
        for (final Map.Entry<Integer, Set<Integer>> e : nums1ValueToIndexes.entrySet()) {
            final int val = e.getKey();
            final int rem = tot - val;
            final Set<Integer> indexesInNums2 = this.nums2ValueToIndexes.getOrDefault(rem, new HashSet<>());
            if (indexesInNums2.size() != 0) {
                count += (e.getValue().size() * indexesInNums2.size());
            }
        }
        return count;
    }
}
