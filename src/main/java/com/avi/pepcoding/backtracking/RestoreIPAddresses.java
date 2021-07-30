package com.avi.pepcoding.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 29/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RestoreIPAddresses {
    private final List<String> result = new ArrayList<>();
    private String s;
    public List<String> restoreIpAddresses(final String s) {
        this.s = s;
        final StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        backtrack(0, sb, 1);
        return result;
    }

    private void backtrack(int index, StringBuilder sb, int oldLen) {
        if(index == s.length()) {
            if(isValidIPAddress(sb.toString())) {
                result.add(sb.toString());
            }
            return;
        }
        // include number
        sb.append(s.charAt(index));
        backtrack(index + 1, sb, oldLen + 1);
        sb.setLength(oldLen);

        // put dot
        sb.append(".");
        backtrack(index + 1, sb, oldLen + 1);
        sb.setLength(oldLen);
    }

    private boolean isValidIPAddress(final String s) {
        final String[] arr = s.split(".");
        if (arr.length != 4) {
            return false;
        }
        for (final String str : arr) {
            final int value = Integer.parseInt(str);
            if (value >= 0 && value <= 255) {
                continue;
            }
            return false;
        }
        return true;
    }
}
