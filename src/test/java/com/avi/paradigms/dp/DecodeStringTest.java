package com.avi.paradigms.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by navinash on 05/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DecodeStringTest {

    @Test
    public void count() {
        {
            final String s = "12";
            final DecodeString solver = new DecodeString(s);
            final int expected = 2;
            final int countRecursive = solver.countRecursive();
            final int countIterative = solver.countIterative();
            final List<String> allDecodings = solver.getAllDecodings();
            System.out.println("allDecodings: " + allDecodings);
            solver.printAllDecodings();
            Assert.assertEquals(s, expected, countRecursive);
            Assert.assertEquals(s, expected, countIterative);
            Assert.assertEquals(s, expected, allDecodings.size());
            System.out.println("------------------------------");
        }

        {
            final String s = "226";
            final DecodeString solver = new DecodeString(s);
            final int expected = 3;
            final int countRecursive = solver.countRecursive();
            final int countIterative = solver.countIterative();
            final List<String> allDecodings = solver.getAllDecodings();
            System.out.println("allDecodings: " + allDecodings);
            solver.printAllDecodings();
            Assert.assertEquals(s, expected, countRecursive);
            Assert.assertEquals(s, expected, countIterative);
            Assert.assertEquals(s, expected, allDecodings.size());
            System.out.println("------------------------------");
        }
        {
            final String s = "121";
            final DecodeString solver = new DecodeString(s);
            final int expected = 3;
            final int countRecursive = solver.countRecursive();
            final int countIterative = solver.countIterative();
            final List<String> allDecodings = solver.getAllDecodings();
            System.out.println("allDecodings: " + allDecodings);
            solver.printAllDecodings();
            Assert.assertEquals(s, expected, countRecursive);
            Assert.assertEquals(s, expected, countIterative);
            Assert.assertEquals(s, expected, allDecodings.size());
            System.out.println("------------------------------");
        }

        {
            final String s = "1234";
            final DecodeString solver = new DecodeString(s);
            final int expected = 3;
            final int countRecursive = solver.countRecursive();
            final int countIterative = solver.countIterative();
            final List<String> allDecodings = solver.getAllDecodings();
            System.out.println("allDecodings: " + allDecodings);
            solver.printAllDecodings();
            Assert.assertEquals(s, expected, countRecursive);
            Assert.assertEquals(s, expected, countIterative);
            Assert.assertEquals(s, expected, allDecodings.size());
            System.out.println("------------------------------");
        }
    }
}
