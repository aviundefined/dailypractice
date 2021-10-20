package com.avi.practice.leetcode.weeklycontest.num263;

/**
 * Created by navinash on 20/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SimpleBankSystem {

    public static final class Bank {

        private final long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (!isValid(account1) || !isValid(account2)) {
                return false;
            }
            // from account1 to account2
            if (withdraw(account1, money)) {
                deposit(account2, money);
                return true;
            }
            return false;
        }

        public boolean deposit(int account, long money) {
            if (!isValid(account)) {
                return false;
            }
            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (!isValid(account)) {
                return false;
            }
            if (balance[account - 1] >= money) {
                balance[account - 1] -= money;
                return true;
            }
            return false;
        }

        private boolean isValid(final int account) {
            if (account > balance.length || account <= 0) {
                return false;
            }
            return true;
        }
    }

}
