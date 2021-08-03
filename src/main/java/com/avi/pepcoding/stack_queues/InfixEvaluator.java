package com.avi.pepcoding.stack_queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by navinash on 03/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class InfixEvaluator {

    private static final Map<Character, Integer> operatorPriority = new HashMap<>();

    static {
        operatorPriority.put('*', 10);
        operatorPriority.put('/', 10);
        operatorPriority.put('+', 5);
        operatorPriority.put('-', 5);
    }

    public int evaluate(final String expression) {
        if (expression == null || expression.length() == 0 || "".equals(expression.trim())) {
            return 0;
        }
        final Stack<Integer> nums = new Stack<>();
        final Stack<Character> operator = new Stack<>();
        int num = 0;
        boolean isNumProgress = false;
        for (final char c : expression.toCharArray()) {
            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                isNumProgress = true;
                continue;
            }
            if (!Character.isDigit(c) && isNumProgress) {
                nums.push(num); // push the current value in nums stack
                num = 0; // start new number
                isNumProgress = false;
            }

            if (c == '(') {
                operator.push(c);
            } else if (c == ')') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    final int rightValue = nums.pop();
                    final int leftValue = nums.pop();
                    final char op = operator.pop();
                    final int value = apply(leftValue, rightValue, op);
                    nums.push(value);
                }
                operator.pop();
            } else if (operatorPriority.containsKey(c)) {
                while (!operator.isEmpty()
                        && operator.peek() != ')'
                        && operatorPriority.get(c) <= operatorPriority.getOrDefault(operator.peek(), 0)) {
                    final char op = operator.pop();
                    final int rightValue = nums.pop();
                    final int leftValue = nums.pop();
                    final int value = apply(leftValue, rightValue, op);
                    nums.push(value);
                }
                operator.push(c);
            }
        }
        while (!operator.isEmpty()) {
            final int rightValue = nums.pop();
            final int leftValue = nums.pop();
            final char op = operator.pop();
            final int value = apply(leftValue, rightValue, op);
            nums.push(value);
        }
        return nums.peek();
    }

    private int apply(int leftValue, int rightValue, char op) {

        switch (op) {
            case '+':
                return leftValue + rightValue;
            case '-':
                return leftValue - rightValue;
            case '*':
                return leftValue * rightValue;
            case '/':
                return leftValue / rightValue;
            default:
                return 0;
        }
    }
}
