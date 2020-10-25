package com.avi.educative.multithreading.locks;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public interface IReadWriteLock {

    void acquireReadLock() throws InterruptedException;

    void releaseReadLock();

    void acquireWriteLock() throws InterruptedException;

    void releaseWriteLock();
}
