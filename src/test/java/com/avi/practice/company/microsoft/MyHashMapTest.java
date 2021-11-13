package com.avi.practice.company.microsoft;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 28/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MyHashMapTest {

    @Test
    public void testUseCase1() {
        /*
         * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
         * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
         * Output
         * [null, null, null, 1, -1, null, 1, null, -1]
         */

        final MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        Assert.assertEquals(1, myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        Assert.assertEquals(-1, myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        Assert.assertEquals(1, myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        Assert.assertEquals(-1, myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}