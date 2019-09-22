package com.avi.paradigms.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 23/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CatalanNumberTest {

    @Test
    public void catalan() {
        final CatalanNumber solver = new CatalanNumber();
        final int[] expectedCatalans = {1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862};
        for (int i = 0; i < expectedCatalans.length; i++) {
            final String message = String.valueOf(i);
            final int expectedCatalan = expectedCatalans[i];
            final int actualCatalan = solver.catalan(i);
            Assert.assertEquals(message, expectedCatalan, actualCatalan);
        }
    }
}
