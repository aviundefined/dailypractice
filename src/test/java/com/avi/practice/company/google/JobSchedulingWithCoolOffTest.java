package com.avi.practice.company.google;

import junit.framework.TestCase;

/**
 * Created by navinash on 31/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JobSchedulingWithCoolOffTest extends TestCase {

    public void testSchedule1() {
        final JobSchedulingWithCoolOff solver = new JobSchedulingWithCoolOff();
        final String jobs = "aaacc";
        final int coolOff = 1;
        final String schedule = solver.schedule(jobs, coolOff);
        System.out.println(schedule);
    }


    public void testSchedule2() {
        final JobSchedulingWithCoolOff solver = new JobSchedulingWithCoolOff();
        final String jobs = "aaacc";
        final int coolOff = 2;
        final String schedule = solver.schedule(jobs, coolOff);
        System.out.println(schedule);
    }

    public void testSchedule3() {
        final JobSchedulingWithCoolOff solver = new JobSchedulingWithCoolOff();
        final String jobs = "aaaaaabccaghaaiijkartyugjbbcfgt";
        final int coolOff = 3;
        final String schedule = solver.schedule(jobs, coolOff);
        System.out.println(schedule);
    }
}