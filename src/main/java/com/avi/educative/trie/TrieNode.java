package com.avi.educative.trie;

/**
 * Created by navinash on 22/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class TrieNode {
    private static final int NUM_CHILDREN = 26;
    private final TrieNode[] children = new TrieNode[NUM_CHILDREN];
    private boolean isEndWord = false;

    public boolean isEndWord() {
        return isEndWord;
    }

    public final TrieNode getOrCreateChild(final char c) {
        final int index = index(c);
        if (children[index] == null) {
            final TrieNode child = new TrieNode();
            children[index] = child;
        }
        return children[index];
    }

    public final TrieNode getChild(final char c) {
        return children[index(c)];
    }

    public final void unsetChild(final char c) {
        this.children[index(c)] = null;
    }

    public TrieNode[] getAllChildren() {
        return this.children;
    }

    public final boolean isLeaf() {
        for(final TrieNode node : this.children) {
            if(node != null) {
                return false;
            }
        }
        return true;
    }

    public final void markAsLeaf() {
        this.isEndWord = true;
    }

    public final void unMarkAsLeaf() {
        this.isEndWord = false;
    }

    private static int index(final char c) {
        return c - 'a';
    }

    public static char getChar(final int index) {
        return (char) (index + 'a');
    }
}
