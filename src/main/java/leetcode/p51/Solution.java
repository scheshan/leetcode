package leetcode.p51;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[n];

        List<List<String>> res = new ArrayList<>();
        perm(board, 0, rows, cols, res);
        return res;
    }

    private void perm(boolean[][] board, int ind, boolean[] rows, boolean[] cols, List<List<String>> res) {
        if (ind == board.length) {
            res.add(generate(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, rows, cols, ind, col)) {
                rows[ind] = true;
                cols[col] = true;
                board[ind][col] = true;
                perm(board, ind + 1, rows, cols, res);
                rows[ind] = false;
                cols[col] = false;
                board[ind][col] = false;
            }
        }
    }

    private List<String> generate(boolean[][] board) {
        List<String> res = new ArrayList<>(board.length);
        for (int i = 0; i < board.length; i++) {
            char[] arr = new char[board.length];
            for (int j = 0; j < board[i].length; j++) {
                arr[j] = board[i][j] ? 'Q' : '.';
            }
            res.add(new String(arr));
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
