package com.avi.pepcoding.graph.union_find;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by navinash on 17/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AccountsMergeTest {

    @Test
    public void accountsMerge1() {
        final AccountsMerge solver = new AccountsMerge();
        final List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
        );
        final List<List<String>> expected = Arrays.asList(
                Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
        );

        final List<List<String>> actual = solver.accountsMerge(accounts);
        Assert.assertEquals(accounts.toString(), new HashSet<>(expected), new HashSet<>(actual));
    }
}