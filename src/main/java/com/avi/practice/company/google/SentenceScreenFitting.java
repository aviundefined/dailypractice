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


    public int wordsTyping1(String[] sentence, int rows, int cols) {
        int[] lens = new int[sentence.length];
        int i=0, sentLen=0;
        for (final String word: sentence) {
            final int len = word.length();
            if (len > cols) {
                return 0;//length of word > num cols
            }
            lens[i++] = len;
            sentLen += len;
            sentLen++;//space after word
        }
        sentLen--; //no space after last word

        boolean patternFound = false;

        i=0;//word
        int numSent = 0;
        int r=0;//row
        int rem = cols;//remaining cols in row
        while(!patternFound && r < rows) {
            //loop until all words done once
            while(!patternFound && r < rows && i < lens.length) {
                if ((i == 0) && (rem == cols && numSent > 0)) {
                    //starting for 0th word from 0th col & we have already found at least 1 sentence
                    patternFound = true;
                } else if ((i == 0) && (rem > sentLen)) {
                    //starting for 0th word and sentLen smaller than remaining columns
                    //find multiples of sentence fits in remaining cols
                    numSent += (rem+1)/(sentLen+1);//space after sentence
                    rem -= numSent*(sentLen+1)-1;//no space after last
                    if (rem > 0)
                        rem--;//add space if col remaining
                } else if (lens[i] > rem) {
                    //word not fitting in remaining cols
                    if (i == 0) {
                        //This will be only when pattern found, and not in Starting case
                        patternFound = true;
                    } else {
                        r++;
                        rem = cols;
                    }
                } else {
                    //word fits
                    rem -= lens[i++];
                    if (rem > 0)
                        rem--;//space
                    if (i == lens.length) {
                        //finished with our sentence
                        numSent++;
                        i = 0;
                    }
                }
            }
        }
        if (!patternFound)
            return numSent;
        else {
            int totalSent = 0;
            int repeat = rows / (r+1);
            totalSent += (numSent * repeat);

            int remaining = rows % (r+1);
            totalSent += wordsTyping(sentence, remaining, cols);

            return totalSent;
        }

    }

}
