package com.avi.educative.multithreading;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 29/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MoleculeBuilderTest {

    @Test
    public void test() throws Exception {
        final MoleculeBuilder builder = new MoleculeBuilder();
        final Thread[] hydrogens = new Thread[30];
        final Thread[] oxygens = new Thread[10];
        for (int i = 0; i < hydrogens.length; i++) {
            final String name = "hydrogen-" + i;
            hydrogens[i] = new Thread(() -> {
                try {
                    builder.hydrogen();
                } catch (InterruptedException ignored) {
                }
            });
            hydrogens[i].setName(name);
        }

        for (int i = 0; i < oxygens.length; i++) {
            final String name = "oxygen-" + i;
            oxygens[i] = new Thread(() -> {
                try {
                    builder.oxygen();
                } catch (InterruptedException ignored) {
                }
            });
            oxygens[i].setName(name);
        }

        for (final Thread oxygen : oxygens) {
            oxygen.start();
        }
        for (final Thread hydrogen : hydrogens) {
            hydrogen.start();
        }
        for (final Thread hydrogen : hydrogens) {
            hydrogen.join();
        }
        for (final Thread oxygen : oxygens) {
            oxygen.join();
        }
    }
}