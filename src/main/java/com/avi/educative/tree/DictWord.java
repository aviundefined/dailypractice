package com.avi.educative.tree;

import java.util.Arrays;

/**
 * Created by navinash on 08/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DictWord {

    public static boolean isFormationPossible(String[] dict, String word) {
        if (word.length() < 2 || dict.length < 2) {
            return false;
        }

        final Trie trie = new Trie();
        for (final String s : dict) {
            trie.insert(s);
        }

        System.out.println("All Words: " + trie.getWords());
        final int n = word.length();
        for (int i = 0; i < n; i++) {
            final String first = word.substring(0, i);
            final String second = word.substring(i, n);
            if(first.length() > 0 && second.length() > 0) {
                if (trie.search(first) && trie.search(second)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Input dict (use only 'a' through 'z' and lower case)
        String[] dict = {"the", "hello", "there", "answer", "any", "dragon", "world", "their", "inc"};


        System.out.println("Keys: " + Arrays.toString(dict));

        if (isFormationPossible(dict, "helloworld")) { System.out.println("true"); } else {
            System.out.println("false");
        }
    }

}
