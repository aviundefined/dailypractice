package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 24/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ReorderDataInLogFilesTest {

    private static final ReorderDataInLogFiles solver = new ReorderDataInLogFiles();

    @Test
    public void reorderLogFiles() {
        final String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        final String[] expected = {"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};
        final String[] actual = solver.reorderLogFiles(logs);
        System.out.println("Logs:" + Arrays.toString(logs));
        System.out.println("Expected:" + Arrays.toString(expected));
        System.out.println("Actual:" + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }
}