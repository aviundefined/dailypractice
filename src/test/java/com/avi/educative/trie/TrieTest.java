package com.avi.educative.trie;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 22/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TrieTest {

    @Test
    public void insertAndSearch() {
        final Trie trie = new Trie();
        trie.insert("the");
        trie.insert("and");
        trie.insert("their");
        trie.insert("an");
        trie.insert("answer");

        Assert.assertTrue("the", trie.search("the"));
        Assert.assertTrue("and", trie.search("and"));
        Assert.assertTrue("their", trie.search("their"));
        Assert.assertTrue("an", trie.search("an"));
        Assert.assertTrue("answer", trie.search("answer"));

        Assert.assertFalse("they", trie.search("they"));
        Assert.assertFalse("them", trie.search("them"));
        Assert.assertFalse("a", trie.search("a"));
        Assert.assertFalse("as", trie.search("as"));
        Assert.assertFalse("bad", trie.search("bad"));

        trie.delete("their");
        Assert.assertFalse("their", trie.search("their"));
        trie.delete("an");
        Assert.assertFalse("an", trie.search("an"));
    }
}