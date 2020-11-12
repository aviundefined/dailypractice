package com.avi.educative.tree;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public interface IHeap {

    void insert(final int num);
    int delete(final int index);
    int poll();
    int peek();
    void print();
}
