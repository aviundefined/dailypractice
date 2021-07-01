package com.avi.educative.tree.segment_tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 01/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SegmentTreeMaxTest {

    @Test
    public void test() {
        // - - - - - - - --0  1  2  3  4   5
        final int[] arr = {1, 3, 6, 9, 12, 0};
        final SegmentTreeMax st = new SegmentTreeMax(arr);
        Assert.assertEquals(12, st.getMax(2, 4));
        Assert.assertEquals(9, st.getMax(1, 3));
        Assert.assertEquals(0, st.getMax(5, 5));
        Assert.assertEquals(12, st.getMax(0, 4));
        Assert.assertEquals(12, st.getMax(0, 5));
        Assert.assertEquals(6, st.getMax(1, 2));

        st.update(5, 13);
        Assert.assertEquals(12, st.getMax(2, 4));
        Assert.assertEquals(9, st.getMax(1, 3));
        Assert.assertEquals(13, st.getMax(5, 5));
        Assert.assertEquals(12, st.getMax(0, 4));
        Assert.assertEquals(13, st.getMax(0, 5));
        Assert.assertEquals(6, st.getMax(1, 2));
    }
}