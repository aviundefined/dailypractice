package com.avi.practice.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by navinash on 15/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class MathPractice {

    final List<Integer> allFactors(final int A) {
        final ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= (A / 2 + 1); i++) {
            if (A % i == 0) {
                factors.add(i);
            }
        }
        if (A > 2) {
            factors.add(A);
        }
        return factors;
    }

    final List<Integer> allFactorsOptimized(final int A) {
        final ArrayList<Integer> factors = new ArrayList<>();
        final double sqrt = Math.sqrt(A);
        for (int i = 1; i <= sqrt; i++) {
            if (A % i == 0) {
                if (A / i == i) {
                    factors.add(i);
                } else {
                    factors.add(i);
                    factors.add(A / i);
                }
            }
        }
        Collections.sort(factors);
        return factors;
    }

    final int isPrime(final int A) {
        if (A <= 1) {
            return 0; // base case 1 not a prime
        }
        if (A == 2 || A == 3) {
            return 1; // base case 2 and 3 are prime
        }
        if (A % 2 == 0 || A % 3 == 0) {
            return 0; // check divisibility of 2 and 3 as a base case
        }
        final double sqrt = Math.sqrt(A);
        // prime numbers are of type 6n - 1 and 6n + 1 so only check the divisibility from those numbers
        for (int i = 5; i <= sqrt; i = i + 6) {
            if (A % i == 0) {
                return 0;
            }
        }
        for (int i = 7; i <= sqrt; i = i + 6) {
            if (A % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    final ArrayList<Integer> sieve(int A) {
        final ArrayList<Integer> primes = new ArrayList<>();
        if (A < 2) {
            return primes;
        }
        primes.add(2);
        if (A >= 3) {
            primes.add(3);
        }
        // prime numbers are always of type 6n - 1 and 6n + 1
        for (int i = 5; i <= A; i = i + 6) {
            if (isPrime(i) == 1) {
                primes.add(i);
            }
        }
        for (int i = 7; i <= A; i = i + 6) {
            if (isPrime(i) == 1) {
                primes.add(i);
            }
        }
        Collections.sort(primes);
        return primes;
    }

    final String decimalToBinary(int A) {
        if (A == 0) {
            return "0";
        }
        final Stack<Integer> stack = new Stack<>();
        while (A > 0) {
            final int remainder = A % 2;
            A = A / 2;
            stack.add(remainder);
        }

        final StringBuilder b = new StringBuilder();
        while (!stack.isEmpty()) {
            b.append(stack.pop());
        }
        return b.toString();
    }

    final int binaryToDecimal(final String binary) {
        int decimal = 0;
        int bin = Integer.parseInt(binary);
        if (bin == 0) {
            return 0;
        }
        int i = 0;
        while (bin > 0) {
            final int remainder = bin % 10;
            bin = bin / 10;
            decimal = decimal + (remainder * (int) Math.pow(2, i));
            i++;
        }
        return decimal;
    }

    final ArrayList<String> fizzBuzz(int A) {
        final ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(i + "");
            }
        }
        return list;
    }

    final int isPalindrome(int A) {
        final char[] chars = String.valueOf(A).toCharArray();
        final int n = chars.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (chars[l] != chars[r]) {
                return 0;
            }
            l++;
            r--;
        }
        return 1;
    }
}
