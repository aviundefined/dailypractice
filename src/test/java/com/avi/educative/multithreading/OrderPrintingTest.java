package com.avi.educative.multithreading;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 26/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class OrderPrintingTest {

    @Test
    public  void test() throws InterruptedException {
        final OrderPrinting orderPrinting  = new OrderPrinting();
        orderPrinting.orderPrinting();
    }
}