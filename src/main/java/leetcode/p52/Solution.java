package leetcode.p52;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[n];

        return perm(board, 0, rows, cols);
    }

    private int perm(boolean[][] board, int ind, boolean[] rows, boolean[] cols) {
        if (ind == board.length) {
            return 1;
        }

        int res = 0;

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, rows, cols, ind, col)) {
                rows[ind] = true;
                cols[col] = true;
                board[ind][col] = true;
                res += perm(board, ind + 1, rows, cols);
                rows[ind] = false;
                cols[col] = false;
                board[ind][col] = false;
            }
        }
        return res;
    }

    private boolean isValid(boolean[][] board, boolean[] rows, boolean[] cols, int row, int col) {
        if (cols[col] || rows[row]) {
            return false;
        }
        int r = row;
        int c = col;
        while (r > 0 && c > 0) {
            if (board[--r][--c]) {
                return false;
            }
        }
        r = row;
        c = col;
        while (r > 0 && c < board.length - 1) {
            if (board[--r][++c]) {
                return false;
            }
        }
        return true;
    }
}
