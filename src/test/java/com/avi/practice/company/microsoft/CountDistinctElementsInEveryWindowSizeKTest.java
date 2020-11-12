package com.avi.practice.company.microsoft;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CountDistinctElementsInEveryWindowSizeKTest {

    private final CountDistinctElementsInEveryWindowSizeK solver = new CountDistinctElementsInEveryWindowSizeK();

    @Test
    public void solve() {
        {
            final int[] arr = {1, 2, 1, 3, 4, 2, 3};
            final int k = 4;
            CommonUtils.printArr(arr);
            final List<Integer> expected = new ArrayList<>();
            expected.add(3);
            expected.add(4);
            expected.add(4);
            expected.add(3);
            final List<Integer> actual = solver.solve(arr, k);
            Assert.assertEquals(expected, actual);
        }
    }
}