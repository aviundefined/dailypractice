package com.avi.practice.company.microsoft;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RomanNumber {

    private static final Map<Integer, String> symbolByValue = new TreeMap<>((o1, o2) -> {
        if (o1 > o2) {
            return -1;
        } else if (o1 < o2) {
            return 1;
        }
        return 0;
    });

    static {
        symbolByValue.put(1, "I");
        symbolByValue.put(4, "IV");
        symbolByValue.put(5, "V");
        symbolByValue.put(9, "IX");
        symbolByValue.put(10, "X");
        symbolByValue.put(40, "XL");
        symbolByValue.put(50, "L");
        symbolByValue.put(90, "XC");
        symbolByValue.put(100, "C");
        symbolByValue.put(400, "CD");
        symbolByValue.put(500, "D");
        symbolByValue.put(900, "CM");
        symbolByValue.put(1000, "M");

        System.out.println(symbolByValue);
    }

    public final String romanNumber(int number) {
        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<Integer, String> e : symbolByValue.entrySet()) {
            final int multiplier = number / e.getKey();
            if (multiplier > 0) {
                for (int i = 0; i < multiplier; i++) {
                    sb.append(e.getValue());
                }
            }
            number = number % e.getKey();
            if (number == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
