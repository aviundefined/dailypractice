package com.avi.educative.trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
        trie.insert("as");
        trie.insert("answer");
        trie.insert("bat");
        trie.insert("ball");
        trie.insert("bowler");
        trie.insert("bowl");

        Assert.assertTrue("the", trie.search("the"));
        Assert.assertTrue("and", trie.search("and"));
        Assert.assertTrue("their", trie.search("their"));
        Assert.assertTrue("an", trie.search("an"));
        Assert.assertTrue("as", trie.search("as"));
        Assert.assertTrue("answer", trie.search("answer"));
        Assert.assertTrue("bat", trie.search("bat"));
        Assert.assertTrue("ball", trie.search("ball"));
        Assert.assertTrue("bowl", trie.search("bowl"));
        Assert.assertTrue("bowler", trie.search("bowler"));

        Assert.assertFalse("they", trie.search("they"));
        Assert.assertFalse("them", trie.search("them"));
        Assert.assertFalse("a", trie.search("a"));
        Assert.assertFalse("bad", trie.search("bad"));

        {
            final List<String> allWords = trie.getAllWords();
            System.out.println(allWords);
        }


        trie.delete("their");
        Assert.assertFalse("their", trie.search("their"));
        trie.delete("an");

        {
            final List<String> allWords = trie.getAllWords();
            System.out.println(allWords);
        }

    }
}