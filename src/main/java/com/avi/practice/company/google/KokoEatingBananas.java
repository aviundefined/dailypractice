package com.avi.practice.company.google;

/**
 * Created by navinash on 27/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1000000009;
        int maxRate = Integer.MAX_VALUE;
        while(low <= high) {
            final int mid = low + (high - low)/2;
            if(canEat(piles, h, mid)) {
                if(mid < maxRate) {
                    maxRate = mid;
                }
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return maxRate;
    }

    private boolean canEat(final int[] piles, final int h, final int k) {
        int timeLeft = h;
        for (int pile : piles) {
            if (timeLeft < 0) {
                return false;
            }
            timeLeft = timeLeft - pile / k - (pile % k == 0 ? 0 : 1);
        }

        return timeLeft >= 0;
    }
}
