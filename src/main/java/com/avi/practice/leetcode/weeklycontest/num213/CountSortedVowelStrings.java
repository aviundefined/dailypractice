package com.avi.practice.leetcode.weeklycontest.num213;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 02/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
 * <p>
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: 5
 * Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: 15
 * Explanation: The 15 sorted strings that consist of vowels only are
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
 * Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 50
 */
public class CountSortedVowelStrings {

    public int countVowelStrings(int n) {
        final int[] dp = {1, 1, 1, 1, 1};
        for (int i = 2; i <= n; i++) {
            int sum = dp[0];
            for (int j = 1; j < dp.length; j++) {
                sum = sum + dp[j];
                dp[j] = sum;
            }
        }

        CommonUtils.printArr(dp);
        int count = 0;
        for (final int a : dp) {
            count += a;
        }
        return count;
    }
}
