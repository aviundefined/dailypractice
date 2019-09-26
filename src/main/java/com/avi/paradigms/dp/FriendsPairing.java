package com.avi.paradigms.dp;

/**
 * Created by navinash on 26/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class FriendsPairing {

    final int pairs(final int numberOfPeople) {
        if (numberOfPeople == 0 || numberOfPeople == 1 || numberOfPeople == 2) {
            return numberOfPeople; // base cases if 0 people then there is no way to pair, if one people then there is only way to pair the he is single, // for 2 - {(1), (2)}, {(1,2)}
        }
        final int[] pairs = new int[numberOfPeople + 1];
        // populate base cases
        pairs[0] = 0;
        pairs[1] = 1;
        pairs[2] = 2;
        // f(i) is the function to get number of ways to pair ith person, then there are two options
        //  - ith person is single then it's equal to number of ways to pair (i-1) persons i.e. f(i-1)
        ///  - ith person is not single, then ith person can be paired with (i-1) persons so this will (i-1)*f(i-2)
        for (int i = 3; i <= numberOfPeople; i++) {
            pairs[i] = pairs[i - 1] + (i - 1) * pairs[i - 2];
        }
        return pairs[numberOfPeople];
    }
}
