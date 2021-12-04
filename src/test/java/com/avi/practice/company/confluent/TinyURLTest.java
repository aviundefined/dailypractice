package com.avi.practice.company.confluent;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 04/12/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TinyURLTest {

    private final TinyURL tinyURL = new TinyURL();

    @Test
    public void useCase1() {
        final String url = "https://boardgamearena.com/3/terramystica?table=219329354";
        final String shortUrl = tinyURL.encode(url);
        System.out.printf("%s -> %s\n", url, shortUrl);
        final String convert = tinyURL.decode(shortUrl);
        Assert.assertEquals(url, convert);
    }
}