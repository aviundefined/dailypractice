package com.avi.practice.company.google;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 01/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AlphabetBoardPathTest {

    @Test
    public void alphabetBoardPath1() {
        final AlphabetBoardPath solver =new AlphabetBoardPath();
        final String target  = "leet";
        final String actual = solver.alphabetBoardPath(target);
        System.out.println(actual);
    }

    @Test
    public void alphabetBoardPath2() {
        final AlphabetBoardPath solver =new AlphabetBoardPath();
        final String target  = "j";
        final String actual = solver.alphabetBoardPath(target);
        System.out.println(actual);
    }
}