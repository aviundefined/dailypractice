package com.avi.practice.company.uber;

/**
 * You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:
 * <p>
 * A stone '#'
 * A stationary obstacle '*'
 * Empty '.'
 * The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
 * <p>
 * It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.
 * <p>
 * Return an n x m matrix representing the box after the rotation described above.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: box = [["#",".","#"]]
 * Output: [["."],
 * ["#"],
 * ["#"]]
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: box = [["#",".","*","."],
 * ["#","#","*","."]]
 * Output: [["#","."],
 * ["#","#"],
 * ["*","*"],
 * [".","."]]
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: box = [["#","#","*",".","*","."],
 * ["#","#","#","*",".","."],
 * ["#","#","#",".","#","."]]
 * Output: [[".","#","#"],
 * [".","#","#"],
 * ["#","#","*"],
 * ["#","*","."],
 * ["#",".","*"],
 * ["#",".","."]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == box.length
 * n == box[i].length
 * 1 <= m, n <= 500
 * box[i][j] is either '#', '*', or '.'.
 */
public class RotatingTheBox {
    private static final char EMPTY = '.';
    private static final char STONE = '#';
    private static final char OBSTACLE = '*';

    public char[][] rotateTheBox(char[][] box) {
        if (box == null || box.length == 0) {
            return box;
        }
        final int m = box.length;
        final int n = box[0].length;
        final char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            int empty = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == OBSTACLE) {
                    empty = j - 1;
                }
                if (box[i][j] == STONE) {
                    box[i][j] = EMPTY;
                    box[i][empty] = STONE;
                    empty--;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                result[j][n - 1 - i] = box[i][j];
            }
        }
        return result;
    }
}
