package com.avi.educative.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Created by navinash on 26/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintFooBar {

    private final int n;
    private final Semaphore foo = new Semaphore(0);
    private final Semaphore bar = new Semaphore(0);

    public PrintFooBar(final int n) {
        this.n = n;
    }

    public void printFoo() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            System.out.println("Foo-" + i);
            bar.release(1);
            foo.acquire();
        }
    }

    public void printBar() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            bar.acquire();
            System.out.println("Bar-" + i);
            foo.release(1);
        }
    }
}
