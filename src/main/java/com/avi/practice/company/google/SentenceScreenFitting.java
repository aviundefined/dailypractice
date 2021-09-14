package com.avi.practice.company.google;

/**
 * Given a rows x cols screen and a sentence represented as a list of strings, return the number of times the given sentence can be fitted on the screen.
 * <p>
 * The order of words in the sentence must remain unchanged, and a word cannot be split into two lines. A single space must separate two consecutive words in a line.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: sentence = ["hello","world"], rows = 2, cols = 8
 * Output: 1
 * Explanation:
 * hello---
 * world---
 * The character '-' signifies an empty space on the screen.
 * Example 2:
 * <p>
 * Input: sentence = ["a", "bcd", "e"], rows = 3, cols = 6
 * Output: 2
 * Explanation:
 * a-bcd-
 * e-a---
 * bcd-e-
 * The character '-' signifies an empty space on the screen.
 * Example 3:
 * <p>
 * Input: sentence = ["i","had","apple","pie"], rows = 4, cols = 5
 * Output: 1
 * Explanation:
 * i-had
 * apple
 * pie-i
 * had--
 * The character '-' signifies an empty space on the screen.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= sentence.length <= 100
 * 1 <= sentence[i].length <= 10
 * sentence[i] consists of lowercase English letters.
 * 1 <= rows, cols <= 2 * 104
 */
public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {

        // try to fit the words till first word is again at start of the row
        final int numWords = sentence.length;
        int rem = cols;
        int row = 0;
        int count = 0;
        int i = 0;
        boolean found = false;
        boolean isRepeating = false;
        while (row < rows) {
            if (found && row != rows && i == 0 && rem == cols) {
                isRepeating = true;
                break;
            }
            // try to fit current word in current row
            if (sentence[i].length() <= rem) {
                rem = rem - sentence[i].length() - 1; // extra space;
                i = (i + 1) % numWords;
                if (i == 0) {
                    count++;
                    found = true;
                }
            } else {
                row++;
                rem = cols;
            }
        }
        if (!isRepeating) {
            return count;
        }
        int numSentence = (rows / row) * count;
        final int remainingRows = rows % row;
        return numSentence + wordsTyping(sentence, remainingRows, cols);
    }

}
