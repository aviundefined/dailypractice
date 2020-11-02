package com.avi.educative.stack_queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 02/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GenerateBinaryNumberTest {

    @Test
    public void generate() {
        final GenerateBinaryNumber solver = new GenerateBinaryNumber();
        final String[] output = solver.generate(3);
        for(int i = 0; i < 3; i++)
            System.out.print(output[i] + " ");
    }
}