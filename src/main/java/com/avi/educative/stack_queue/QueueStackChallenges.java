package com.avi.educative.stack_queue;

/**
 * Created by navinash on 04/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class QueueStackChallenges {

    public void reverseFirstK(final Queue<Integer> q, final int k) {

        final Stack<Integer> s = new Stack<>(k);
        while (!s.isFull()) {
            s.push(q.dequeue());
        }

        while (!s.isEmpty()) {
            q.enqueue(s.pop());
        }

        for (int i = 0; i < q.getMaxSize() - k; i++) {
            q.enqueue(q.dequeue());
        }
    }

    public int[] getNextGreaterNumber(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        final int[] result = new int[arr.length];
        final Stack<Integer> s = new Stack<>(arr.length);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.top() <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = s.top();
            }
            s.push(arr[i]);
        }
        return result;
    }

    public static int evaluatePostFix(final String expression) {
        if (expression == null || expression.isEmpty() || expression.trim().equals("")) {
            return Integer.MIN_VALUE;
        }
        final char[] chars = expression.toCharArray();
        final Stack<Integer> numbers = new Stack<>(expression.length());
        for (final char c : chars) {
            if (isDigit(c)) {
                numbers.push(Integer.parseInt(String.valueOf(c)));
                continue;
            }
            if (numbers.getCurrentSize() == 1) {
                break;
            }
            final Operator op = Operator.get(c);
            final int firstNumber = numbers.pop();
            final int secondNumber = numbers.pop();

            switch (op) {
                case PLUS:
                    numbers.push(secondNumber + firstNumber);
                    break;
                case MINUS:
                    numbers.push(secondNumber - firstNumber);
                    break;
                case MULTIPLY:
                    numbers.push(secondNumber * firstNumber);
                    break;
                case DIVIDE:
                    numbers.push(secondNumber / firstNumber);
                    break;
                default:
                    throw new IllegalArgumentException("Operation not supported: " + op);
            }

        }
        return numbers.pop();
    }

    private enum Operator {
        PLUS('+'),
        MINUS('-'),
        MULTIPLY('*'),
        DIVIDE('/');
        private final char value;

        Operator(final char value) {
            this.value = value;
        }

        private static Operator get(final char c) {
            final Operator[] values = Operator.values();
            for (final Operator op : values) {
                if (op.value == c) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Value not supported: " + c);
        }
    }

    private static boolean isDigit(final char c) {
        return c >= '0' && c <= '9';
    }
}
