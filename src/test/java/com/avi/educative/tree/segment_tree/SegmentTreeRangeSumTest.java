package com.avi.educative.tree.segment_tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 01/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SegmentTreeRangeSumTest {

    @Test
    public void test() {
        // - - - - - - - - 0  1  2  3  4  5
        final int[] arr = {1, 3, 5, 7, 9, 11};
        final SegmentTreeRangeSum st = new SegmentTreeRangeSum(arr);
        Assert.assertEquals(21, st.getRangeSum(2, 4));
        st.update(3, 15);
        Assert.assertEquals(29, st.getRangeSum(2, 4));
    }
}