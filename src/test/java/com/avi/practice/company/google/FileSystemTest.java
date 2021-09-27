package com.avi.practice.company.google;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 27/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FileSystemTest {

    @Test
    public void test1() {
        /*
         *["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
         * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
         * [null,[],null,null,[""],"hello"]
         * [null,[],null,null,["a"],"hello"]
         */
        final FileSystem fs = new FileSystem();
        {
            final String path = "/";
            final List<String> expected = new ArrayList<>();
            final List<String> actual = fs.ls(path);
            Assert.assertEquals(path, expected, actual);
        }
        {
            final String path = "/a/b/c";
            fs.mkdir(path);
        }
        {
            final String path = "/a/b/c/d";
            final String content = "hello";
            fs.addContentToFile(path, content);
        }
        {
            final String path = "/";
            final List<String> expected = new ArrayList<>();
            expected.add("a");
            final List<String> actual = fs.ls(path);
            Assert.assertEquals(path, expected, actual);
        }
        {
            final String path = "/a/b/c/d";
            final String expected = "hello";
            final String actual = fs.readContentFromFile(path);
            Assert.assertEquals(path, expected, actual);
        }
    }

    @Test
    public void test2() {

        final FileSystem fs = new FileSystem();
        {
            final String path = "/";
            final List<String> expected = new ArrayList<>();
            final List<String> actual = fs.ls(path);
            Assert.assertEquals(path, expected, actual);
        }
        {
            final String path = "/a/b/c";
            fs.mkdir(path);
        }
        {
            final String path = "/a/b/c/d";
            final String content = "hello world";
            fs.addContentToFile(path, content);
        }
        {
            final String path = "/";
            final List<String> expected = new ArrayList<>();
            expected.add("a");
            final List<String> actual = fs.ls(path);
            Assert.assertEquals(path, expected, actual);
        }
        {
            final String path = "/a/b/c/d";
            final String expected = "hello world";
            final String actual = fs.readContentFromFile(path);
            Assert.assertEquals(path, expected, actual);
        }
        {
            final String path = "/a/b/c/d";
            final String content = " hello hello world";
            fs.addContentToFile(path, content);
        }
        {
            final String path = "/a/b/c/d";
            final String expected = "hello world hello hello world";
            final String actual = fs.readContentFromFile(path);
            Assert.assertEquals(path, expected, actual);
        }
        {
            final String path = "/a/b/c/dddd";
            final String content = "winstons";
            fs.addContentToFile(path, content);
        }
        {
            final String path = "/a/b/c";
            final List<String> expected = new ArrayList<>();
            expected.add("d");
            expected.add("dddd");
            final List<String> actual = fs.ls(path);
            Assert.assertEquals(path, expected, actual);
        }
        {
            final String path = "/a/b/c/dddd";
            final String expected = "winstons";
            final String actual = fs.readContentFromFile(path);
            Assert.assertEquals(path, expected, actual);
        }

    }
}