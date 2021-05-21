package com.avi.pepcoding.tree.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 15/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GenericNode {

    private final int data;
    private final List<GenericNode> children = new ArrayList<>();

    public GenericNode(int data) {
        this.data = data;
    }

    public final int getData() {
        return this.data;
    }

    public final List<GenericNode> getChildren() {
        return this.children;
    }
}
