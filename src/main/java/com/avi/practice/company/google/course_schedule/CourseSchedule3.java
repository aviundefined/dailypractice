package com.avi.practice.company.google.course_schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * /*
 * Students may decide to take different "tracks" or sequences of courses in the Computer Science curriculum. There may be more than one track that includes the same course, but each student follows a single linear track from a "root" node to a "leaf" node. In the graph below, their path always moves left to right.
 * <p>
 * Write a function that takes a list of (source, destination) pairs, and returns the name of all of the courses that the students could be taking when they are halfway through their track of courses.
 * Sample input 1:
 * all_courses_1 = [
 * ["Logic", "COBOL"],
 * ["Data Structures", "Algorithms"],
 * ["Creative Writing", "Data Structures"],
 * ["Algorithms", "COBOL"],
 * ["Intro to Computer Science", "Data Structures"],
 * ["Logic", "Compilers"],
 * ["Data Structures", "Logic"],
 * ["Graphics", "Networking"],
 * ["Networking", "Algorithms"],
 * ["Creative Writing", "System Administration"],
 * ["Databases", "System Administration"],
 * ["Creative Writing", "Databases"],
 * ["Intro to Computer Science", "Graphics"],
 * ]
 * <p>
 * Sample output 1 (in any order):
 * ["Data Structures", "Networking", "Creative Writing", "Databases"]
 * <p>
 * All paths through the curriculum (midpoint *highlighted*):
 * <p>
 * Intro to C.S. -> Graphics -> *Networking* -> Algorithms -> Cobol
 * Intro to C.S. -> *Data Structures* -> Algorithms -> COBOL
 * Intro to C.S. -> *Data Structures* -> Logic -> COBOL
 * Intro to C.S. -> *Data Structures* -> Logic -> Compiler
 * Creative Writing -> *Databases* -> System Administration
 * *Creative Writing* -> System Administration
 * Creative Writing -> *Data Structures* -> Algorithms -> COBOL
 * Creative Writing -> *Data Structures* -> Logic -> COBOL
 * Creative Writing -> *Data Structures* -> Logic -> Compilers
 * <p>
 * Visual representation:
 * <p>
 * ____________    ______________
 * |          |    |            |
 * | Graphics |    | Networking |
 * ---->|__________|--->|____________|
 * |                       |
 * |                       |
 * |                       |  ______________
 * ____________   |                       |  |            |
 * |          |   |    ______________     >->| Algorithms |--\     _____________
 * | Intro to |   |    |            |    /   |____________|   \    |           |
 * | C.S.     |---+    | Data       |   /                      >-->| COBOL     |
 * |__________|    \   | Structures |--+     ______________   /    |___________|
 * >->|____________|   \    |            |  /
 * ____________    /                     \-->| Logic      |-+      _____________
 * |          |   /    ______________        |____________|  \     |           |
 * | Creative |  /     |            |                         \--->| Compilers |
 * | Writing  |-+----->| Databases  |                              |___________|
 * |__________|  \     |____________|-\     _________________________
 * \                    \    |                       |
 * \--------------------+-->| System Administration |
 * |_______________________|
 * <p>
 * Sample input 2:
 * all_courses_2 = [
 * ["Course_3", "Course_7"],
 * ["Course_0", "Course_1"],
 * ["Course_1", "Course_2"],
 * ["Course_2", "Course_3"],
 * ["Course_3", "Course_4"],
 * ["Course_4", "Course_5"],
 * ["Course_5", "Course_6"],
 * ]
 * Sample output 2 (in any order):
 * ["Course_2", "Course_3"]
 */
public class CourseSchedule3 {

    private final Graph graph = new Graph();
    private final List<List<String>> allPaths = new ArrayList<>();
    private final Set<String> visited = new HashSet<>();

    public CourseSchedule3(final String[][] courses) {
        for (final String[] course : courses) {
            graph.addEdge(course[0], course[1]);
        }
    }

    public Set<String> getMidTermCourses() {
        final Set<String> midTermCourses = new HashSet<>();
        getAllPaths(new ArrayList<>());
        printAllPaths();
        for (final List<String> path : allPaths) {
            final int mid = path.size() / 2;
            midTermCourses.add(path.get(mid));
        }
        return midTermCourses;
    }

    private void printAllPaths() {
        int i = 1;
        for (final List<String> path : allPaths) {
            System.out.printf("------ %s ------", i);
            System.out.println(path);
            i++;
        }
    }

    private void getAllPaths(final List<String> curr) {

        for (final String course : graph.getAllNodes()) {
            if (visited.contains(course) || graph.inDegree(course) != 0) {
                continue;
            }
            visited.add(course);
            curr.add(course);
            for (final String nextCourse : graph.getNeighbours(course)) {
                graph.decInDegree(nextCourse);
            }

            getAllPaths(curr);

            visited.remove(course);
            curr.remove(curr.size() - 1);
            for (final String nextCourse : graph.getNeighbours(course)) {
                graph.incInDegree(nextCourse);
            }
        }

        if (curr.size() == graph.getAllNodes().size()) {
            allPaths.add(new ArrayList<>(curr));
        }
    }

    private static final class Graph {
        private final Map<String, Set<String>> adJList = new HashMap<>();
        private final Set<String> allNodes = new HashSet<>();
        private final Map<String, Integer> inDegrees = new HashMap<>();

        private void addEdge(final String src, final String dst) {
            this.adJList.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
            this.allNodes.add(src);
            this.allNodes.add(dst);

            this.inDegrees.compute(dst, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return 1 + v;
            });
        }

        private int inDegree(final String node) {
            return this.inDegrees.getOrDefault(node, 0);
        }

        private void incInDegree(final String node) {
            this.inDegrees.compute(node, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return 1 + v;
            });
        }

        private void decInDegree(final String node) {
            final int degree = inDegree(node);
            if (degree > 0) {
                this.inDegrees.put(node, degree - 1);
            }
        }

        private Set<String> getAllNodes() {
            return this.allNodes;
        }

        private Set<String> getNeighbours(final String node) {
            return this.adJList.getOrDefault(node, new HashSet<>());
        }
    }
}
