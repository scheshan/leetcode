package leetcode.p79;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == word.charAt(0) && dfs(board, row, col, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int ind) {
        if (ind == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != word.charAt(ind)) {
            return false;
        }

        board[row][col] = ' ';
        if (dfs(board, row - 1, col, word, ind + 1)) {
            return true;
        }
        if (dfs(board, row + 1, col, word, ind + 1)) {
            return true;
        }
        if (dfs(board, row, col - 1, word, ind + 1)) {
            return true;
        }
        if (dfs(board, row, col + 1, word, ind + 1)) {
            return true;
        }
        board[row][col] = word.charAt(ind);
        return false;
    }
}
