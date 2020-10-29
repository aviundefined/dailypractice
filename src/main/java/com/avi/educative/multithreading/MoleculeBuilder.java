package com.avi.educative.multithreading;

/**
 * Created by navinash on 28/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MoleculeBuilder {

    private volatile int numHydrogen = 0;
    private volatile int numOxygen = 0;
    private final Object lock = new Object();

    public void hydrogen() throws InterruptedException {
        synchronized (lock) {
            numHydrogen++;
            while (numHydrogen < 2 || numOxygen < 1) {
                lock.wait();
            }
            while (numHydrogen >= 2 && numOxygen >= 1) {
                buildMolecule();
                numHydrogen = numHydrogen - 2;
                numOxygen--;
            }
            lock.notifyAll();
        }

    }

    public void oxygen() throws InterruptedException {
        synchronized (lock) {
            numOxygen++;
            while (numHydrogen < 2 || numOxygen < 1) {
                lock.wait();
            }
            while (numHydrogen >= 2 && numOxygen >= 1) {
                buildMolecule();
                numHydrogen = numHydrogen - 2;
                numOxygen--;
            }
            lock.notifyAll();
        }
    }

    private void buildMolecule() {
        System.out.println(Thread.currentThread().getName() + ": Molecule built: H2O");
    }

}
