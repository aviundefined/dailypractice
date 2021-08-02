package com.avi.practice.company.google;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
 * <p>
 * Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
 * <p>
 * <p>
 * <p>
 * We may make the following moves:
 * <p>
 * 'U' moves our position up one row, if the position exists on the board;
 * 'D' moves our position down one row, if the position exists on the board;
 * 'L' moves our position left one column, if the position exists on the board;
 * 'R' moves our position right one column, if the position exists on the board;
 * '!' adds the character board[r][c] at our current position (r, c) to the answer.
 * (Here, the only positions that exist on the board are positions with letters on them.)
 * <p>
 * Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = "leet"
 * Output: "DDR!UURRR!!DDD!"
 * Example 2:
 * <p>
 * Input: target = "code"
 * Output: "RR!DDRR!UUL!R!"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= target.length <= 100
 * target consists only of English lowercase letters.
 */
public class AlphabetBoardPath {

    private static final int m = 6;
    private static final int n = 5;
    private static final char[][] board = new char[m][n];
    private static final String[] dirs = {"D", "L", "R", "U"};
    private static final int[][] directions = {
            {1, 0}, // D
            {0, -1}, // L
            {0, 1}, // R
            {-1, 0} // U
    };

    {
        board[0] = new char[]{'a', 'b', 'c', 'd', 'e'};
        board[1] = new char[]{'f', 'g', 'h', 'i', 'j'};
        board[2] = new char[]{'k', 'l', 'm', 'n', 'o'};
        board[3] = new char[]{'p', 'q', 'r', 's', 't'};
        board[4] = new char[]{'u', 'v', 'w', 'x', 'y'};
        board[5] = new char[]{'z', ' ', ' ', ' ', ' '};
    }

    public String alphabetBoardPath(String target) {
        if (target == null || target.length() == 0) {
            return "";
        }

        for(final char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        final StringBuilder sb = new StringBuilder();
        int startRow = 0, startCol = 0;
        for (final char c : target.toCharArray()) {
            final boolean[] visited = new boolean[26];
            final Queue<Cell> q = new ArrayDeque<>();
            q.offer(new Cell(startRow, startCol, ""));
            while (!q.isEmpty()) {
                // remove mark* work add*
                final Cell curr = q.poll();
                if (visited[board[curr.x][curr.y] - 'a']) {
                    continue;
                }
                visited[board[curr.x][curr.y] - 'a'] = true;
                if (board[curr.x][curr.y] == c) {
                    startRow = curr.x;
                    startCol = curr.y;
                    sb.append(curr.path).append("!");
                    break;
                }
                for (int i = 0; i < dirs.length; i++) {
                    final int newX = curr.x + directions[i][0];
                    final int newY = curr.y + directions[i][1];
                    if (newX >= 0
                            && newY >= 0
                            && newX < m
                            && newY < n
                            && board[newX][newY] != ' '
                            && !visited[board[newX][newY] - 'a']) {
                        q.offer(new Cell(newX, newY, curr.path + dirs[i]));
                    }

                }
            }
        }
        return sb.toString();
    }

    private static final class Cell {
        private final int x;
        private final int y;
        private final String path;

        private Cell(final int x, final int y, final String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}
