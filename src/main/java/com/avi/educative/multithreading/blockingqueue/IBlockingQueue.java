package com.avi.educative.multithreading.blockingqueue;

/**
 * Created by navinash on 24/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public interface IBlockingQueue<T> {

    void enqueue(final T data) throws InterruptedException;

    T dequeue() throws InterruptedException;

    int size();
}
