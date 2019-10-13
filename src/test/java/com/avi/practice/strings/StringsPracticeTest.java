package com.avi.practice.strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by navinash on 11/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
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

    @Test
    public void getSentence() {
        {
            final String str = "thisisteststring";
            final String expected = "this is test string";
            final String sentence = StringsPractice.getSentence(str);
            Assert.assertEquals(str, expected, sentence);
        }
        {
            final String str = "thehappydogwenttotheparkonasunnyday";
            final String expected = "the happy dog went to the park on a sunny day";
            final String sentence = StringsPractice.getSentence(str);
            Assert.assertEquals(str, expected, sentence);
        }
    }

    @Test
    public void splitSentence() {
        {
            final String str = "thehappydogwenttotheparkonasunnyday";
            final String expected = "the happy dog went to the park on a sunny day";
            final int numOfSentences = 1;
            final List<String> sentences = StringsPractice.splitSentence(str);
            System.out.println(sentences);
         //   Assert.assertEquals(str, numOfSentences, sentences.size());
           // Assert.assertEquals(str, expected, sentences.get(0));
        }
        {
            final String str = "thisisteststring";
            final String expected = "this is test string";
            final int numOfSentences = 1;
            final List<String> sentences = StringsPractice.splitSentence(str);
            System.out.println(sentences);
       //     Assert.assertEquals(str, numOfSentences, sentences.size());
         //   Assert.assertEquals(str, expected, sentences.get(0));
        }
    }
}
