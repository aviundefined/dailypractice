package com.avi.practice.leetcode.weeklycontest.num159;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SubfolderRemoverTest {

    @Test
    public void solve() {
        {
            final String[] folders = {};
            CommonUtils.printArr(folders);
            final List<String> expected = Collections.emptyList();
            final List<String> actual = SubfolderRemover.solve(folders);
            System.out.println(actual);
            Assert.assertEquals(expected, actual);
        }
        {
            final String[] folders = {"/a/b"};
            CommonUtils.printArr(folders);
            final List<String> expected = Collections.singletonList("/a/b");
            final List<String> actual = SubfolderRemover.solve(folders);
            System.out.println(actual);
            Assert.assertEquals(expected, actual);
        }
        {
            final String[] folders = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
            CommonUtils.printArr(folders);
            final List<String> expected = Arrays.asList("/a", "/c/d", "/c/f");
            final List<String> actual = SubfolderRemover.solve(folders);
            System.out.println(actual);
            Assert.assertEquals(expected, actual);
        }
        {
            final String[] folders = {"/a/b", "/a", "/c/d", "/c/d/e", "/c/f"};
            CommonUtils.printArr(folders);
            final List<String> expected = Arrays.asList("/a", "/c/d", "/c/f");
            final List<String> actual = SubfolderRemover.solve(folders);
            System.out.println(actual);
            Assert.assertEquals(expected, actual);
        }
        {
            final String[] folders = {"/a", "/a/b/c", "/a/b/d"};
            CommonUtils.printArr(folders);
            final List<String> expected = Collections.singletonList("/a");
            final List<String> actual = SubfolderRemover.solve(folders);
            System.out.println(actual);
            Assert.assertEquals(expected, actual);
        }
        {
            final String[] folders = {"/a/b/c", "/a/b/ca", "/a/b/d"};
            CommonUtils.printArr(folders);
            final List<String> expected = Arrays.asList("/a/b/c", "/a/b/ca", "/a/b/d");
            final List<String> actual = SubfolderRemover.solve(folders);
            System.out.println(actual);
            Assert.assertEquals(expected, actual);
        }
    }
}