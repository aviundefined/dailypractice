package com.avi.practice.company.google.course_schedule;

import org.junit.Test;

import java.util.List;

/**
 * Created by navinash on 21/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CourseScheduleAllPossiblesTest {


    @Test
    public void findOrder1() {
        final int numCourses = 6;
        final CourseScheduleAllPossibles solver = new CourseScheduleAllPossibles();
        final int[][] prerequisites = {
                {5, 2},
                {5, 0},
                {4, 0},
                {4, 1},
                {2, 3},
                {3, 1}};
        final List<List<Integer>> allPaths = solver.findOrder(numCourses, prerequisites);
        System.out.println(allPaths);
    }
}