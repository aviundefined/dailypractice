package com.avi.educative.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 08/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(final String key) {
        if (key == null || key.trim().length() == 0) {
            throw new IllegalArgumentException("Null or Empty Key insertion is not allowed");
        }

        final char[] chars = key.toLowerCase().toCharArray();
        TrieNode current = root;
        for (final char c : chars) {
            final int index = getIndex(c);
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.markAsLeaf();
    }

    public boolean search(final String key) {
        if (key == null || key.trim().length() == 0) {
            throw new IllegalArgumentException("Key is null or empty");
        }

        final char[] chars = key.toLowerCase().toCharArray();
        TrieNode current = root;
        for (final char c : chars) {
            final int index = getIndex(c);
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndWord;
    }

    public boolean delete(final String key) {
        if (root == null) {
            throw new IllegalArgumentException("Trie is empty");
        }
        if (key == null || key.trim().length() == 0) {
            throw new IllegalArgumentException("Key is null or empty");
        }
        final char[] chars = key.toLowerCase().toCharArray();
        return _delete(root, chars, chars.length, 0);
    }

    private boolean _delete(TrieNode current, char[] chars, int keyLength, int level) {
        if (current == null) {
            return false; // Word not present in trie
        }

        if (keyLength == level) {
            // reached at end
            if (hasNoChildren(current)) {
                current = null;
                return true; // delete self
            } else {
                current.markAsLeaf();
                return false; // delete self not required
            }
        } else {
            final TrieNode child = current.children[getIndex(chars[level])];
            final boolean childDeleted = _delete(child, chars, keyLength, level + 1);
            if (childDeleted) {
                current.children[getIndex(chars[level])] = null;
                if (current.isEndWord) {
                    return false;
                } else if (!hasNoChildren(current)) {
                    return false;
                } else {
                    current = null;
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    public int totalWords() {
        if (root == null) {
            return 0;
        }
        return _totalWords(root);
    }

    public List<String> getWords() {
        if (root == null) {
            return Collections.emptyList();
        }

        final List<String> words = new ArrayList<>();
        final List<Character> chars = new ArrayList<>();
        _getWords(root, 0, words, chars);
        return words;
    }

    private void _getWords(final TrieNode current, final int level, final List<String> words, final List<Character> chars) {
        if (current.isEndWord) {
            // found the word
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < level; i++) {
                word.append(chars.get(i));
            }
            words.add(word.toString());
        }
        int i = 0;
        for (final TrieNode child : current.children) {
            if (child != null) {
                chars.add(level, (char) (i + 'a'));
                _getWords(child, level + 1, words, chars);
            }
            i++;
        }
    }

    private int _totalWords(TrieNode current) {
        int count = 0;
        if (current.isEndWord) {
            count++;
        }
        for (final TrieNode node : current.children) {
            if (node != null) {
                count += _totalWords(node);
            }
        }
        return count;
    }

    private boolean hasNoChildren(final TrieNode node) {
        for (final TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    private static int getIndex(final char c) {
        return c - 'a';
    }
}
