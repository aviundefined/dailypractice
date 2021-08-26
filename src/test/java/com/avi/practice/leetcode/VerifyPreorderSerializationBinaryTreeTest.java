package com.avi.practice.leetcode;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by navinash on 26/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class VerifyPreorderSerializationBinaryTreeTest extends TestCase {

    public void testIsValidSerialization1() {
        final VerifyPreorderSerializationBinaryTree solver = new VerifyPreorderSerializationBinaryTree();
        final String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        final boolean expected = true;
        final boolean actual = solver.isValidSerialization(preorder);
        Assert.assertEquals(preorder, expected, actual);
    }

    public void testIsValidSerialization2() {
        final VerifyPreorderSerializationBinaryTree solver = new VerifyPreorderSerializationBinaryTree();
        final String preorder = "1,#";
        final boolean expected = false;
        final boolean actual = solver.isValidSerialization(preorder);
        Assert.assertEquals(preorder, expected, actual);
    }

    public void testIsValidSerialization3() {
        final VerifyPreorderSerializationBinaryTree solver = new VerifyPreorderSerializationBinaryTree();
        final String preorder = "9,#,#,1";
        final boolean expected = false;
        final boolean actual = solver.isValidSerialization(preorder);
        Assert.assertEquals(preorder, expected, actual);
    }

    public void testIsValidSerialization4() {
        final VerifyPreorderSerializationBinaryTree solver = new VerifyPreorderSerializationBinaryTree();
        final String preorder = "#,#,#";
        final boolean expected = false;
        final boolean actual = solver.isValidSerialization(preorder);
        Assert.assertEquals(preorder, expected, actual);
    }
}