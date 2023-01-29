package leetcode.p419;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int countBattleships(char[][] board) {
        int res = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'X') {
                    dfs(board, row, col);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, int row, int col) {
        if (board[row][col] == '.') {
            return;
        }

        board[row][col] = '.';
        if (row > 0) {
            dfs(board, row - 1, col);
        }
        if (row < board.length - 1) {
            dfs(board, row + 1, col);
        }
        if (col > 0) {
            dfs(board, row, col - 1);
        }
        if (col < board[row].length - 1) {
            dfs(board, row, col + 1);
        }
    }
}
