package com.avi.educative.multithreading;

import com.avi.educative.multithreading.DeferredCallbackExecutor.CallBack;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DeferredCallbackExecutorTest {


    @Test
    public void test() throws Exception {
        Set<Thread> allThreads = new HashSet<>();
        final DeferredCallbackExecutor deferredCallbackExecutor = new DeferredCallbackExecutor();

        Thread service = new Thread(() -> {
            try {
                deferredCallbackExecutor.start();
            } catch (InterruptedException ie) {

            }
        });

        service.start();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                CallBack cb = new CallBack(1000L, " Hello this is " + Thread.currentThread().getName());
                deferredCallbackExecutor.register(cb);
            });
            thread.setName("Thread_" + (i + 1));
            thread.start();
            allThreads.add(thread);
            Thread.sleep(1000);
        }

        for (Thread t : allThreads) {
            t.join();
        }
    }

}