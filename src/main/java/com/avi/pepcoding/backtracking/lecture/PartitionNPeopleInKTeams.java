package com.avi.pepcoding.backtracking.lecture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 30/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PartitionNPeopleInKTeams {

    public void getAllTeams(final int n, final int k) {

        final List<List<Integer>> currentTeams = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            currentTeams.add(new ArrayList<>());
        }

        backtrack(1, k, currentTeams, n);
    }

    private void backtrack(int i, int k, List<List<Integer>> currentTeams, int n) {
        if(i > n) {
            if(k == 0) {
                System.out.println(currentTeams);
            }
            return;
        }
        for (int j = 0; j < currentTeams.size(); j++) {
            final List<Integer> currentTeam = currentTeams.get(j);
            if (currentTeam.size() > 0) {
                currentTeam.add(i);
                backtrack(i + 1, k, currentTeams, n);
                currentTeam.remove(currentTeam.size() - 1);
            } else {
                currentTeam.add(i);
                backtrack(i + 1, k - 1, currentTeams, n);
                currentTeam.remove(currentTeam.size() - 1);
                break;
            }

        }
    }
}
