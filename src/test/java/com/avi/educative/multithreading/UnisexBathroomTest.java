package com.avi.educative.multithreading;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class UnisexBathroomTest {


    @Test
    public void test() throws InterruptedException {

        final UnisexBathroom unisexBathroom = new UnisexBathroom(3);

        Thread female1 = new Thread(() -> {
            try {
                unisexBathroom.femaleUseBathroom("Lisa");
            } catch (InterruptedException ignored) {

            }
        });

        Thread male1 = new Thread(() -> {
            try {
                unisexBathroom.maleUseBathroom("John");
            } catch (InterruptedException ignored) {

            }
        });

        Thread male2 = new Thread(() -> {
            try {
                unisexBathroom.maleUseBathroom("Bob");
            } catch (InterruptedException ignored) {

            }
        });

        Thread male3 = new Thread(() -> {
            try {
                unisexBathroom.maleUseBathroom("Anil");
            } catch (InterruptedException ignored) {

            }
        });

        Thread male4 = new Thread(() -> {
            try {
                unisexBathroom.maleUseBathroom("Wentao");
            } catch (InterruptedException ignored) {

            }
        });

        female1.start();
        male1.start();
        male2.start();
        male3.start();
        male4.start();

        female1.join();
        male1.join();
        male2.join();
        male3.join();
        male4.join();

    }
}