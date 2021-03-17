package com.avi.practice.company.nutanix.practice;

import org.junit.Test;

import java.util.List;


public class StringTransformationTest {

    @Test
    public void convert1() {

        final StringTransformation solver = new StringTransformation();
        final String s1 = "cat";
        final String s2 = "pet";
        final String[] helperArray = {"mat", "dol", "col", "cel", "lot", "dot", "cet", "dat"};
        final List<List<String>> results = solver.convert(s1, s2, helperArray);
        results.forEach(System.out::println);
    }

    @Test
    public void convert2() {
        final StringTransformation solver = new StringTransformation();
        final String s1 = "cat";
        final String s2 = "pet";
        final String[] helperArray = {"sat", "dat"};
        final List<List<String>> results = solver.convert(s1, s2, helperArray);
        results.forEach(System.out::println);
    }

    @Test
    public void convert3() {
        final StringTransformation solver = new StringTransformation();
        final String s1 = "cat";
        final String s2 = "pet";
        final String[] helperArray = {"cat", "pet"};
        final List<List<String>> results = solver.convert(s1, s2, helperArray);
        results.forEach(System.out::println);
    }

    @Test
    public void convert4() {
        final StringTransformation solver = new StringTransformation();
        final String s1 = "cat";
        final String s2 = "pet";
        final String[] helperArray = {"pat", "pet"};
        // {"cat" , "pet", "pat", "pet"};
        // cat -> pat
        // pet -> pat
        // pat -> pet
        final List<List<String>> results = solver.convert(s1, s2, helperArray);
        results.forEach(System.out::println);
    }

    @Test
    public void convert5() {
        final StringTransformation solver = new StringTransformation();
        final String s1 = "cat";
        final String s2 = "pet";
        final String[] helperArray = {"pat", "pet", "peta", "cata"};
        // {"cat" , "pet", "pat", "pet"};
        // cat -> pat
        // pet -> pat
        // pat -> pet
        final List<List<String>> results = solver.convert(s1, s2, helperArray);
        results.forEach(System.out::println);
    }

    @Test
    public void convert6() {
        final StringTransformation solver = new StringTransformation();
        final String s1 = "cat";
        final String s2 = "pet";
        final String[] helperArray = {"mat", "dol", "col", "cel", "lot", "dot", "cet", "dat", "peta", "cata"};
        final List<List<String>> results = solver.convert(s1, s2, helperArray);
        results.forEach(System.out::println);
    }

    @Test
    public void convert7() {
        final StringTransformation solver = new StringTransformation();
        final String s1 = "a";
        final String s2 = "e";
        final String[] helperArray = {"b", "c", "d"};
        final List<List<String>> results = solver.convert(s1, s2, helperArray);
        results.forEach(System.out::println);
    }
}