package com.avi.practice.company.cloudkitchen.parsers.xml;

import com.avi.practice.company.cloudkitchen.parsers.model.Order;

/**
 * Created by navinash on 31/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public interface OrderProcessor {

    void process(final Order order);
}
