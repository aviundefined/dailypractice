package com.avi.pepcoding.backtracking;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 25/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CrosswordTest {
    private static final Crossword solver = new Crossword();

    @Test
    public void solve1() {
        final char[][] board = {
                {'-', '-', '-'},
                {'-', '+', '+'},
                {'-', '+', '+'},
        };
        final String[] words = {"and", "ant"};
        solver.solve(board, words);
    }
}