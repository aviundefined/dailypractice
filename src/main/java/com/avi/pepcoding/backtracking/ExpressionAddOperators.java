package com.avi.pepcoding.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 29/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ExpressionAddOperators {

    public static void main(String[] args) {
        final String s = "12+3-14*15+5*56*67+65";

        final int calculate = Solver.calculate(s);
    }

    public List<String> addOperators(String num, int target) {
        final Solver solver = new Solver(num, target);
        return solver.solve();
    }

    private static final class Solver {
        private static final char[] operators = {'*', '+', '-'};
        private final String str;
        private final int target;
        private final List<String> result = new ArrayList<>();

        public Solver(String str, int target) {
            this.str = str;
            this.target = target;
        }

        private static int calculate(final String exp) {
            // 123 + 34 + 3 - 4 * 5 + 5 * 56 * 67
            int lastOpIndex = -1;
            final StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < exp.length()) {
                final char c = exp.charAt(i);
                if (c != '*') {
                    sb.append(exp.charAt(i));
                    if (c == '-' || c == '+') {
                        lastOpIndex = i;
                    }
                    i++;
                    continue;
                }

                final int prevNum;
                final int oldLen;
                if (lastOpIndex == -1) {
                    prevNum = Integer.parseInt(exp.substring(0, i));
                } else {
                    prevNum = Integer.parseInt(exp.substring(lastOpIndex + 1, i));
                }

                // search for next operator
                int num = 0;
                for (int j = i + 1; j < exp.length(); j++) {
                    if (!Character.isDigit(exp.charAt(j))) {
                        i = j;
                        break;
                    }
                    num = num * 10 + Integer.parseInt(String.valueOf(exp.charAt(j)));
                }
                final int val = prevNum * num;
                sb.setLength(lastOpIndex + 1);
                sb.append(val);
                lastOpIndex = i;

                //   i
                // 5*67
            }
            System.out.println(sb.toString());

            return 0;
        }

        public List<String> solve() {
            final StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            backtrack(1, sb, sb.length());
            return result;
        }

        private boolean backtrack(int index, StringBuilder sb, int oldLength) {
            if (index == str.length()) {
                final int value = calculate(sb.toString());
                if (value == target) {
                    result.add(sb.toString());
                    return true;
                }
                return false;
            }

            // try without operator
            sb.append(str.charAt(index + 1));
            boolean solved = backtrack(index + 1, sb, sb.length());
            sb.setLength(oldLength);

            // try with operator
            for (final char op : operators) {
                sb.append(op);
                sb.append(str.charAt(index + 1));
                solved |= backtrack(index + 1, sb, sb.length());
                sb.setLength(oldLength);
            }
            return solved;
        }

    }
}
