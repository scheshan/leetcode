package leetcode.p79;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (dfs(board, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int ind) {
        if (board[row][col] != word.charAt(ind)) {
            return false;
        }
        boolean res = ind == word.length() - 1;
        board[row][col] = ' ';
        if (row > 0) {
            res = res || dfs(board, row - 1, col, word, ind + 1);
        }
        if (row < board.length - 1) {
            res = res || dfs(board, row + 1, col, word, ind + 1);
        }
        if (col > 0) {
            res = res || dfs(board, row, col - 1, word, ind + 1);
        }
        if (col < board[row].length - 1) {
            res = res || dfs(board, row, col + 1, word, ind + 1);
        }
        board[row][col] = word.charAt(ind);
        return res;
    }
}
