package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 17/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BrowserHistoryTest {

    @Test
    public void testUseCase1() {
        /*
         * ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
         * [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
         * Output:
         * [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
         */

        final BrowserHistory solver = new BrowserHistory("leetcode.com");
        solver.visit("google.com");
        solver.visit("facebook.com");
        solver.visit("youtube.com");
        Assert.assertEquals("facebook.com", solver.back(1));
        Assert.assertEquals("google.com", solver.back(1));
        Assert.assertEquals("facebook.com", solver.forward(1));
        solver.visit("linkedin.com");
        Assert.assertEquals("linkedin.com", solver.forward(2));
        Assert.assertEquals("google.com", solver.back(2));
        Assert.assertEquals("linkedin.com", solver.forward(7));
    }

}