package com.avi.pepcoding.dp;

/**
 * Created by navinash on 26/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PartitionIntoTeams {

    public long divideNPlayersIntoKTeams(final int n, final int k) {
        if (n < k || n == 0 || k == 0) {
            return 0L;
        }
        if (n == k || k == 1) {
            return 1L;
        }
        final long[][] f = new long[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            f[i][1] = 1L;
        }

        for (int players = 1; players <= n; players++) {
            for (int teams = 1; teams <= k; teams++) {
                if (teams == 0) {
                    f[players][teams] = 0L;
                } else if (players < teams) {
                    f[players][teams] = 0L;
                } else if (teams == 1) {
                    f[players][teams] = 1L;
                } else if (players == teams) {
                    f[players][teams] = 1L;
                } else {
                    f[players][teams] = f[players - 1][teams - 1] + teams * f[players - 1][teams];
                }
            }
        }


        return f[n][k];
    }
}
