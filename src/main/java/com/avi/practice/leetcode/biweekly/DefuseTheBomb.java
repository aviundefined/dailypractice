package com.avi.practice.leetcode.biweekly;

/**
 * Created by navinash on 20/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * <p>
 * You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.
 * <p>
 * To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.
 * <p>
 * If k > 0, replace the ith number with the sum of the next k numbers.
 * If k < 0, replace the ith number with the sum of the previous k numbers.
 * If k == 0, replace the ith number with 0.
 * As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].
 * <p>
 * Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: code = [5,7,1,4], k = 3
 * Output: [12,10,16,13]
 * Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
 * Example 2:
 * <p>
 * Input: code = [1,2,3,4], k = 0
 * Output: [0,0,0,0]
 * Explanation: When k is zero, the numbers are replaced by 0.
 * Example 3:
 * <p>
 * Input: code = [2,4,9,3], k = -2
 * Output: [12,5,6,13]
 * Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == code.length
 * 1 <= n <= 100
 * 1 <= code[i] <= 100
 * -(n - 1) <= k <= n - 1
 */
public class DefuseTheBomb {

    public int[] decrypt(int[] code, int k) {
        // code[i] = 101 * new[i] + a[i];
        final int n = code.length;
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                code[i] = 0;
            }
            return code;
        }
        int max = 100_01;
        if (k > 0) {
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            code[0] = (max * sum + code[0]);
            int i = 1;
            while (i < n) {
                sum -= (code[i] % max);
                sum += (code[(i + k) % n] % max);
                code[i] = max * sum + code[i];
                i++;
            }
            for (int j = 0; j < n; j++) {
                code[j] = code[j] / max;
            }
        } else {
            reverse(code, n);
            k = -1 * k;
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            code[0] = (max * sum + code[0]);
            int i = 1;
            while (i < n) {
                sum -= (code[i] % max);
                sum += (code[(i + k) % n] % max);
                code[i] = max * sum + code[i];
                i++;
            }
            for (int j = 0; j < n; j++) {
                code[j] = code[j] / max;
            }
            reverse(code, n);
        }

        return code;
    }

    private void reverse(int[] code, int n) {
        int l = 0;
        int r = n - 1;
        while (l < r) {
            final int tmp = code[l];
            code[l] = code[r];
            code[r] = tmp;
            l++;
            r--;
        }
    }
}
