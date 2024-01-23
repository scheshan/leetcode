package leetcode.p79;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/23
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int ind) {
        if (ind == word.length() - 1) {
            return true;
        }
        board[i][j] = ' ';

        if (i > 0 && board[i - 1][j] == word.charAt(ind + 1) && dfs(board, i - 1, j, word, ind + 1)) {
            return true;
        }
        if (i < board.length - 1 && board[i + 1][j] == word.charAt(ind + 1) && dfs(board, i + 1, j, word, ind + 1)) {
            return true;
        }
        if (j > 0 && board[i][j - 1] == word.charAt(ind + 1) && dfs(board, i, j - 1, word, ind + 1)) {
            return true;
        }
        if (j < board[i].length - 1 && board[i][j + 1] == word.charAt(ind + 1) && dfs(board, i, j + 1, word, ind + 1)) {
            return true;
        }

        board[i][j] = word.charAt(ind);
        return false;
    }
}
