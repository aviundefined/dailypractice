package com.avi.practice.leetcode.daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 19/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0 || "".equals(num.trim())) {
            return Collections.emptyList();
        }

        final Solver solver = new Solver(num, target);
        return solver.validExpressions();
    }

    private static final class Solver {

        private final String num;
        private final int target;
        private final List<String> result = new ArrayList<>();
        private Solver(final String num, final int target) {
            this.num = num;
            this.target = target;
        }

        private List<String> validExpressions() {
            backtrack(0, 0, 0, 0, new StringBuilder());
            return result;
        }

        private void backtrack(final  int index, long previousOperand, long currentOperand, long value, final StringBuilder curr) {
            if(index >= num.length()) {
                // add curr expression if valid
                if(value == target && currentOperand == 0) {
                    result.add(curr.substring(1));
                }
                return;
            }

            int oldLen = curr.length();
            final char currChar = num.charAt(index);
            currentOperand = currentOperand * 10 + Long.parseLong(String.valueOf(currChar));
            final String currentOperandStr = String.valueOf(currentOperand);

            if(currentOperand > 0) {
                backtrack(index + 1, previousOperand, currentOperand, value, curr);
            }


            curr.append("+");
            curr.append(currentOperandStr);
            backtrack(index + 1, currentOperand, 0, value + currentOperand, curr);
            curr.setLength(oldLen);

            if(oldLen > 0) {
                curr.append("-");
                curr.append(currentOperandStr);
                backtrack(index + 1, -currentOperand, 0, value - currentOperand, curr);
                curr.setLength(oldLen);

                curr.append("*");
                curr.append(currentOperandStr);
                backtrack(index + 1, currentOperand * previousOperand, 0, value - previousOperand + (currentOperand * previousOperand), curr);
                curr.setLength(oldLen);
            }
        }
    }
}
