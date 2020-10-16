package com.avi.educative.linkedlist;

/**
 * Created by navinash on 15/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class SinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public final Node<T> getHead() {
        return head;
    }

    public final void setHead(Node<T> head) {
        this.head = head;
    }

    public final int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public final boolean isEmpty() {
        return head == null;
    }

    public final void insertAtHead(final T data) {
        final Node<T> node = new Node<>(data);
        if (this.head != null) {
            node.setNext(this.head);
        }
        this.head = node;
        this.size++;
    }

    public final void insertAtEnd(final T data) {
        final Node<T> node = new Node<>(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node<T> last = null;
            Node<T> n = head;
            while (n != null) {
                last = n;
                n = n.getNext();
            }
            last.setNext(node);
        }
        this.size++;
    }

    public final void insertAfter(final T data, final T after) {
        Node<T> n = this.head;
        while (n != null) {
            if (after.equals(n.getData())) {
                final Node<T> node = new Node<>(data);
                node.setNext(n.getNext());
                n.setNext(node);
                this.size++;
                return;
            }
            n = n.getNext();
        }
        throw new IllegalArgumentException("No node found with value: " + after);
    }

    public final boolean searchNode(final T data) {
        if (isEmpty()) {
            return false;
        }

        Node<T> n = this.head;
        while (n != null) {
            if (data.equals(n.getData())) {
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    public final void deleteAtHead() {
        if (isEmpty()) {
            return;
        }
        this.head = head.getNext();
        this.size--;
    }

    public final void deleteAtEnd() {
        if (isEmpty()) {
            return;
        }
        // Only one element
        if (this.head.getNext() == null) {
            this.head = null;
            this.size--;
            return;
        }
        Node<T> secondLast = head;
        Node<T> last = head.getNext();
        while (last.getNext() != null) {
            secondLast = last;
            last = last.getNext();
        }

        secondLast.setNext(null);
        this.size--;
    }

    public final void deleteByValue(final T data) {
       // Base cases:
        // 1. List is empty
        if (isEmpty()) {
            return;
        }

        // 2. Head matched with the value
        if (this.head.getData().equals(data)) {
            this.head = this.head.getNext();
            this.size--;
            return;
        }

        Node<T> prevNode = head;
        Node<T> currNode = head.getNext();
        while (currNode != null) {
            if (currNode.getData().equals(data)) {
                prevNode.setNext(currNode.getNext());
                this.size--;
                break;
            }
            prevNode = currNode;
            currNode = currNode.getNext();
        }
    }

    public final void print() {
        Node<T> n = head;
        while (n != null) {
            System.out.print(n.getData() + ",");
            n = n.getNext();
        }
        System.out.println();
    }
}
