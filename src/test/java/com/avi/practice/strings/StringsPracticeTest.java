package com.avi.practice.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 11/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 *    -- VMware Confidential
 */
public class StringsPracticeTest {

    @Test
    public void maximumLengthSubstringWithNoDuplicates() {
        {
            final String str = "thisisteststring";
            final String expected = "string";
            final String subStr = StringsPractice.maximumLengthSubstringWithNoDuplicates(str);
            Assert.assertEquals(str, expected, subStr);
        }
        {
            final String str = "this is test string";
            final String expected = " string";
            final String subStr = StringsPractice.maximumLengthSubstringWithNoDuplicates(str);
            Assert.assertEquals(str, expected, subStr);
        }
        {
            final String str = "i like to drink tea";
            final String expected = "drink tea";
            final String subStr = StringsPractice.maximumLengthSubstringWithNoDuplicates(str);
            Assert.assertEquals(str, expected, subStr);
        }

    }
}
