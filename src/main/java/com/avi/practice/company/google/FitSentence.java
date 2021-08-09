package com.avi.practice.company.google;

/**
 * Created by navinash on 09/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FitSentence {

    public final int lines(final String text, final int width) {
        if (text == null || text.length() == 0 || "".equals(text.trim())) {
            return 0;
        }
        final String[] words = text.split(" ");
        return 1 + recurse(words, width, 0, width);
    }

    private int recurse(String[] words, int width, int index, int maxWidth) {
        if (index >= words.length) {
            return 0;
        }
        if (words[index].length() > maxWidth) {
            throw new RuntimeException(String.format("%s length is greater than maxWidth %s", words[index], maxWidth));
        }

        if (words[index].length() < width) { // word can be fit in current row and one place for space
            return recurse(words, width - words[index].length() - 1, index + 1, maxWidth);
        } else if (words[index].length() == width) { // word just filled the current start new row with maxWidth
            return 1 + recurse(words, maxWidth, index + 1, maxWidth);
        } else { // word can be fit in this row, try new row
            return 1 + recurse(words, maxWidth - words[index].length() - 1, index + 1, maxWidth);
        }
    }
}
