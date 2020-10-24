package com.avi.educative.linkedlist;

/**
 * Created by navinash on 16/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DoublyLinkedList<T> {
    private Node<T> head;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void insertAtHead(final T data) {
        final Node<T> node = new Node<>(data);
        if (!isEmpty()) {
            node.setNext(this.head);
            this.head.setPrev(node);
        }
        this.head = node;
        this.size++;
    }

    public boolean searchNode(final T data) {
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

    public void deleteByValue(final T data) {
        if (isEmpty()) {
            return;
        }

        if (this.head.getData().equals(data)) {
            this.head = this.head.getNext();
            this.head.setPrev(null);
            this.size--;
        }

        Node<T> currNode = this.head;
        while (currNode != null) {
            if (currNode.getData().equals(data)) {
                final Node<T> prevNode = currNode.getPrev();
                final Node<T> nextNode = currNode.getNext();
                prevNode.setNext(nextNode);
                nextNode.setPrev(prevNode);
                this.size--;
                break;
            }
            currNode = currNode.getNext();
        }
    }

    public void print() {
        Node<T> n = head;
        while (n != null) {
            System.out.print(n.getData() + ",");
            n = n.getNext();
        }
        System.out.println();
    }
}
