package com.avi.educative.trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 22/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TrieTest {

    @Test
    public void insertAndSearch() {
        final String[] words = {"the", "and", "their", "an", "as", "answer", "bat", "ball", "bowler", "bowl"};
        final Trie trie = build(words);
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
            System.out.println("---------------");
        }


        trie.delete("their");
        Assert.assertFalse("their", trie.search("their"));
        trie.delete("an");

        {
            final List<String> allWords = trie.getAllWords();
            System.out.println(allWords);
            System.out.println("---------------");
        }

    }

    @Test
    public void suggestions1() {
        final int max = 3;
        final String[] words = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        final Trie trie = build(words);
        final String searchWord = "mouse";
        final List<List<String>> allSuggestions = trie.allSuggestions(searchWord, max);
        for(final List<String> suggestions : allSuggestions) {
            System.out.println(suggestions);
        }
        System.out.println("---------------");
    }

    @Test
    public void suggestions2() {
        final int max = 3;
        final String[] words = {"havana"};
        final Trie trie = build(words);
        final String searchWord = "havana";
        final List<List<String>> allSuggestions = trie.allSuggestions(searchWord, max);
        for(final List<String> suggestions : allSuggestions) {
            System.out.println(suggestions);
        }
        System.out.println("---------------");
    }

    @Test
    public void suggestions3() {
        final int max = 3;
        final String[] words = {"bags","baggage","banner","box","cloths"};
        final Trie trie = build(words);
        final String searchWord = "bags";
        final List<List<String>> allSuggestions = trie.allSuggestions(searchWord, max);
        for(final List<String> suggestions : allSuggestions) {
            System.out.println(suggestions);
        }
        System.out.println("---------------");
    }

    @Test
    public void suggestions4() {
        final int max = 3;
        final String[] words = {"havana"};
        final Trie trie = build(words);
        final String searchWord = "tatiana";
        final List<List<String>> allSuggestions = trie.allSuggestions(searchWord, max);
        for(final List<String> suggestions : allSuggestions) {
            System.out.println(suggestions);
        }
        System.out.println("---------------");
    }

    private Trie build(final String[] words) {
        return build(Arrays.asList(words));
    }

    private Trie build(final List<String> words) {
        final Trie trie = new Trie();
        for (final String word : words) {
            trie.insert(word);
        }
        return trie;
    }
}