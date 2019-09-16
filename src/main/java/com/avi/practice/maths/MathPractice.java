package com.avi.practice.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by navinash on 15/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class MathPractice {

    private static final Map<String, Integer> charToVal = new HashMap<>();

    static {
        charToVal.put("A", 1);
        charToVal.put("B", 2);
        charToVal.put("C", 3);
        charToVal.put("D", 4);
        charToVal.put("E", 5);
        charToVal.put("F", 6);
        charToVal.put("G", 7);
        charToVal.put("H", 8);
        charToVal.put("I", 9);
        charToVal.put("J", 10);
        charToVal.put("K", 11);
        charToVal.put("L", 12);
        charToVal.put("M", 13);
        charToVal.put("N", 14);
        charToVal.put("O", 15);
        charToVal.put("P", 16);
        charToVal.put("Q", 17);
        charToVal.put("R", 18);
        charToVal.put("S", 19);
        charToVal.put("T", 20);
        charToVal.put("U", 21);
        charToVal.put("V", 22);
        charToVal.put("W", 23);
        charToVal.put("X", 24);
        charToVal.put("Y", 25);
        charToVal.put("Z", 26);
    }

    private static final Map<Integer, String> valToChar = new HashMap<>();

    static {
        valToChar.put(1, "A");
        valToChar.put(2, "B");
        valToChar.put(3, "C");
        valToChar.put(4, "D");
        valToChar.put(5, "E");
        valToChar.put(6, "F");
        valToChar.put(7, "G");
        valToChar.put(8, "H");
        valToChar.put(9, "I");
        valToChar.put(10, "J");
        valToChar.put(11, "K");
        valToChar.put(12, "L");
        valToChar.put(13, "M");
        valToChar.put(14, "N");
        valToChar.put(15, "O");
        valToChar.put(16, "P");
        valToChar.put(17, "Q");
        valToChar.put(18, "R");
        valToChar.put(19, "S");
        valToChar.put(20, "T");
        valToChar.put(21, "U");
        valToChar.put(22, "V");
        valToChar.put(23, "W");
        valToChar.put(24, "X");
        valToChar.put(25, "Y");
        valToChar.put(26, "Z");
    }


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

    final int reverseInteger(final int A) {
        final boolean isNegative = A < 0;
        final char[] chars = String.valueOf(Math.abs(A)).toCharArray();
        final int n = chars.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            final char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
        try {
            final int reversed = Integer.parseInt(new String(chars));
            return isNegative ? -1 * reversed : reversed;
        } catch (final NumberFormatException e) {
            return 0;
        }
    }

    final int gcdBySubtractionRecursion(final int A, final int B) {
        if (A == 0 && B == 0) {
            return 0;
        }
        if (A == 0) {
            return B;
        }
        if (B == 0) {
            return A;
        }
        if (A > B) {
            return gcdBySubtractionRecursion(A - B, B);
        } else {
            return gcdBySubtractionRecursion(A, B - A);
        }
    }

    final int gcdBySubtraction(final int A, final int B) {
        if (A == 0 && B == 0) {
            return 0;
        }
        if (A == 0) {
            return B;
        }
        if (B == 0) {
            return A;
        }
        int a = Math.max(A, B);
        int b = Math.min(A, B);
        while (b > 0) {
            int tmp1 = b;
            b = a - b;
            a = tmp1;
            if (b <= 0) {
                break;
            }
            int tmp2 = a;
            a = Math.max(tmp2, b);
            b = Math.min(tmp2, b);
        }
        return a;
    }

    final int gcdByModuloRecursion(final int A, final int B) {
        if (A == 0 && B == 0) {
            return 0;
        }
        if (B == 0) {
            return A;
        }
        if (A == 0) {
            return B;
        }
        return gcdByModuloRecursion(B, A % B);
    }

    final int gcdByModuloIteration(int A, int B) {
        if (A == 0 && B == 0) {
            return 0;
        }
        if (B == 0) {
            return A;
        }
        if (A == 0) {
            return B;
        }

        while (B > 0) {
            int tmp = B;
            B = A % B;
            A = tmp;
        }
        return A;
    }

    final int trailingZerosInFactorial(int A) {
        if (A < 5) {
            return 0;
        }
        int zeros = 0;
        for (int i = 5; A / i >= 1; i = i * 5) {
            zeros = zeros + A / i;
        }
        return zeros;
    }

    final int titleToNumber(final String A) {
        final char[] chars = A.toCharArray();
        int col = 0;
        final int n = A.length();
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            col = col + ((int) Math.pow(26, j) * charToVal.get(String.valueOf(chars[i]).toUpperCase()));
            j++;
        }
        return col;
    }

    final String numberToTitle(int A) {
        if (A <= 0) {
            return "0";
        }
        if (A <= 26) {
            return valToChar.get(A);
        }
        final Stack<String> stack = new Stack<>();
        while (A > 0) {
            final int remainder = A % 26;
            A = A / 26;
            if (remainder == 0) {
                A--;
            }
            stack.add(valToChar.get(remainder == 0 ? 26 : remainder));
        }

        final StringBuilder b = new StringBuilder();
        while (!stack.isEmpty()) {
            b.append(stack.pop());
        }
        return b.toString();
    }
}
