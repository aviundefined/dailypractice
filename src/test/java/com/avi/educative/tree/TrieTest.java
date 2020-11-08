package com.avi.educative.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 08/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TrieTest {

    @Test
    public void basic() {

        // Input keys (use only 'a' through 'z' and lower case)
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "abc"};
        String[] output = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys to insert: " + Arrays.toString(keys) + "\n");

        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++) {
            t.insert(keys[i]);
            System.out.println("\"" + keys[i] + "\"" + " Inserted.");
        }

        System.out.println("Total words: " + t.totalWords());
        {
            final List<String> words = t.getWords();
            System.out.println("All words: " + words);
        }

        // Search for different keys
        if (t.search("the")) { System.out.println("the --- " + output[1]); } else {
            System.out.println("the --- " + output[0]);
        }

        if (t.search("these")) { System.out.println("these --- " + output[1]); } else {
            System.out.println("these --- " + output[0]);
        }

        if (t.search("abc")) { System.out.println("abc --- " + output[1]); } else {
            System.out.println("abc --- " + output[0]);
        }


        // Search for different keys and delete if found
        if (t.search("the")) {
            System.out.println("the --- " + output[1]);
            t.delete("the");
            System.out.println("Deleted key \"the\"");
        } else { System.out.println("the --- " + output[0]); }

        if (t.search("these")) {
            System.out.println("these --- " + output[1]);
            t.delete("these");
            System.out.println("Deleted key \"these\"");
        } else { System.out.println("these --- " + output[0]); }

        if (t.search("abc")) {
            System.out.println("abc --- " + output[1]);
            t.delete("abc");
            System.out.println("Deleted key \"abc\"");
        } else { System.out.println("abc --- " + output[0]); }

        // check if the string has deleted correctly or still present
        if (t.search("abc")) { System.out.println("abc --- " + output[1]); } else {
            System.out.println("abc --- " + output[0]);
        }

        if (t.delete("these")) {
            System.out.println("Deleted: \"these\"");
        } else {
            System.out.println("Not found: \"these\"");
        }

        if (t.delete("answer")) {
            System.out.println("Deleted: \"answer\"");
        } else {
            System.out.println("Not found: \"answer\"");
        }

        System.out.println("Total words: " + t.totalWords());

        {
            final List<String> words = t.getWords();
            System.out.println("All words: " + words);
        }

    }
}