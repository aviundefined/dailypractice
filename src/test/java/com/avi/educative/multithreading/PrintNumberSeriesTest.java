package com.avi.educative.multithreading;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 26/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintNumberSeriesTest {

    @Test
    public void test() throws InterruptedException {
        final PrintNumberSeries series = new PrintNumberSeries(9);
        final Thread zero = new Thread(() -> {
            try {
                series.printZero();
            } catch (InterruptedException ignored) {
            }
        });
        final Thread odd = new Thread(() -> {
            try {
                series.printOdd();
            } catch (InterruptedException ignored) {
            }
        });
        final Thread even = new Thread(() -> {
            try {
                series.printEven();
            } catch (InterruptedException ignored) {
            }
        });

        even.start();
        zero.start();
        odd.start();
        odd.join();
        zero.join();
        even.join();
    }
}