package com.avi.educative.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 22/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class Trie {

    private final TrieNode root = new TrieNode();

    /**
     * Insert {@param word} in {@link Trie}
     */
    public final void insert(final String word) {
        if (word == null || "".equals(word.trim())) {
            return;
        }
        // let's insert the
        // start from root if check first char is present of or not. if present then use that else add that
        // set pointer to child
        TrieNode node = root;
        for (final char c : word.toLowerCase().toCharArray()) {
            node = node.getOrCreateChild(c);
        }
        node.markAsLeaf();
    }

    /**
     * Search {@param word} in {@link Trie}
     *
     * @return true is word found in {@link Trie} else false
     */
    public final boolean search(final String word) {
        if (word == null || "".equals(word.trim())) {
            return true;
        }
        // start from the root and check if node exist for each level
        TrieNode node = root;
        for (final char c : word.toLowerCase().toCharArray()) {
            final TrieNode child = node.getChild(c);
            if (child == null) {
                return false;
            }
            node = child;

        }
        return node.isEndWord();
    }

    /**
     * Delete {@param word} from {@link Trie}
     */
    public final void delete(final String word) {
        if (word == null) {
            throw new IllegalArgumentException("Word is null");
        }
        _delete(word, root, 0);
    }

    private boolean _delete(String word, TrieNode node, int level) {
        if (node == null) {
            return false;
        }
        // reached at the level where last character of the word exists
        if (level == word.length()) {
            // if there are no children after this then it can remove itself and send this feedback to it's parent
            // it's parent can do the same if doesn't have any children anymore after delete this node
            if (node.isLeaf()) {
                node = null;
                return true;
            }
            node.unMarkAsLeaf();
            return false;
        }

        final boolean childDeleted = _delete(word, node.getChild(word.charAt(level)), level + 1);
        if (!childDeleted) {
            return false;
        }

        node.unsetChild(word.charAt(level));
        if (node.isEndWord()) {
            return false;
        }
        if (node.isLeaf()) {
            return true;
        }
        return false;
    }

    /**
     * @return Get All the words present in {@link Trie}
     */
    public final List<String> getAllWords() {
        final List<String> words = new ArrayList<>();
        dfs(root, new StringBuilder(), 0, '.', words);
        return words;
    }

    private void dfs(TrieNode node, StringBuilder sb, int level, char c, List<String> words) {
        if (node == null) {
            return;
        }
        sb.append(c);
        if (node.isEndWord()) {
            words.add(sb.toString());
        }
        int i = 0;
        for (final TrieNode child : node.getAllChildren()) {
            if (child != null) {
                final char childChar = TrieNode.getChar(i);
                dfs(child, sb, level + 1, childChar, words);
            }
            i++;
        }
        sb.setLength(level);
    }
}
