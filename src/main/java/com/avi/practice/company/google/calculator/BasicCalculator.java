package com.avi.practice.company.google.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by navinash on 10/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BasicCalculator {

    private static final Map<Character, Integer> priority = new HashMap<>();

    static {
        priority.put('/', 10);
        priority.put('*', 10);
        priority.put('+', 5);
        priority.put('-', 5);
        priority.put('(', 1);
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int num = 0;
        final Stack<Integer> operands = new Stack<>();
        final Stack<Character> operators = new Stack<>();
        boolean isNumberInProgress = false;
        int sign = 1;
        for (final char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                isNumberInProgress = true;
            } else {
                if (c == '-' && operands.isEmpty() && !isNumberInProgress) {
                    sign = -1;
                    continue;
                }
                if (isNumberInProgress) {
                    operands.push(sign * num);
                    sign = 1;
                    num = 0;
                    isNumberInProgress = false;
                }
                if (c == '(') {
                    operators.push(c);
                } else if (c == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        final char op = operators.pop();
                        final int right = operands.pop();
                        final int left = operands.pop();
                        final int result = apply(left, right, op);
                        operands.push(result);
                    }
                    operators.pop();
                } else {
                    // get current operator priority
                    final int currPriority = priority.get(c);

                    while (!operators.isEmpty()
                            && operators.peek() != '('
                            && priority.get(operators.peek()) >= currPriority) {
                        // all higher priority
                        final char op = operators.pop();
                        final int right = operands.pop();
                        final int left = operands.pop();
                        final int result = apply(left, right, op);
                        operands.push(result);
                    }
                    operators.push(c);
                }
            }
        }

        if (isNumberInProgress) {
            operands.add(sign * num);
        }
        while (!operators.isEmpty()) {
            final int right = operands.pop();
            final int left = operands.pop();
            final char op = operators.pop();
            final int value = apply(left, right, op);
            operands.push(value);
        }
        return operands.peek();
    }

    private int apply(final int left, final int right, final char op) {
        switch (op) {
            case '*':
                return left * right;
            case '-':
                return left - right;
            case '+':
                return left + right;
            case '/':
                return left / right;
        }

        throw new RuntimeException("Invalid operator: " + op);
    }
}
