package com.avi.educative.linkedlist;

/**
 * Created by navinash on 15/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class Node<T> {

    private final T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(final T data) {
        this.data = data;
    }

    public final T getData() {
        return data;
    }

    public final Node<T> getNext() {
        return next;
    }

    public final void setNext(Node<T> next) {
        this.next = next;
    }

    public final Node<T> getPrev() {
        return prev;
    }

    public final void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}
