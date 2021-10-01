package com.avi.practice.company.google;

import java.util.Random;

/**
 * Created by navinash on 01/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ShuffleArray {

    static final class Solution {
        private int[] shuffle;
        private int[] nums;

        public Solution(int[] nums) {
            this.shuffle = nums;
            this.nums = nums.clone();
        }

        public int[] reset() {
            shuffle = nums;
            nums = nums.clone();
            return nums;
        }

        public int[] shuffle() {
            for (int i = 0; i < nums.length; i++) {
                swap(i, random(i, nums.length));
            }
            return shuffle;
        }

        private void swap(final int i, final int j) {
            final int tmp = shuffle[i];
            shuffle[i] = shuffle[j];
            shuffle[j] = tmp;
        }

        private int random(final int min, final int max) {
            return new Random().nextInt(max - min) + min;
        }

    }
}
