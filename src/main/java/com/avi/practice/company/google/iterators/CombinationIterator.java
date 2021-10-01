package com.avi.practice.company.google.iterators;

/**
 * Design the CombinationIterator class:
 * <p>
 * CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
 * next() Returns the next combination of length combinationLength in lexicographical order.
 * hasNext() Returns true if and only if there exists a next combination.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [["abc", 2], [], [], [], [], [], []]
 * Output
 * [null, "ab", true, "ac", true, "bc", false]
 * <p>
 * Explanation
 * CombinationIterator itr = new CombinationIterator("abc", 2);
 * itr.next();    // return "ab"
 * itr.hasNext(); // return True
 * itr.next();    // return "ac"
 * itr.hasNext(); // return True
 * itr.next();    // return "bc"
 * itr.hasNext(); // return False
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= combinationLength <= characters.length <= 15
 * All the characters of characters are unique.
 * At most 104 calls will be made to next and hasNext.
 * It's guaranteed that all calls of the function next are valid.
 */
public class CombinationIterator {

    private final int length;
    private final int combinationLength;
    private final String characters;
    private int bitmask;

    public CombinationIterator(String characters, int combinationLength) {
        this.length = characters.length();
        this.combinationLength = combinationLength;
        this.characters = characters;
        this.bitmask = (1 << length) - (1 << (length - combinationLength));
    }

    public String next() {
        if (!hasNext()) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            final int mask = 1 << (length - i - 1);
            if ((bitmask & mask) != 0) {
                sb.append(characters.charAt(i));
            }
        }

        bitmask--;
        while (bitmask > 0 && Integer.bitCount(bitmask) != combinationLength) {
            bitmask--;
        }

        return sb.toString();
    }

    public boolean hasNext() {
        return bitmask > 0;
    }
}
