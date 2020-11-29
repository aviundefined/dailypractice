package com.avi.educative.tree.questions;

import com.avi.educative.tree.Node;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 26/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MirrorCheckTest {
    private static final MirrorCheck solver = new MirrorCheck();

    @Test
    public void isMirror() {
        final Node root = new Node(1);
        root.setLeftChild(new Node(2));
        root.setRightChild(new Node(2));
        root.getLeftChild().setLeftChild(new Node(3));
        root.getLeftChild().setRightChild(new Node(4));
        root.getRightChild().setLeftChild(new Node(4));
        root.getRightChild().setRightChild(new Node(3));
        final boolean actual = solver.isMirror(root);
        Assert.assertTrue(actual);
    }
}