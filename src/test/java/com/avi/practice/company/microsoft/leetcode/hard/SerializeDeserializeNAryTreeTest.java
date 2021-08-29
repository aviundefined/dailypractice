package com.avi.practice.company.microsoft.leetcode.hard;

import com.avi.practice.company.microsoft.leetcode.hard.SerializeDeserializeNAryTree.Node;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;

/**
 * Created by navinash on 27/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SerializeDeserializeNAryTreeTest extends TestCase {

    private static Node getTree1() {
        final Node root = new Node(10, new ArrayList<>());
        final Node child20 = new Node(20, new ArrayList<>());
        final Node child30 = new Node(30, new ArrayList<>());
        final Node child40 = new Node(40, new ArrayList<>());
        final Node child50 = new Node(50, new ArrayList<>());
        final Node child60 = new Node(60, new ArrayList<>());
        final Node child70 = new Node(70, new ArrayList<>());
        final Node child80 = new Node(80, new ArrayList<>());
        final Node child90 = new Node(90, new ArrayList<>());
        final Node child100 = new Node(100, new ArrayList<>());
        final Node child110 = new Node(110, new ArrayList<>());
        final Node child120 = new Node(120, new ArrayList<>());
        root.children.add(child20);
        root.children.add(child30);
        root.children.add(child40);
        child20.children.add(child50);
        child20.children.add(child60);
        child30.children.add(child70);
        child30.children.add(child80);
        child30.children.add(child90);
        child40.children.add(child100);
        child80.children.add(child110);
        child80.children.add(child120);
        return root;
    }

    private static Node getTree2() {
        final Node root = new Node(1, new ArrayList<>());
        final Node child3 = new Node(3, new ArrayList<>());
        final Node child2 = new Node(2, new ArrayList<>());
        final Node child4 = new Node(4, new ArrayList<>());
        final Node child5 = new Node(5, new ArrayList<>());
        final Node child6 = new Node(6, new ArrayList<>());

        root.children.add(child3);
        root.children.add(child2);
        root.children.add(child4);
        child3.children.add(child5);
        child3.children.add(child6);

        return root;
    }

    public void test1() {
        final Node node = getTree1();
        final SerializeDeserializeNAryTree solver = new SerializeDeserializeNAryTree();
        final String serialize = solver.serialize(node);
        System.out.println(serialize);
        final Node deserialize = solver.deserialize(serialize);
        final String reSerialized = solver.serialize(deserialize);
        System.out.println(reSerialized);
        Assert.assertEquals(serialize, reSerialized);
        Assert.assertEquals(node, deserialize);
    }

    public void test2() {
        final Node node = getTree2();
        final SerializeDeserializeNAryTree solver = new SerializeDeserializeNAryTree();
        final String serialize = solver.serialize(node);
        System.out.println(serialize);
        final Node deserialize = solver.deserialize(serialize);
        final String reSerialized = solver.serialize(deserialize);
        System.out.println(reSerialized);
        Assert.assertEquals(serialize, reSerialized);
        Assert.assertEquals(node, deserialize);
    }


}