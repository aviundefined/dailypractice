package com.avi.practice.maths;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 15/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MathPracticeTest {

    private MathPractice tool;

    @Before
    public void setup() {
        tool = new MathPractice();
    }

    @After
    public void tearDown() {
        tool = null;
    }

    @Test
    public void allFactors() {
        {
            final int a = 1;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            Assert.assertEquals(expected, tool.allFactors(a));
        }
        {
            final int a = 2;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(2);
            Assert.assertEquals(expected, tool.allFactors(a));
        }
        {
            final int a = 3;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(3);
            Assert.assertEquals(expected, tool.allFactors(a));
        }
        {
            final int a = 6;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(2);
            expected.add(3);
            expected.add(6);
            Assert.assertEquals(expected, tool.allFactors(a));
        }

        {
            final int a = 85463;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(7);
            expected.add(29);
            expected.add(203);
            expected.add(421);
            expected.add(2947);
            expected.add(12209);
            expected.add(85463);
            Assert.assertEquals(expected, tool.allFactors(a));
        }
    }

    @Test
    public void allFactorsOptimized() {
        {
            final int a = 1;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            Assert.assertEquals(expected, tool.allFactorsOptimized(a));
        }
        {
            final int a = 2;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(2);
            Assert.assertEquals(expected, tool.allFactorsOptimized(a));
        }
        {
            final int a = 3;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(3);
            Assert.assertEquals(expected, tool.allFactorsOptimized(a));
        }
        {
            final int a = 6;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(2);
            expected.add(3);
            expected.add(6);
            Assert.assertEquals(expected, tool.allFactorsOptimized(a));
        }

        {
            final int a = 85463;
            final List<Integer> expected = new ArrayList<>();
            expected.add(1);
            expected.add(7);
            expected.add(29);
            expected.add(203);
            expected.add(421);
            expected.add(2947);
            expected.add(12209);
            expected.add(85463);
            Assert.assertEquals(expected, tool.allFactorsOptimized(a));
        }
    }

    @Test
    public void isPrime() {
        Assert.assertEquals(0, tool.isPrime(1));
        Assert.assertEquals(1, tool.isPrime(2));
        Assert.assertEquals(1, tool.isPrime(3));
        Assert.assertEquals(0, tool.isPrime(4));
        Assert.assertEquals(1, tool.isPrime(5));
        Assert.assertEquals(0, tool.isPrime(6));
        Assert.assertEquals(1, tool.isPrime(7));
        Assert.assertEquals(0, tool.isPrime(8));
        Assert.assertEquals(0, tool.isPrime(9));
        Assert.assertEquals(0, tool.isPrime(10));
        Assert.assertEquals(1, tool.isPrime(11));
        Assert.assertEquals(0, tool.isPrime(12));
        Assert.assertEquals(1, tool.isPrime(13));
        Assert.assertEquals(0, tool.isPrime(14));
        Assert.assertEquals(0, tool.isPrime(15));
        Assert.assertEquals(0, tool.isPrime(16));
        Assert.assertEquals(1, tool.isPrime(17));
        Assert.assertEquals(0, tool.isPrime(18));
        Assert.assertEquals(1, tool.isPrime(19));
        Assert.assertEquals(0, tool.isPrime(20));
        Assert.assertEquals(0, tool.isPrime(21));
        Assert.assertEquals(0, tool.isPrime(22));
        Assert.assertEquals(1, tool.isPrime(23));
        Assert.assertEquals(0, tool.isPrime(24));
        Assert.assertEquals(0, tool.isPrime(25));
        Assert.assertEquals(0, tool.isPrime(26));
        Assert.assertEquals(0, tool.isPrime(27));
        Assert.assertEquals(0, tool.isPrime(28));
        Assert.assertEquals(1, tool.isPrime(29));
        Assert.assertEquals(0, tool.isPrime(30));
        Assert.assertEquals(1, tool.isPrime(31));
        Assert.assertEquals(0, tool.isPrime(32));
        Assert.assertEquals(0, tool.isPrime(33));
        Assert.assertEquals(0, tool.isPrime(34));
        Assert.assertEquals(0, tool.isPrime(35));
        Assert.assertEquals(0, tool.isPrime(36));
        Assert.assertEquals(1, tool.isPrime(37));
        Assert.assertEquals(0, tool.isPrime(38));
        Assert.assertEquals(0, tool.isPrime(39));
        Assert.assertEquals(0, tool.isPrime(40));
        Assert.assertEquals(1, tool.isPrime(41));
        Assert.assertEquals(0, tool.isPrime(42));
        Assert.assertEquals(1, tool.isPrime(43));
        Assert.assertEquals(0, tool.isPrime(44));
        Assert.assertEquals(0, tool.isPrime(45));
        Assert.assertEquals(0, tool.isPrime(46));
        Assert.assertEquals(1, tool.isPrime(47));
        Assert.assertEquals(0, tool.isPrime(48));
        Assert.assertEquals(0, tool.isPrime(49));
        Assert.assertEquals(0, tool.isPrime(50));
        Assert.assertEquals(0, tool.isPrime(51));
        Assert.assertEquals(0, tool.isPrime(52));
    }

    @Test
    public void sieve() {
        {
            final int a = 1;
            final ArrayList<Integer> primes = new ArrayList<>();
            Assert.assertEquals(primes, tool.sieve(a));
        }
        {
            final int a = 2;
            final ArrayList<Integer> primes = new ArrayList<>();
            primes.add(2);
            Assert.assertEquals(primes, tool.sieve(a));
        }
        {
            final int a = 3;
            final ArrayList<Integer> primes = new ArrayList<>();
            primes.add(2);
            primes.add(3);
            Assert.assertEquals(primes, tool.sieve(a));
        }
        {
            final int a = 4;
            final ArrayList<Integer> primes = new ArrayList<>();
            primes.add(2);
            primes.add(3);
            Assert.assertEquals(primes, tool.sieve(a));
        }
        {
            final int a = 5;
            final ArrayList<Integer> primes = new ArrayList<>();
            primes.add(2);
            primes.add(3);
            primes.add(5);
            Assert.assertEquals(primes, tool.sieve(a));
        }
        {
            final int a = 6;
            final ArrayList<Integer> primes = new ArrayList<>();
            primes.add(2);
            primes.add(3);
            primes.add(5);
            Assert.assertEquals(primes, tool.sieve(a));
        }
        {
            final int a = 7;
            final ArrayList<Integer> primes = new ArrayList<>();
            primes.add(2);
            primes.add(3);
            primes.add(5);
            primes.add(7);
            Assert.assertEquals(primes, tool.sieve(a));
        }
        {
            final int a = 9;
            final ArrayList<Integer> primes = new ArrayList<>();
            primes.add(2);
            primes.add(3);
            primes.add(5);
            primes.add(7);
            Assert.assertEquals(primes, tool.sieve(a));
        }
        {
            final int a = 11;
            final ArrayList<Integer> primes = new ArrayList<>();
            primes.add(2);
            primes.add(3);
            primes.add(5);
            primes.add(7);
            primes.add(11);
            Assert.assertEquals(primes, tool.sieve(a));
        }
        {
            final int a = 19;
            final ArrayList<Integer> primes = new ArrayList<>();
            primes.add(2);
            primes.add(3);
            primes.add(5);
            primes.add(7);
            primes.add(11);
            primes.add(13);
            primes.add(17);
            primes.add(19);
            Assert.assertEquals(primes, tool.sieve(a));
        }
    }

    @Test
    public void decimalToBinaryViceVersa() {
        {
            final int a = 0;
            final String binary = tool.decimalToBinary(a);
            Assert.assertEquals("0", binary);
            Assert.assertEquals(a, tool.binaryToDecimal(binary));
        }
        {
            final int a = 1;
            final String binary = tool.decimalToBinary(a);
            Assert.assertEquals("1", binary);
            Assert.assertEquals(a, tool.binaryToDecimal(binary));
        }
        {
            final int a = 2;
            final String binary = tool.decimalToBinary(a);
            Assert.assertEquals("10", binary);
            Assert.assertEquals(a, tool.binaryToDecimal(binary));
        }
        {
            final int a = 3;
            final String binary = tool.decimalToBinary(a);
            Assert.assertEquals("11", binary);
            Assert.assertEquals(a, tool.binaryToDecimal(binary));
        }
        {
            final int a = 4;
            final String binary = tool.decimalToBinary(a);
            Assert.assertEquals("100", binary);
            Assert.assertEquals(a, tool.binaryToDecimal(binary));
        }
        {
            final int a = 6;
            final String binary = tool.decimalToBinary(a);
            Assert.assertEquals("110", binary);
            Assert.assertEquals(a, tool.binaryToDecimal(binary));
        }
        {
            final int a = 7;
            final String binary = tool.decimalToBinary(a);
            Assert.assertEquals("111", binary);
            Assert.assertEquals(a, tool.binaryToDecimal(binary));
        }
        {
            final int a = 357;
            final String binary = tool.decimalToBinary(a);
            Assert.assertEquals("101100101", binary);
            Assert.assertEquals(a, tool.binaryToDecimal(binary));
        }
    }

    @Test
    public void fizzBuzz() {
        {
            final int a = 5;
            final List<String> expected = Arrays.asList("1", "2", "Fizz", "4", "Buzz");
            Assert.assertEquals(expected, tool.fizzBuzz(a));
        }

        {
            final int a = 17;
            final List<String> expected = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz", "16", "17");
            Assert.assertEquals(expected, tool.fizzBuzz(a));
        }
    }

    @Test
    public void isPalindrome() {
        {
            final int a = 9;
            Assert.assertEquals(String.valueOf(a), 1, tool.isPalindrome(a));
        }
        {
            final int a = 12121;
            Assert.assertEquals(String.valueOf(a), 1, tool.isPalindrome(a));
        }
        {
            final int a = 121;
            Assert.assertEquals(String.valueOf(a), 1, tool.isPalindrome(a));
        }
        {
            final int a = 1331;
            Assert.assertEquals(String.valueOf(a), 1, tool.isPalindrome(a));
        }
        {
            final int a = 123;
            Assert.assertEquals(String.valueOf(a), 0, tool.isPalindrome(a));
        }
        {
            final int a = 121121;
            Assert.assertEquals(String.valueOf(a), 1, tool.isPalindrome(a));
        }
    }

    @Test
    public void reverseInteger() {
        {
            final int a = 1234;
            final int expected = 4321;
            Assert.assertEquals(String.valueOf(a), expected, tool.reverseInteger(a));
        }

        {
            final int a = 12345;
            final int expected = 54321;
            Assert.assertEquals(String.valueOf(a), expected, tool.reverseInteger(a));
        }

        {
            final int a = 4;
            final int expected = 4;
            Assert.assertEquals(String.valueOf(a), expected, tool.reverseInteger(a));
        }

        {
            final int a = 12;
            final int expected = 21;
            Assert.assertEquals(String.valueOf(a), expected, tool.reverseInteger(a));
        }

        {
            final int a = 0;
            final int expected = 0;
            Assert.assertEquals(String.valueOf(a), expected, tool.reverseInteger(a));
        }

        {
            final int a = -1234567891;
            final int expected = -1987654321;
            Assert.assertEquals(String.valueOf(a), expected, tool.reverseInteger(a));

        }
        {
            final int a = -1146467285;
            final int expected = 0;
            Assert.assertEquals(String.valueOf(a), expected, tool.reverseInteger(a));

        }
    }

    @Test
    public void gcd() {
        {
            final int a = 0;
            final int b = 0;
            final int expected = 0;
            final int gcdBySubtraction = tool.gcdBySubtraction(a, b);
            final int gcdBySubtractionRecursion = tool.gcdBySubtractionRecursion(a, b);
            final int gcdByModuloRecursion = tool.gcdByModuloRecursion(a, b);
            final int gcdByModuloIteration = tool.gcdByModuloIteration(a, b);
            Assert.assertEquals(String.format("(%d, %d)", a, b), expected, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdByModuloIteration, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdBySubtraction);
        }
        {
            final int a = 9;
            final int b = 0;
            final int expected = 9;
            final int gcdBySubtraction = tool.gcdBySubtraction(a, b);
            final int gcdBySubtractionRecursion = tool.gcdBySubtractionRecursion(a, b);
            final int gcdByModuloRecursion = tool.gcdByModuloRecursion(a, b);
            final int gcdByModuloIteration = tool.gcdByModuloIteration(a, b);
            Assert.assertEquals(String.format("(%d, %d)", a, b), expected, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdByModuloIteration, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdBySubtraction);
        }
        {
            final int a = 0;
            final int b = 6;
            final int expected = 6;
            final int gcdBySubtraction = tool.gcdBySubtraction(a, b);
            final int gcdBySubtractionRecursion = tool.gcdBySubtractionRecursion(a, b);
            final int gcdByModuloRecursion = tool.gcdByModuloRecursion(a, b);
            final int gcdByModuloIteration = tool.gcdByModuloIteration(a, b);
            Assert.assertEquals(String.format("(%d, %d)", a, b), expected, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdByModuloIteration, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdBySubtraction);
        }
        {
            final int a = 15;
            final int b = 20;
            final int expected = 5;
            final int gcdBySubtraction = tool.gcdBySubtraction(a, b);
            final int gcdBySubtractionRecursion = tool.gcdBySubtractionRecursion(a, b);
            final int gcdByModuloRecursion = tool.gcdByModuloRecursion(a, b);
            final int gcdByModuloIteration = tool.gcdByModuloIteration(a, b);
            Assert.assertEquals(String.format("(%d, %d)", a, b), expected, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdByModuloIteration, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdBySubtraction);
        }
        {
            final int a = 15;
            final int b = 20;
            final int expected = 5;
            final int gcdBySubtraction = tool.gcdBySubtraction(a, b);
            final int gcdBySubtractionRecursion = tool.gcdBySubtractionRecursion(a, b);
            final int gcdByModuloRecursion = tool.gcdByModuloRecursion(a, b);
            final int gcdByModuloIteration = tool.gcdByModuloIteration(a, b);
            Assert.assertEquals(String.format("(%d, %d)", a, b), expected, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdByModuloIteration, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdBySubtraction);
        }

        {
            final int a = 20;
            final int b = 15;
            final int expected = 5;
            final int gcdBySubtraction = tool.gcdBySubtraction(a, b);
            final int gcdBySubtractionRecursion = tool.gcdBySubtractionRecursion(a, b);
            final int gcdByModuloRecursion = tool.gcdByModuloRecursion(a, b);
            final int gcdByModuloIteration = tool.gcdByModuloIteration(a, b);
            Assert.assertEquals(String.format("(%d, %d)", a, b), expected, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdByModuloIteration, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdBySubtraction);
        }

        {
            final int a = 36;
            final int b = 72;
            final int expected = 36;
            final int gcdBySubtraction = tool.gcdBySubtraction(a, b);
            final int gcdBySubtractionRecursion = tool.gcdBySubtractionRecursion(a, b);
            final int gcdByModuloRecursion = tool.gcdByModuloRecursion(a, b);
            final int gcdByModuloIteration = tool.gcdByModuloIteration(a, b);
            Assert.assertEquals(String.format("(%d, %d)", a, b), expected, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdByModuloIteration, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdBySubtraction);
        }

        {
            final int a = 60;
            final int b = 36;
            final int expected = 12;
            final int gcdBySubtraction = tool.gcdBySubtraction(a, b);
            final int gcdBySubtractionRecursion = tool.gcdBySubtractionRecursion(a, b);
            final int gcdByModuloRecursion = tool.gcdByModuloRecursion(a, b);
            final int gcdByModuloIteration = tool.gcdByModuloIteration(a, b);
            Assert.assertEquals(String.format("(%d, %d)", a, b), expected, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdByModuloIteration, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdBySubtraction);
        }

        {
            final int a = 7166;
            final int b = 1779;
            final int expected = 1;
            final int gcdBySubtraction = tool.gcdBySubtraction(a, b);
            final int gcdBySubtractionRecursion = tool.gcdBySubtractionRecursion(a, b);
            final int gcdByModuloRecursion = tool.gcdByModuloRecursion(a, b);
            final int gcdByModuloIteration = tool.gcdByModuloIteration(a, b);
            Assert.assertEquals(String.format("(%d, %d)", a, b), expected, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdByModuloIteration, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdBySubtraction);
        }

        {
            final int a = 9437;
            final int b = 3097;
            final int expected = 1;
            final int gcdBySubtraction = tool.gcdBySubtraction(a, b);
            final int gcdBySubtractionRecursion = tool.gcdBySubtractionRecursion(a, b);
            final int gcdByModuloRecursion = tool.gcdByModuloRecursion(a, b);
            final int gcdByModuloIteration = tool.gcdByModuloIteration(a, b);
            Assert.assertEquals(String.format("(%d, %d)", a, b), expected, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdByModuloIteration, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdBySubtraction);
        }
    }

    @Test
    public void compareAllGCDApproaches() {
        final int n = randInt(100);
        for (int i = 0; i <= n; i++) {
            final int a = randInt(10000);
            final int b = randInt(10000);
            final int gcdBySubtraction = tool.gcdBySubtraction(a, b);
            final int gcdBySubtractionRecursion = tool.gcdBySubtractionRecursion(a, b);
            final int gcdByModuloRecursion = tool.gcdByModuloRecursion(a, b);
            final int gcdByModuloIteration = tool.gcdByModuloIteration(a, b);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdByModuloIteration, gcdByModuloRecursion);
            Assert.assertEquals(String.format("(%d, %d)", a, b), gcdBySubtractionRecursion, gcdBySubtraction);
        }
    }

    @Test
    public void trailingZerosInFactorial() {
        {
            final int A = 4;
            final int expected = 0;
            final int actual = tool.trailingZerosInFactorial(A);
            Assert.assertEquals(expected, actual);
        }
        {
            final int A = 5;
            final int expected = 1;
            final int actual = tool.trailingZerosInFactorial(A);
            Assert.assertEquals(expected, actual);
        }
        {
            final int A = 10;
            final int expected = 2;
            final int actual = tool.trailingZerosInFactorial(A);
            Assert.assertEquals(expected, actual);
        }
        {
            final int A = 20;
            final int expected = 4;
            final int actual = tool.trailingZerosInFactorial(A);
            Assert.assertEquals(expected, actual);
        }
        {
            final int A = 26;
            final int expected = 6;
            final int actual = tool.trailingZerosInFactorial(A);
            Assert.assertEquals(expected, actual);
        }
        {
            final int A = 50;
            final int expected = 12;
            final int actual = tool.trailingZerosInFactorial(A);
            Assert.assertEquals(expected, actual);
        }
        {
            final int A = 54;
            final int expected = 12;
            final int actual = tool.trailingZerosInFactorial(A);
            Assert.assertEquals(expected, actual);
        }
        {
            final int A = 55;
            final int expected = 13;
            final int actual = tool.trailingZerosInFactorial(A);
            Assert.assertEquals(expected, actual);
        }
        {
            final int A = 100;
            final int expected = 24;
            final int actual = tool.trailingZerosInFactorial(A);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void titleToNumber() {
        {
            final String a = "A";
            final int expected = 1;
            final int actual = tool.titleToNumber(a);
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }
        {
            final String a = "B";
            final int expected = 2;
            final int actual = tool.titleToNumber(a);
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }
        {
            final String a = "Z";
            final int expected = 26;
            final int actual = tool.titleToNumber(a);
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }
        {
            final String a = "AA";
            final int expected = 27;
            final int actual = tool.titleToNumber(a);
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }
        {
            final String a = "AB";
            final int expected = 28;
            final int actual = tool.titleToNumber(a);
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }
        {
            final String a = "AY";
            final int expected = 51;
            final int actual = tool.titleToNumber(a);
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }
        {
            final String a = "AZ";
            final int expected = 52;
            final int actual = tool.titleToNumber(a);
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }
        {
            final String a = "BZ";
            final int expected = 78;
            final int actual = tool.titleToNumber(a);
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }

        {
            final String a = "A";
            final int expected = 1;
            final int actual = tool.titleToNumber(a.toLowerCase());
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }
        {
            final String a = "B";
            final int expected = 2;
            final int actual = tool.titleToNumber(a.toLowerCase());
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }
        {
            final String a = "Z";
            final int expected = 26;
            final int actual = tool.titleToNumber(a.toLowerCase());
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }
        {
            final String a = "AA";
            final int expected = 27;
            final int actual = tool.titleToNumber(a.toLowerCase());
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }
        {
            final String a = "AB";
            final int expected = 28;
            final int actual = tool.titleToNumber(a.toLowerCase());
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }
        {
            final String a = "AY";
            final int expected = 51;
            final int actual = tool.titleToNumber(a.toLowerCase());
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }
        {
            final String a = "AZ";
            final int expected = 52;
            final int actual = tool.titleToNumber(a.toLowerCase());
            final String title = tool.numberToTitle(actual);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(a, title);
        }

        {
            final int a = 943566;
            final String title = tool.numberToTitle(a);
            final int number = tool.titleToNumber(title);
            Assert.assertEquals("BAQTZ", title);
            Assert.assertEquals(a, number);
        }
    }

    @Test
    public void testExcelColumnsTitles() {
        final int n = randInt();
        for (int i = 0; i <= n; i++) {
            final int a = randInt(10000);
            final String title = tool.numberToTitle(a);
            final int number = tool.titleToNumber(title);
            Assert.assertEquals(a, number);
        }
    }

    private static int randInt() {
        return randInt(1000);
    }

    private static int randInt(final int n) {
        return (int) (Math.random() * n) + 5;
    }
}