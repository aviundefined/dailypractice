package com.avi.educative.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by navinash on 02/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GenerateBinaryNumber {

    public final String[] generate(final int n) {
        final String[] binaryNumbers = new String[n];
        final Queue<String> q = new LinkedList<>();
        q.add("1");
        for (int i = 0; i < n; i++) {
            binaryNumbers[i] = q.poll();
            q.add(binaryNumbers[i] + "0");
            q.add(binaryNumbers[i] + "1");
        }
        return binaryNumbers;
    }
}
