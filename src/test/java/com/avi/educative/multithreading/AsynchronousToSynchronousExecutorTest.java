package com.avi.educative.multithreading;

import com.avi.educative.multithreading.AsynchronousToSynchronousExecutor.Executor;
import com.avi.educative.multithreading.AsynchronousToSynchronousExecutor.SynchronousExecutor;
import org.junit.Test;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AsynchronousToSynchronousExecutorTest {

    @Test
    public void testSynchronous() throws Exception {
        final SynchronousExecutor executor = new SynchronousExecutor();
        executor.asynchronousExecution(() -> {
            System.out.println("I am done");
        });
        System.out.println("main thread exiting...");
    }

    @Test
    public void testAsynchronous() throws Exception {
        final Executor executor = new Executor();
        executor.asynchronousExecution(() -> {
            System.out.println("I am done");
        });
        System.out.println("main thread exiting...");
    }
}