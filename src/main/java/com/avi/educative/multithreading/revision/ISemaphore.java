package com.avi.educative.multithreading.revision;

/**
 * Created by navinash on 22/11/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public interface ISemaphore {
    void acquire() throws InterruptedException;
    void release() throws InterruptedException;
}
