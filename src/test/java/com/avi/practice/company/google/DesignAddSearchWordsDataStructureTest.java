package com.avi.practice.company.google;

import com.avi.practice.company.google.DesignAddSearchWordsDataStructure.WordDictionary;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by navinash on 04/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DesignAddSearchWordsDataStructureTest {

    @Test
    public void testUseCase1() {
        final WordDictionary solver = new WordDictionary();
        solver.addWord("bad");
        solver.addWord("dad");
        solver.addWord("mad");
        assertFalse(solver.search("pad"));
        assertTrue(solver.search("bad"));
        assertTrue(solver.search(".ad"));
        assertTrue(solver.search("b.."));
    }
}