package com.avi.practice.company.google.course_schedule;

import java.util.HashMap;
import java.util.HashSet;
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

    public CourseSchedule3(final String[][] courses) {
        for (final String[] course : courses) {
            graph.addEdge(course[0], course[1]);
        }
    }

    public final Set<String> getAllCourses() {
        return graph.getAllNodes();
    }

    private static final class Graph {
        private final Map<String, Set<String>> adJList = new HashMap<>();
        private final Set<String> allNodes = new HashSet<>();

        private void addEdge(final String src, final String dst) {
            this.adJList.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
            this.allNodes.add(src);
            this.allNodes.add(dst);
        }

        private Set<String> getAllNodes() {
            return this.allNodes;
        }

        private Set<String> getNeighbours(final String node) {
            return this.adJList.getOrDefault(node, new HashSet<>());
        }
    }
}
