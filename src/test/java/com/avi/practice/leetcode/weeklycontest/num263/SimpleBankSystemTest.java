package com.avi.practice.leetcode.weeklycontest.num263;

import com.avi.practice.leetcode.weeklycontest.num263.SimpleBankSystem.Bank;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 20/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SimpleBankSystemTest {

    @Test
    public void testUseCase1() {
        /*
         * ["Bank","withdraw","transfer","deposit","transfer","withdraw"]
         * [[[10,100,20,50,30]],[3,10],[5,1,20],[5,20],[3,4,15],[10,50]]
         *
         * [null, true, true, true, false, false]
         */
        final Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
        Assert.assertTrue(bank.withdraw(3,10));
        Assert.assertTrue(bank.transfer(5,1, 20));
        Assert.assertTrue(bank.deposit(5,10));
        Assert.assertFalse(bank.transfer(3,4, 15));
        Assert.assertFalse(bank.withdraw(10, 50));
    }

}