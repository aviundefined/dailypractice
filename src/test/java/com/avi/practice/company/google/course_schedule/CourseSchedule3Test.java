package com.avi.practice.company.google.course_schedule;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by navinash on 22/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CourseSchedule3Test {

    @Test
    public void getAllCourses() {
        final String[][] courses = getInput1();
        final CourseSchedule3 solver = new CourseSchedule3(courses);
        final Set<String> expected = new HashSet<>(Arrays.asList("Data Structures", "Networking", "Creative Writing", "Databases"));
        final Set<String> actual = solver.getMidTermCourses();
        Assert.assertEquals(expected, actual);
    }

    private static String[][] getInput1() {
        return new String[][]{
                {"Logic", "COBOL"},
                {"Data Structures", "Algorithms"},
                {"Creative Writing", "Data Structures"},
                {"Algorithms", "COBOL"},
                {"Intro to Computer Science", "Data Structures"},
                {"Logic", "Compilers"},
                {"Data Structures", "Logic"},
                {"Graphics", "Networking"},
                {"Networking", "Algorithms"},
                {"Creative Writing", "System Administration"},
                {"Databases", "System Administration"},
                {"Creative Writing", "Databases"},
                {"Intro to Computer Science", "Graphics"},
        };
    }
}