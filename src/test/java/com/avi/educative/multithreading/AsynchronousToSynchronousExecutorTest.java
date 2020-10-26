package com.avi.educative.multithreading;

import com.avi.educative.multithreading.AsynchronousToSynchronousExecutor.Executor;
import com.avi.educative.multithreading.AsynchronousToSynchronousExecutor.SynchronousExecutorUsingMonitor;
import com.avi.educative.multithreading.AsynchronousToSynchronousExecutor.SynchronousExecutorUsingSemaphore;
import org.junit.Test;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AsynchronousToSynchronousExecutorTest {

    @Test
    public void testSynchronousUsingSemaphore() throws Exception {
        final SynchronousExecutorUsingSemaphore executor = new SynchronousExecutorUsingSemaphore();
        executor.asynchronousExecution(() -> {
            System.out.println("I am done");
        });
        System.out.println("main thread exiting...");
    }

    @Test
    public void testSynchronousUsingMonitor() throws Exception {
        final SynchronousExecutorUsingMonitor executor = new SynchronousExecutorUsingMonitor();
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