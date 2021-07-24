package com.avi.practice.company.microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 23/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(final int num : nums) {
            list.add(num + "");
        }
        System.out.println(list);
        list.sort((a, b) -> {
            final String s1 = a + "" + b;
            final String s2 = b + "" + a;
            return s2.compareTo(s1);
        });

        final StringBuilder sb = new StringBuilder();
        for(final int num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }
}
