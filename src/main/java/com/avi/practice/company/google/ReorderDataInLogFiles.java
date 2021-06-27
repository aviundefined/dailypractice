package com.avi.practice.company.google;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
 * <p>
 * There are two types of logs:
 * <p>
 * Letter-logs: All words (except the identifier) consist of lowercase English letters.
 * Digit-logs: All words (except the identifier) consist of digits.
 * Reorder these logs so that:
 * <p>
 * The letter-logs come before all digit-logs.
 * The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
 * The digit-logs maintain their relative ordering.
 * Return the final order of the logs.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * Explanation:
 * The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
 * The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
 * Example 2:
 * <p>
 * Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * All the tokens of logs[i] are separated by a single space.
 * logs[i] is guaranteed to have an identifier and at least one word after the identifier.
 */
public class ReorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length <= 1) {
            return logs;
        }

        final Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                final Tuple t1 = new Tuple(o1);
                final Tuple t2 = new Tuple(o1);

                /*
                 * The letter-logs come before all digit-logs.
                 * The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
                 * The digit-logs maintain their relative ordering.
                 */

                if (t1.isDigit && !t2.isDigit) {
                    return 1;
                }

                if (!t1.isDigit && t2.isDigit) {
                    return -1;
                }

                if (t1.isDigit && t2.isDigit) {
                    return 1;
                }

                if (t1.value.equals(t2.value)) {
                    return t1.key.compareTo(t2.key);
                }
                return t1.value.compareTo(t2.value);

            }
        };

        Arrays.sort(logs, comparator);
        return logs;
    }


    private static final class Tuple {
        private final String key;
        private final String value;
        private boolean isDigit = true;

        public Tuple(final String str) {
            final int i = str.indexOf(" ");
            key = str.substring(0, i);
            value = str.substring(i + 1);

            final String[] values = value.split(" ");
            for (final String s : values) {
                try {
                    Integer.parseInt(s);
                } catch (final NumberFormatException e) {
                    isDigit = false;
                    break;
                }
            }
        }
    }
}
