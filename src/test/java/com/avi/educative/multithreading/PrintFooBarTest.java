package com.avi.educative.multithreading;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 26/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintFooBarTest {

    @Test
    public void test() throws Exception {
        final PrintFooBar fooBar = new PrintFooBar(10);
        final Thread foo = new Thread(() -> {
            try {
                fooBar.printFoo();
            } catch (InterruptedException ignored) {
            }
        });

        final Thread bar = new Thread(() -> {
            try {
                fooBar.printBar();
            } catch (InterruptedException ignored) {
            }
        });

        foo.start();
        bar.start();
        foo.join();
        bar.join();
    }
}