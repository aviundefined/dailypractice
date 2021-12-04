package com.avi.mock;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by navinash on 03/12/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class StringMatcher {

    public String getMaxString(final Iterator<Character> itr, final char[] chars) {
        final Set<Character> charSet = getCharSet(chars);

        String result = "";
        final StringBuilder sb = new StringBuilder();
        final Set<Character> currSet = new HashSet<>();

        while(itr.hasNext()) {
            final char c = itr.next();
            if(charSet.contains(c)) {
                sb.append(c);
                currSet.add(c);
            } else {
                if(currSet.size() == charSet.size() && sb.length() > result.length()) {
                    result = sb.toString();
                }
                sb.setLength(0);
                currSet.clear();
            }
        }

        if (currSet.size() == charSet.size() && sb.length() > result.length()) {
            result = sb.toString();
        }

        return result;
    }

    private Set<Character> getCharSet(final char[] chars) {
        final Set<Character> charSet = new HashSet<>();
        for(final char c : chars) {
            charSet.add(c);
        }

        return charSet;
    }

}
