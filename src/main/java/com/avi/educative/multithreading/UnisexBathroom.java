package com.avi.educative.multithreading;

import com.avi.educative.multithreading.semaphore.CountingSemaphore;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class UnisexBathroom {

    final long BATHROOM_USE_TIME = 2 * 1000L;
    private final Object lock = new Object();
    private volatile int numEmployeesInBathroom;
    private final int maxAllowedEmployeesInBathroom;
    private final CountingSemaphore semaphore;

    public UnisexBathroom(int maxAllowedEmployeesInBathroom) {
        this.maxAllowedEmployeesInBathroom = maxAllowedEmployeesInBathroom;
        this.semaphore = new CountingSemaphore(maxAllowedEmployeesInBathroom);
    }

    private enum Gender {
        MALE,
        FEMALE,
        NONE
    }

    private Gender inUsedBy = Gender.NONE;

    public void maleUseBathroom(final String name) throws InterruptedException {
        synchronized (lock) {
            while (inUsedBy == Gender.FEMALE) {
                lock.wait();
            }
            semaphore.acquire();
            inUsedBy = Gender.MALE;
            numEmployeesInBathroom++;
        }

        useBathroom(name);
        semaphore.release();
        synchronized (lock) {
            numEmployeesInBathroom--;
            if (numEmployeesInBathroom == 0) {
                inUsedBy = Gender.NONE;
            }
            lock.notifyAll();
        }
    }

    public void femaleUseBathroom(final String name) throws InterruptedException {
        synchronized (lock) {
            while (inUsedBy == Gender.MALE) {
                lock.wait();
            }
            semaphore.acquire();
            inUsedBy = Gender.FEMALE;
            numEmployeesInBathroom++;
        }

        useBathroom(name);
        semaphore.release();
        synchronized (lock) {
            numEmployeesInBathroom--;
            if (numEmployeesInBathroom == 0) {
                inUsedBy = Gender.NONE;
            }
            lock.notifyAll();
        }
    }

    private void useBathroom(final String name) throws InterruptedException {
        System.out.println(name + " is using a bathroom");
        Thread.sleep(BATHROOM_USE_TIME);
        System.out.println(name + " is done using a bathroom");
    }
}
