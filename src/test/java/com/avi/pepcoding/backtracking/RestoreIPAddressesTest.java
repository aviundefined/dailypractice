package com.avi.pepcoding.backtracking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by navinash on 29/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RestoreIPAddressesTest {

    @Test
    public void restoreIpAddresses() {
        final RestoreIPAddresses solver = new RestoreIPAddresses();
        final String s = "25525511135";
        final List<String> result = solver.restoreIpAddresses(s);
        System.out.println(result);
    }
}